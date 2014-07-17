package fantastic.world;

import java.util.Random;

import fantastic.blocks.FantasticBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCoral extends WorldGenerator {
	
	static Random rand = new Random();
	public static int[] acceptable = {
    		Block.sand.blockID, Block.gravel.blockID, Block.dirt.blockID, Block.stone.blockID, Block.blockClay.blockID
    };
	
	public static int[] blocks = {
			FantasticBlocks.brainCoralNormal.blockID,
			FantasticBlocks.brainCoralPurple.blockID,
			FantasticBlocks.brainCoralRed.blockID,
			FantasticBlocks.brainCoralYellow.blockID,
			FantasticBlocks.spongeCoralLightgreen.blockID,
			FantasticBlocks.spongeCoralOrange.blockID,
			FantasticBlocks.spongeCoralPink.blockID,
			Block.sponge.blockID
	};
	
	public static int[] bushPlants = {
		FantasticBlocks.bushCoralBlue.blockID,
		FantasticBlocks.bushCoralPurple.blockID,
		FantasticBlocks.bushCoralRed.blockID,
		FantasticBlocks.bushCoralYellow.blockID,
		FantasticBlocks.leafyCoralBlue.blockID,
		FantasticBlocks.leafyCoralCreeper.blockID,
		FantasticBlocks.leafyCoralCyan.blockID,
		FantasticBlocks.leafyCoralRed.blockID,
		FantasticBlocks.snakeCoralBlue.blockID,
		FantasticBlocks.snakeCoralPink.blockID,
		FantasticBlocks.anemoneSmall.blockID,
		FantasticBlocks.anemoneTall.blockID
		
	};
	
	public static boolean acceptable(int block) {
    	for(int i = 0; i < acceptable.length; i++) {
    		if(acceptable[i] == block) {
    			return true;
    		}
    	}
    	return false;
    }
	
	public static boolean isBlock(int block) {
		for(int i = 0; i < blocks.length; i++) {
			if(blocks[i] == block) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBush(int block) {
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

    	
		
		int above = world.getBlockId(x, y + 1, z);
		int below = world.getBlockId(x, y - 1, z);
		
		if(world.getBlockId(x, y, z) == Block.waterStill.blockID && world.getBlockId(x, y + 4, z) == Block.waterStill.blockID && below != Block.waterStill.blockID) {
			
			for(int i = 0; i < 2 + random.nextInt(5); i++) {
				int block = blocks[random.nextInt(blocks.length)];
				
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
					if(world.getBlockId(x+r, y+s, z+t) == Block.waterStill.blockID && world.getBlockMaterial(x+r, y+s-1, z+t).isSolid() && world.getBlockId(x+r, y+s+1, z+t) == Block.waterStill.blockID && rand.nextInt(12) == 0)
					{
						world.setBlock(x+r, y+s, z+t, bushPlants[rand.nextInt(bushPlants.length)]);
					}
				}
			}
		}
		
	}

	public static void generateCircle(World world, int x, int y, int z, int radius, int id) {
		for(int j = -radius; j <= radius; j = (j + 1)) {
			for(int k = 0; k <= 0; k = (k + 1)) {
				for(int m = -radius; m <= radius; m = (m + 1)) {
					int maxX = (int) Math.sqrt((double)(((j * j) + (k * k)) + (m * m)));
					if(maxX < (radius + 1)) {
						
						if(world.getBlockId(x + j, y + k, z + m) == Block.waterStill.blockID || world.getBlockId(x + j, y + k, z + m) == Block.waterMoving.blockID) {
							world.setBlock(x + j, y + k, z + m, id);
						}
						
					}
				}
			}
		}
	}
	
	public static void generateDisk2(World world, int x, int y, int z, int radius, int layers, int id) {
		for(int j = -layers; j <= layers; j = (j + 1)) {
			generateCircle(world, x, y + j, z, (j > 0) ? radius - j : radius + j, id);
		}
	}
}
