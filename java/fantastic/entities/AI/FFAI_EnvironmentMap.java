package fantastic.entities.AI;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FFAI_EnvironmentMap 
{
	private List pointList = new ArrayList();
	
	
	public void BuildMap(World aWorld, Vec3 aCenterPosition,int XScanRange, int YScanRange, int ZScanRange)
	{
		for (int _i=-XScanRange;_i<=XScanRange;_i++)
		{
			for (int _j=-YScanRange;_j<=YScanRange;_j++)
			{
				for (int _k=-ZScanRange;_k<=ZScanRange;_k++)
				{
					Block _block = null;
					try
					{
						_block = aWorld.getBlock((int)aCenterPosition.xCoord+_i, (int)aCenterPosition.yCoord+_j, (int)aCenterPosition.zCoord+_k); 
						if ((_block!=null) && (_block == Blocks.water))
						{
							pointList.add(_block);
						}	
					
					}
					catch (Exception ex)
					{
						//Invalid coordinate. It is simply not added to the map
					}
					
				}
			}
		}
	}
	
	public void ClearPointList()
	{
		pointList.clear();
	}
	
	
}
