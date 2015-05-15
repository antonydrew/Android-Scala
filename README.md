# Q&A (300-500 words):
**Note: ScalaDocs in doc folder of root project as well as STATE MODEL DIAGRAM...see YouTuve video as well!


## Pair Development

* Doc K has been helping me on this one especially with the ideas of thinking of the VIEW in an ABSTRACT manner (grid) and also with handling STATE...

## State Diagram versus Actual Code

* The state diagram should be very close to the actual code though the code will probably have more LISTENERS and variables to handle SCORE and LEVELS etc...

## Overall approach of Project and Trade-offs of MVC concept

* I tried to keep this tough project simple by running tasks ASYNC in background.  The STATE (MOVE/VULNERABLE) could be thought of as a separate OBJECT or even WITHIN DOTS.SCALA CLASS itself.
The big difference with MVC versus MVA is that the CONTROLLER is handling transactions between the MODEL and VIEW (though the MODEL can interact directly with the VIEW by emitting LISTENERS).
Because the CONTROLLER is so important, care must be taken to WIRE the CONTROLLER with the MODEL etc...

I did also try using GRIDVIEW to render squares on the GUI, but ended up simply drawing lines instead via OnDraw withing DotView.scala.