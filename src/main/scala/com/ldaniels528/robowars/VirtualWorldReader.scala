package com.ldaniels528.robowars

import java.awt.Color

import com.ldaniels528.fxcore3d._
import com.ldaniels528.robowars.objects.vehicles._
import com.ldaniels528.robowars.objects.ai.AggressiveAI

import scala.collection.mutable.{Map => MMap}
import scala.xml._

/**
 * Virtual World Reader
 * @author lawrence.daniels@gmail.com
 */
object VirtualWorldReader {

  /**
   * Loads the virtual world from disk
   * @param path the given resource path
   */
  def load(path: String): VirtualWorld = parse(XML.load(ContentManager.getResource(path)))

  def decode(xmlString: String): VirtualWorld = parse(XML.loadString(xmlString))

  def parse(xml: Elem): VirtualWorld = {
    // define the containers
    val colors = MMap[String, Color]()
    val classDefs = MMap[String, Class[_]]()
    var thePlayer: AbstractVehicle = null

    // create the world
    val world = toWorld(xml).getOrElse(die("Invalid virtual world definition"))

    // process the XML file
    xml.child map { node =>
      node.label match {
        case "actor" => toActor(world, classDefs, node) foreach {
          case (actor, isPlayer) =>
            if (isPlayer) {
              println(s"Player is $actor (${actor.getClass.getName})")
              thePlayer = actor
              world.activePlayer = actor
            } else {
              val ab = new AggressiveAI(actor)
              ab.selectTarget(thePlayer)
            }
        }
        case "colorDef" => toColor(node) foreach (colors += _)
        case "door" => toDoor(world, classDefs, node)
        case "item" => toItem(world, classDefs, node)
        case "objectDef" => toClassDef(node) foreach (classDefs += _)
        case "structure" => toStructure(world, classDefs, node)
        case _ =>
      }
    }

    world
  }

  private def lookup[T](entityType: String, items: MMap[String, T], id: String): T = {
    items.getOrElse(id, die(s"Missing $entityType definition $id"))
  }

  private def toWorld(xml: Elem): Option[VirtualWorld] = {
    ((xml \\ "world") flatMap { node =>
      for {
        name <- ((node \ "@name") map (_.text)).headOption
        minX <- ((node \ "@minX") map (_.text)).headOption map (_.toDouble)
        minY <- ((node \ "@minY") map (_.text)).headOption map (_.toDouble)
        size <- ((node \ "@size") map (_.text)).headOption map (_.toInt)
        rows <- ((node \ "@rows") map (_.text)).headOption map (_.toInt)
        gravity <- ((node \ "@gravity") map (_.text)).headOption map (_.toDouble)
      } yield VirtualWorld(minX, minY, size, rows, gravity)
    }).headOption
  }

  private def toColor(node: Node): Option[(String, Color)] = {
    for {
      id <- (node \ "@id").map(_.text).headOption
      r <- (node \ "@red").map(_.text).headOption.map(_.toInt)
      g <- (node \ "@green").map(_.text).headOption.map(_.toInt)
      b <- (node \ "@blue").map(_.text).headOption.map(_.toInt)
    } yield (id, new Color(r, g, b))
  }

  private def toClassDef(node: Node): Option[(String, Class[_])] = {
    for {
      id <- (node \ "@id").map(_.text).headOption
      className <- (node \ "@class").map(_.text).headOption
      classInst = Class.forName(className)
    } yield (id, classInst)
  }

  private def toEnvironment(node: Node): Option[Environment] = {
    for {
      sky <- (node \ "@sky").map(_.text).headOption
      ground <- (node \ "@ground").map(_.text).headOption
    } yield new Environment(sky, ground)
  }

  private def toActor(world: VirtualWorld, classDefs: MMap[String, Class[_]], node: Node): Option[(AbstractVehicle, Boolean)] = for {
    id <- (node \ "@type").map(_.text).headOption
    classDef = lookup("object", classDefs, id)
    x <- (node \ "@x").map(_.text).headOption.map(_.toDouble)
    y <- (node \ "@y").map(_.text).headOption.map(_.toDouble)
    z <- (node \ "@z").map(_.text).headOption.map(_.toDouble)
    isPlayer = (node \ "@isPlayer").map(_.text).headOption.contains("true")
  } yield {
    //println(s"Instantiating '$id' from ${classDef.getName}")
    val args = Array(world, new FxPoint3D(x, y, z)) map (_.asInstanceOf[Object])
    val cons = classDef.getConstructors()(0)
    val actor = cons.newInstance(args: _*).asInstanceOf[AbstractVehicle]
    (actor, isPlayer)
  }

  private def toDoor(world: VirtualWorld, classDefs: MMap[String, Class[_]], node: Node): Option[FxObject] = {
    for {
      id <- (node \ "@type").map(_.text).headOption
      classDef = lookup("class", classDefs, id)
      x <- (node \ "@x").map(_.text).headOption.map(_.toDouble)
      y <- (node \ "@y").map(_.text).headOption.map(_.toDouble)
      z <- (node \ "@z").map(_.text).headOption.map(_.toDouble)
      rx <- (node \ "@rx").map(_.text).headOption.map(_.toDouble)
      ry <- (node \ "@ry").map(_.text).headOption.map(_.toDouble)
      rz <- (node \ "@rz").map(_.text).headOption.map(_.toDouble)
    } yield {
      //println(s"Instantiating '$id' from ${classDef.getName}")
      val args = Array(world, new FxPoint3D(x, y, z), new FxAngle3D(rx, ry, rz)) map (_.asInstanceOf[Object])
      val cons = classDef.getConstructors()(0)
      cons.newInstance(args: _*).asInstanceOf[FxObject]
    }
  }

  private def toItem(world: VirtualWorld, classDefs: MMap[String, Class[_]], node: Node): Option[FxObject] = {
    for {
      id <- (node \ "@type").map(_.text).headOption
      classDef = lookup("class", classDefs, id)
      x <- (node \ "@x").map(_.text).headOption.map(_.toDouble)
      y <- (node \ "@y").map(_.text).headOption.map(_.toDouble)
      z <- (node \ "@z").map(_.text).headOption.map(_.toDouble)
    } yield {
      //println(s"Instantiating '$id' from ${classDef.getName}")
      val args = Array(world, new FxPoint3D(x, y, z)) map (_.asInstanceOf[Object])
      val cons = classDef.getConstructors()(0)
      cons.newInstance(args: _*).asInstanceOf[FxObject]
    }
  }

  private def toStructure(world: VirtualWorld, classDefs: MMap[String, Class[_]], node: Node): Option[FxObject] = {
    for {
      id <- (node \ "@type").map(_.text).headOption
      classDef = lookup("class", classDefs, id)
      x <- (node \ "@x").map(_.text).headOption.map(_.toDouble)
      y <- (node \ "@y").map(_.text).headOption.map(_.toDouble)
      z <- (node \ "@z").map(_.text).headOption.map(_.toDouble)
      rx <- (node \ "@rx").map(_.text).headOption.map(_.toDouble)
      ry <- (node \ "@ry").map(_.text).headOption.map(_.toDouble)
      rz <- (node \ "@rz").map(_.text).headOption.map(_.toDouble)
      w <- (node \ "@width").map(_.text).headOption.map(_.toDouble)
      d <- (node \ "@depth").map(_.text).headOption.map(_.toDouble)
      h <- (node \ "@height").map(_.text).headOption.map(_.toDouble)
    } yield {
      //println(s"Instantiating '$id' from ${classDef.getName}")
      val args = Array(world, FxPoint3D(x, y, z), FxAngle3D(rx, ry, rz), FxScale3D(w, h, d)) map (_.asInstanceOf[Object])
      val cons = classDef.getConstructors()(0)
      cons.newInstance(args: _*).asInstanceOf[FxObject]
    }
  }

  private def extract(node: Node, name: String): Option[String] = {
    (node \ s"@$name").map(_.text).headOption
  }

  private def die[S](message: String): S = {
    throw new IllegalStateException(message)
  }

  case class Environment(sky: String, ground: String)

}