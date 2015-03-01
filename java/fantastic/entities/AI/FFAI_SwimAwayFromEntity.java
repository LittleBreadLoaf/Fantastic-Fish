package fantastic.entities.AI;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimAwayFromEntity extends FFAI_Base 
{

    private final int COORDINATE_CHECK_INTERVAL = 500; //in ms


    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float toleratedDistance;
    private Class watchedClass;
    private long lastCoorTime=0;

	
	
	public FFAI_SwimAwayFromEntity(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority,  Class aWatchedClass, float aToleratedDistance) 
	{
		super(anAI, aFish,aPriority,-1);
		
		watchedClass = aWatchedClass;
		toleratedDistance=aToleratedDistance;


	}

	@Override
	public boolean Execute()
	{
        if ((ffish!=null) && (ffish.isEntityAlive()))
        {
        	long _currentTime = System.currentTimeMillis();
        	
        	if (_currentTime>lastCoorTime+COORDINATE_CHECK_INTERVAL) //Will not more often than every 500ms, making the swim fish in a more linear fashion.
        	{
        	
            	this.closestEntity=null;
        		//List _entityList = ffish.worldObj.getEntitiesWithinAABB(watchedClass, ffish.boundingBox.expand((double)toleratedDistance, (double)toleratedDistance,(double)toleratedDistance));
        		List _entityList = ffish.worldObj.getEntitiesWithinAABBExcludingEntity(ffish, ffish.boundingBox.expand((double)toleratedDistance, (double)toleratedDistance,(double)toleratedDistance));
        		Iterator _iterator = _entityList.iterator();

        		Object _scannedEntity = null;
				
				int _i = 0;
				while (_iterator.hasNext())
				{
					_scannedEntity = (Entity)_iterator.next();
					if (!(_scannedEntity instanceof EntityFantasticFish))
					{
							this.closestEntity = (Entity)_scannedEntity;
							break;
					}
				}
	        	
	        	if (this.closestEntity!=null)
	        	{
	        		FantasticDebug.Output("ENTITY TOO CLOSE",true);
	        		ffai.targetCoor = FishMovementHelper.GetFleeingCoordinate(ffish,this.closestEntity, 10,4,3,ffish.GetMinimumDepth());
	        		
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
        
        return false;
        	

	}
	
	
	
}
