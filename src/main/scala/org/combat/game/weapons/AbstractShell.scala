package org.combat.game.weapons

import org.combat.fxcore3d.FxWorld._
import org.combat.fxcore3d._
import org.combat.game.VirtualWorldImpl;
import org.combat.game.structures.AbstractMovingScenery;

/**
 * Abstract Shell
 * @author lawrence.daniels@gmail.com
 */
class AbstractShell(
  world: FxWorld,
  origin: FxPoint3D,
  agl: FxAngle3D,
  dpos: FxVelocityVector,
  dagl: FxAngle3D,
  randomSpread: Double,
  randomRotation: Double,
  lifeTime: Double)
  extends AbstractMovingScenery(world, origin, agl,
    FxVelocityVector(dpos.x + rand(-randomSpread, randomSpread), dpos.y + rand(-randomSpread, randomSpread), dpos.z + rand(-randomSpread, randomSpread)),
    new FxAngle3D(dagl.x + rand(-randomRotation, randomRotation), dagl.y + rand(-randomRotation, randomRotation), dagl.z + rand(-randomRotation, randomRotation))) {

  override def update(dt: Double) {
    super.update(dt);

    val v = getdPosition();
    v.y += world.gravity * dt;
    setdPosition(v);

    if ((getPosition().y < 0) || (getAge() > lifeTime)) {
      die();
    }
  }

}
