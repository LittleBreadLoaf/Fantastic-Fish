package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimWanderLikeSunnyAfternoon extends FFAI_Base 
{

	int xZone = 0;
	int yZone = 0;
	int maxSizeThatChangeDepth = 0;
	
	
	public FFAI_SwimWanderLikeSunnyAfternoon(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution,  int aXZone, int aYZone, int aMaxSizeThatChangeDepth) 
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

        			int _sizeOrdinal = ffish.GetFishSize().ordinal();
        			if (_sizeOrdinal<=maxSizeThatChangeDepth)
        			{
        				//Fish of size big and smaller will change depth
        				long _time  = ffish.worldObj.getWorldTime();
        				if ((_time>=6000) && (_time<=10000))
	        			{
	        				//Fish ascend during bright daylight between noon and 16h00 to get sunlight
	        				ffai.targetCoor=FishMovementHelper.findRandomTargetAscend((EntityCreature)ffish, xZone,4);
	        			}
	        			else
	        			{
	        				//At another time its random
	        				ffai.targetCoor=FishMovementHelper.findRandomTarget((EntityCreature)ffish, xZone,4);
	        			}
        			}
        			else
        			{
        				//Fish of size large and legendary will stay deep
        				ffai.targetCoor=FishMovementHelper.findRandomTargetDescend((EntityCreature)ffish, xZone,4);
        				
        			}
        			
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
