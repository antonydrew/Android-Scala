package edu.luc.etl.cs313.scala.uidemo.model

import android.graphics.Color

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * A dot: the coordinates, color and size.
 * @param x horizontal coordinate.
 * @param y vertical coordinate.
 * @param color the color.
 * @param diameter dot diameter.
 */
case class Dot(x: Float, y: Float, color: Int, diameter: Int)//, var vulnerability: Int)

object Dots {
  trait DotsChangeListener {
    /** @param dots the dots that changed. */
    def onDotsChange(dots: Dots): Unit
  }
}

// TODO must work on STATE model for monsters or should I just leave "soft" states INSIDE this Model.Dots.scala file????

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
   * Made this function to erase a monster/dot by copying function above addDot
   * @param x
   * @param y
   * @param diameter
   */
  def eraseDot(x: Float, y:Float, diameter: Int)={
        for (current <- dots)
          if(current.x > x-diameter && current.x < x+diameter && current.y > y-diameter && current.y < y+ diameter && current.color==Color.RED){
            dots-= current
          }
        notifyListener()
      }

    /** Vulnerability over time*
      * @param percentage change for vulnerable state
      */
    def makeVulnerable(percentage : Float) : Unit ={
      for (current <- dots){
        var makeVulnerable = Random.nextInt(5)
        if (Random.nextFloat > percentage){
          ???
        }
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
