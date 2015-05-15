package model

import android.view.{MotionEvent, View}
import android.view.View.OnTouchListener
import edu.luc.etl.cs313.scala.uidemo.model.Dots


/* TODO must work on STATE model for monsters or simply leave inside Model.Dots.scala????? :
-Make abstract rep of 2D grid
-Use ASYNC in background that sends onTick() event to ALL monsters at once so each monster is a little state
-2 main states: MOVE [can I?] and VULNERABLE [to TOUCH event]...if can move then invoke/create onMove() method [which uses RAND square jump]
-Use BINARY SEMAPHORE to make sure only 1 monster allowed [or filling] each square
-Once abstract rep is done for 2D grid, then study onDraw API to figure out how to render board in MAIN.XML...USE GRIDVIEW to show squares and alternate colors!
 */

object State {

  trait Initializable { def actionInit(): Unit }

  trait DotsStateMachine extends Dots.DotsChangeListener with Initializable {
    //def onDotsChange(dots: Dots): Unit
    def getState(): DotsState
    def actionUpdateView(): Unit
  }


  /** A state in a state machine. This interface is part of the State pattern. */
  trait DotsState extends Dots.DotsChangeListener with OnTouchListener {
    def updateView(): Unit
    def getId(): Int
  }
//
  /** An implementation of the state machine for the stopwatch. */
  abstract class DefaultDotsStateMachine(
                                      Dots: Dots,
                                      uiUpdateListener: DotsState
                                      ) extends DotsStateMachine with Serializable {

    /** The current internal state of this adapter component. Part of the State pattern. */
    private var state: DotsState = _

    protected def setState(state: DotsState): Unit = {
      this.state = state
      uiUpdateListener.onDotsChange(Dots)
      //uiUpdateListener.updateState(state.getId)
    }

    def getState(): DotsState = state

    def toVulnerableState(): Unit = setState(VULNERABLE)

    private val VULNERABLE = new DotsState {

      override def getId(): Int = ???

      override def updateView(): Unit = ???

      override def onTouch(v: View, event: MotionEvent): Boolean = ???

      /** @param dots the dots that changed. */
      override def onDotsChange(dots: Dots): Unit = ???
    }



    }
  }









