package fantastic.blocks;

import java.util.Random;

import fantastic.items.FantasticItems;
import fantastic.world.WorldGenCoral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;


public class BlockTallSeaPlant extends Block {
	
	private int[] acceptable = {
    		Block.sand.blockID, Block.gravel.blockID, Block.dirt.blockID
    };
	 
	 int maxHeight;
	 int phases;

	public BlockTallSeaPlant(int id, Material material) {
		super(id, material);
		this.setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = 5;
        this.phases = 16;
	}
	
	public BlockTallSeaPlant(int id, Material material, int maxHeight) {
		super(id, material);
		setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = maxHeight;
        this.phases = 16;
	}
	
	public BlockTallSeaPlant(int id, Material material, int maxHeight, int phases) {
		super(id, material);
		setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = maxHeight;
        this.phases = phases;
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
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) 
	{
        return this.canPlaceBlockAt(world, x, y, z);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block block = Block.blocksList[world.getBlockId(x, y - 1, z)];
        return (block != null && acceptable(block));
    }
	
	boolean acceptable(Block block)
	{
		if(block.blockID == Block.sand.blockID || block.blockID == Block.dirt.blockID || 
				block.blockID == FantasticBlocks.plantKelp.blockID || block.blockID == FantasticBlocks.plantSeaweed.blockID)
		return true;
		else
			return false;
	}
}