package edu.luc.etl.cs313.scala.uidemo.model

import android.graphics.Color
import edu.luc.etl.cs313.scala.uidemo.model.Monsters.MonstersChangeListener

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 *
 * @param x
 * @param y
 * @param color
 * @param diameter
 * @param vulnerability
 */
case class Monster(x: Float, y: Float, color: Int, diameter: Int, vulnerability: Float) //DONE rename MONSTERS as singular dots evolve into monster


object Monsters {
  trait MonstersChangeListener {
    /** @param monsters the monsters that changed. */
    def onMonstersChange(monster: Monsters): Unit
  }
}

/**
 * Created class for Monsters by basically copying Dots class
 */
class Monsters {

  private val monsters = new ListBuffer[Monsters]

  private var monstersChangeListener: MonstersChangeListener = _

  /** @param l set the change listener. */
  def setDotsChangeListener(l: MonstersChangeListener) = monstersChangeListener = l

  /** @return immutable list of dots. */
  def getMonsters(): List[Monsters] = monsters.toList

  /** @return the most recently added dot. */
  def getLastMonster(): Monster = if (monsters.size <= 0) null else ???


  def eraseMonster(x: Float, y: Float, color: Int, diameter: Int, vulnerability: Float): Unit = {
    monsters -= monsters.last
    notifyListener()
  }


  /** Vulnerability over time - want to use RANDOM but not sure how to tie it all together
    * @param degree change for vulnerable state
    */
  def makeVulnerable(degree : Float) : Unit ={
    for (monster <- monsters){
      var makeVulnerable = Random.nextInt(5)
      if (Random.nextFloat > degree){
        ???
      }
    }
    notifyListener()
  }

//  /** Change color based on vulnerability - yellow = vulnerable
//    *
//    */
//  def changeColorMonster(): Unit = {
//    getMonsters().foreach(monster =>
//      if(monster.color == Color.GREEN){
//        monster.color = Color.YELLOW
//      }else{
//        monster.color = Color.GREEN
//      }
//    )
//    notifyListener()
//  }

  private def notifyListener(): Unit =
    if (null != monstersChangeListener)
      monstersChangeListener.onMonstersChange(this)



}

/**
 * A dot: the coordinates, color and size.
 * @param x horizontal coordinate.
 * @param y vertical coordinate.
 * @param color the color.
 * @param diameter dot diameter.
 */
case class Dot(x: Float, y: Float, color: Int, diameter: Int)

object Dots {
  trait DotsChangeListener {
    /** @param dots the dots that changed. */
    def onDotsChange(dots: Dots): Unit
  }
}

/** A list of dots. */
class Dots {

  private val dots = new ListBuffer[Dot]

  private var dotsChangeListener: Dots.DotsChangeListener = _

  /** @param l set the change listener. */
  def setDotsChangeListener(l: Dots.DotsChangeListener) = dotsChangeListener = l

  /** @return the most recently added dot. */
  def getLastDot(): Dot = if (dots.size <= 0) null else dots.last // TODO convert to option

  /** @return immutable list of dots. */
  def getDots(): List[Dot] = dots.toList

  /**
   * @param x dot horizontal coordinate.
   * @param y dot vertical coordinate.
   * @param color dot color.
   * @param diameter dot size.
   */
  def addDot(x: Float, y: Float, color: Int, diameter: Int): Unit = {
    dots += Dot(x, y, color, diameter)
    notifyListener()
  }

  /**
   * Made this function to try and erase a dot
   * @param x
   * @param y
   * @param diameter
   */
  def eraseDot(x: Float, y: Float, diameter: Int): Unit = {
    for (dot <- dots)
      if(dot.x > x-diameter && dot.x < x+diameter && dot.y > y-diameter && dot.y < y+ diameter){
        dots-= dot
      }
    notifyListener()
  }

  
  /** Remove all dots. */
  def clearDots(): Unit = {
    dots.clear()
    notifyListener()
  }

  private def notifyListener(): Unit =
    if (null != dotsChangeListener)
      dotsChangeListener.onDotsChange(this)









}
