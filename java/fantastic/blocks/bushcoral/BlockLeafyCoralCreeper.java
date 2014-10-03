package fantastic.blocks.bushcoral;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockLeafyCoralCreeper extends BlockBushCoral {

	public BlockLeafyCoralCreeper(Material material) {
		super(material);
		setBlockName(FantasticInfo.ID + ":" + "leafycoral_creeper");
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		if(new Random().nextDouble() < 0.4) {
			world.createExplosion(null, x, y, z, 2f, false);
		} else {
			dropBlockAsItem(world, x, y, z, getIdFromBlock(this), 0);
		}
	}
	
	@Override
	 /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Items.gunpowder;
    }

}