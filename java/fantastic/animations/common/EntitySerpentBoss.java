package fantastic.animations.common;

import net.minecraft.entity.EntityCreature;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import fantastic.animations.common.animations.SerpentBoss.AnimationHandlerSerpentBoss;
import fantastic.animations.common.mcacommonlibrary.IMCAnimatedEntity;
import fantastic.animations.common.mcacommonlibrary.animation.AnimationHandler;

public class EntitySerpentBoss extends EntityCreature implements IMCAnimatedEntity {
	protected AnimationHandler animHandler = new AnimationHandlerSerpentBoss(this);
	public EntitySerpentBoss(World par1World) {
		super(par1World);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public AnimationHandler getAnimationHandler() {
		return animHandler;
	}

	@Override
	public void onUpdate()
	{
            super.onUpdate();
        }

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readEntityFromNBT(nbttagcompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
	}
}