public class Qgrid
{
	double grid[][] = new double[10][20];
	int actions[][] = new int[10][20];

	Qgrid()
	{
	initializeGrid();
	}

	public void initializeGrid()
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
					grid[i][j] = 0;
			}
		}
		//make the wall in the center
		grid[0][9] = -5;
		grid[1][9] = -5;
		grid[2][9] = -5;
		grid[3][9] = -5;

		grid[6][9] = -5;
		grid[7][9] = -5;
		grid[8][9] = -5;
		grid[9][9] = -5;
	}
}
