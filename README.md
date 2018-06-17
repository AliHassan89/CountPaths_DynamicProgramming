# CountPaths_DynamicProgramming

You are given a grid of cells with size N rows by M columns. A robot is situated 
at the bottom-left cell (row N-1, column 0). It can move from cell to cell but 
only to the right and to the top. Some cells are empty and the robot can pass 
through them but others are not and the robot cannot enter such cells. The robot 
cannot go outside the grid boundaries.

The robot has a goal to reach top-right cell (row 0, column M-1). Both the start 
and end cells are always empty. You need to compute the number of different paths 
that the robot can take from start to end. Only count paths that visit empty 
cells and move only to the right and up.

N and M will be numbers in the range [1, 512].

Write a method, which accepts the grid as an argument and returns one integer - 
the total number of different paths that the robot can take from the start to 
the end cell, MODULO 1,000,003. The reason we will use the modulo operation here 
is that the actual result could become a really big number and we don't want to 
let handling big numbers complicate the task more.

The input grid will contain N strings with M characters each - either '0' or '1', 
with '0' meaning an empty cell and '1' meaning an occupied cell. Each of these 
strings corresponds to a row in the grid.

# Solution

1. Create a memo table of same number of rows and columns. e.g: int[][] memo = new int[row][col]

2. Initialize the memo table with -1 value.

3. Pass following parameters in a recursive function 
	* grid
	* memo table
	* starting position of robot which is last row and first column
	
4. The base case of recursive function will check if row is less than 0 then return 0.

5. Another case will check if the robot has gone outside the grid or the value in the grid box is 1 then return 0.

6. Otherwise it is checked if the value in memo table for this particular box is not -1 then that means this box has been visited before and the number of paths are known to get here then simply return memo[r][c].

7. If robot has reached top right corner then return 1.

8. Lastly recursively call function moving one column to the right plus moving one row up and saving the value in memo table for that row and column.

9. return value from memo table for row and column.
