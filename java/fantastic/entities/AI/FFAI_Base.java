package fantastic.entities.AI;

import java.util.Random;

import fantastic.entities.EntityFantasticFish;

public class FFAI_Base 
{
	protected Random rand = new Random();
	protected EntityFantasticFish ffish;
	protected EntityFFAI ffai;
	public int Priority = 0;
	protected int percentageOfExecution = -1;


	
	public FFAI_Base(EntityFFAI anAI, EntityFantasticFish aFish, int aPriority,int aPercentageOfExecution)
	{
		ffai = anAI;
		ffish = aFish;
		Priority=aPriority;
		percentageOfExecution=aPercentageOfExecution;

	}
	
	
	public boolean Execute()
	{
		//Nothing is done by default
		return false;
	}
	
	protected boolean ExecutionFilterCheck()
	{
		if (percentageOfExecution==-1)
		{
			return true;
		}
		else
		{
			return ((rand.nextInt(100)+1)<=percentageOfExecution);
		}

	}
	

	
	
}
