package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimAwayFromPlayer extends FFAI_Base 
{

    private final int COORDINATE_CHECK_INTERVAL = 500; //in ms


    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float toleratedDistance;
    private Class watchedClass;
    private long lastCoorTime=0;

	
	
	public FFAI_SwimAwayFromPlayer(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority,  Class aWatchedClass, float aToleratedDistance) 
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
        		//Check if a player is within range
	        	if (this.watchedClass == EntityPlayer.class)
	            {
	            	this.closestEntity = ffish.worldObj.getClosestPlayerToEntity(ffish, (double)toleratedDistance);
	            }
	        	
	        	if (this.closestEntity!=null)
	        	{
	        		FantasticDebug.Output("PLAYER TOO CLOSE");
	        		ffai.targetCoor = FishMovementHelper.GetFleeingCoordinate(ffish,this.closestEntity, 10,4);
	        		ffai.currentAIState = AIState.Fleeing;
	        		lastCoorTime = System.currentTimeMillis();
	        		return true;
	        	}


        	}
        }
        
        return false;
        	

	}
	
	
	
}
