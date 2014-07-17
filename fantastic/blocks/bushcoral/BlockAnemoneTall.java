package fantastic.blocks.bushcoral;

import java.util.Random;

import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class BlockAnemoneTall extends BlockBushCoral {

	public BlockAnemoneTall(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "anemone_tall");
		this.setUnlocalizedName("anemone_tall");
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        entity.attackEntityFrom(DamageSource.cactus, 1.0F);
    }
	

}