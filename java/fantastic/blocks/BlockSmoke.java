package fantastic.blocks;

import java.util.Random;

import fantastic.FantasticInfo;
import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockSmoke extends Block {

	public BlockSmoke(Material par2Material) 
	{
		super(par2Material);
		this.setBlockName(FantasticInfo.ID + ":" + "smoke_block");
		this.setCreativeTab(FantasticItems.tabFantastic);
	}
	
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	
    		for (int l = 1; l < 8; ++l)
    		{
    			float f = (float)par2 + 0.5F;
    			float f1 = (float)par3 + par5Random.nextFloat() + par5Random.nextInt(l);
    			float f2 = (float)par4 + 0.5F;
    			par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
    		}
    	
    }
    
    @Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

}
