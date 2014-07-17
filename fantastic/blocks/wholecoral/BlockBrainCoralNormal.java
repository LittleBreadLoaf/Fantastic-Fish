package fantastic.blocks.wholecoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralNormal extends BlockCoral {

	public BlockBrainCoralNormal(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "braincoral_normal");
		this.setUnlocalizedName("braincoral_normal");
	}

}