import java.util.HashMap;

public class QTable
{
	HashMap<String,Double> Qtable = new HashMap<>();

	QTable()
	{
		initializeQTable();

	}

	//initialize QTable to 0.0
	public void initializeQTable()
	{
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 4; k++)
				{
					Qtable.put(String.valueOf(i) + String.valueOf(j) + String.valueOf(k),0.0);
				}
			}
		}
	}

	public double getQValue(int x, int y, int action)
	{
		return Qtable.get(String.valueOf(x) + String.valueOf(y) + String.valueOf(action));
	}

	public int getTableSize()
	{
		int total = 0;
		for (Double list : this.Qtable.values()) {
			total += 1;
		}
		return total;
	}

	//used initially when a random direction is picked
	public void setQValue(int x, int y, int action, int bx, int by)
	{
		String key = String.valueOf(x) + String.valueOf(y) + String.valueOf(action);
		double value = (.9)*(getQValue(x, y, action)) + (.1)*(reward(bx,by) + (.97)*(getJValue(bx,by)));
		Qtable.replace(key, value);
	}

	public double getJValue(int x, int y)
	{
		//loop through and pick the best action
		double best = 0.0;
		double temp;

		for (int i = 0; i < 4; i++)
		{
			temp = getQValue(x,y,i);

			if(temp > best)
				best = temp;
		}
		return best;
	}

	public double reward(int x, int y)
	{
		if(x == 19 && y == 9)
			return 100.0;
		if(Main.hitAWall(x,y))
		{
			return -100.0;
		}
		else
			return 0;
	}

public void printQTable(Qgrid grid)
{
	for (int i = 0; i < 10; i++)
	{
		for (int j = 0; j < 20; j++)
		{
			//choose best boi
				String temp = getBestDirectionString(j,i,grid);
				System.out.print(temp + " ");
		}
		System.out.println();
	}
}

public String getBestDirectionString(int x, int y,Qgrid grid)
{
	if(x ==0 && y ==0)
		return "S";
	if(x ==19 && y ==9)
		return "G";
	if(grid.grid[y][x] == -5)//if the value at grid is negative return "#"
		return "#";

	return Main.getAction(grid.actions[y][x]);
}


}
