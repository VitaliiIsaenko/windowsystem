### Expert Features

## Minimising windows

**minimisedSimpleWindows**: List containing all minimised Simple Windows
**simpleWindows:** List containing all simple windows.

When the green button in top right corner of any window is clicked, the simple window object is removed from the list simpleWindows and added to the list minimisedSimpleWindows. 

All of the simpleWindows in the minimisedSimpleWindows list are **displayed as icons** in the **bottom left** corner of the panel. When their dedicated button is pressed the simpleWindow object is **removed** from the **simpleWindows** list and **added** to the **minimisedSimpleWindows** list 


## Window Reordering 

**simpleWindows:** List containing all simple windows.
**n:**  size of *simpleWindows*

**Clicking** on any **visible part** of a any **window** will bring it to **back of the list**. 

The drawing method **iterates** over the **list of simple Windows** from **0 to n-1**, which means that the **simple window in position x** is displayed on **top** of **all other simple windows in positions y < x** .


## Active Window 

At all times one window **exactly one window** is marked **active**. This window is always the last element in the list **simpleWindows** .  It is displayed on top of everything else 