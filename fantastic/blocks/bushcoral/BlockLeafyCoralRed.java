package fantastic.blocks.bushcoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockLeafyCoralRed extends BlockBushCoral {

	public BlockLeafyCoralRed(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "leafycoral_red");
		this.setUnlocalizedName("leafycoral_red");
	}

}