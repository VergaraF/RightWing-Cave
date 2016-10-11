# RightWing-Cave
RightWing Cave is a 1-player game consisting of a row of squares of any size each containing an integer.

The rules of the game are simple. The circle on the initial square is a marker that can move to other squares along the row. At each step in the game, you may move the marker the number of squares indicated by the integer in the square it currently occupies. The marker may move either left or right along the row but may not move past either end. For example, the only legal first move is to move the marker four squares to the right because there is no room to move four spaces to the left. The goal of the game is to move the marker to the cave, the “0” at the far end of the row. In this configuration, you can solve the game by making the following set of moves:

[4] 8 5 2 3 5 1 6 4 0
Starting position: Index 0, number = 4.

Step 1: Move right # of index as indicated by current number (in this case, it was 4, we move 4 indexes to the right)
4 8 5 2 [3] 5 1 6 4 0

Step 2: Keep moving right if it is possible, otherwise move left
4 8 5 2 3 5 1 [6] 4 0

Step 3: Move left as it was not possible to move right
4 [8] 5 2 3 5 1 6 4 0

Step 4: Move right as it was not possible to move left
4 8 5 2 3 5 1 6 4 [0]


Though the RightWing Cave game is solvable, actually with more than one solution—some configurations of this form may be impossible, such as the following one:

[5] 8 2 3 1 5 0

In this configuration, you will bounce between the two 5’s, but you cannot reach any other square.

This game is developed in Java for a Data Structures & Algorithm class
