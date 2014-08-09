package com.ldaniels528.robowars.objects.structures

import com.ldaniels528.fxcore3d._
import com.ldaniels528.fxcore3d.polygon.FxModelInstance

/**
 * Generic Wall
 * @author lawrence.daniels@gmail.com
 */
case class GenericWall(theWorld: FxWorld, pos: FxPoint3D, agl: FxAngle3D, dim: FxScale3D)
  extends AbstractStaticStructure(theWorld, FxPoint3D(pos.x, dim.h, pos.z), agl) {

  // set the default polyhedron instance
  lazy val modelInstance = FxModelInstance("/models/structures/wall1.f3d", dim)

}
