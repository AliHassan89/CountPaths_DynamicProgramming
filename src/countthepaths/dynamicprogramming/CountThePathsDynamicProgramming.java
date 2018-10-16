/*

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

Time complexity:
Since we are using dynamic programming, the time complexity of this prgram will be O(mxn)
where 
m is the number of rows
n is the number of columns


 */
package countthepaths.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class CountThePathsDynamicProgramming 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<String> grid = new ArrayList<>();
        grid.add("1000");
        grid.add("0100");
        grid.add("0000");
        grid.add("0000");
        
        System.out.println(count_the_paths(grid));
    }
    
    public static int count_the_paths(List<String> grid) 
    {
        int row = grid.size();
        int col = (grid.get(0)).length();
        
        int[][] memo = new int[row][col];
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
            {
                memo[i][j] = -1;
            }
        }
        
        return countPaths(grid, memo, row-1, 0);
    }
    
    private static int countPaths(List<String> grid, int[][] memo, int r, int c)
    {
        if (r < 0)
            return 0;
        
        String s = grid.get(r);
        
        if (c == s.length() || s.charAt(c) == '1')
        {
            return 0;
        }
        
        if (memo[r][c] != -1)
        {
            return memo[r][c];
        }
        
        if (r == 0 && c == s.length() - 1)
        {
            return 1;
        }
        else
        {
            memo[r][c] = countPaths(grid, memo, r, c+1) + countPaths(grid, memo, r-1, c);
        }
        
        return memo[r][c];
        
    }
    
}
