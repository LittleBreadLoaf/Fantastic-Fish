package fantastic.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fantastic.blocks.FantasticBlocks;

public class WorldGenKelp extends WorldGenerator {
	
	static Random rand = new Random();
	public static Block[] acceptable = {
    		Blocks.sand, Blocks.gravel, Blocks.dirt, Blocks.stone, Blocks.clay
    };
	
	public static Block[] blocks = {
			FantasticBlocks.plantKelp,
			FantasticBlocks.plantSeaweed,
	};
	
	
	public static boolean acceptable(Block block) {
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
		Block above = world.getBlock(x, y + 1, z);
		Block below = world.getBlock(x, y - 1, z);
		
		
			if(world.getBlock(x, y, z) == Blocks.water && world.getBlock(x, y + 8, z) == Blocks.water && world.getBlock(x, y-1, z) == Blocks.gravel ) 
			{
				for (int x1 = -6 + rand.nextInt(4); x1<= 8 + rand.nextInt(4); x1++)
				{
					for (int z1 = -7 + rand.nextInt(4); z1<= 11 + rand.nextInt(4); z1++)
					{
						for (int y1 = -4; y1<= 4; y1++)
						{
							if((world.getBlock(x+x1, y+y1 - 1, z+z1) == Blocks.dirt || world.getBlock(x+x1, y+y1 - 1, z+z1) == Blocks.sand  || world.getBlock(x+x1, y+y1 - 1, z+z1) == Blocks.gravel) && rand.nextInt(5) == 0)
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
				if(world.getBlock(x, y + k + 1, z) == Blocks.water && world.getBlock(x, y + k, z) != Blocks.dirt && world.getBlock(x, y + k, z) != Blocks.sand)
				{
					world.setBlock(x, y + k, z, FantasticBlocks.plantSeaweed);
				}
			}
			
		}
		
		else
		{
			for(int k = 0; k <= height; k++)
			{
				if(world.getBlock(x, y + k + 1, z) == Blocks.water && world.getBlock(x, y + k, z) != Blocks.dirt && world.getBlock(x, y + k, z) != Blocks.sand)
				{
					world.setBlock(x, y + k, z, FantasticBlocks.plantKelp);
				}
			}
		}
		
	}

	
}
