package fantastic.blocks;

import java.util.Random;

import fantastic.items.FantasticItems;
import fantastic.world.WorldGenCoral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;


public class BlockBushCoral extends Block {
	
	 private int[] acceptable = {
	    		Block.sand.blockID, Block.gravel.blockID, Block.dirt.blockID, Block.blockClay.blockID
	    };

	public BlockBushCoral(int id, Material material) {
		super(id, material);
		this.setCreativeTab(FantasticItems.tabFantastic);
        setLightValue(1.0f);
	}
	
	public boolean acceptable(int block) {
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

	    		par1World.destroyBlock(par2, par3, par4, true);
	    	}
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
    {
    	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    	
    }
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.getBlockId(par2, par3 - 1, par4) == Block.waterStill.blockID || !par1World.getBlockMaterial(par2, par3 + 1, par4).isLiquid())
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
		int above = world.getBlockId(x, y + 1, z);
		int below = world.getBlockId(x, y - 1, z);
		return (world.getBlockId(x, y, z) == Block.waterStill.blockID) ? acceptable(below) && above == Block.waterStill.blockID : false;
	}
}