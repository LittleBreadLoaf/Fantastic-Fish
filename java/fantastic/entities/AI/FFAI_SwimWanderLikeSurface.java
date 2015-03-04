package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimWanderLikeSurface extends FFAI_Base 
{

	int xZone = 0;
	int minRangeSwim = -1;
	
	
	public FFAI_SwimWanderLikeSurface(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution,  int aXZone, int aMinRangeSwim) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		xZone = aXZone;
		minRangeSwim=aMinRangeSwim;
	
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

    				//Fish of size large and legendary will stay close to the surface
        			ffai.targetCoor=FishMovementHelper.findRandomTargetAscend((EntityCreature)ffish, xZone,4,minRangeSwim,ffish.GetMinimumDepth());
        			
	        		//The target coor can be null if not enough depth is available. In this case, we will try to get a new coordinate with less depth.
	        		//Its better to move in shallow water than stay still.
	        		if (ffai.targetCoor==null)
	        		{
	        			ffai.targetCoor = FishMovementHelper.findRandomTargetAscend((EntityCreature)ffish, xZone,4,minRangeSwim,-1);
	        		}
        			
        			if(ffai.targetCoor!=null)
        			{
        				ffai.currentAIState=AIState.Wander;
            			ffai.targetCoor.yCoord=ffai.targetCoor.yCoord-ffish.PositionSizeAdjust();
        				return true;
        			}
        		}
        		
        	}
        	
        }
        
        return false;
        	

	}
	
	
	
}
