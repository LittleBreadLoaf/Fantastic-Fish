package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockSpongeCoralPink extends BlockCoral {

	public BlockSpongeCoralPink(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "spongecoral_pink");
		this.setUnlocalizedName("spongecoral_pink");
	}

}