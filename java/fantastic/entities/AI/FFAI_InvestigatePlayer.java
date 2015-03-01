package fantastic.entities.AI;

import java.awt.Point;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.AI.EntityFFAI.AIState;

public class FFAI_InvestigatePlayer extends FFAI_Base 
{
	
	private int chanceOfAggression;
	private int circlingRadius;
	private Entity potentialTarget = null;
	private EntityPlayer closestPlayer = null;
	private double angleToPlayer = 0;

	
	public FFAI_InvestigatePlayer(EntityFFAI anAI, EntityFantasticFish aFish,int aPriority, int aPercentageOfExecution, int aChanceOfAggression, int aCirclingRadius) 
	{
		super(anAI, aFish,aPriority,aPercentageOfExecution);
		chanceOfAggression=aChanceOfAggression;
		circlingRadius=aCirclingRadius;
		
	
	}

	public boolean Execute()
	{
        if ((ffish!=null) && (ffish.isEntityAlive()))
        {

        	if ((potentialTarget!=null) && (potentialTarget.isEntityAlive()))
        	{
        		//There is already a potential target
        		circlePotentialTarget();
        	}
        	else
        	{
	        	
	        	//First, check the roll time if the action can be done at this time.
	        	long _currentTime = System.currentTimeMillis();
	        	if (ffai.TimeCheck(_currentTime))
	        	{
	        		//Since the time checked-in, it is possible that this action will be taken.
	        		//However, there is only a chance that it will happen
	        		if (ExecutionFilterCheck())
	        		{
	            		//Check if a player is within range
	                	this.closestPlayer = ffish.worldObj.getClosestPlayerToEntity(ffish, (double)10);
	                	if ((this.closestPlayer!=null) && (this.closestPlayer.isInWater()))
	                	{
	                		potentialTarget = this.closestPlayer;
	                		angleToPlayer = GetBestAngleToPlayer(this.closestPlayer,circlingRadius);
	                	}
	        		
	        		}
	        	
	        	}
        	}
        }
        
        return false;

	}
        
       private double GetBestAngleToPlayer(EntityPlayer aPlayer, double aRadius)
       {
    	   double _distance=99999;
    	   double _shortestDistance=99999;
    	   double _angleToPlayer=0;
    	   
    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 0, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=0;
    	   }

    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 45, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=45;
    	   }

    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 90, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=90;
    	   }

    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 135, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=135;
    	   }

    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 180, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=180;
    	   }
    	   
    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 225, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=225;
    	   }
    	   
    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 270, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=270;
    	   }
    	   
    	   _distance=GetDistanceFromTargetAtAngle(aPlayer, 315, aRadius);
    	   if (_distance<_shortestDistance)
    	   {
    		   _shortestDistance=_distance;
    		   _angleToPlayer=315;
    	   }
    	   
    	   return _angleToPlayer;
    	   
    	   
       }
       
       
       private double GetDistanceFromTargetAtAngle(Entity aTarget, double anAngle, double aRadius)
       {
    	   if ((ffish!=null) && (ffish.isEntityAlive()) && (aTarget!=null) && (aTarget.isEntityAlive()))
    	   {
	    	   Vec3 _vec3 = PointOnCircle(aRadius,anAngle,aTarget.posX,aTarget.posY,aTarget.posZ);
	    	   if (_vec3!=null)
	    	   {
		    	   if(ffish.worldObj.getBlock((int)_vec3.xCoord, (int)_vec3.yCoord, (int)_vec3.zCoord) == Blocks.water)
		    	   {
		    		   return ffish.getDistance(_vec3.xCoord, _vec3.yCoord, _vec3.zCoord);
		    	   }
	    	   }
    	   }
    	   return 99999;
    	   
       }
       
	
		private boolean circlePotentialTarget()
        {
        	return true;
        }
        
        
        private static Vec3 PointOnCircle(double radius, double angleInDegrees, double aCenterXCoor, double aCenterYCoor, double aCenterZCoor)
        {
            // Convert from degrees to radians via multiplication by PI/180        
            //double _x = (radius * Math.cos(angleInDegrees * Math.PI / 180F)) + aCenterXCoor;
            //double _z = (radius * Math.sin(angleInDegrees * Math.PI / 180F)) + aCenterZCoor;
        	
            double _x = Math.floor(radius * Math.cos(angleInDegrees));
            double _z = Math.floor(radius * Math.sin(angleInDegrees));
            	
            return Vec3.createVectorHelper(_x, aCenterYCoor, _z);
            
            //Anoter one
            //x = r * cos(a) 
            // y = r * sin(a) 
        } 
        
        private double NextAngle()
        {
        	angleToPlayer = (angleToPlayer+45) % 360;
        	return angleToPlayer;
        }
	
        private double PreviousAngle()
        {
        	angleToPlayer = (angleToPlayer-45) % 360;
        	return angleToPlayer;
        }
	
	
}
