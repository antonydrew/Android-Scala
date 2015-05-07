package model

import edu.luc.etl.cs313.scala.uidemo.model.Dots

object State {
  trait DotsChangeListener {
    /** @param dots the dots that changed. */
    def onDotsChange(dots: Dots): Unit
  }
}

/* TODO must work on STATE model for monsters:
-Make abstract rep of 2D grid
-Use ASYNC in background that sends onTick() event to ALL monsters at once so each monster is a little state
-2 main states: MOVE [can I?] and VULNERABLE [to TOUCH event]...if can move then invoke/create onMove() method [which uses RAND square jump]
-Use BINARY SEMAPHORE to make sure only 1 monster allowed [or filling] each square
-Once abstract rep is done for 2D grid, then study onDraw API to figure out how to render board in MAIN.XML...

 */

