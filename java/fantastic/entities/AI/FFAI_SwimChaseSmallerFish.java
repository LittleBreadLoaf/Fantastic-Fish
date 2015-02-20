package fantastic.entities.AI;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimChaseSmallerFish extends FFAI_Base 
{

    private final int COORDINATE_CHECK_INTERVAL = 500; //in ms
    
    protected Entity closestEntity;
    private float watchedDistance;
    private long lastCoorTime=0;
	
	
	public FFAI_SwimChaseSmallerFish(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution, float aWatchedDistance) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		
		watchedDistance = aWatchedDistance;


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
        		
	        		this.closestEntity=null;
		        	
		    		//Get the list of close fish
		    		List _fishList = ffish.worldObj.getEntitiesWithinAABB(EntityFantasticFish.class, ffish.boundingBox.expand((double)watchedDistance, (double)watchedDistance,(double)watchedDistance));
		        		
					Iterator _iterator = _fishList.iterator();
					EntityFantasticFish _scannedFish;
					
					int _i = 0;
					while (_iterator.hasNext())
					{
						//If the scanned fish is afraid of the current fish, it means that it is small enough to be chased
						_scannedFish = (EntityFantasticFish)_iterator.next();
						if (_scannedFish.IsAfraidOf(ffish))
						{
							this.closestEntity = _scannedFish;
							break;
						}
					}
		
		        	
		        	if (this.closestEntity!=null)
		        	{
		            	FantasticDebug.Output("CHASING SMALLER FISH",true);	
		        		ffai.targetCoor = Vec3.createVectorHelper(this.closestEntity.posX, this.closestEntity.posY,this.closestEntity.posZ);
		            	ffai.currentAIState = AIState.Pursuing;
			        	lastCoorTime = System.currentTimeMillis();
		            	return true;
		        	}
		        	else
		        	{
		        		FantasticDebug.Output("NO SMALL FISH FOUND",true);
		        	}

        		}
        	}
        }

        return false;
	}
	
}
