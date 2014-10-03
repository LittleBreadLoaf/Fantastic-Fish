package fantastic.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fantastic.blocks.FantasticBlocks;

public class WorldGenCoral extends WorldGenerator {
	
	static Random rand = new Random();
	public static Block[] acceptable = {
    		Blocks.sand, Blocks.gravel, Blocks.dirt, Blocks.stone, Blocks.clay,
    		FantasticBlocks.brainCoralNormal,
			FantasticBlocks.brainCoralPurple,
			FantasticBlocks.brainCoralRed,
			FantasticBlocks.brainCoralYellow,
			FantasticBlocks.spongeCoralLightgreen,
			FantasticBlocks.spongeCoralOrange,
			FantasticBlocks.spongeCoralPink,
			Blocks.sponge
    };
	
	public static Block[] blocks = {
			FantasticBlocks.brainCoralNormal,
			FantasticBlocks.brainCoralPurple,
			FantasticBlocks.brainCoralRed,
			FantasticBlocks.brainCoralYellow,
			FantasticBlocks.spongeCoralLightgreen,
			FantasticBlocks.spongeCoralOrange,
			FantasticBlocks.spongeCoralPink,
			Blocks.sponge
	};
	
	public static Block[] bushPlants = {
		FantasticBlocks.bushCoralBlue,
		FantasticBlocks.bushCoralPurple,
		FantasticBlocks.bushCoralRed,
		FantasticBlocks.bushCoralYellow,
		FantasticBlocks.leafyCoralBlue,
		FantasticBlocks.leafyCoralCreeper,
		FantasticBlocks.leafyCoralCyan,
		FantasticBlocks.leafyCoralRed,
		FantasticBlocks.snakeCoralBlue,
		FantasticBlocks.snakeCoralPink,
		FantasticBlocks.anemoneSmall,
		FantasticBlocks.anemoneTall
		
	};
	
	public static boolean acceptable(Block block) {
    	for(int i = 0; i < acceptable.length; i++) {
    		if(acceptable[i] == block) {
    			return true;
    		}
    	}
    	return false;
    }
	
	public static boolean isBlock(Block block) {
		for(int i = 0; i < blocks.length; i++) {
			if(blocks[i] == block) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBush(Block block) {
		for(int i = 0; i < bushPlants.length; i++) {
			if(bushPlants[i] == block) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{

    	
		
		Block above = world.getBlock(x, y + 1, z);
		Block below = world.getBlock(x, y - 1, z);
		
		if(world.getBlock(x, y, z) == Blocks.water && world.getBlock(x, y + 4, z) == Blocks.water && below != Blocks.water) {
			
			for(int i = 0; i < 2 + random.nextInt(5); i++) {
				Block block = blocks[random.nextInt(blocks.length)];
				
				generateDisk2(world, x, y, z, 5 + random.nextInt(5), 1 + random.nextInt(3), block);

				if(random.nextBoolean()) {
					y = y - random.nextInt(3);
				} else {
					y = y + random.nextInt(3);
				}
				
				if(random.nextBoolean()) {
					if(random.nextBoolean()) {
						x = x - random.nextInt(5);
					} else {
						x = x + random.nextInt(5);
					}
				} else {
					if(random.nextBoolean()) {
						z = z + random.nextInt(5);
					} else {
						z = z - random.nextInt(5);
					}
				}
			}	
			this.generateBushes(world,x,y,z);
			return true;
		}
		return false;
	}
	
	

	private void generateBushes(World world, int x, int y, int z) 
	{
		for(int r = -15; r<15; r++)
		{
			for(int s = -10; s<10; s++)
			{
				for(int t = -15; t<15; t++)
				{
					if(world.getBlock(x+r, y+s, z+t) == Blocks.water && world.getBlock(x+r, y+s-1, z+t).getMaterial() != Material.water && world.getBlock(x+r, y+s+1, z+t) == Blocks.water && rand.nextInt(12) == 0)
					{
						world.setBlock(x+r, y+s, z+t, bushPlants[rand.nextInt(bushPlants.length)]);
					}
				}
			}
		}
		
	}

	public static void generateCircle(World world, int x, int y, int z, int radius, Block id) {
		for(int j = -radius; j <= radius; j = (j + 1)) {
			for(int k = 0; k <= 0; k = (k + 1)) {
				for(int m = -radius; m <= radius; m = (m + 1)) {
					int maxX = (int) Math.sqrt((double)(((j * j) + (k * k)) + (m * m)));
					if(maxX < (radius + 1)) {
						
							world.setBlock(x + j, y + k, z + m, id);
						
						
					}
				}
			}
		}
	}
	
	public static void generateDisk2(World world, int x, int y, int z, int radius, int layers, Block id) {
		for(int j = -layers; j <= layers; j = (j + 1)) {
			generateCircle(world, x, y + j, z, (j > 0) ? radius - j : radius + j, id);
		}
	}
}
