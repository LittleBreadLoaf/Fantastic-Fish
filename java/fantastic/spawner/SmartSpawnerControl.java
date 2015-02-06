package fantastic.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.EntityFantasticFish.FishSize;
import fantastic.entities.EntityPike;
import fantastic.entities.EntitySalmon;
import fantastic.entities.AI.FishMovementHelper;

public class SmartSpawnerControl 
{

	public static enum SpawnResult {Remote,Spawned,SpawnedButMaxisReachedNow, KilledMaxReached, KilledWaterDepthNotRespected, KilledFilteredOut};
	private static List classControlItemList = new ArrayList();
	private static Random rand = new Random();
	
	
	public SmartSpawnerControl()
	{

	}
	
	
	public static void Init()
	{
		FantasticDebug.Output("SmartSpawnerControl.Init();");
		//Set the spawn control parameters
		AddClassControlItem(EntityPike.class,FishSize.Medium,1,5,500);
		AddClassControlItem(EntitySquid.class,20,5,750);

	}

	
	
	//Add a SpawnControlItem to the list. Return false if the class already exist (and the item is not added).
	public static boolean AddClassControlItem(Class aClass, int aMaxSpawnedInstance, int aMinWaterDepth, int aSpawnFilter)
	{
		try
		{
			if (getSpawnControlItem(aClass)==null)
			{
				FantasticDebug.Output("Adding class to classControlItemList: "+aClass.getName());
				SpawnControlItem _item = new SpawnControlItem(aClass, aMaxSpawnedInstance, aMinWaterDepth, aSpawnFilter);
				classControlItemList.add(_item);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception ex)
		{
			FantasticDebug.Output(ex.getStackTrace().toString());
			return false;
		}
		
	}
	
	
	//Add a SpawnControlItem to the list. Return false if the class already exist (and the item is not added).
	public static boolean AddClassControlItem(Class aClass,FishSize aFishSize, int aMaxSpawnedInstance, int aMinWaterDepth, int aSpawnFilter)
	{
		try
		{
			if (getSpawnControlItem(aClass)==null)
			{
				FantasticDebug.Output("Adding class to classControlItemList: "+aClass.getName());
				SpawnControlItem _item = new SpawnControlItem(aClass, aFishSize, aMaxSpawnedInstance, aMinWaterDepth, aSpawnFilter);
				classControlItemList.add(_item);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception ex)
		{
			FantasticDebug.Output(ex.getStackTrace().toString());
			return false;
		}
		
	}
	
	//Remove a SpawnControlItem to the list. Return false if the class is not found or deleted.
	public static boolean RemoveClassControlItem(Class aClass)
	{
		try
		{
			SpawnControlItem _item = getSpawnControlItem(aClass);
			
			if (_item!=null)
			{
				classControlItemList.remove(_item);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception ex)
		{
			FantasticDebug.Output(ex.getStackTrace().toString());
			return false;
		}
		
	}
	
	//Need to be called in this event handler "	public void entitySpawned (EntityJoinWorldEvent event)"
	public static SpawnResult ProcessSpawn(Entity anEntity)
	{
		
			FantasticDebug.Output("Trying to spawn entity: "+anEntity.getClass().getName());
			SpawnControlItem _item = null;
			
			if (anEntity instanceof EntityFantasticFish)
			{
				if (SetFantasticFishParameters((EntityFantasticFish)anEntity)==null)
				{
					//Spawn was filtered out.
					return SpawnResult.KilledFilteredOut;
				}
				
				//Entity is a Fantastic fish
				_item = getSpawnControlItem(anEntity.getClass(),((EntityFantasticFish)anEntity).GetFishSize());			
			}
			else
			{
				//Entity is standard
				_item = getSpawnControlItem(anEntity.getClass());
			}
			
			
			if (_item!=null)
			{
				//Check if max number or instances is reached.
				if (_item.IsMaxReached())
				{
					//Max is reached. Killing entity
					killSpawn(anEntity,"Max number of instance is reached. Total: "+_item.GetCurrentSpawnedInstance());
					return SpawnResult.KilledMaxReached;
				}
	
				//Check the water depth
				if (_item.IsCheckingWaterDept())
				{
					int _depth = FishMovementHelper.getWaterDept(anEntity.worldObj, anEntity.posX, anEntity.posY, anEntity.posZ);
					if (!_item.RespectWaterDepth(_depth))
					{
						//Water depth is not respected. Killing entity.
						killSpawn(anEntity,"Water depth is not respected. Min waterdepth is: "+_item.GetMinWaterDepth()+" Actual is: "+_depth);
						return SpawnResult.KilledWaterDepthNotRespected;
					}
				}
				
				FantasticDebug.Output("Spawn granted.");
				_item.AddCurrentSpawnedInstance();
				return SpawnResult.Spawned;
				
			}
			else
			{
				//That entity class is not controlled. Therefore, it can be spawned.
				return SpawnResult.Spawned;
			}


	}
	
	//Need to be called in this event handler "public void onLivingDeathEvent(LivingDeathEvent event)"
	public static void ProcessDespawn(Entity anEntity)
	{
		FantasticDebug.Output("Process the despawn of entity: "+anEntity.getClass().getName());
		SpawnControlItem _item = null;
		
		if (anEntity instanceof EntityFantasticFish)
		{
			//Entity is a Fantastic fish
			_item = getSpawnControlItem(anEntity.getClass(),((EntityFantasticFish)anEntity).GetFishSize());			
		}
		else
		{
			//Entity is standard
			_item = getSpawnControlItem(anEntity.getClass());
		}
		
		
		if (_item!=null)
		{
			_item.RemovedCurrentSpawnedInstance();
		}
	}
	
	//Set the fantastic fish sizes and textures depending of the depth of the water.
	private static EntityFantasticFish SetFantasticFishParameters(EntityFantasticFish anEntity)
	{
		SpawnControlItem _newItem;
		if (anEntity!=null)
		{
			List _itemList = new ArrayList();
			
			//Get the water depth
			int _depth = FishMovementHelper.getWaterDept(anEntity.worldObj, anEntity.posX, anEntity.posY, anEntity.posZ);
			
			//Get the spawn control item for all the sizes for that specific class of fish
			if (anEntity.GetHasDifferentSize())
			{
				buildRollList(_itemList,anEntity,FishSize.Tiny,_depth);
				buildRollList(_itemList,anEntity,FishSize.Small,_depth);
				buildRollList(_itemList,anEntity,FishSize.Medium,_depth);
				buildRollList(_itemList,anEntity,FishSize.Big,_depth);
				buildRollList(_itemList,anEntity,FishSize.Large,_depth);
				buildRollList(_itemList,anEntity,FishSize.Legendary,_depth);
				
			}
			else
			{
				//Fish is one size
				buildRollList(_itemList,anEntity,FishSize.OneSize,_depth);
			}

			//Roll the size of the fish
			FishSize _size = rollSize(_itemList);
			
			if (_size!=FishSize.Null)
			{
				//If a fish size is returned, then a texture is chosen
				int _texture = rand.nextInt(anEntity.GetNumberOfTextures()+1);
				//The fish is finaly initialized correctly.
				anEntity.InitializeFish(_size,_texture,0);
				return anEntity;
			}
			else
			{
				//No fish can spawn there. Killing the entity.
				killSpawn(anEntity,"No fishes can spawn. They were filtered out.");
				return null;
			}

		}
		return null;
	}
	
	private static void buildRollList(List _rollList,EntityFantasticFish anEntity, FishSize forSize, int aDepth)
	{
		
		SpawnControlItem _newItem = null;
		SpawnControlItem _rollItem = getSpawnControlItem(anEntity.getClass(),forSize);	
		if ((_rollItem!=null) && (_rollItem.RespectWaterDepth(aDepth)))
		{
			_rollList.add(_rollItem);
		}
		else
		{
			//The fish is not filtered, it is then added to the list with the default values...
			_newItem = new SpawnControlItem(anEntity.getClass(),-1,-1,anEntity.GetSizeDefaultSpawnFilter(forSize));
			_rollList.add(_newItem);
		}		
	}
	
	private static FishSize rollSize(List aValidSpawnList)
	{
		if ((aValidSpawnList!=null) && (aValidSpawnList.size()>0))
		{
			int _roll = rand.nextInt(1000)+1; //Roll a number between 1 and 1000
			FantasticDebug.Output("Rollsize value: " + Integer.toString(_roll));
			Iterator _iterator = aValidSpawnList.iterator();
			FantasticDebug.Output("Spawn list size: " + Integer.toString(classControlItemList.size()));
			int _i = 0;
			while (_iterator.hasNext())
			{
				SpawnControlItem _item = (SpawnControlItem) _iterator.next();
				if (_roll<=(_item.GetSpawnFilter()+_i))
				{
					return _item.GetFishSize();
				}
				else
				{
					_i=_i+_item.GetSpawnFilter();
				}
			}
			
			//Roll is out of range, no fish will spawn
			return FishSize.Null;
		}
		else
		{
			//Nothing was added to the list, then no fishes can spawn there.
			return FishSize.Null;
		}

		
	}
	
	
	private static void killSpawn(Entity anEntity, String debugStringReason)
	{
		FantasticDebug.Output("Killing entity: "+anEntity.getClass().getName()+" Reason: "+debugStringReason);
		try
		{
			anEntity.setDead();
		}
		catch (Exception ex)
		{
			FantasticDebug.Output("Cannot kill entity: "+anEntity.getClass().getName()+ "Exception: "+ex.getStackTrace().toString());
		}
	}
	
	//Return the SpawnControlItem from the class
	private static SpawnControlItem getSpawnControlItem(Class aClass)
	{
		Iterator _iterator = classControlItemList.iterator();
		FantasticDebug.Output("List size: " + Integer.toString(classControlItemList.size()));
		while (_iterator.hasNext())
		{
			SpawnControlItem _item = (SpawnControlItem) _iterator.next();

			FantasticDebug.Output("getSpawnControlItem parameter aClass "+aClass.getName());
			FantasticDebug.Output("getSpawnControlItem SpawnControlItem "+_item.GetSpawningClass());
			
			if (aClass==_item.GetSpawningClass())
			{
				FantasticDebug.Output("getSpawnControlItem: Found entity: "+aClass.getName());
				return _item;
			}
		}
		FantasticDebug.Output("getSpawnControlItem: Did not found entity: "+aClass.getName());
		return null;		
	}
	
	//Return the SpawnControlItem from the class
	private static SpawnControlItem getSpawnControlItem(Class aClass, FishSize aFishSize)
	{
		Iterator _iterator = classControlItemList.iterator();
		while (_iterator.hasNext())
		{
			SpawnControlItem _item = (SpawnControlItem) _iterator.next();

			if ((aClass==_item.GetSpawningClass()) && (_item.GetFishSize()==aFishSize))
			{
				return _item;
			}
		}
		return null;		
	}
	
	
}
