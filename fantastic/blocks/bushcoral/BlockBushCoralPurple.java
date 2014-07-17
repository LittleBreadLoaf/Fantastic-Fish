package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockBushCoralPurple extends BlockBushCoral {

	public BlockBushCoralPurple(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "bushcoral_purple");
		this.setUnlocalizedName("bushcoral_purple");
	}

}