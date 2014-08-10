package com.ldaniels528.robowars.objects.structures.fixed

import com.ldaniels528.fxcore3d._
import com.ldaniels528.fxcore3d.polygon.FxModelInstance
import com.ldaniels528.robowars.objects.structures.Structure

/**
 * Generic Pillar
 * @author lawrence.daniels@gmail.com
 */
case class Pillar(theWorld: FxWorld, pos: FxPoint3D, agl: FxAngle3D, scale: FxScale3D)
  extends FxObject(theWorld, FxPoint3D(pos.x, scale.h, pos.z), agl)
  with Structure {

  // set the default polyhedron instance
  lazy val modelInstance = FxModelInstance("/models/structures/pillar1.f3d", scale)

}
