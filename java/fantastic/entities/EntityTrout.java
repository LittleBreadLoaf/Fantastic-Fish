package fantastic.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import fantastic.FantasticDebug;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.entities.AI.EntityFFAI.AIState;
import fantastic.entities.AI.EntityFFAI;
import fantastic.entities.AI.FFAI_SwimAwayFromBiggerFish;
import fantastic.entities.AI.FFAI_SwimAwayFromPlayer;
import fantastic.entities.AI.FFAI_SwimChaseSmallerFish;
import fantastic.entities.AI.FFAI_SwimJumpForFlies;
import fantastic.entities.AI.FFAI_SwimStayStill;
import fantastic.entities.AI.FFAI_SwimWander;
import fantastic.entities.AI.FishMovementHelper;
import fantastic.items.FantasticItems;

public class EntityTrout extends EntityFantasticFish
{
	//Textures
	private final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/trout1.png");
	private final ResourceLocation texture2 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/trout2.png");

	
	//CONSTRUCTOR
	public EntityTrout(World aWorld)
	{
		super(aWorld);
		brain=new EntityFFAI(this,10000,15000,22500,4000,9500,14000);
		InitializeAI();
	}

	//CONSTRUCTOR
	public EntityTrout(World aWorld, FishSize aSize, int aTextureIndex, int isOutOfWater)
	{
		this(aWorld);
		InitializeFish(aSize,aTextureIndex,isOutOfWater);
	}
	
	//*** PUBLIC METHOD ***
	@Override
	public void InitializeFish(FishSize aSize, int aTextureIndex, int isOutOfWater)
	{
		SetFishSize(aSize);
		SetTextureIndex(aTextureIndex);
		SetIsOutOfWater(isOutOfWater);
		this.ignoreFrustumCheck = true;
		SetHasNotSpawned(false);
		this.setSize(1.0F, 1.0F);
	}
	
	//This property tells if the class has different size of fish for the same class. By default, it return false. 
	//Override that methof if the class has multiple size.
	@Override
	public boolean GetHasDifferentSize()
	{
		return true;
	}
	
	@Override
	public float GetTailFlapSpeed()
	{
		

		//return 0.5F;
			switch (GetFishSize())
			{
				
				case Tiny : return 1.0F*currentTailFlapSpeedMult;
				case Small : return 0.8F*currentTailFlapSpeedMult;
				case Medium : return 0.7F*currentTailFlapSpeedMult;
				case Big : return 0.6F*currentTailFlapSpeedMult;
				case Large : return 0.5F*currentTailFlapSpeedMult;
				case Legendary : return 0.4F*currentTailFlapSpeedMult;
				default: return 1.0F; 


			}
	}
	
	
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

	}
	
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
		
	}
	


    @Override
	public float GetRenderValueFromSize()
	{
		switch (GetFishSize())
		{
			case Tiny : return 0.15F;
			case Small : return 0.30F;
			case Medium : return 0.40F;
			case Big : return 0.7F;
			case Large : return 0.9F;
			case Legendary : return 1.2F;
			default: return 0.15F; 
		}
	}
    
    @Override
    public double GetSpeedFromAIState(AIState aState)
    {
    	if (aState==AIState.StayStill)
    	{
    		return 1;
    	}
    	
    	if (aState==AIState.Wander)
    	{
    		return 1;
    	}

    	if (aState==AIState.Fleeing)
    	{
    		return 6;
    	}
    	
    	if (aState==AIState.Jump)
    	{
    		return 10;
    	}
    	
    	if (aState==AIState.Pursuing)
    	{
    		return 6;
    	}

    	
    	//default
    	return 1;
    	
    }
    
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	public ResourceLocation GetTexture()
	{
		switch (GetTextureIndex())
		{
			case 1: return texture1;
			case 2: return texture2;
			default: return texture1;
		}
		
	}
	
	public static int GetNumberOfTextures()
	{
		return 2;
	}
	
	//*** PROTECTED METHOD ***
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D );
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(FantasticItems.rawTroutFillet, 1 + rand.nextInt(this.getNumberOfItemDroppedFromSize())), 0.0F);
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return null;
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
			return null;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return null;
	}

	protected boolean canDespawn()
	{
	    return this.hasCustomNameTag() ? false : true;
	}

	
	//*** PRIVATE METHOD ***
	private int getNumberOfItemDroppedFromSize()
	{
		switch (this.GetFishSize())
		{
			case Tiny: return 1;
			case Small: return 1;
			case Medium: return 2;
			case Big: return 2;
			case Large: return 3;
			case Legendary: return 5;
			default : return 1;
		}
	}
	
	private void InitializeAI()
	{
        this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setCanSwim(true);
        this.tasks.taskEntries.clear();
        
        brain.AddActionToList(new FFAI_SwimAwayFromPlayer(brain, this, 0,EntityPlayer.class,6));
        brain.AddActionToList(new FFAI_SwimAwayFromBiggerFish(brain, this, 1,EntityFantasticFish.class,2));
        brain.AddActionToList(new FFAI_SwimWander(brain,this,2,40,7,1,4));
        brain.AddActionToList(new FFAI_SwimChaseSmallerFish(brain,this,3,20,7));
        brain.AddActionToList(new FFAI_SwimJumpForFlies(brain, this, 3,30,3));
        //brain.AddActionToList(new FFAI_SwimStayStill(brain, this,0,100));

        
	}

	    
}
