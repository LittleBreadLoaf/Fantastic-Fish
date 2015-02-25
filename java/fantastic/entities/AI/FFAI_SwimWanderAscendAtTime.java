package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimWanderAscendAtTime extends FFAI_Base 
{
	private long startTime = -1;
	private long stopTime = -1;
	private int xZone = 0;
	private int yZone = 0;
	private int minRangeSwim = -1;
	private int maxSizeThatChangeDepth = 0;
	
	
	public FFAI_SwimWanderAscendAtTime(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, long aStartTime, long aStopTime, int aPercentageOfExecution,  int aXZone, int aYZone, int aMinRangeSwim, int aMaxSizeThatChangeDepth) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		xZone = aXZone;
		yZone = aYZone;
		startTime=aStartTime;
		stopTime=aStopTime;
		minRangeSwim=aMinRangeSwim;
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

        			boolean _inAscendTime = ffai.CheckCurrentTimeBetweenInterval(startTime,stopTime);
        			
        			FantasticDebug.Output("AscendTime: "+Boolean.toString(_inAscendTime)+" Time: "+Long.toString(ffish.worldObj.getWorldTime() % 24000));

        			
        			int _sizeOrdinal = ffish.GetFishSize().ordinal();
        			if (_sizeOrdinal<=maxSizeThatChangeDepth)
        			{
        				//Fish of size big and smaller will change depth
	        			if (_inAscendTime)
	        			{
	        				//Fish ascend at dusk and dawn
	        				ffai.targetCoor=FishMovementHelper.findRandomTargetAscend((EntityCreature)ffish, xZone,4,minRangeSwim,ffish.GetMinimumDepth());
	        			}
	        			else
	        			{
	        				ffai.targetCoor=FishMovementHelper.findRandomTargetDescend((EntityCreature)ffish, xZone,4,minRangeSwim,ffish.GetMinimumDepth());
	        			}
        			}
        			else
        			{
        				//Fish of size large and legendary will stay deep
        				ffai.targetCoor=FishMovementHelper.findRandomTargetDescend((EntityCreature)ffish, xZone,4,minRangeSwim,ffish.GetMinimumDepth());
        				
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
