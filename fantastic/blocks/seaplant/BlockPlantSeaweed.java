package fantastic.blocks.seaplant;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fantastic.FantasticInfo;
import fantastic.blocks.FantasticBlocks;
import fantastic.items.FantasticItems;


public class BlockPlantSeaweed extends Block {
	
	public BlockPlantSeaweed(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "plant_seaweed");
		this.setTickRandomly(true);
		this.setUnlocalizedName("plant_seaweed");
		this.setStepSound(soundGrassFootstep);
	}
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
	        return null;
	    }
		
		
		
		public boolean isOpaqueCube() {
	        return false;
	    }

	    public boolean renderAsNormalBlock() {
	        return false;
	    }

	    public int getRenderType() {
	        return 1;
	    }
	    
	    /**
	     * Returns the ID of the items to drop on destruction.
	     */
	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return FantasticItems.seaweed.itemID;
	    }

	    /**
	     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
	     */
	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
	    
	    /**
	     * Ticks the block if it's been scheduled
	     */
	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	    	if (par1World.getBlockId(par2, par3 + 1, par4) == Block.waterStill.blockID)
	        {
	    		int l;

	            for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == this.blockID; ++l)
	            {
	                ;
	            }

	            if (l < 3)
	            {
	                int i1 = par1World.getBlockMetadata(par2, par3, par4);

	                if (i1 == 15)
	                {
	                    par1World.setBlock(par2, par3 + 1, par4, this.blockID);
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
	                }
	                else
	                {
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 + 1, 4);
	                }
	            }
	        }
	        if (!this.canBlockStay(par1World, par2, par3, par4))
	        {
	    		
	    		par1World.destroyBlock(par2, par3, par4, false);
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
	    	if(par1World.getBlockId(par2, par3 - 1, par4) == Block.waterStill.blockID || par1World.isAirBlock(par2, par3 + 1, par4))
	    	{
	    		return false;
	    	}
	    	else
	    	{
	    		return true;
	    	}
	    }
	   
		
}