package com.ldaniels528.fxcore3d.polygon

import java.awt.Graphics2D

import com.ldaniels528.fxcore3d.camera.FxCamera
import com.ldaniels528.fxcore3d.{FxArrayOf3DPoints, FxPoint3D, FxProjectedPoints}

/**
 * FxEngine Convex Polyhedron
 * @author lawrence.daniels@gmail.com
 */
case class FxConvexPolyhedron(vertices: FxArrayOf3DPoints,
                              myPolygons: Seq[FxIndexingPolygon],
                              myPolygonNormals: FxArrayOf3DPoints) extends FxPolyhedron {

  val nbrOfPolygons = myPolygons.length

  override def calculateIntensities(light: FxPoint3D, intensities: Array[Double]) {
    val p = new FxPoint3D()
    myPolygonNormals.points.foreach { poly =>
      p.set(poly.x, poly.y, poly.z)
      intensities(poly.index) = p.dotProduct(light)
    }
  }

  override def clipAndPaint(g: Graphics2D, ppa: FxProjectedPoints, camera: FxCamera) {
    myPolygons foreach (_.clipAndPaint(g, ppa, camera))
  }

  override def clipAndPaintWithShading(g: Graphics2D, ppa: FxProjectedPoints, camera: FxCamera, intensities: Array[Double]) {
    var n = 0
    myPolygons foreach { poly =>
      poly.clipAndPaintWithShading(g, ppa, camera, intensities(n))
      n += 1
    }
  }

  override def makeClone: FxPolyhedron = {
    new FxConvexPolyhedron(vertices.makeClone, myPolygons map (_.makeClone), myPolygonNormals)
  }

  /**
   * overrides FxPolyhedron.paint(..) the polygons don't need to be sorted.
   */
  override def paint(g: Graphics2D, ppa: FxProjectedPoints) {
    myPolygons foreach (_.paint(g, ppa))
  }

  override def paintWithShading(g: Graphics2D, ppa: FxProjectedPoints, intensities: Array[Double]) {
    var n = 0
    myPolygons foreach { poly =>
      poly.paintWithShading(g, ppa, intensities(n))
      n += 1
    }
  }

  override def scalePoints(sx: Double, sy: Double, sz: Double) {
    vertices.points foreach { vertex =>
      vertex.x *= sx
      vertex.y *= sy
      vertex.z *= sz
    }
  }

}