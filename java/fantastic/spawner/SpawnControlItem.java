package fantastic.spawner;

import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish.FishSize;

public class SpawnControlItem 

{
	public static enum SpawnControlItemType {Entity,FF_Entity}; //Normal entity or fantastic fish entity
	
	private int spawnFilter;
	private Class spawningClass = null;
	private int maxSpawnedInstances = -1;
	private int currentSpawnedInstance = 0;
	private int minWaterDept = -1;
	private FishSize fishSize;
	private SpawnControlItemType itemType = SpawnControlItemType.Entity; //Standard is Entity, it can be changed later


	
	public SpawnControlItem(Class aClass, int aMaxSpawnedInstance, int aMinWaterDepth, int aSpawnFilter)
	{
		spawningClass=aClass;
		maxSpawnedInstances=aMaxSpawnedInstance;
		spawnFilter=aSpawnFilter;
		minWaterDept = aMinWaterDepth;
		fishSize=FishSize.OneSize; //It will also work for land mobs ... OneSize is set for fishes with one size or any other mobs
		itemType = SpawnControlItemType.Entity;
	}
	
	public SpawnControlItem(Class aClass,FishSize aFishSize, int aMaxSpawnedInstance, int aMinWaterDepth, int aSpawnFilter)
	{
		spawningClass=aClass;
		maxSpawnedInstances=aMaxSpawnedInstance;
		minWaterDept = aMinWaterDepth;
		fishSize=aFishSize;
		spawnFilter=aSpawnFilter;
		itemType = SpawnControlItemType.FF_Entity;
	}

	public int GetSpawnFilter()
	{
		return spawnFilter;
	}
	
	
	public void SetSpawningClass(Class aClass)
	{
		spawningClass = aClass;
	}
	
	public Class GetSpawningClass()
	{
		return spawningClass;
	}

	public int GetSpawnWeight()
	{
		return GetSpawnWeight();
	}
	
	public int GetMaxSpawnedInstances()
	{
		return maxSpawnedInstances;
	}
	
	public int GetMinWaterDepth()
	{
		return minWaterDept;
	}
	
	
	public void SetMaxSpawnedInstance(int aMaxSpawnInstances)
	{
		maxSpawnedInstances = aMaxSpawnInstances;
	}
	
	public void AddCurrentSpawnedInstance()
	{
		currentSpawnedInstance++;
	}
	
	public void RemovedCurrentSpawnedInstance()
	{
		
		currentSpawnedInstance--;
		FantasticDebug.Output(" Decreasing spawned class: "+this.GetSpawningClass().getName()+" CurrentSpawned instance: "+Integer.toString(currentSpawnedInstance)+" Max instances: "+Integer.toString(maxSpawnedInstances));
	}
	
	public int GetCurrentSpawnedInstance()
	{
		
		return currentSpawnedInstance;
	}
	
	public boolean IsMaxReached()
	{
		FantasticDebug.Output("Class: "+this.GetSpawningClass().getName()+" CurrentSpawned instance: "+Integer.toString(currentSpawnedInstance)+" Max instances: "+Integer.toString(maxSpawnedInstances));
		if (maxSpawnedInstances==-1)
		{
			//There is no max set, so the max is not reached
			return false;
		}
		
		return currentSpawnedInstance>=maxSpawnedInstances;
	}
	
	public boolean RespectWaterDepth(int aSpawnedWaterDept)
	{
		if (minWaterDept==-1)
		{
			//There is no min set, so the depth is respected
			return true;
		}
		
		return aSpawnedWaterDept>=minWaterDept;		
	}
	
	
	//This will return true is the controlled entity will control the water dept. 
	public boolean IsCheckingWaterDept()
	{
		return minWaterDept>=-1;
	}
	
	public SpawnControlItemType GetSpawnControlItemType()
	{
		return itemType;
	}
	
	public FishSize GetFishSize()
	{
		return fishSize;
	}


}
