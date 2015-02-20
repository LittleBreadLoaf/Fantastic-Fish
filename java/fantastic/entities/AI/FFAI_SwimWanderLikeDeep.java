package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimWanderLikeDeep extends FFAI_Base 
{

	int xZone = 0;
	int yZone = 0;
	int maxSizeThatChangeDepth = 0;
	
	
	public FFAI_SwimWanderLikeDeep(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution,  int aXZone, int aYZone, int aMaxSizeThatChangeDepth) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		xZone = aXZone;
		yZone = aYZone;
		maxSizeThatChangeDepth=aMaxSizeThatChangeDepth;
	
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

    				//Fish of size large and legendary will stay deep
        			ffai.targetCoor=FishMovementHelper.findRandomTargetDescend((EntityCreature)ffish, xZone,4);
    			
        			if(ffai.targetCoor!=null)
        			{
        				ffai.currentAIState=AIState.Wander;
        				return true;
        			}
        		}
        		
        	}
        	
        }
        
        return false;
        	

	}
	
	
	
}
