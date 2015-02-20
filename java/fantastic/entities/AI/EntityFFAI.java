package fantastic.entities.AI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import fantastic.FantasticDebug;
import fantastic.entities.EntityFantasticFish;
import fantastic.spawner.SpawnControlItem;

public class EntityFFAI 
{

	public static enum AIState {Idle,Fleeing,StayStill,Wander,Jump, Pursuing};
	
	protected Random rand = new Random();
	private EntityFantasticFish ffish = null;
	
	private long startDuskTime = -1;
	private long endDuskTime = -1;
	private long startDawnTime = -1;
	private long endDawnTime = -1;
	
	private long lastExecutionTime = System.currentTimeMillis();
	private boolean executing = false;
	protected int minTimerBetweenAction = -1; //in ms 
	protected int maxTimerBetweenAction = -1; //in ms
	protected int nextActionTimer = -1;
	
	public long LockActionCurrentTime = -1;
	public long LockActionInterval =-1;
	
	public Vec3 targetCoor = null;
	public AIState currentAIState;
	
	List actionList = new ArrayList();
	

	
	public EntityFFAI(EntityFantasticFish aFish, int aMinTimerBetweenAction, int aMaxTimerBetweenAction,long aStartDawnTime, long anEndDawnTime, long aStartDuskTime, long anEndDuskTime)
	{
		ffish = aFish;
		startDuskTime = aStartDuskTime;
		endDuskTime = anEndDuskTime;
		startDawnTime = aStartDawnTime;
		endDawnTime = anEndDawnTime;
		targetCoor = Vec3.createVectorHelper(ffish.posX, ffish.posY, ffish.posZ);
		minTimerBetweenAction=aMinTimerBetweenAction;
		maxTimerBetweenAction=aMaxTimerBetweenAction;
		
	}
	
	public void ClearActionList()
	{
		actionList.clear();
	}
	
	public void AddActionToList(FFAI_Base anAction)
	{
		actionList.add(anAction);
		Collections.sort(actionList, new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2) 
			{
				
				FFAI_Base i1 = (FFAI_Base)o1;
				FFAI_Base i2 = (FFAI_Base)o2;
				
				return (i2.Priority<i1.Priority)?1 : -1;
			}
			
		});
		
	}
	
	public void Tick()
	{
		if (!executing)
		{
			executing=true;
			long _currentTime = System.currentTimeMillis();
			
			if ((ffish!=null) && (ffish.isEntityAlive()) && (LockActionCurrentTime==-1 || (LockActionCurrentTime + LockActionInterval<=_currentTime) ))
			{
				boolean _executionResult = false;
				ResetActionLock();
				if (!ffish.worldObj.isRemote)
				{
					
					Iterator _iterator = actionList.iterator();
					int _i = 0;
					while (_iterator.hasNext())
					{
						FFAI_Base _item = (FFAI_Base) _iterator.next();
						//Will execute only if previous action (high in the priority list) were not executed
						if (!_executionResult)
						{
							if (_item.Execute())
							{
								_executionResult=true;
								//Take note of the current time
								ResetExecutionTimer();
								break;
							}
						}
					}
					
					//Will now move to the location set by a previous action
					if ((targetCoor!=null) && (LockActionCurrentTime==-1))
					{
						FishMovementHelper.SwimTo(ffish, targetCoor.xCoord, targetCoor.yCoord, targetCoor.zCoord, ffish.GetSpeedFromAIState(this.currentAIState));
					}
				}
			}
			else
			{
				FantasticDebug.Output("LOCKED!!!");
			}
			executing=false;
		}
	}
	

	public void SetLastExecutionTime(long aTime)
	{
		lastExecutionTime=aTime;
	}
	
	public long GetLastExecutionTime()
	{
		return lastExecutionTime;
	}
	
	public boolean isDusk()
	{
		if (ffish!=null)
		{
			
			long _time = ffish.worldObj.getWorldTime() % 24000;
			FantasticDebug.Output("TIME: "+Long.toString(_time));
			if (startDuskTime<=endDuskTime)
			{
				//Dusk begin before 6 am and ends after 6am. 6 am is time 0
				return ((_time>=startDuskTime) && (_time<=endDuskTime));
			}
			else
			{
				return (((_time>=startDuskTime) && (_time<=24000)) || ((_time>=0) && (_time<=endDuskTime)));
			}
			
		}
		return false;
	}
	
	public boolean isDawn()
	{
		if (ffish!=null)
		{
			
			long _time = ffish.worldObj.getWorldTime() % 24000;
			FantasticDebug.Output("TIME: "+Long.toString(_time));
			if (startDawnTime<=endDawnTime)
			{
				return ((_time>=startDawnTime) && (_time<=endDawnTime));
			}
			else
			{
				return (((_time>=startDawnTime) && (_time<=24000)) || ((_time>=0) && (_time<=endDawnTime)));
			}
			
		}
		return false;
	}
	
	private void ResetActionLock()
	{
        //Reset the jump lock if it was set before
		LockActionCurrentTime=-1;
		LockActionInterval=-1;
	}
	
	private int RollTimeCheck()
	{
		if (nextActionTimer==-1)
		{
			nextActionTimer=rand.nextInt(maxTimerBetweenAction-minTimerBetweenAction)+minTimerBetweenAction;
		}
		return nextActionTimer;
	}
	
	protected void ResetExecutionTimer()
	{
		nextActionTimer=-1;
		SetLastExecutionTime(System.currentTimeMillis());
	}
	
	protected boolean TimeCheck(long aTimeToCheck)
	{
		return (aTimeToCheck>=GetLastExecutionTime()+RollTimeCheck());
	}
	
	
}
