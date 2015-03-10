package fantastic.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
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
import fantastic.entities.AI.FFAI_SwimAwayFromEntity;
import fantastic.entities.AI.FFAI_SwimAwayFromPlayer;
import fantastic.entities.AI.FFAI_SwimChaseSmallerFish;
import fantastic.entities.AI.FFAI_SwimJumpForFlies;
import fantastic.entities.AI.FFAI_SwimStayStill;
import fantastic.entities.AI.FFAI_SwimWanderAscendAtTime;
import fantastic.entities.AI.FFAI_SwimWanderFullRandom;
import fantastic.entities.AI.FFAI_SwimWanderLikeDeep;
import fantastic.entities.AI.FFAI_SwimWanderLikeSunnyAfternoon;
import fantastic.entities.AI.FishMovementHelper;
import fantastic.items.FantasticItems;

public class EntityFungus extends EntityFantasticFish
{
	//Textures
	private final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/fungus_fish.png");

	
	//CONSTRUCTOR
	public EntityFungus(World aWorld)
	{
		super(aWorld);
		brain=new EntityFFAI(this,10000,15000);
		InitializeAI();
	}

	//CONSTRUCTOR
	public EntityFungus(World aWorld, FishSize aSize, int aTextureIndex, int isOutOfWater)
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
		this.ignoreFrustumCheck = true;
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
				
				case Tiny : return 0.5F+currentSpeed*0.3F;
				case Small : return 0.5F+currentSpeed*0.3F;
				case Medium : return 0.5F+currentSpeed*0.3F;
				case Big : return 0.5F+currentSpeed*0.3F;
				case Large : return 0.5F+currentSpeed*0.3F;
				case Legendary : return 0.5F+currentSpeed*0.3F;
				default: return 0.5F; 
			}
	}
	
    @Override
	public float GetRenderValueFromSize()
	{
		switch (GetFishSize())
		{
			case Tiny : return 0.15F;
			case Small : return 0.60F;
			case Medium : return 0.70F;
			case Big : return 0.9F;
			case Large : return 1.3F;
			case Legendary : return 1.7F;
			default: return 0.15F; 
		}
	}
    
    @Override
    public float GetSpeedFromAIState(AIState aState)
    {
    	if (aState==AIState.Idle)
    	{
    		return 1;
    	}

    	
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
    		return 3;
    	}
    	
    	if (aState==AIState.Jump)
    	{
    		return 6;
    	}
    	
    	if (aState==AIState.Pursuing)
    	{
    		return 3;
    	}

    	
    	//default
    	return 1;
    	
    }
    

	public ResourceLocation GetTexture()
	{
		switch (GetTextureIndex())
		{
			case 1: return texture1;
			default: return texture1;
		}
		
	}
	
	public static int GetNumberOfTextures()
	{
		return 1;
	}
	
	//*** PROTECTED METHOD ***

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(FantasticItems.filletRaw, 1 + rand.nextInt(this.getNumberOfItemDroppedFromSize())), 0.0F);
	}


	
	//*** PRIVATE METHOD ***
	private int getNumberOfItemDroppedFromSize()
	{
		switch (this.GetFishSize())
		{
			case Tiny: return 1;
			case Small: return 1;
			case Medium: return 2;
			case Big: return 3;
			case Large: return 4;
			case Legendary: return 6;
			default : return 1;
		}
	}
	
	private void InitializeAI()
	{
        this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setCanSwim(true);
        this.tasks.taskEntries.clear();
        
        brain.AddActionToList(new FFAI_SwimAwayFromEntity(brain, this, 0,EntityCreature.class,2));
        brain.AddActionToList(new FFAI_SwimAwayFromPlayer(brain, this, 1,6));
        brain.AddActionToList(new FFAI_SwimAwayFromBiggerFish(brain, this, 2,EntityFantasticFish.class,3));
        brain.AddActionToList(new FFAI_SwimWanderAscendAtTime(brain,this,3,22500,4000,50,7,1,-1,4));
        brain.AddActionToList(new FFAI_SwimWanderAscendAtTime(brain,this,4,9500,14000,50,7,1,-1,4));
        brain.AddActionToList(new FFAI_SwimChaseSmallerFish(brain,this,5,20,7));

        
	}

	    
}
