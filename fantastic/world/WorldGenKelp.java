package fantastic.world;

import java.util.Random;

import fantastic.blocks.FantasticBlocks;
import fantastic.entities.EntityStarfish;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenKelp extends WorldGenerator {
	
	static Random rand = new Random();
	public static int[] acceptable = {
    		Block.sand.blockID, Block.gravel.blockID, Block.dirt.blockID, Block.stone.blockID, Block.blockClay.blockID
    };
	
	public static int[] blocks = {
			FantasticBlocks.plantKelp.blockID,
			FantasticBlocks.plantSeaweed.blockID,
	};
	
	
	public static boolean acceptable(int block) {
    	for(int i = 0; i < acceptable.length; i++) {
    		if(acceptable[i] == block) {
    			return true;
    		}
    	}
    	return false;
    }
	
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		int ex = x, why = y, zee = z;
		int above = world.getBlockId(x, y + 1, z);
		int below = world.getBlockId(x, y - 1, z);
		
		
			if(world.getBlockId(x, y, z) == Block.waterStill.blockID && world.getBlockId(x, y + 8, z) == Block.waterStill.blockID && world.getBlockId(x, y-1, z) == Block.dirt.blockID ) 
			{
				for (int x1 = -6 + rand.nextInt(4); x1<= 8 + rand.nextInt(4); x1++)
				{
					for (int z1 = -7 + rand.nextInt(4); z1<= 11 + rand.nextInt(4); z1++)
					{
						for (int y1 = -4; y1<= 4; y1++)
						{
							if((world.getBlockId(x+x1, y+y1 - 1, z+z1) == Block.dirt.blockID || world.getBlockId(x+x1, y+y1 - 1, z+z1) == Block.sand.blockID) && rand.nextInt(5) == 0)
							{
								this.generateTower(world, x+x1, y+y1, z+z1, rand.nextInt(5));
							}
						}
						
					}
					
				}
				
				
			}
			return true;
		}


	private void generateTower(World world, int x, int y, int z, int height) 
	{
		
		if(rand.nextBoolean())
		{
			for(int k = 0; k <= 5 + height; k++)
			{
				if(world.getBlockId(x, y + k + 1, z) == Block.waterStill.blockID && world.getBlockId(x, y + k, z) != Block.dirt.blockID && world.getBlockId(x, y + k, z) != Block.sand.blockID)
				{
					world.setBlock(x, y + k, z, FantasticBlocks.plantSeaweed.blockID);
				}
			}
			
		}
		
		else
		{
			for(int k = 0; k <= height; k++)
			{
				if(world.getBlockId(x, y + k + 1, z) == Block.waterStill.blockID && world.getBlockId(x, y + k, z) != Block.dirt.blockID && world.getBlockId(x, y + k, z) != Block.sand.blockID)
				{
					world.setBlock(x, y + k, z, FantasticBlocks.plantKelp.blockID);
				}
			}
		}
		
	}

	
}
