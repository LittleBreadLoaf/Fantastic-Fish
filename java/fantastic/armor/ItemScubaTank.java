package fantastic.armor;


import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
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
import fantastic.Names;
import fantastic.items.FantasticItems;

public class ItemScubaTank extends ItemArmor 
{
	private static final int AIR_UNIT = 6000;
	private static long bubbleLoopTimer = 0;
	private static Random rand = new Random();
	
	public ItemScubaTank(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName("scuba_tank");
		this.setCreativeTab(FantasticItems.tabFantastic);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":scuba_tank");
	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/scuba_1.png";
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List data, boolean b)
	{
		int left = AIR_UNIT - itemStack.getItemDamage();
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
		if(player.isInsideOfMaterial(Material.water) && stack.getItemDamage() < (AIR_UNIT-1))
		{
			stack.damageItem(1, player);
			player.setAir(300);
			PlayBubbles(world,player);
		}
	}

	@SideOnly(Side.CLIENT)
	private void PlayBubbles(World aWorld, EntityPlayer aPlayer)
	{
		//Will play one of the 3 bubbles sound every 12 seconds when the tank is used under water.
		long _currentTime = System.currentTimeMillis();
		
		if ((_currentTime - bubbleLoopTimer)>12000)
		{
			bubbleLoopTimer = _currentTime;
			int _i = rand.nextInt(4)+1;
//			System.out.println("Playing sound fantastic:bubbles_"+Integer.toString(_i));
			aWorld.playSoundAtEntity(aPlayer,"fantastic:bubbles_"+Integer.toString(_i),1.0F,1.0F);
		}
	}


    @Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = FantasticMod.proxy.getArmorModel(2);
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