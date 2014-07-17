package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockBushCoralRed extends BlockBushCoral {

	public BlockBushCoralRed(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "bushcoral_red");
		this.setUnlocalizedName("bushcoral_red");
	}

}