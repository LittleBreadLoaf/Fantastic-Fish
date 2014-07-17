package fantastic.blocks;

import java.util.Random;

import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;


public class BlockCoral extends Block {

	public BlockCoral(int id, Material material) {
		super(id, material);
		setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(FantasticItems.tabFantastic);
        setLightValue(1.0f);
	}
}