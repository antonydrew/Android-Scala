package edu.luc.etl.cs313.scala.uidemo
package controller

import android.graphics.Color
import android.view.{MotionEvent, View}
import edu.luc.etl.cs313.scala.uidemo.model.Dots

import scala.collection.mutable.ArrayBuffer

/** Listen for taps. */
class TrackingTouchListener(dots: Dots) extends View.OnTouchListener {

  val tracks = new ArrayBuffer[Int]


  override def onTouch(v: View, evt: MotionEvent): Boolean = {
    val action = evt.getAction
    action & MotionEvent.ACTION_MASK match {
      case MotionEvent.ACTION_DOWN | MotionEvent.ACTION_POINTER_DOWN =>
        val idx = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
          MotionEvent.ACTION_POINTER_INDEX_SHIFT
        tracks += evt.getPointerId(idx)
      case MotionEvent.ACTION_POINTER_UP =>
        val idx = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
          MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        tracks -= evt.getPointerId(idx)
      case MotionEvent.ACTION_MOVE =>
        for (i <- tracks) {
          val idx = evt.findPointerIndex(i)
          for (j <- 0 until evt.getHistorySize) {
//            deleteDot(
//              dots,
//              evt.getHistoricalX(idx, j),
//              evt.getHistoricalY(idx, j),
//              evt.getHistoricalPressure(idx, j),
//              evt.getHistoricalSize(idx, j)
//            )
          }
        }
      case _ => return false
    }

    for (i <- tracks) {
      val idx = evt.findPointerIndex(i)
      eraseDot(dots,
        evt.getX(idx),
        evt.getY(idx),
        //evt.getPressure(idx),
        DOT_DIAMETER
      )
    }

    true
  }

  private def addDot(dots: Dots, x: Float, y: Float, p: Float, s: Float) =
    dots.addDot(x, y, Color.CYAN, ((p + 0.5) * (s + 0.5) * DOT_DIAMETER).toInt)

  /**
   * Inserted erase function here which calls from Dots class
   * @param dots
   * @param x
   * @param y
   * @param diameter
   */
  private def eraseDot(dots: Dots, x: Float, y: Float, diameter:Int) =
    dots.eraseDot(x, y, diameter)



}
