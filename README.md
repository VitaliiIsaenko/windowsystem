3)

A callback function is simply a function which some piece of code calls, executes and return to the caller.  

It's a mechanism for postponing the decision of what function to call. Instead of having to make this decision when writing the code, you can make it at run time and choose a function which didn't even exist before.  This mechanism allows the use of the "plug-in" style to extend the capabilities of a piece of code. 

In C this is easily handled by pointers. In other languages it is handled in different ways. 

For example when registering an event listener, one normally defines a function which gets called when the event is triggered. Callback functions allow for this to happen. 

Java Swing Event listeners work in a similar way. You can register an event listener and perform any function you want when the event is triggered. The guys who designed the Java Swing library didn't hardcode every possible function the event listener can receive. Instead they made it abstract and allow the event listener to receive any function and perform it. In a certain way it is also a callback function.


More on Event Listener in C:

To register an event listener in C one could the Observer pattern for example. Pointers make it easy to register callback functions for the events.

