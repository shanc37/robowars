package com.ldaniels528.robowars.actors

import com.ldaniels528.fxcore3d.polygon.{FxPolyhedron, FxPolyhedronInstance}
import com.ldaniels528.fxcore3d.{FxPoint3D, FxVelocityVector, FxWorld}
import com.ldaniels528.robowars.ContentManager
import com.ldaniels528.robowars.actors.Glider._
import com.ldaniels528.robowars.structures.GenericFragment
import com.ldaniels528.robowars.weapons.{BombBay, MiniCannon, MissileLauncher}

/**
 * Glider Vehicle
 * @author lawrence.daniels@gmail.com
 */
class Glider(world: FxWorld, p: FxPoint3D)
  extends AbstractActor(world, FxPoint3D(p.x, p.y + SCALE.y, p.z), FxVelocityVector(Math.PI, 0, 0), health = 5d) {

  val turningRate: Double = 0.6d
  val pitchRate: Double = 0.5d
  val acceleration: Double = 3d
  val brakingRate: Double = 3d
  val maxVelocity: Double = 150d
  val climbRate: Double = 3d
  val decentRate: Double = 4d
  val pitchClimbRateFactor: Double = 1d

  // set the default polyhedron instance
  lazy val polyhedronInstance = new FxPolyhedronInstance(MODEL, SCALE)

  // attach some weapons
  this += new MiniCannon(this, new FxPoint3D(0, SCALE.y, 0))
  this += new MissileLauncher(this, new FxPoint3D(0, SCALE.y, 0))
  this += new BombBay(this, new FxPoint3D(0, SCALE.y, 0))
  selectWeapon(0)

  override def die() {
    super.die()
    (1 to FRAGMENTS_WHEN_DEAD) foreach { n =>
      new GenericFragment(world, FRAGMENT_SIZE, position,
        FRAGMENT_SPREAD, FRAGMENT_GENERATIONS, FRAGMENT_SPEED, 3)
    }
    new GliderRemains(world, this)
    ()
  }

  override def update(dt: Double) {
    super.update(dt)

    // -- check collision with ground
    val p = position
    if (p.y < SCALE.y) {
      p.y = SCALE.y
      setPosition(p)

      // update the velocity
      setdPosition({
        val dp = getdPosition()
        dp.setAngleAboutXaxis(0)
        dp.setVelocity(0)
        dp
      })

      // -- some damage depending on the speed
      val vel = getdPosition().getVelocity()
      damageHealth(vel)
    }
    ()
  }

}

/**
 * Glider Companion Object
 * @author lawrence.daniels@gmail.com
 */
object Glider {
  val MODEL: FxPolyhedron = ContentManager.loadModel("/models/actors/glider.f3d")
  val SCALE = new FxPoint3D(8d, 1d, 4d)

  val FRAGMENT_SIZE: Double = 0.25d
  val FRAGMENT_SPEED: Double = 7d
  val FRAGMENT_SPREAD: Double = 1d
  val FRAGMENTS_WHEN_DEAD: Int = 15
  val FRAGMENT_GENERATIONS: Int = 1

}
