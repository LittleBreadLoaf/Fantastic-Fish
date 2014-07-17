package fantastic.blocks.wholecoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockSpongeCoralLightgreen extends BlockCoral {

	public BlockSpongeCoralLightgreen(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "spongecoral_lightgreen");
		this.setUnlocalizedName("spongecoral_lightgreen");
	}

}