package fantastic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.FantasticMod;
import fantastic.Names;
import fantastic.armor.FantasticArmor;
import fantastic.items.FantasticItems;
import fantastic.network.ACMessage;
import fantastic.tiles.TileAirCompressor;

public class BlockAirCompressor extends BlockContainer
{

	public BlockAirCompressor(Material material)
	{
		super(material);

		this.setBlockTextureName("compressor_item");
		this.setBlockName(FantasticInfo.ID + ":" + Names.AComp_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setCreativeTab(FantasticItems.tabFantastic);
		this.setStepSound(Block.soundTypeAnvil);
	}

	@Override
	public int getRenderType()
	{
		return FantasticIds.airCompressorRenderingID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		
		TileAirCompressor ACEntity = (TileAirCompressor)world.getTileEntity(x, y, z);
		if(ACEntity != null)
		{
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == FantasticArmor.singleTank)
			{
				if(!ACEntity.getSingleTank() && !ACEntity.getDoubleTank())
				{
					ACEntity.setSingleTank(true);
					ACEntity.setTankDamage(player.getCurrentEquippedItem().getItemDamage());
					FantasticMod.network.sendToServer(new ACMessage(ACEntity, 1));
					player.getCurrentEquippedItem().stackSize--;
				}
			}
			else if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == FantasticArmor.scubaTank)
			{
				if(!ACEntity.getSingleTank() && !ACEntity.getDoubleTank())
				{
					ACEntity.setDoubleTank(true);
					ACEntity.setTankDamage(player.getCurrentEquippedItem().getItemDamage());
					FantasticMod.network.sendToServer(new ACMessage(ACEntity, 2));
					player.getCurrentEquippedItem().stackSize--;
				}
			}
			else 
			{
				if(ACEntity.getSingleTank())
				{
					ItemStack tank = new ItemStack(FantasticArmor.singleTank, 1);
					tank.setItemDamage(ACEntity.getTankDamage());
					ACEntity.setTankDamage(0);
					EntityItem theTank = new EntityItem(world, x, y, z, tank);
					if(!world.isRemote)
						world.spawnEntityInWorld(theTank);

					FantasticMod.network.sendToServer(new ACMessage(ACEntity, 0));
					ACEntity.setSingleTank(false);
				}
				if(ACEntity.getDoubleTank())
				{
					ItemStack tank = new ItemStack(FantasticArmor.scubaTank, 1);
					tank.setItemDamage(ACEntity.getTankDamage());
					ACEntity.setTankDamage(0);
					EntityItem theTank = new EntityItem(world, x, y, z, tank);
					if(!world.isRemote)
						world.spawnEntityInWorld(theTank);

					FantasticMod.network.sendToServer(new ACMessage(ACEntity, 0));
					ACEntity.setDoubleTank(false);
				}
			}
		}
		
		return true;
	}
	
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) 
	{

		TileAirCompressor ACEntity = (TileAirCompressor)world.getTileEntity(x, y, z);
		if(ACEntity != null)
		{
			if(ACEntity.getSingleTank())
			{
				ItemStack tank = new ItemStack(FantasticArmor.singleTank, 1);
				tank.setItemDamage(ACEntity.getTankDamage());
				ACEntity.setTankDamage(0);
				EntityItem theTank = new EntityItem(world, x, y, z, tank);
				if(!world.isRemote)
					world.spawnEntityInWorld(theTank);
					
				ACEntity.setSingleTank(false);
			}
			if(ACEntity.getDoubleTank())
			{
				ItemStack tank = new ItemStack(FantasticArmor.scubaTank, 1);
				tank.setItemDamage(ACEntity.getTankDamage());
				ACEntity.setTankDamage(0);
				EntityItem theTank = new EntityItem(world, x, y, z, tank);
				if(!world.isRemote)
					world.spawnEntityInWorld(theTank);
					
				ACEntity.setDoubleTank(false);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileAirCompressor();
	}
}