package fantastic.entities.AI;


import fantastic.entities.EntityFantasticFish;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class EntityAISwimAwayFromBiggerFish  extends EntityAIBase
{
    private int speed = 0;
	private EntityLiving theWatcher;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float maxDistanceFromBigFish;
    private int lookTime;
    private float executionCheck;
    private Class watchedClass;


    public EntityAISwimAwayFromBiggerFish(EntityWaterMob aWaterMob, Class aWatchedClass, float aMaxDistance, int aFleeingSpeed)
    {
        this.theWatcher = aWaterMob;
        this.watchedClass = aWatchedClass;
        this.maxDistanceFromBigFish = aMaxDistance;
        this.executionCheck = 0.02F;	//Will be executed only 20% of the time
        this.speed=aFleeingSpeed;
        this.setMutexBits(2);
    }

    public EntityAISwimAwayFromBiggerFish(EntityWaterMob aWaterMob, Class aWatchedClass, float aMaxDistance, float anExecutionCheck, int aFleeingSpeed)
    {
        this.theWatcher = aWaterMob;
        this.watchedClass = aWatchedClass;
        this.maxDistanceFromBigFish = aMaxDistance;
        this.executionCheck = anExecutionCheck;
        this.speed=aFleeingSpeed;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theWatcher.getRNG().nextFloat() >= this.executionCheck)
        {
            return false;
        }
        else
        {
            if (this.theWatcher.getAttackTarget() != null)
            {
                this.closestEntity = this.theWatcher.getAttackTarget();
            }

            if (this.watchedClass == EntityFantasticFish.class)
            {
                this.closestEntity = this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.boundingBox.expand((double)this.maxDistanceFromBigFish, 3.0D, (double)this.maxDistanceFromBigFish), this.theWatcher);
            }

            return this.closestEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.closestEntity.isEntityAlive() ? false : (this.theWatcher.getDistanceSqToEntity(this.closestEntity) > (double)(this.maxDistanceFromBigFish * this.maxDistanceFromBigFish) ? false : this.lookTime > 0);
    	
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        EntityCreature _fish = ((EntityCreature)this.theWatcher);
    	System.out.println("BIG FISH TOO CLOSE!!!");
        
        Vec3 _vec3 = null;
        Block _targetBlock = Blocks.bedrock;
        
        FishMovementHelper.FleeOtherEntity((EntityWaterMob)this.theWatcher, this.closestEntity, 7, 6, this.speed);
        
//	    for (int _i=0;_i<100;_i++)
//	    {
//	    	//_vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom((EntityCreature)this.closestEntity, 8, 4, Vec3.createVectorHelper(this.closestEntity.posX, this.closestEntity.posY, this.closestEntity.posZ));
//	    	_vec3 = RandomPositionGenerator.findRandomTarget(_fish,8,4);
//	    	_targetBlock = this.theWatcher.worldObj.getBlock(MathHelper.floor_double(_vec3.xCoord),MathHelper.floor_double(_vec3.yCoord),MathHelper.floor_double(_vec3.zCoord));
//	    	if (_targetBlock instanceof BlockLiquid)
//	    	{
//	    		System.out.println("RUNNING AWAY!!!");
//	    		_fish.getNavigator().tryMoveToXYZ(_vec3.xCoord,_vec3.yCoord,_vec3.zCoord, 3.0);
//	    		break;
//	    	}
//	    	
//	    }
        


    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.closestEntity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        //this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0F, (float)this.theWatcher.getVerticalFaceSpeed());
        //--this.lookTime;
    }

}	
