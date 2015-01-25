package edu.usc.preparation;

public class MazeRunner {

	private final int VISITED = 5;
	private final int PATH = 7;
	
	private int[][] grid = null;
	
	public MazeRunner(int[][] grid)
	{
		this.grid = grid;
	}
	
	private boolean isValid(int row, int column)
	{
		if((row >=0 && row <= grid.length-1) && (column>=0 && column <= grid[0].length-1))
		{
			if(grid[row][column] == 1) //shouldn't be VISITED=5, PATH=7 or blocked=0
				return true;
		}
		
		return false;
	}
	
	public boolean traverse(int row, int column)
	{
		boolean isComplete = false;
		
		if(isValid(row, column))
		{
			grid[row][column] = VISITED;
			
			if(row == grid.length-1 && column== grid[0].length-1)
			{
				isComplete = true;
			}
			else
			{
				isComplete = traverse(row+1, column);
				
				if(!isComplete)
					isComplete = traverse(row,column+1);
				if(!isComplete)
					isComplete = traverse(row-1,column);
				if(!isComplete)
					isComplete = traverse(row,column-1);
			}
			
			if(isComplete)
				grid[row][column]=PATH;
			
		}
		return isComplete;
	}
	
	public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("\n");

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[row].length; col++)
            {
               result.append(grid[row][col]);
            	result.append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
