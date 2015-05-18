# Q&A (300-500 words):
**Note: ScalaDocs in doc folder of root project as well as STATE MODEL DIAGRAM...see YouTube video as well!


## Pair Development

* Doc K has been helping me on this one especially with the ideas of thinking of the VIEW in an ABSTRACT manner (grid) and also with handling STATE.  In general,
he instructed me to create a CLOCK class, an explicit STATE class and a MONSTERS class as well as using ASYNC.  Though I did not have the skill to tie all these CLASSES together, I still 
leant a lot in terms of efficient software engineering design.

## State Diagram versus Actual Code

* The state diagram should be very close to the actual code though the code will probably have more LISTENERS and variables to handle SCORE and LEVELS etc...

## Overall approach of Project and Trade-offs of MVC/MVA concepts

* I tried to keep this tough project simple by running tasks ASYNC in background.  The STATE (MOVE/VULNERABLE) could be thought of as a separate OBJECT or even WITHIN DOTS.SCALA CLASS itself.
The big difference with MVC versus MVA is that the CONTROLLER is handling transactions between the MODEL and VIEW (though the MODEL can interact directly with the VIEW by emitting LISTENERS).
Because the CONTROLLER is so important, care must be taken to WIRE the CONTROLLER with the MODEL etc.  Personally, I like MVA better as it is further DECOUPLED in terms of systems engineering.
What does this mean?  In MVA, the model cannot directly interact with the VIEW, so, it is easier to maintain as it is COMPARTMENTALIZED.

Though I did end up creating STATE, CLOCK and MONSTERS classes, I was NOT able to wire all these pieces together and create a fully functional game.
I did also try using GRIDVIEW to render squares on the GUI, but ended up simply drawing lines instead via OnDraw withing DotView.scala.

Since I could NOT get proper functionality working, I ended up just modifying DOTS class intead [of using CUSTOM MONSTERS class}.

A YouTube video can be seen here which demonstrates functionality of several projects and BitBucket project links here: http://youtu.be/91nFHyWR6VU

[YouTube](http://youtu.be/91nFHyWR6VU)

[Project 1a HelloWorld](https://adrew@bitbucket.org/adrew/cs413f14)
[Project 2 Shapes](https://adrew@bitbucket.org/adrew/cs413f14)
[Project 3a & 3b Stopwatch](https://adrew@bitbucket.org/adrew/stopwatch-android-scala)
[Make-up MidTerm](https://adrew@bitbucket.org/adrew/test2)
[Project 5](https://bitbucket.org/adrew/uidemo-android-scala)
