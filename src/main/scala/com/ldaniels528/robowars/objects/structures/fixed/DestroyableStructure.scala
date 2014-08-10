package com.ldaniels528.robowars.objects.structures.fixed

import com.ldaniels528.fxcore3d._
import com.ldaniels528.robowars.audio.AudioManager._
import com.ldaniels528.robowars.objects.Damageable
import com.ldaniels528.robowars.objects.structures.fixed.DestroyableStructure._
import com.ldaniels528.robowars.objects.structures.moving.GenericFragment
import com.ldaniels528.robowars.objects.weapons.AbstractProjectile

/**
 * Destroyable Structure
 * @author lawrence.daniels@gmail.com
 */
abstract class DestroyableStructure(world: FxWorld, pos: FxPoint3D, agl: FxAngle3D, initialHealth: Double)
  extends AbstractStaticStructure(world, pos, agl)
  with Damageable {

  def maxHealth: Double = initialHealth

  def scale: FxScale3D

  override def die() {
    // play the explosion clip
    audioPlayer ! BuildingExplodeClip

    // leave ruins behind
    new GenericBuildingRuin(world, position, angle, scale.reducedHeight(0.2d))

    // create the explosion
    val height = scale.h
    val fragCount = (REL_FRAG_WHEN_DEAD * height).toInt
    (1 to fragCount) foreach { n =>
      new GenericFragment(world, REL_FRAG_SIZE * height,
        position, REL_FRAG_SPREAD * height,
        (height * REL_FRAG_GENERATIONS).toInt, height * REL_FRAG_SPEED, height * REL_FRAG_ROTATION)
    }

    // allow super-class to take action
    super.die()
  }

  override def handleCollisionWith(obj: FxObject, dt: Double): Boolean = {
    obj match {
      case r: AbstractProjectile =>
        if (damageHealth(r.impactDamage) <= 0) die()
        else {
          // play projectile's death song
          audioPlayer ! CrashClip
        }
      case _ =>
    }
    super.handleCollisionWith(obj, dt)
  }

  override def interestedOfCollisionWith(obj: FxObject): Boolean = {
    obj match {
      case r: AbstractProjectile => true
      case _ => super.interestedOfCollisionWith(obj)
    }
  }

}

/**
 * Destroyable Structure Companion Object
 * @author lawrence.daniels@gmail.com
 */
object DestroyableStructure {
  val REL_FRAG_SIZE: Double = 0.6d
  val REL_FRAG_SPEED: Double = 2d
  val REL_FRAG_SPREAD: Double = 1d
  val REL_FRAG_WHEN_DEAD: Double = 1d
  val REL_FRAG_GENERATIONS: Double = 0.01d
  val REL_FRAG_ROTATION: Double = 0.2d

}