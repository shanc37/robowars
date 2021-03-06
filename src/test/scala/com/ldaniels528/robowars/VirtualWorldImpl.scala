package com.ldaniels528.robowars

import com.ldaniels528.fxcore3d._
import com.ldaniels528.robowars.objects.ai._
import com.ldaniels528.robowars.objects.structures.{Wall1, _}
import com.ldaniels528.robowars.objects.vehicles._

/**
 * Virtual World Test Implementation
 * @author lawrence.daniels@gmail.com
 */
class VirtualWorldImpl() extends VirtualWorld(-500, -500, 500, 20, -10d) {
  val world: FxWorld = this
  activePlayer = new HoverTank(world, FxPoint3D(0, 0, -290))
  //activePlayer = new Glider(world, FxPoint3D(20, -400, 0));

  // populate the world
  populateWorld()
  attachActors()

  def populateWorld() {
    new Pillar(world, FxPoint3D(-410, 0, -300), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))

    section1

    new Pillar(world, FxPoint3D(-414, 0, -295), FxAngle3D(0, Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))

    section2

    new Pillar(world, FxPoint3D(414, 0, -295), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))

    section3

    new Pillar(world, FxPoint3D(-410, 0, 410), FxAngle3D(0, Math.PI, 0), FxScale3D(w = 2, d = 3, h = 12))

    section4

    section5

    section6

    Building1(world, FxPoint3D(25, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(25, 0, -105), FxScale3D(5, 5, 5))

    section7

    section8

    section9

    Building1(world, FxPoint3D(385, 0, -45), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(385, 0, 5), FxScale3D(5, 5, 5))

    section10

    section11

    section12

    Building1(world, FxPoint3D(-115, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-125, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-145, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-155, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-175, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-185, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-205, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-215, 0, -255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-235, 0, -95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-245, 0, -95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-255, 0, -95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-255, 0, -105), FxScale3D(5, 5, 5))

    section13

    Building1(world, FxPoint3D(-120, 0, -170), FxScale3D(10, 10, 10))
    Building1(world, FxPoint3D(-120, 0, -200), FxScale3D(10, 10, 10))
    Building1(world, FxPoint3D(-210, 0, -170), FxScale3D(10, 10, 10))
    Building1(world, FxPoint3D(-210, 0, -200), FxScale3D(10, 10, 10))

    section14

    Building1(world, FxPoint3D(-25, 0, -105), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-25, 0, -255), FxScale3D(5, 5, 5))

    section15

    section16

    Building1(world, FxPoint3D(-375, 0, -5), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-375, 0, -35), FxScale3D(5, 5, 5))

    new Pillar(world, FxPoint3D(55, 0, 405), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))

    section17

    new Pillar(world, FxPoint3D(-410, 0, 180), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))

    section18

    new Pillar(world, FxPoint3D(-50, 0, 260), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))

    section19

    section20

    section21

    Building1(world, FxPoint3D(-255, 0, 215), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-255, 0, 255), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-265, 0, 245), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-275, 0, 235), FxScale3D(5, 5, 5))

    section22

    section23

    section24

    section25

    Building1(world, FxPoint3D(35, 0, 275), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(35, 0, 285), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-35, 0, 275), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-35, 0, 285), FxScale3D(5, 5, 5))

    section26

    section27

    section28

    section29

    section30

    Building1(world, FxPoint3D(-135, 0, 25), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-105, 0, 65), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-105, 0, 95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-135, 0, 95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-195, 0, 95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-225, 0, 55), FxScale3D(5, 5, 5))

    section31

    Building1(world, FxPoint3D(-265, 0, 55), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-275, 0, 45), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-285, 0, 35), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-305, 0, 105), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-305, 0, 85), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-335, 0, 105), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-335, 0, 85), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-55, 0, -95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-85, 0, -85), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-105, 0, -65), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-105, 0, 25), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-85, 0, 45), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-55, 0, 55), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(-25, 0, 65), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(55, 0, -95), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(85, 0, -85), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(105, 0, -65), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(105, 0, 25), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(85, 0, 45), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(55, 0, 55), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(25, 0, 65), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(115, 0, -5), FxScale3D(5, 5, 5))
    Building1(world, FxPoint3D(115, 0, -35), FxScale3D(5, 5, 5))
  }

  def section31 {

    var i: Int = 0
    while (i <= 50) {
      {
        Building1(world, FxPoint3D(-205 - i, 0, 115 - i), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-235 - i, 0, 115 - i), FxScale3D(5, 5, 5))
      }
      i += 10
    }

  }

  def section30 {

    var x: Int = -195
    while (x > -260) {
      {
        Building1(world, FxPoint3D(x, 0, 25), FxScale3D(5, 5, 5))
      }
      x -= 30
    }

  }

  def section29 {

    var x: Int = -245
    while (x > -340) {
      {
        Building1(world, FxPoint3D(x, 0, 125), FxScale3D(5, 5, 5))
      }
      x -= 30
    }

  }

  def section28 {

    var x: Int = -105
    while (x > -230) {
      {
        Building1(world, FxPoint3D(x, 0, 125), FxScale3D(5, 5, 5))
      }
      x -= 30
    }

  }

  def section27 {

    var y: Int = 90
    while (y < 140) {
      {
        {
          var x: Int = -30
          while (x > -80) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(10, 10, 10))
            }
            x -= 40
          }
        }
      }
      y += 40
    }

  }

  def section26 {

    var y: Int = 90
    while (y < 140) {
      {
        {
          var x: Int = 30
          while (x < 80) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(10, 10, 10))
            }
            x += 40
          }
        }
      }
      y += 40
    }

  }

  def section25 {

    var x: Int = 20
    while (x > -70) {
      {
        Building1(world, FxPoint3D(x, 0, 300), FxScale3D(10, 10, 10))
      }
      x -= 40
    }

  }

  def section24 {

    var x: Int = 0
    while (x > -90) {
      {
        Building1(world, FxPoint3D(x, 0, 360), FxScale3D(10, 10, 10))
      }
      x -= 40
    }

  }

  def section23 {

    var y: Int = 290
    while (y < 380) {
      {
        {
          var x: Int = -140
          while (x > -230) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(10, 10, 10))
            }
            x -= 40
          }
        }
      }
      y += 40
    }

  }

  def section22 {

    var y: Int = 235
    while (y < 380) {
      {
        {
          var x: Int = -355
          while (x > -380) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(5, 5, 5))
            }
            x -= 20
          }
        }
      }
      y += 20
    }

  }

  def section21 {

    var y: Int = 215
    while (y < 260) {
      {
        {
          var x: Int = -135
          while (x > -240) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(5, 5, 5))
            }
            x -= 20
          }
        }
      }
      y += 20
    }

  }

  def section20 {

    var y: Int = 255
    while (y > 190) {
      {
        new Wall1(world, FxPoint3D(-54, 0, y), FxAngle3D(0, Math.PI / 2, 0), FxScale3D(w = 8, d = 2, h = 10))
        new Pillar(world, FxPoint3D(-54, 0, y - 10), FxAngle3D(0, Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))
      }
      y -= 20
    }

  }

  def section19 {

    var x: Int = -40
    while (x <= 50) {
      {
        if (x == 0) {
          new MainGate(world, FxPoint3D(x, 0, 260), FxAngle3D(0, 0, 0))
          new Pillar(world, FxPoint3D(x + 10, 0, 260), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
        else {
          new Wall1(world, FxPoint3D(x, 0, 260), FxAngle3D(0, 0, 0), FxScale3D(w = 8, d = 2, h = 10))
          new Pillar(world, FxPoint3D(x + 10, 0, 260), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
      }
      x += 20
    }

  }

  def section18 {

    var x: Int = -400
    while (x <= 50) {
      {
        if ((x == 0) || (x == -320)) {
          new MainGate(world, FxPoint3D(x, 0, 180), FxAngle3D(0, 0, 0))
          new Pillar(world, FxPoint3D(x + 10, 0, 180), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
        else {
          new Wall1(world, FxPoint3D(x, 0, 180), FxAngle3D(0, 0, 0), FxScale3D(w = 8, d = 2, h = 10))
          new Pillar(world, FxPoint3D(x + 10, 0, 180), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
      }
      x += 20
    }

  }

  def section17 {

    var y: Int = 395
    while (y > 185) {
      {
        new Wall1(world, FxPoint3D(55, 0, y), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 8, d = 2, h = 10))
        new Pillar(world, FxPoint3D(55, 0, y - 10), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))
      }
      y -= 20
    }

  }

  def section16 {

    var y: Int = -35
    while (y < 20) {
      {
        {
          var x: Int = -115
          while (x > -270) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(5, 5, 5))
            }
            x -= 30
          }
        }
      }
      y += 30
    }

  }

  def section15 {

    var y: Int = -245
    while (y < 60) {
      {
        {
          var x: Int = -295
          while (x > -350) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(5, 5, 5))
            }
            x -= 50
          }
        }
      }
      y += 30
    }

  }

  def section14 {

    var y: Int = -225
    while (y < -130) {
      {
        Building1(world, FxPoint3D(-25, 0, y), FxScale3D(5, 5, 5))
      }
      y += 30
    }

  }

  def section13 {

    var y: Int = -230
    while (y < -130) {
      {
        {
          var x: Int = -120
          while (x > -220) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(10, 10, 10))
            }
            x -= 30
          }
        }
      }
      y += 90
    }

  }

  def section12 {

    var y: Int = -115
    while (y < -90) {
      {
        Building1(world, FxPoint3D(-115, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-125, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-145, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-155, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-175, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-185, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-205, 0, y), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(-215, 0, y), FxScale3D(5, 5, 5))
      }
      y += 20
    }

  }

  def section11 {

    var x: Int = -235
    while (x > -260) {
      {
        Building1(world, FxPoint3D(x, 0, -255), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -235), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -225), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -205), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -195), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -175), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -165), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -145), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -135), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -115), FxScale3D(5, 5, 5))
      }
      x -= 20
    }

  }

  def section10 {

    var x: Int = -75
    while (x > -100) {
      {
        Building1(world, FxPoint3D(x, 0, -255), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -235), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -225), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -205), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -195), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -175), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -165), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -145), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -135), FxScale3D(5, 5, 5))
        Building1(world, FxPoint3D(x, 0, -115), FxScale3D(5, 5, 5))
      }
      x -= 20
    }

  }

  def section9 {

    var y: Int = 0
    while (y > -50) {
      {
        {
          var x: Int = 150
          while (x < 360) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(10, 10, 10))
            }
            x += 40
          }
        }
      }
      y -= 40
    }

  }

  def section8 {

    var x: Int = 385
    while (x > 100) {
      Building1(world, FxPoint3D(x, 0, -105), FxScale3D(5, 5, 5))
      x -= 30
    }

  }

  def section7 {

    var x: Int = 385
    while (x > 130) {
      Building1(world, FxPoint3D(x, 0, -75), FxScale3D(5, 5, 5))
      x -= 30
    }

  }

  def section6 {

    var y: Int = -225
    while (y < -130) {
      {
        Building1(world, FxPoint3D(25, 0, y), FxScale3D(5, 5, 5))
      }
      y += 30
    }

  }

  def section5 {

    var y: Int = -255
    while (y < -130) {
      {
        {
          var x: Int = 385
          while (x > 40) {
            {
              Building1(world, FxPoint3D(x, 0, y), FxScale3D(5, 5, 5))
            }
            x -= 30
          }
        }
      }
      y += 30
    }

  }

  def section4 {

    var x: Int = -400
    while (x <= 400) {
      {
        new Wall1(world, FxPoint3D(x, 0, 410), FxAngle3D(0, Math.PI, 0), FxScale3D(w = 8, d = 2, h = 10))
        new Pillar(world, FxPoint3D(x + 10, 0, 410), FxAngle3D(0, Math.PI, 0), FxScale3D(w = 2, d = 3, h = 12))
      }
      x += 20
    }

  }

  def section3 {
    var y: Int = -285
    while (y <= 400) {
      {
        new Wall1(world, FxPoint3D(414, 0, y), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 8, d = 2, h = 10))
        new Pillar(world, FxPoint3D(414, 0, y + 10), FxAngle3D(0, -Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))
      }
      y += 20
    }
  }

  def section2 {
    var y: Int = -285
    while (y <= 400) {
      {
        new Wall1(world, FxPoint3D(-414, 0, y), FxAngle3D(0, Math.PI / 2, 0), FxScale3D(w = 8, d = 2, h = 10))
        new Pillar(world, FxPoint3D(-414, 0, y + 10), FxAngle3D(0, Math.PI / 2, 0), FxScale3D(w = 2, d = 3, h = 12))
      }
      y += 20
    }
  }

  def section1 {
    var x: Int = -400
    while (x <= 400) {
      {
        if (x == 0) {
          new MainGate(world, FxPoint3D(x, 0, -300), FxAngle3D(0, 0, 0))
          new Pillar(world, FxPoint3D(x + 10, 0, -300), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
        else {
          new Wall1(world, FxPoint3D(x, 0, -300), FxAngle3D(0, 0, 0), FxScale3D(w = 8, d = 2, h = 10))
          new Pillar(world, FxPoint3D(x + 10, 0, -300), FxAngle3D(0, 0, 0), FxScale3D(w = 2, d = 3, h = 12))
        }
      }
      x += 20
    }
  }

  private def attachActors() {
    var ab: AggressiveAI = null
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-165, 0, -185)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-43.6, 0, -104.8)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-295, 0, 165)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-345, 0, 165)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-295, 0, 215)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-345, 0, 215)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(25, 0, 225)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-25, 0, 225)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(15, 0, 335)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-15, 0, 335)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-255, 0, 295)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-255, 0, 365)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new AntiTankCannon(world, FxPoint3D(-305, 0, 325)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new Rover(world, FxPoint3D(0, 0, -500)))
    ab.selectTarget(activePlayer)
    ab = new AggressiveAI(new Rover(world, FxPoint3D(0, 0, -360)))
    ab.selectTarget(activePlayer)
    val b: PassiveAI = new PassiveAI(new Glider(world, FxPoint3D(-10, -370, 0)))
    b.navigateTo(FxPoint3D(0, 30, 100), 0.01)
  }
}
