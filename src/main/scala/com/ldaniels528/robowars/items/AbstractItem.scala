package com.ldaniels528.robowars.items

import com.ldaniels528.fxcore3d._
import com.ldaniels528.robowars.AbstractMovingObject

/**
 * Represents a collectible or power-up item
 * @author lawrence.daniels@gmail.com
 */
abstract class AbstractItem(w: FxWorld, p: FxPoint3D)
  extends AbstractMovingObject(w, p, FxAngle3D(), FxVelocityVector(), FxAngle3D()) {

  override def update(dt: Double) {
    super.update(dt)

    // the item must continually spin
    setAngle({
      val agl = angle
      agl.y += dt
      agl
    })
  }

}
