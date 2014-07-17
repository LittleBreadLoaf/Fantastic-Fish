package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockLeafyCoralBlue extends BlockBushCoral {

	public BlockLeafyCoralBlue(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "leafycoral_blue");
		this.setUnlocalizedName("leafycoral_blue");
	}

}