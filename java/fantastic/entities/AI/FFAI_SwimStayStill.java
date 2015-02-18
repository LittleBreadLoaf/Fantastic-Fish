package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimStayStill extends FFAI_Base 
{

	
	public FFAI_SwimStayStill(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);

	}

	public boolean Execute()
	{
		
        if ((ffish!=null) && (ffish.isEntityAlive()))
        {
        	//First, check the roll time if the action can be done at this time.
        	long _currentTime = System.currentTimeMillis();
        	if (ffai.TimeCheck(_currentTime))
        	{

        		//Since the time checked-in, it is possible that this action will be taken.
        		//However, there is only a chance that it will happen
        		if (ExecutionFilterCheck())
        		{
        			ffai.targetCoor = Vec3.createVectorHelper(ffish.posX, ffish.posY, ffish.posZ);
            		ffai.currentAIState = AIState.StayStill;
            		return true;
        		}
        	}
        }

        	return false;
	}
	
}
