package org.combat.game.structures

import GenericTower._
import org.combat.fxcore3d._
import org.combat.game.ContentManager

/**
 * Generic Tower
 * @author lawrence.daniels@gmail.com
 */
class GenericTower(
  world: FxWorld,
  x: Double, z: Double,
  agl: FxAngle3D,
  myWidth: Double, myBredth: Double, myHeight: Double)
  extends AbstractStaticStructure(world, x, myHeight, z, new FxAngle3D(0, 0, 0), INITIAL_HEIGHT) {

  usePolyhedronInstance(new FxPolyhedronInstance(MODEL, new FxPoint3D(myWidth, myHeight, myBredth)));

  override def die() {
    super.die();
    val pos = getPosition();
    new GenericTowerRuin(getWorld(), pos.x, pos.z, getAngle(), myWidth, myBredth, myHeight * .2);
    val nbr = (REL_FRAG_WHEN_DEAD * myHeight).toInt
    for (n <- 1 to nbr) {
      new GenericFragment(getWorld(), REL_FRAG_SIZE * myHeight,
        getPosition(), REL_FRAG_SPREAD * myHeight,
        (myHeight * REL_FRAG_GENERATIONS).toInt, myHeight * REL_FRAG_SPEED,
        myHeight * REL_FRAG_ROTATION);
    }
  }

}

/**
 * Generic Tower (Companion Object)
 * @author lawrence.daniels@gmail.com
 */
object GenericTower {
  val MODEL: FxPolyhedron = ContentManager.loadModel("f3d/build2.f3d")
  val REL_FRAG_SIZE: Double = 0.6d
  val REL_FRAG_SPEED: Double = 2d
  val REL_FRAG_SPREAD: Double = 1d
  val REL_FRAG_WHEN_DEAD: Double = 1
  val REL_FRAG_GENERATIONS: Double = 0.01d
  val REL_FRAG_ROTATION: Double = 0.2d
  val INITIAL_HEIGHT: Double = 20d

}