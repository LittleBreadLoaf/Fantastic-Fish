package fantastic.entities.AI;

import java.util.Random;

import fantastic.FantasticDebug;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FishMovementHelper 
{


// Return the total water depth on the Y axis at a specific location.
// The block passed in parameter must be a water block along the Y axis
	
	// Return the total water depth on the Y axis at a specific location.
	// The block passed in parameter must be a water block along the Y axis
		
	public static int getWaterDept(World aWorld, double xPos, double yPos, double zPos)
	{
		int _waterDepth = 0;
		
		for(int up = 0;up<=30;up++)
		{
			try
			{
				if(aWorld.getBlock((int)xPos, (int)yPos+up, (int)zPos) == Blocks.water)
				{
					_waterDepth++;
				}
			}
			catch (Exception ex)
			{
				//Do nothing, it only catches block that are out of range. Those are not water, so they are not added.
			}
		}		
		
		for(int down = -30; down<0; down++)
		{
			try
			{
				if(aWorld.getBlock((int)xPos, (int)yPos+down, (int)zPos) == Blocks.water)
				{
					_waterDepth++;
				}
			}
			catch (Exception ex)
			{
				//Do nothing, it only catches block that are out of range. Those are not water, so they are not added.			
			}
			
		}
		
		FantasticDebug.Output("Mesured water depth is: "+Integer.toString(_waterDepth));
		return _waterDepth++;
		
	}

	
	
public static void SwimStill(EntityWaterMob aWaterMob)
{
	
	if ((!aWaterMob.isDead) && (aWaterMob!=null))
	{
        if (!aWaterMob.worldObj.isRemote)
        {
			FantasticDebug.Output("SWIMMING STILL");
        	aWaterMob.motionX = 0D;
			aWaterMob.motionZ = 0D;
			aWaterMob.motionY = 0D;
        }
		
	}
}

public static void FleeOtherEntity(EntityWaterMob aWaterMob, Entity aScaryEntity, int xzFleeZoneSize, int yFleeZoneSize, int speed)
{
	
	if ((!aWaterMob.isDead) && (aWaterMob!=null) && (!aScaryEntity.isDead) && (aScaryEntity!=null))
	{
		double scaryXPos = aScaryEntity.posX;
		double scaryYPos = aScaryEntity.posY;
		double scaryZPos = aScaryEntity.posZ;
		Vec3 scaryVectorPos = Vec3.createVectorHelper(scaryXPos,scaryYPos,scaryZPos);
		Vec3 _fleeingCoor = findRandomTargetBlockAwayFrom(aWaterMob, xzFleeZoneSize, yFleeZoneSize, scaryVectorPos);
		
		if (_fleeingCoor!=null)
		{
			FantasticDebug.Output("ESCAPING at x:"+Double.toString(_fleeingCoor.xCoord)+" y:"+Double.toString(_fleeingCoor.yCoord)+" z:"+Double.toString(_fleeingCoor.zCoord));
			approachTarget(aWaterMob,_fleeingCoor.xCoord,_fleeingCoor.yCoord,_fleeingCoor.zCoord, speed);
		}
	}
}


private static Vec3 findRandomTargetBlockAwayFrom(EntityWaterMob aWaterMob, int xzFleeZoneSize, int yFleeZoneSize, Vec3 aScaryVectorPos)
{
    Vec3 _fleeingVector = Vec3.createVectorHelper((aWaterMob.posX - aScaryVectorPos.xCoord),(aWaterMob.posY - aScaryVectorPos.yCoord), (aWaterMob.posZ - aScaryVectorPos.zCoord));
    return findRandomTargetBlock(aWaterMob, xzFleeZoneSize, yFleeZoneSize, _fleeingVector);
}

/** searches 10 blocks at random in a within par1(x,z) and par2 (y) distance, ignores those not in the direction of
* par3Vec3, then points to the first water block available.
*/
private static Vec3 findRandomTargetBlock(EntityCreature p_75462_0_, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_)
{
   Random random = p_75462_0_.getRNG();
   boolean flag = false;
   int k = 0;
   int l = 0;
   int i1 = 0;
   boolean flag1;
   Block _targetBlock = Blocks.bedrock;

   if (p_75462_0_.hasHome())
   {
       double d0 = (double)(p_75462_0_.getHomePosition().getDistanceSquared(MathHelper.floor_double(p_75462_0_.posX), MathHelper.floor_double(p_75462_0_.posY), MathHelper.floor_double(p_75462_0_.posZ)) + 4.0F);
       double d1 = (double)(p_75462_0_.func_110174_bM() + (float)p_75462_1_);
       flag1 = d0 < d1 * d1;
   }
   else
   {
       flag1 = false;
   }

   for (int l1 = 0; l1 < 10; ++l1)
   {
       int j1 = random.nextInt(2 * p_75462_1_) - p_75462_1_;
       int i2 = random.nextInt(2 * p_75462_2_) - p_75462_2_;
       int k1 = random.nextInt(2 * p_75462_1_) - p_75462_1_;

       if (p_75462_3_ == null || (double)j1 * p_75462_3_.xCoord + (double)k1 * p_75462_3_.zCoord >= 0.0D)
       {
           j1 += MathHelper.floor_double(p_75462_0_.posX);
           i2 += MathHelper.floor_double(p_75462_0_.posY);
           k1 += MathHelper.floor_double(p_75462_0_.posZ);

           
       	_targetBlock = p_75462_0_.worldObj.getBlock(j1, i2, k1);
       	if (_targetBlock instanceof BlockLiquid)
       	{
       		//System.out.println("WATER BLOCK FOUND");
		   if (!flag1 || p_75462_0_.isWithinHomeDistance(j1, i2, k1))
		   {
		           k = j1;
		           l = i2;
		           i1 = k1;
		           flag = true;
		           break;
		       //}
           }
       	}
      }
   }

   if (flag)
   {
       return Vec3.createVectorHelper((double)k, (double)l, (double)i1);
   }
   else
   {
       return null;
   }
}




//Math converted to use more accurate and readable Vec3's
public static void approachTarget(EntityWaterMob aWaterMob, double xCoor, double yCoor, double zCoor, int speed) 
{
	if ((!aWaterMob.isDead) && (aWaterMob!=null))
	{
		Vec3 vec3 = Vec3.createVectorHelper(xCoor + 0.5D - aWaterMob.posX, yCoor + 0.1D - aWaterMob.posY, zCoor - aWaterMob.posZ).normalize();		
		aWaterMob.motionX += (vec3.xCoord * 0.5D - aWaterMob.motionX) * 0.05000000149011612D * speed;
		aWaterMob.motionY += (vec3.yCoord * 0.699999988079071D - aWaterMob.motionY) * 0.05000000149011612D * speed;
		aWaterMob.motionZ += (vec3.zCoord * 0.5D - aWaterMob.motionZ) * 0.05000000149011612D * speed;
		float f = (float) (Math.atan2(aWaterMob.motionZ, aWaterMob.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - aWaterMob.rotationYaw);
		aWaterMob.moveForward = 0.15F * speed;
		aWaterMob.rotationYaw += f1;
		aWaterMob.motionY += 0.0160829F;
	}
}


	
	
	
	
	
}
