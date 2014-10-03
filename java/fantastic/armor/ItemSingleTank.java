package fantastic.armor;


import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.FantasticMod;
import fantastic.items.FantasticItems;

public class ItemSingleTank extends ItemArmor 
{

	public ItemSingleTank(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName("single_tank");
		this.setCreativeTab(FantasticItems.tabFantastic);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":single_tank");
	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/scuba_1.png";
	}
	
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List data, boolean b)
	{
		int left = 2400 - itemStack.getItemDamage();
		int seconds = left/20;
		int minutes = 0;
		while(seconds >= 60)
		{
			seconds -=60;
			minutes++;
		}
		
		data.add(seconds < 10 ? (minutes + ":0" + seconds) : (minutes + ":" + seconds));
	}


	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		ItemStack helm = player.getEquipmentInSlot(4);
		ItemStack chest = player.getEquipmentInSlot(3);
		ItemStack pants = player.getEquipmentInSlot(2);
		ItemStack boots = player.getEquipmentInSlot(1);
		if(player.isInsideOfMaterial(Material.water) && stack.getItemDamage() < 3600)
		{
			stack.damageItem(1, player);
			player.setAir(300);
		}
	}


    @Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = FantasticMod.proxy.getArmorModel(4);
				if(armorModel != null){

					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.bipedHeadwear.showModel = false;
					armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
					armorModel.bipedRightArm.showModel = armorSlot == 1;
					armorModel.bipedLeftArm.showModel = armorSlot == 1;
					armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
					armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
					if(entityLiving instanceof EntityPlayer && entityLiving.getHeldItem() != null)
						{
							
							if(entityLiving.getHeldItem().getItem() == Items.bow)
							{
								armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;	
							}
							else
							{
								if(((EntityPlayer)entityLiving).getItemInUseDuration() > 0)
								armorModel.heldItemRight = 3;
							}
								
						}
					return armorModel;
					}
			
		}
		return armorModel;
}



}