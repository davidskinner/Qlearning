import java.util.Random;




public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        QTable qtable = new QTable();
        //Position object
        int cX = 0;
        int cY = 0;
        for (int i = 0; i < 1000; i++)
        {
            // Pick an action
            int action = 0;
            double randomness  = 0.05;
            if(rand.nextDouble() < randomness)
            {
                // Explore (pick a random action)
                //            action = rand.nextInt(4); // pick one of the four actions:l,r,u,d
            }
            else
            {
                //pick best action
                action = 0;

                if(qtable.getQValue(cX,cY, action) == 0.0)
                    action = rand.nextInt(4);
                else
                {
                    for (int candidateAction = 0; candidateAction < 4; candidateAction++)
                    {
                        if(qtable.getQValue(cX,cY,action) > qtable.getQValue(cX,cY, action))
                            action = candidateAction;
                    }
                }
            }
            //do the action
            //?????do? return array?

            //j is the new state coordinates or


        }

        //print grid

    }
}
