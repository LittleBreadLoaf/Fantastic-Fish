package fantastic.entities;

import java.lang.reflect.Constructor;

import sun.security.action.GetIntegerAction;
import cpw.mods.fml.common.FMLCommonHandler;
import fantastic.FantasticDebug;
import fantastic.FantasticIds;
import fantastic.FantasticMod;
import fantastic.entities.AI.EntityFFAI;
import fantastic.entities.AI.FishMovementHelper;
import fantastic.entities.AI.EntityFFAI.AIState;
import fantastic.network.FantasticNetwork;
import fantastic.network.TailSpeedMessage;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFantasticFish extends EntityWaterMob
{
	public static enum FishSize { Null,Tiny,Small,Medium,Big,Large,Legendary, OneSize};


	private static int DATAWATCHER_OUT_OF_WATER = 17;
	private static int DATAWATCHER_TEXTURE = 19;
	private static int DATAWATCHER_FISH_SIZE = 21;
	private static String DATAWATCHER_OUT_OF_WATER_STRING = "IsOutOfWater";
	private static String DATAWATCHER_TEXTURE_STRING = "TextureIndex";
	private static String DATAWATCHER_FISH_SIZE_STRING = "FishSize";
	private static String DATAWATCHER_HAS_NOT_SPAWNED_STRING = "HasNotSpawned";


	public EntityFFAI brain;
	public int currentSpeed=1;
	public FishSize currentSize = FishSize.Null;
	
	private boolean hasNotSpawned = true;
	
	protected float currentTailFlapSpeedMult = 1.0F;

	

	//CONSTRUCTOR
	public EntityFantasticFish(World aWorld) 
	{
		super(aWorld);
		
	}

	public void InitializeFish(FishSize aSize, int aTextureIndex, int isOutOfWater)
	{
	}
	
	//*** PROPERTIES
	
	//This property tells if the class has different size of fish for the same class. By default, it return false. 
	//Override that methof if the class has multiple size.
	public boolean GetHasDifferentSize()
	{
		return false;
	}
	
	//This property tells on 1000 what is the change that a fish spawn at the size returned. Those are the default values,
	//they can be overriden in sub classes.
	public static int GetSizeDefaultSpawnFilter(FishSize aSize)
	{

		if (aSize==FishSize.Tiny) return 400;
		if (aSize==FishSize.Small) return 300;
		if (aSize==FishSize.Medium) return 150;
		if (aSize==FishSize.Big) return 90;
		if (aSize==FishSize.Large) return 50;
		if (aSize==FishSize.Legendary) return 10;
		
		return 1000; //For the one size fish. Not filtered.
	}
	
	
	public float GetTailFlapSpeed()
	{
		return 1;
	}
	
	public boolean GetHasNotSpawned()
	{
		return this.hasNotSpawned;
	}
	
	public void SetHasNotSpawned(boolean hasSpawned)
	{
		this.hasNotSpawned = hasSpawned;
	}
	
	public void SetIsOutOfWater(int par1)
	{
		if(FMLCommonHandler.instance().getEffectiveSide().isServer())
		this.dataWatcher.updateObject(DATAWATCHER_OUT_OF_WATER, Integer.valueOf(par1));
	}
	
	public int GetIsOutOfWater()
	{
		int _isOut;
		try
		{
			_isOut = this.dataWatcher.getWatchableObjectInt(DATAWATCHER_OUT_OF_WATER);
		}
		catch (Exception ex)
		{
			_isOut=0;
		}
		
		return _isOut;
	}
	

	public int GetTextureIndex()
	{
		int _texture;
		try
		{
			_texture = this.dataWatcher.getWatchableObjectInt(DATAWATCHER_TEXTURE);
		}
		catch (Exception ex)
		{
			_texture = 1;
		}
		return _texture;
		
	}
	
	//This property tells how many texture are available. It must be overriden in sub classes.
	public static int GetNumberOfTextures()
	{
		return 1;
	}
	
	protected void SetTextureIndex(int par1)
	{
		if(FMLCommonHandler.instance().getEffectiveSide().isServer())
		this.dataWatcher.updateObject(DATAWATCHER_TEXTURE, Integer.valueOf(par1));
	}
	



	public FishSize GetFishSize()
	{
		FishSize _size;
		
		if (currentSize!=FishSize.Null)
		{
			return currentSize;
		}
		else
		{
			//Try to get it from the NBT
			try
			{
				_size = GetDataWatcherSizeForValue(this.dataWatcher.getWatchableObjectInt(DATAWATCHER_FISH_SIZE));
			}
			catch (Exception ex)
			{
				_size = FishSize.Tiny;//Tiny by default
			}
		}

		return _size;
	}
	
	

	public static void SpawnFromItemDamage(World aWorld, FishSize aSize, int isOutOfWater, double posX, double posY, double posZ, int anItemDamage)
	{
		switch (anItemDamage)
		{
			case 0 : SpawnSizedFish(aWorld,EntityBasicFish.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 1 : SpawnSizedFish(aWorld,EntityBasicFish.class,2, aSize,isOutOfWater,posX,posY,posZ);break;
			case 2 : SpawnSizedFish(aWorld,EntityBasicFish.class,3, aSize,isOutOfWater,posX,posY,posZ);break;
			case 3 : SpawnSizedFish(aWorld,EntityBasicFish.class,4, aSize,isOutOfWater,posX,posY,posZ);break;
			case 4 : SpawnSizedFish(aWorld,EntityBasicFish.class,5, aSize,isOutOfWater,posX,posY,posZ);break;
			case 5 : SpawnSizedFish(aWorld,EntityBasicFish.class,6, aSize,isOutOfWater,posX,posY,posZ);break;
			case 6 : SpawnSizedFish(aWorld,EntityCaveFish.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 7 : SpawnSizedFish(aWorld,EntityFeeder.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 8 : SpawnSizedFish(aWorld,EntityMossy.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 9 : SpawnSizedFish(aWorld,EntityTuna.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 10 : SpawnSizedFish(aWorld,EntityCatfish.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 11 : SpawnSizedFish(aWorld,EntitySalmon.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 12 : SpawnSizedFish(aWorld,EntitySalmon.class,2, aSize,isOutOfWater,posX,posY,posZ);break;
			case 13 : SpawnSizedFish(aWorld,EntityFungus.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 14 : SpawnSizedFish(aWorld,EntityPike.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 15 : SpawnSizedFish(aWorld,EntityPike.class,2, aSize,isOutOfWater,posX,posY,posZ);break;
			case 16 : SpawnSizedFish(aWorld,EntityMusky.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 17 : SpawnSizedFish(aWorld,EntityTrout.class,1, aSize,isOutOfWater,posX,posY,posZ);break;
			case 18 : SpawnSizedFish(aWorld,EntityTrout.class,2, aSize,isOutOfWater,posX,posY,posZ);break;

			default : SpawnSizedFish(aWorld,EntityBasicFish.class,1, aSize,isOutOfWater,posX,posY,posZ);break; //on a bug, a basic fish will be returned
			
		}	
	}
	
	public static void SpawnSizedFish(World aWorld,Class aFishClass, int aTextureIndex, FishSize aSize,  int isOutOfWater, double posX, double posY, double posZ)
	{
		
		if ((aFishClass!=null) && (aTextureIndex>-1))
		{
			try
			{
				//Set the parameter array to get the constructor by reflection
				Class[] _typeList = new Class[]{World.class, FishSize.class,int.class,int.class};
				
				//Get the constructor
				Constructor _cons = aFishClass.getConstructor(_typeList);
				
				//Set the parameter values array for the constructor
				Object[] _objList = {aWorld,aSize,aTextureIndex,isOutOfWater};
				
				//Instantiate the fish
				Object _newFish = _cons.newInstance(_objList);
				
				//Spawn it
				((Entity)_newFish).setLocationAndAngles(posX, posY, posZ, 0, 0);
				aWorld.spawnEntityInWorld((Entity)_newFish);
				
			} catch (Exception e) 
			{
				FantasticDebug.Output(e.getStackTrace().toString());
			}			
		}

	}

	

    /*public float GetRenderDropDownFromSide()
    {
    	return 0; 
    }*/
	
	protected void SetFishSize(FishSize aFishSize)
	{
		if (aFishSize!=FishSize.Null)
		{
			currentSize=aFishSize;
			if(FMLCommonHandler.instance().getEffectiveSide().isServer())
				this.dataWatcher.updateObject(DATAWATCHER_FISH_SIZE, GetDataWatcherIntValueForSize(aFishSize));
		}
				
	}
	
    
	//Will disable gravity if the fish is in the water. Will enable gravity if the fish is out of the water.
	@Override
    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {

		if (this.isInWater())
		{
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		}
		else
		{
			super.moveEntityWithHeading(p_70612_1_,p_70612_2_);
		}

    }
	
	
	@Override
	protected void updateAITasks()
	{
		brain.Tick();
	}

	
	protected boolean isAIEnabled()
	{
		return true;

	}

	public int getTotalArmorValue()
	{
		return 0;
	}

	
	/**
	 * By default, a fish is afraid of another fish 2 sizes bigger than they are. Example. A Tiny fish is not afraid of other Tiny or Small fishes. But they are otherwise.
	 * @param anotherFish
	 * @return True if its afraid
	 */
	public boolean IsAfraidOf(EntityFantasticFish anotherFish)
	{
		if ((!anotherFish.isDead) && (anotherFish!=null))
		{
			//TINY
			if (this.GetFishSize()==FishSize.Tiny)
			{
				return ((anotherFish.GetFishSize()==FishSize.Medium) || (anotherFish.GetFishSize()==FishSize.Big) || (anotherFish.GetFishSize()==FishSize.Large) ||(anotherFish.GetFishSize()==FishSize.Legendary));
			}
			
			//SMALL
			if (this.GetFishSize()==FishSize.Small)
			{
				return ((anotherFish.GetFishSize()==FishSize.Big) || (anotherFish.GetFishSize()==FishSize.Large) ||(anotherFish.GetFishSize()==FishSize.Legendary));
			}
			
			//MEDIUM
			if (this.GetFishSize()==FishSize.Medium)
			{
				return ((anotherFish.GetFishSize()==FishSize.Large) ||(anotherFish.GetFishSize()==FishSize.Legendary));
			}
			
			//BIG
			if (this.GetFishSize()==FishSize.Big)
			{
				return (anotherFish.GetFishSize()==FishSize.Legendary);
			}

		}
		
		//Default is not afraid. Large and Legendary are not afraid of anything
		return false;

	}
	


	//This method needs to be overriden
	public float GetRenderValueFromSize()
	{
		return 1.0F;
	}
	
	public void SetCurrentTailFlapSpeedMult(float aMult)
	{
		if (aMult!=currentTailFlapSpeedMult)
		{
			if (!this.worldObj.isRemote)
			{
				
				FantasticNetwork.network.sendToAll(new TailSpeedMessage(this.getEntityId(), currentTailFlapSpeedMult));
			}
			
			currentTailFlapSpeedMult=aMult;
		}

	}
	
	public float GetCurrentTailFlapSpeedMult()
	{
		return currentTailFlapSpeedMult;
	}
	
    public double GetSpeedFromAIState(AIState aState)
    {
    	//default
    	return 1;
    }



	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(DATAWATCHER_OUT_OF_WATER, Integer.valueOf(0));
		this.dataWatcher.addObject(DATAWATCHER_TEXTURE, Integer.valueOf(0));
		this.dataWatcher.addObject(DATAWATCHER_FISH_SIZE, Integer.valueOf(0));
		//this.dataWatcher.addObject(22, Integer.valueOf(-1));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		FantasticDebug.Output("writeEntityToNbt");
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger(DATAWATCHER_TEXTURE_STRING, this.GetTextureIndex());
		par1NBTTagCompound.setInteger(DATAWATCHER_FISH_SIZE_STRING, GetDataWatcherIntValueForSize(this.GetFishSize()));
		par1NBTTagCompound.setBoolean(DATAWATCHER_HAS_NOT_SPAWNED_STRING, this.GetHasNotSpawned());
		par1NBTTagCompound.setInteger(DATAWATCHER_OUT_OF_WATER_STRING, this.GetIsOutOfWater());
		
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		FantasticDebug.Output("readEntityFromNbt",true);
		super.readEntityFromNBT(par1NBTTagCompound);
		this.SetTextureIndex(par1NBTTagCompound.getInteger(DATAWATCHER_TEXTURE_STRING));
		this.SetFishSize(GetDataWatcherSizeForValue(par1NBTTagCompound.getInteger(DATAWATCHER_FISH_SIZE_STRING)));
		this.SetHasNotSpawned(par1NBTTagCompound.getBoolean(DATAWATCHER_HAS_NOT_SPAWNED_STRING));
		this.SetIsOutOfWater(par1NBTTagCompound.getInteger(DATAWATCHER_OUT_OF_WATER_STRING));
	}

	
	protected static int GetDataWatcherIntValueForSize(FishSize aSize)
	{
		if (aSize==FishSize.Tiny) return 0;
		if (aSize==FishSize.Small) return 1;
		if (aSize==FishSize.Medium) return 2;
		if (aSize==FishSize.Big) return 3;
		if (aSize==FishSize.Large) return 4;
		if (aSize==FishSize.Legendary) return 5;
		
		return 0; //Tiny is default otherwise
	}
	
	protected static FishSize GetDataWatcherSizeForValue(int aValue)
	{
		switch (aValue)
		{
			case 0 : return FishSize.Tiny;
			case 1 : return FishSize.Small;
			case 2 : return FishSize.Medium;
			case 3 : return FishSize.Big;
			case 4 : return FishSize.Large;
			case 5 : return FishSize.Legendary;
			default: return FishSize.Tiny;
		}
		
	}
	
	
	
}
