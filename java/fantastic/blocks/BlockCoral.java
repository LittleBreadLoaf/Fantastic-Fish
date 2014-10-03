package fantastic.blocks;

import java.util.Random;

import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;


public class BlockCoral extends Block {

	public BlockCoral(Material material) {
		super(material);
		setStepSound(Block.soundTypeStone);
		this.setCreativeTab(FantasticItems.tabFantastic);
        this.setLightLevel(1.0f);
	}
}