package com.ldaniels528.robowars.objects.weapons

import com.ldaniels528.fxcore3d._
import com.ldaniels528.fxcore3d.polygon.FxModelInstance
import com.ldaniels528.robowars.objects.vehicles.AbstractVehicle

/**
 * Represents a Mini-Cannon Round
 * @author lawrence.daniels@gmail.com
 */
case class MiniCannonRound(w: FxWorld, theShooter: AbstractVehicle, p: FxPoint3D, agl0: FxAngle3D)
  extends AbstractProjectile(w, theShooter, FxPoint3D(p.x, p.y/2, p.z), FxVelocityVector(agl0.y, agl0.x, velocity = 70d), impactDamage = 1d, lifeTime = 3d) {

  // define the 3D model
  lazy val modelInstance = FxModelInstance("/models/weapons/bullet.f3d", FxScale3D(0.15d, 0.15d, 0.75d))

}
