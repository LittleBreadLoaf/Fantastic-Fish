package fantastic.entities.AI;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimAwayFromBiggerFish extends FFAI_Base 
{

    private final int COORDINATE_CHECK_INTERVAL = 500; //in ms
    
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float toleratedDistance;
    private Class watchedClass;
    private long lastCoorTime=0;

	
	
	public FFAI_SwimAwayFromBiggerFish(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, Class aWatchedClass, float aToleratedDistance) 
	{
		super(anAI, aFish,aPriority,-1);
		
		watchedClass = aWatchedClass;
		toleratedDistance=aToleratedDistance;

	}

	public boolean Execute()
	{
        if ((ffish!=null) && (ffish.isEntityAlive()))
        {
        	long _currentTime = System.currentTimeMillis();
        	
        	if (_currentTime>lastCoorTime+COORDINATE_CHECK_INTERVAL) //Will not more often than every 500ms, making the swim fish in a more linear fashion.
        	{
        		this.closestEntity=null;
	        	//Check if another fish is within range
	        	if (this.watchedClass == EntityFantasticFish.class)
	            {
	            	//this.closestEntity = ffish.worldObj.findNearestEntityWithinAABB(this.watchedClass, ffish.boundingBox.expand((double)toleratedDistance, (double)toleratedDistance,(double)toleratedDistance), ffish);
	            	
	        		//Get the list of close fish
	        		List _fishList = ffish.worldObj.getEntitiesWithinAABB(EntityFantasticFish.class, ffish.boundingBox.expand((double)toleratedDistance, (double)toleratedDistance,(double)toleratedDistance));
	        		
					Iterator _iterator = _fishList.iterator();
					EntityFantasticFish _scannedFish;
					
					int _i = 0;
					while (_iterator.hasNext())
					{
						_scannedFish = (EntityFantasticFish)_iterator.next();
						if (ffish.IsAfraidOf(_scannedFish))
						{
							this.closestEntity = _scannedFish;
							break;
						}
					}

	            }
	        	
	        	if (this.closestEntity!=null)
	        	{
	        		if (ffish.IsAfraidOf((EntityFantasticFish)this.closestEntity))
	        		{
	            		ffai.targetCoor = FishMovementHelper.GetFleeingCoordinate(ffish,this.closestEntity, 7,4,-1,ffish.GetMinimumDepth());
	            		
		        		//The target coor can be null if not enough depth is available. In this case, we will try to get a new coordinate with less depth.
		        		//Its better to move in shallow water than stay still.
		        		if (ffai.targetCoor==null)
		        		{
		        			ffai.targetCoor = FishMovementHelper.GetFleeingCoordinate(ffish,this.closestEntity, 8,2,3,-1);
		        		}
	            		
	            		ffai.currentAIState = AIState.Fleeing;
		        		lastCoorTime = System.currentTimeMillis();
	            		return true;
	        			
	        		}
	        	}
	        	
        	}
        }
        
        return false;
	}
	
}
