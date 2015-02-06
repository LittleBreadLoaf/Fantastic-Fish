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

public class EntityAISwimStayStill extends EntityAIBase
{
    private EntityFantasticFish ffish;


    public EntityAISwimStayStill(EntityFantasticFish aFantasticFish)
    {
        this.ffish = aFantasticFish;
        this.setMutexBits(2);
    }


    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	return true;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	return true;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {

		FishMovementHelper.SwimStill(ffish);

    }

    @Override
    public boolean isInterruptible()
    {
        return false;
    }


}