package fantastic.armor;


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

public class ItemWetsuit extends ItemArmor 
{

	public ItemWetsuit(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName("wetsuit");
		this.setCreativeTab(FantasticItems.tabFantastic);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":wetsuit");
	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/scuba_2.png";
	}


    

		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
		{
			ItemStack helm = player.getEquipmentInSlot(4);
			ItemStack chest = player.getEquipmentInSlot(3);
			ItemStack pants = player.getEquipmentInSlot(2);
			ItemStack boots = player.getEquipmentInSlot(1);
			
			if(player.isInWater())
			{
				if(player.isSneaking())
				{
					player.motionY -= 0.05F;
				}
				player.moveFlying(player.moveStrafing, player.moveForward, 0.02F);
				
			
			}
		}
			
	



    @Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = FantasticMod.proxy.getArmorModel(0);
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