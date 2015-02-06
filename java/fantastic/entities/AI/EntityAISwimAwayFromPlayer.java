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

public class EntityAISwimAwayFromPlayer extends EntityAIBase
{
    private int speed = 0;
	private EntityLiving theWatcher;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float maxDistanceFromPlayer;
    private int lookTime;
    private float executionCheck;
    private Class watchedClass;


    public EntityAISwimAwayFromPlayer(EntityWaterMob aWaterMob, Class aWatchedClass, float aMaxDistanceFromPlayer, int aFleeingSpeed)
    {
        this.theWatcher = aWaterMob;
        this.watchedClass = aWatchedClass;
        this.maxDistanceFromPlayer = aMaxDistanceFromPlayer;
        this.executionCheck = 0.02F;
        this.speed=aFleeingSpeed;
        this.setMutexBits(2);
    }

    public EntityAISwimAwayFromPlayer(EntityWaterMob aWaterMob, Class aWatchedClass, float aMaxDistanceFromPlayer, float anExecutionCheck, int aFleeingSpeed)
    {
        this.theWatcher = aWaterMob;
        this.watchedClass = aWatchedClass;
        this.maxDistanceFromPlayer = aMaxDistanceFromPlayer;
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

            if (this.watchedClass == EntityPlayer.class)
            {
            	//DEBUG
            	//float _test = this.theWatcher.getDistanceToEntity(this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, 1000D));
            	//System.out.println(Float.toString(_test));
            	this.closestEntity = this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, (double)this.maxDistanceFromPlayer);
            }

            return this.closestEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.closestEntity.isEntityAlive() ? false : (this.theWatcher.getDistanceSqToEntity(this.closestEntity) > (double)(this.maxDistanceFromPlayer * this.maxDistanceFromPlayer) ? false : this.lookTime > 0);
    	
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
 
    	if (!((EntityFantasticFish)this.theWatcher).aiRegistry.isInMovement)
    	{
	        	
    		((EntityFantasticFish)this.theWatcher).aiRegistry.isInMovement=true;		
	    	EntityCreature _fish = ((EntityCreature)this.theWatcher);
	    	System.out.println("PLAYER TOO CLOSE!!!");
	        
	        Vec3 _vec3 = null;
	        Block _targetBlock = Blocks.bedrock;
	        
	        FishMovementHelper.FleeOtherEntity((EntityWaterMob)this.theWatcher, this.closestEntity, 7, 6, this.speed);
    	}

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

    }
}