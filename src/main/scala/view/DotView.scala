package edu.luc.etl.cs313.scala.uidemo
package view

import android.content.Context
import android.graphics.Paint.Style
import android.graphics.{Canvas, Color, Paint}
import android.util.AttributeSet
import android.view.View
import edu.luc.etl.cs313.scala.uidemo.model._

/**
 * I see spots!
 *
 * @param context
 * @param attrs
 * @param defStyle
 *
 * @author <a href="mailto:android@callmeike.net">Blake Meike</a>
 */
class DotView(context: Context, attrs: AttributeSet, defStyle: Int) extends View(context, attrs, defStyle) {

  { setFocusableInTouchMode(true) }

  /** The model underlying this view. */
  private var dots: Dots = _

  /** @param context the rest of the application */
  def this(context: Context) = {
    this(context, null, 0)
    setFocusableInTouchMode(true)
  }

  /**
   * @param context
   * @param attrs
   */
  def this(context: Context, attrs: AttributeSet) = {
    this(context, attrs, 0)
    setFocusableInTouchMode(true)
  }

  /**
   * Injects the model underlying this view.
   *
   * @param dots
   * */
  def setDots(dots: Dots): Unit = this.dots = dots

  /**
   * I used canvas.DrawLine in order to render 9 box grid on device screen (which
   * gets injected into MAIN.XML
   * @param canvas
   */
  override protected def onDraw(canvas: Canvas): Unit = {
    val paint = new Paint
    paint.setStyle(Style.STROKE)
    paint.setColor(if (hasFocus) Color.BLUE else Color.GRAY)

    canvas.drawRect(0, 0, getWidth - 0, getHeight - 0, paint)

    paint.setColor(Color.BLUE)
    paint.setStrokeWidth(5)

    //canvas.drawRect(20, 20, 750, 840, paint )
    canvas.drawLine(0f,280f,767f,280f, paint)
    canvas.drawLine(0f,560f,767f,560f, paint)
    canvas.drawLine(250f,0f,250f,865f, paint)
    canvas.drawLine(500f,0f,500f,865f, paint)


    if (null == dots) return

    paint.setStyle(Style.FILL)
    for (dot <- dots.getDots) {
      paint.setColor(dot.color)
      canvas.drawCircle(dot.x, dot.y, dot.diameter, paint)
    }
  }





}
