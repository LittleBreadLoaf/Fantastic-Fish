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
import fantastic.FantasticIds;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCatfish;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.EntityFantasticFish.FishSize;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityFungus;
import fantastic.entities.EntityMantaRay;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntityMusky;
import fantastic.entities.EntityPike;
import fantastic.entities.EntitySailfish;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTrout;
import fantastic.entities.EntityTuna;
import fantastic.entities.AI.FishMovementHelper;
import fantastic.entities.sharks.EntityWhiteTipShark;

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
		
		//ColorFish
		AddClassControlItem(EntityBasicFish.class, FishSize.Tiny, FantasticIds.tinyColorFishMaxInstances, FantasticIds.tinyColorFishMinDepth, FantasticIds.tinyColorFishSpawnProbability);
		AddClassControlItem(EntityBasicFish.class, FishSize.Small, FantasticIds.smallColorFishMaxInstances, FantasticIds.smallColorFishMinDepth, FantasticIds.smallColorFishSpawnProbability);
		AddClassControlItem(EntityBasicFish.class, FishSize.Medium, FantasticIds.mediumColorFishMaxInstances, FantasticIds.mediumColorFishMinDepth, FantasticIds.mediumColorFishSpawnProbability);
		AddClassControlItem(EntityBasicFish.class, FishSize.Big, FantasticIds.bigColorFishMaxInstances, FantasticIds.bigColorFishMinDepth, FantasticIds.bigColorFishSpawnProbability);
		AddClassControlItem(EntityBasicFish.class, FishSize.Large, FantasticIds.largeColorFishMaxInstances, FantasticIds.largeColorFishMinDepth, FantasticIds.largeColorFishSpawnProbability);
		AddClassControlItem(EntityBasicFish.class, FishSize.Legendary, FantasticIds.legColorFishMaxInstances, FantasticIds.legColorFishMinDepth, FantasticIds.legColorFishSpawnProbability);

		//Salmon
		AddClassControlItem(EntitySalmon.class, FishSize.Tiny, FantasticIds.tinySalmonMaxInstances, FantasticIds.tinySalmonMinDepth, FantasticIds.tinySalmonSpawnProbability);
		AddClassControlItem(EntitySalmon.class, FishSize.Small, FantasticIds.smallSalmonMaxInstances, FantasticIds.smallSalmonMinDepth, FantasticIds.smallSalmonSpawnProbability);
		AddClassControlItem(EntitySalmon.class, FishSize.Medium, FantasticIds.mediumSalmonMaxInstances, FantasticIds.mediumSalmonMinDepth, FantasticIds.mediumSalmonSpawnProbability);
		AddClassControlItem(EntitySalmon.class, FishSize.Big, FantasticIds.bigSalmonMaxInstances, FantasticIds.bigSalmonMinDepth, FantasticIds.bigSalmonSpawnProbability);
		AddClassControlItem(EntitySalmon.class, FishSize.Large, FantasticIds.largeSalmonMaxInstances, FantasticIds.largeSalmonMinDepth, FantasticIds.largeSalmonSpawnProbability);
		AddClassControlItem(EntitySalmon.class, FishSize.Legendary, FantasticIds.legSalmonMaxInstances, FantasticIds.legSalmonMinDepth, FantasticIds.legSalmonSpawnProbability);
		
		//Trout
		AddClassControlItem(EntityTrout.class, FishSize.Tiny, FantasticIds.tinyTroutMaxInstances, FantasticIds.tinyTroutMinDepth, FantasticIds.tinyTroutSpawnProbability);
		AddClassControlItem(EntityTrout.class, FishSize.Small, FantasticIds.smallTroutMaxInstances, FantasticIds.smallTroutMinDepth, FantasticIds.smallTroutSpawnProbability);
		AddClassControlItem(EntityTrout.class, FishSize.Medium, FantasticIds.mediumTroutMaxInstances, FantasticIds.mediumTroutMinDepth, FantasticIds.mediumTroutSpawnProbability);
		AddClassControlItem(EntityTrout.class, FishSize.Big, FantasticIds.bigTroutMaxInstances, FantasticIds.bigTroutMinDepth, FantasticIds.bigTroutSpawnProbability);
		AddClassControlItem(EntityTrout.class, FishSize.Large, FantasticIds.largeTroutMaxInstances, FantasticIds.largeTroutMinDepth, FantasticIds.largeTroutSpawnProbability);
		AddClassControlItem(EntityTrout.class, FishSize.Legendary, FantasticIds.legTroutMaxInstances, FantasticIds.legTroutMinDepth, FantasticIds.legTroutSpawnProbability);

		//Pike
		AddClassControlItem(EntityPike.class, FishSize.Tiny, FantasticIds.tinyPikeMaxInstances, FantasticIds.tinyPikeMinDepth, FantasticIds.tinyPikeSpawnProbability);
		AddClassControlItem(EntityPike.class, FishSize.Small, FantasticIds.smallPikeMaxInstances, FantasticIds.smallPikeMinDepth, FantasticIds.smallPikeSpawnProbability);
		AddClassControlItem(EntityPike.class, FishSize.Medium, FantasticIds.mediumPikeMaxInstances, FantasticIds.mediumPikeMinDepth, FantasticIds.mediumPikeSpawnProbability);
		AddClassControlItem(EntityPike.class, FishSize.Big, FantasticIds.bigPikeMaxInstances, FantasticIds.bigPikeMinDepth, FantasticIds.bigPikeSpawnProbability);
		AddClassControlItem(EntityPike.class, FishSize.Large, FantasticIds.largePikeMaxInstances, FantasticIds.largePikeMinDepth, FantasticIds.largePikeSpawnProbability);
		AddClassControlItem(EntityPike.class, FishSize.Legendary, FantasticIds.legPikeMaxInstances, FantasticIds.legPikeMinDepth, FantasticIds.legPikeSpawnProbability);

		//Musky
		AddClassControlItem(EntityMusky.class, FishSize.Tiny, FantasticIds.tinyMuskyMaxInstances, FantasticIds.tinyMuskyMinDepth, FantasticIds.tinyMuskySpawnProbability);
		AddClassControlItem(EntityMusky.class, FishSize.Small, FantasticIds.smallMuskyMaxInstances, FantasticIds.smallMuskyMinDepth, FantasticIds.smallMuskySpawnProbability);
		AddClassControlItem(EntityMusky.class, FishSize.Medium, FantasticIds.mediumMuskyMaxInstances, FantasticIds.mediumMuskyMinDepth, FantasticIds.mediumMuskySpawnProbability);
		AddClassControlItem(EntityMusky.class, FishSize.Big, FantasticIds.bigMuskyMaxInstances, FantasticIds.bigMuskyMinDepth, FantasticIds.bigMuskySpawnProbability);
		AddClassControlItem(EntityMusky.class, FishSize.Large, FantasticIds.largeMuskyMaxInstances, FantasticIds.largeMuskyMinDepth, FantasticIds.largeMuskySpawnProbability);
		AddClassControlItem(EntityMusky.class, FishSize.Legendary, FantasticIds.legMuskyMaxInstances, FantasticIds.legMuskyMinDepth, FantasticIds.legMuskySpawnProbability);
		
		//Catfish
		AddClassControlItem(EntityCatfish.class, FishSize.Tiny, FantasticIds.tinyCatfishMaxInstances, FantasticIds.tinyCatfishMinDepth, FantasticIds.tinyCatfishSpawnProbability);
		AddClassControlItem(EntityCatfish.class, FishSize.Small, FantasticIds.smallCatfishMaxInstances, FantasticIds.smallCatfishMinDepth, FantasticIds.smallCatfishSpawnProbability);
		AddClassControlItem(EntityCatfish.class, FishSize.Medium, FantasticIds.mediumCatfishMaxInstances, FantasticIds.mediumCatfishMinDepth, FantasticIds.mediumCatfishSpawnProbability);
		AddClassControlItem(EntityCatfish.class, FishSize.Big, FantasticIds.bigCatfishMaxInstances, FantasticIds.bigCatfishMinDepth, FantasticIds.bigCatfishSpawnProbability);
		AddClassControlItem(EntityCatfish.class, FishSize.Large, FantasticIds.largeCatfishMaxInstances, FantasticIds.largeCatfishMinDepth, FantasticIds.largeCatfishSpawnProbability);
		AddClassControlItem(EntityCatfish.class, FishSize.Legendary, FantasticIds.legCatfishMaxInstances, FantasticIds.legCatfishMinDepth, FantasticIds.legCatfishSpawnProbability);
		
		//Tuna
		AddClassControlItem(EntityTuna.class, FishSize.Tiny, FantasticIds.tinyTunaMaxInstances, FantasticIds.tinyTunaMinDepth, FantasticIds.tinyTunaSpawnProbability);
		AddClassControlItem(EntityTuna.class, FishSize.Small, FantasticIds.smallTunaMaxInstances, FantasticIds.smallTunaMinDepth, FantasticIds.smallTunaSpawnProbability);
		AddClassControlItem(EntityTuna.class, FishSize.Medium, FantasticIds.mediumTunaMaxInstances, FantasticIds.mediumTunaMinDepth, FantasticIds.mediumTunaSpawnProbability);
		AddClassControlItem(EntityTuna.class, FishSize.Big, FantasticIds.bigTunaMaxInstances, FantasticIds.bigTunaMinDepth, FantasticIds.bigTunaSpawnProbability);
		AddClassControlItem(EntityTuna.class, FishSize.Large, FantasticIds.largeTunaMaxInstances, FantasticIds.largeTunaMinDepth, FantasticIds.largeTunaSpawnProbability);
		AddClassControlItem(EntityTuna.class, FishSize.Legendary, FantasticIds.legTunaMaxInstances, FantasticIds.legTunaMinDepth, FantasticIds.legTunaSpawnProbability);
		
		//Sailfish
		AddClassControlItem(EntitySailfish.class, FishSize.Tiny, FantasticIds.tinySailfishMaxInstances, FantasticIds.tinySailfishMinDepth, FantasticIds.tinySailfishSpawnProbability);
		AddClassControlItem(EntitySailfish.class, FishSize.Small, FantasticIds.smallSailfishMaxInstances, FantasticIds.smallSailfishMinDepth, FantasticIds.smallSailfishSpawnProbability);
		AddClassControlItem(EntitySailfish.class, FishSize.Medium, FantasticIds.mediumSailfishMaxInstances, FantasticIds.mediumSailfishMinDepth, FantasticIds.mediumSailfishSpawnProbability);
		AddClassControlItem(EntitySailfish.class, FishSize.Big, FantasticIds.bigSailfishMaxInstances, FantasticIds.bigSailfishMinDepth, FantasticIds.bigSailfishSpawnProbability);
		AddClassControlItem(EntitySailfish.class, FishSize.Large, FantasticIds.largeSailfishMaxInstances, FantasticIds.largeSailfishMinDepth, FantasticIds.largeSailfishSpawnProbability);
		AddClassControlItem(EntitySailfish.class, FishSize.Legendary, FantasticIds.legSailfishMaxInstances, FantasticIds.legSailfishMinDepth, FantasticIds.legSailfishSpawnProbability);

		//MantaRay
		AddClassControlItem(EntityMantaRay.class, FishSize.Tiny, FantasticIds.tinyMantaRayMaxInstances, FantasticIds.tinyMantaRayMinDepth, FantasticIds.tinyMantaRaySpawnProbability);
		AddClassControlItem(EntityMantaRay.class, FishSize.Small, FantasticIds.smallMantaRayMaxInstances, FantasticIds.smallMantaRayMinDepth, FantasticIds.smallMantaRaySpawnProbability);
		AddClassControlItem(EntityMantaRay.class, FishSize.Medium, FantasticIds.mediumMantaRayMaxInstances, FantasticIds.mediumMantaRayMinDepth, FantasticIds.mediumMantaRaySpawnProbability);
		AddClassControlItem(EntityMantaRay.class, FishSize.Big, FantasticIds.bigMantaRayMaxInstances, FantasticIds.bigMantaRayMinDepth, FantasticIds.bigMantaRaySpawnProbability);
		AddClassControlItem(EntityMantaRay.class, FishSize.Large, FantasticIds.largeMantaRayMaxInstances, FantasticIds.largeMantaRayMinDepth, FantasticIds.largeMantaRaySpawnProbability);
		AddClassControlItem(EntityMantaRay.class, FishSize.Legendary, FantasticIds.legMantaRayMaxInstances, FantasticIds.legMantaRayMinDepth, FantasticIds.legMantaRaySpawnProbability);
		
		//Fungus
		AddClassControlItem(EntityFungus.class, FishSize.Tiny, FantasticIds.tinyFungusMaxInstances, FantasticIds.tinyFungusMinDepth, FantasticIds.tinyFungusSpawnProbability);
		AddClassControlItem(EntityFungus.class, FishSize.Small, FantasticIds.smallFungusMaxInstances, FantasticIds.smallFungusMinDepth, FantasticIds.smallFungusSpawnProbability);
		AddClassControlItem(EntityFungus.class, FishSize.Medium, FantasticIds.mediumFungusMaxInstances, FantasticIds.mediumFungusMinDepth, FantasticIds.mediumFungusSpawnProbability);
		AddClassControlItem(EntityFungus.class, FishSize.Big, FantasticIds.bigFungusMaxInstances, FantasticIds.bigFungusMinDepth, FantasticIds.bigFungusSpawnProbability);
		AddClassControlItem(EntityFungus.class, FishSize.Large, FantasticIds.largeFungusMaxInstances, FantasticIds.largeFungusMinDepth, FantasticIds.largeFungusSpawnProbability);
		AddClassControlItem(EntityFungus.class, FishSize.Legendary, FantasticIds.legFungusMaxInstances, FantasticIds.legFungusMinDepth, FantasticIds.legFungusSpawnProbability);

		//Mossy
		AddClassControlItem(EntityMossy.class, FishSize.Tiny, FantasticIds.tinyMossyMaxInstances, FantasticIds.tinyMossyMinDepth, FantasticIds.tinyMossySpawnProbability);
		AddClassControlItem(EntityMossy.class, FishSize.Small, FantasticIds.smallMossyMaxInstances, FantasticIds.smallMossyMinDepth, FantasticIds.smallMossySpawnProbability);
		AddClassControlItem(EntityMossy.class, FishSize.Medium, FantasticIds.mediumMossyMaxInstances, FantasticIds.mediumMossyMinDepth, FantasticIds.mediumMossySpawnProbability);
		AddClassControlItem(EntityMossy.class, FishSize.Big, FantasticIds.bigMossyMaxInstances, FantasticIds.bigMossyMinDepth, FantasticIds.bigMossySpawnProbability);
		AddClassControlItem(EntityMossy.class, FishSize.Large, FantasticIds.largeMossyMaxInstances, FantasticIds.largeMossyMinDepth, FantasticIds.largeMossySpawnProbability);
		AddClassControlItem(EntityMossy.class, FishSize.Legendary, FantasticIds.legMossyMaxInstances, FantasticIds.legMossyMinDepth, FantasticIds.legMossySpawnProbability);

		//Feeder
		AddClassControlItem(EntityFeeder.class, FishSize.Tiny, FantasticIds.tinyFeederMaxInstances, FantasticIds.tinyFeederMinDepth, FantasticIds.tinyFeederSpawnProbability);
		AddClassControlItem(EntityFeeder.class, FishSize.Small, FantasticIds.smallFeederMaxInstances, FantasticIds.smallFeederMinDepth, FantasticIds.smallFeederSpawnProbability);
		AddClassControlItem(EntityFeeder.class, FishSize.Medium, FantasticIds.mediumFeederMaxInstances, FantasticIds.mediumFeederMinDepth, FantasticIds.mediumFeederSpawnProbability);
		AddClassControlItem(EntityFeeder.class, FishSize.Big, FantasticIds.bigFeederMaxInstances, FantasticIds.bigFeederMinDepth, FantasticIds.bigFeederSpawnProbability);
		AddClassControlItem(EntityFeeder.class, FishSize.Large, FantasticIds.largeFeederMaxInstances, FantasticIds.largeFeederMinDepth, FantasticIds.largeFeederSpawnProbability);
		AddClassControlItem(EntityFeeder.class, FishSize.Legendary, FantasticIds.legFeederMaxInstances, FantasticIds.legFeederMinDepth, FantasticIds.legFeederSpawnProbability);

		//WhiteTipShark
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Tiny, FantasticIds.tinyWhiteTipSharkMaxInstances, FantasticIds.tinyWhiteTipSharkMinDepth, FantasticIds.tinyWhiteTipSharkSpawnProbability);
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Small, FantasticIds.smallWhiteTipSharkMaxInstances, FantasticIds.smallWhiteTipSharkMinDepth, FantasticIds.smallWhiteTipSharkSpawnProbability);
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Medium, FantasticIds.mediumWhiteTipSharkMaxInstances, FantasticIds.mediumWhiteTipSharkMinDepth, FantasticIds.mediumWhiteTipSharkSpawnProbability);
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Big, FantasticIds.bigWhiteTipSharkMaxInstances, FantasticIds.bigWhiteTipSharkMinDepth, FantasticIds.bigWhiteTipSharkSpawnProbability);
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Large, FantasticIds.largeWhiteTipSharkMaxInstances, FantasticIds.largeWhiteTipSharkMinDepth, FantasticIds.largeWhiteTipSharkSpawnProbability);
		AddClassControlItem(EntityWhiteTipShark.class, FishSize.Legendary, FantasticIds.legWhiteTipSharkMaxInstances, FantasticIds.legWhiteTipSharkMinDepth, FantasticIds.legWhiteTipSharkSpawnProbability);

		

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
					int _depth = FishMovementHelper.GetWaterDepth(anEntity.worldObj, anEntity.posX, anEntity.posY, anEntity.posZ);
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
			int _depth = FishMovementHelper.GetWaterDepth(anEntity.worldObj, anEntity.posX, anEntity.posY, anEntity.posZ);
			
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
				//The fish is finally initialized correctly.
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
