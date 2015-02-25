package fantastic.entities.AI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_SwimJumpForFlies extends FFAI_Base 
{

	int maxSizeThatJump=0;
	private long startTime = -1;
	private long stopTime = -1;
	

	
	
	public FFAI_SwimJumpForFlies(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, long aStartTime, long aStopTime, int aPercentageOfExecution, int aMaxSizeThatJump) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		maxSizeThatJump=aMaxSizeThatJump;
		startTime=aStartTime;
		stopTime=aStopTime;
	
	}

	public boolean Execute()
	{
		
		if ((ffish!=null) && (ffish.isEntityAlive()))
        {
			
			int _sizeOrdinal = ffish.GetFishSize().ordinal();

			if ((ffai.CheckCurrentTimeBetweenInterval(startTime, stopTime)) && (_sizeOrdinal<=maxSizeThatJump)) //Only jump for flies at dusk
			{
	        	//First, check the roll time if the action can be done at this time.
	        	long _currentTime = System.currentTimeMillis();
	        	if (ffai.TimeCheck(_currentTime))
	        	{
	
	        		//Since the time checked-in, it is possible that this action will be taken.
	        		//However, there is only a chance that it will happen
	        		
	        		if (ExecutionFilterCheck())
	        		{
		        			Vec3 _coor = FishMovementHelper.GetSurfaveAirBlock(ffish.worldObj, Vec3.createVectorHelper(ffish.posX, ffish.posY, ffish.posZ));
		        			
		        			if (_coor!=null) 
		        			{
		        				double _dist = Math.floor(_coor.yCoord)-Math.floor(ffish.posY);	
		        				
		        				if ((_dist<=2) && (ffish.worldObj.isAirBlock((int)_coor.xCoord,(int)_coor.yCoord,(int)_coor.zCoord)))
			        			{
			        				FantasticDebug.Output("CAN JUMP");
			        				ffai.LockActionCurrentTime = System.currentTimeMillis();
			        				ffai.LockActionInterval = 1000; //pause of 1000ms, the fish cannot take any action while in the air.
			        				ffai.targetCoor=Vec3.createVectorHelper(_coor.xCoord, _coor.yCoord-2, _coor.zCoord);
			        				ffai.currentAIState=AIState.Jump;
			        				ffish.setVelocity(0,0.6,0);
			        				return true;
			        			}
		        			}
	        		}
	        		
	        	}
			}
        }
        
        return false;
        	

	}
	
	
	
}
