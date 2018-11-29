import java.util.List;
import java.util.Random;

public class Main
{
	public static void log(String log)
	{
		System.out.println(log);
	}
	static final int[] startingPosition = {0, 0}; // top left
	static final int[] endingPosition = {19, 9}; // bottom right
	public static void main(String[] args)
	{
		int nX;
		int nY;
		int cX;
		int cY;

		Random rand = new Random();
		QTable qtable = new QTable();
		Qgrid grid = new Qgrid();

		cX = startingPosition[0];
		cY = startingPosition[1];

		log("");
//		log("This ran for 3 minutes because it is doing\n" +
//				"one hundred million iterations.");

		for (int i = 0; i < 10000000; i++)
		{
			int action;
			double randomness = .05;///.05

			if (rand.nextDouble() < randomness)
			{
				action = rand.nextInt(4);
			} else
			{
				action = 0;

				for (int candidateAction = 0; candidateAction < 4; candidateAction++)
				{
					if (qtable.getQValue(cX, cY, candidateAction) > qtable.getQValue(cX, cY, action))
						action = candidateAction;
				}
				if (qtable.getQValue(cX, cY, action) == 0.0)
					action = rand.nextInt(4);
			}

			//go a direction
			int[] xy = do_action(cX, cY, action);

			nX = xy[0];//new ones
			nY = xy[1];
			int a = action;
			grid.actions[cY][cX] = a;

			qtable.setQValue(cX, cY, action, nX, nY);

			if(nX == endingPosition[0] && nY == endingPosition[1] || hitAWall(nX,nY) )
			{
				cX = rand.nextInt(20);
				cY =rand.nextInt(10);
			}
			else
			{
				cX = nX;
				cY = nY;
			}
		}
		qtable.printQTable(grid);
	}

	static boolean hitAWall(int x, int y)
	{
		for (int i = 0; i < 4; i++)
		{
			if(y == i && x == 9)
				return true;
		}

		for (int i = 6; i < 10; i++)
		{
			if(y == i && x == 9)
				return true;
		}
		return false;
	}

	static int[] do_action(int x, int y, int action)
	{
		int[] temp = {x, y};

		if (action == 0 && y - 1 > 0) // up
		{
			temp[1] = y - 1;
			return temp;
		}
		if (action == 1 && y + 1 < 10) // down
		{
			temp[1] = y + 1;
			return temp;
		}
		if (action == 2 && x - 1 > 0) // left
		{
			temp[0] = x - 1;
			return temp;
		}
		if (action == 3 && x + 1 < 20) // right
		{
			temp[0] = x + 1;
			return temp;
		}
		return temp;
	}

	public static String getAction(int action)
	{
		if (action == 0)
			return "^";
		if (action == 1)
			return "v";
		if (action == 2)
			return "<";
		return ">";
	}
}
