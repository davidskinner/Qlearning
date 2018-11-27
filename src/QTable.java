import java.util.HashMap;
import java.util.Map;

public class QTable
{
	HashMap<String,Double> Qtable = new HashMap<String, Double>();

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

	public void setQValue(int x, int y, int action)
	{
//		Qtable.replace()
	}

//	public calculateQValue(int x, int y, int action)



}
