# Kotlin_PathFinder

### Introduction
An interview question I was asked.

### Problem
Write an algorithm, to solve the following:

Follow the path, return the letters in order of a valid path.
* Input a starting and ending letter.
* Output should be a string of letters, CSV or otherwise, 
    showing a valid path.

For instance, given A & M the output path should be A,B,C,H,M

```
|=====|=====|=====|=====|=====|
|  A     B     C  |  D  |  E  |  
|=====|=====|     |     |=====|
|  F     G  |  H     I     J  |  
|=====|     |     |=====|     |
|  K     L  |  M  |  N  |  O  |  
|=====|     |=====|=====|=====|
|  P     Q     R     S     T  |  
|     |=====|=====|     |=====|
|  U  |  V     W  |  X     Y  |  
|=====|=====|=====|=====|=====|
```

### Technical Summary

I used a recursive function to start at a value, and loop through 
that values children, then those children's children and so on.  Until
either there are no more children, or the end value is found.

* Main Logic: [StartToEnd](src/main/kotlin/skunkworks/simplepathfinder/logic/StartToEnd.kt)
* Unit Tests: [Unit tests](src/test/kotlin/skunkworks/simplepathfinder/CellTests.kt)