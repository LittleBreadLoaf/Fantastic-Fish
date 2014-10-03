package fantastic.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fantastic.items.FantasticItems;
import fantastic.world.WorldGenCoral;


public class BlockBushCoral extends Block {
	
	 private Block[] acceptable = {
	    		Blocks.sand, Blocks.gravel, Blocks.dirt, Blocks.clay
	    };

	public BlockBushCoral(Material material) {
		super(material);
		this.setCreativeTab(FantasticItems.tabFantastic);
        setLightLevel(1.0f);
	}
	
	public boolean acceptable(Block block) {
    	for(int i = 0; i < acceptable.length; i++) {
    		if(acceptable[i] == block) {
    			return true;
    		}
    	}
    	return WorldGenCoral.isBlock(block);
    }
	
	public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    public int getRenderType() {
        return 1;
    }
	
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	 if (!this.canBlockStay(par1World, par2, par3, par4))
	        {

	    		par1World.setBlock(par2, par3, par4, Blocks.water);
	    	}
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
    {
    	par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));
    	
    }
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.getBlock(par2, par3 - 1, par4) == Blocks.water || par1World.getBlock(par2, par3 + 1, par4).getMaterial() != Material.water)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block above = world.getBlock(x, y + 1, z);
		Block below = world.getBlock(x, y - 1, z);
		return (world.getBlock(x, y, z) == Blocks.water) ? acceptable(below) && above == Blocks.water : false;
	}
}