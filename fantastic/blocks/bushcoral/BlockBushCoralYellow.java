package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockBushCoralYellow extends BlockBushCoral {

	public BlockBushCoralYellow(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "bushcoral_yellow");
		this.setUnlocalizedName("bushcoral_yellow");
	}

}