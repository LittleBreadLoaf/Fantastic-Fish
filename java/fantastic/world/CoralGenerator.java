package fantastic.world;

import java.util.Random;


import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class CoralGenerator implements IWorldGenerator {

	Random rand = new Random();
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
         
    }
	
	private void generateNether(World world, Random random, int x, int z) {
         
    }
	
    private void generateSurface(World world, Random random, int x, int z) {
    	for(int i = 0; i < 2; i++) {
    		int posX = x + random.nextInt(16);
        	int posY = 45 + random.nextInt((10));
        	int posZ = z + random.nextInt(16);
        	
        	if(random.nextInt(25) == 0)
        	{
        		(new WorldGenCoral()).generate(world, random, posX, posY, posZ);
        	}
        	else if(random.nextInt(14) == 0)
        	{
        		(new WorldGenSmokestack()).generate(world, random, posX, posY, posZ);
        	}
        	else
        	{
        		(new WorldGenKelp()).generate(world, random, posX, posY, posZ);
        	}
        
        	
    	}
    }
}