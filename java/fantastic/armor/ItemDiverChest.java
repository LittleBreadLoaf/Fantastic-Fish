package fantastic.armor;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.FantasticMod;
import fantastic.events.PlayerInfo;
import fantastic.items.FantasticItems;

public class ItemDiverChest extends ItemArmor 
{

	public ItemDiverChest(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName("brass_chest");
		this.setTextureName(FantasticInfo.ID + ":brass_chest");
		this.setCreativeTab(FantasticItems.tabFantastic);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":brass_chest");
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/diver_chest.png";
	}
	
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List data, boolean b)
	{
		PlayerInfo info = PlayerInfo.get(player);
		int left = 8400 - info.getDiverAir();
		int seconds = left/20;
		int minutes = 0;
		while(seconds >= 60)
		{
			seconds -=60;
			minutes++;
		}
		
		data.add(seconds < 10 ? (minutes + ":0" + seconds) : (minutes + ":" + seconds));
	}
	  /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	PlayerInfo info = PlayerInfo.get(par3EntityPlayer);
    	info.setDiverAir(0);
    	if(par1ItemStack.getItemDamage() != 0 && !par2World.isRemote)
    	{
    		ItemStack scubaTank = new ItemStack(FantasticArmor.scubaTank, 1, 6000);
    		EntityItem tank = new EntityItem(par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ, scubaTank);
    		par2World.spawnEntityInWorld(tank);
    		
    	}
    }
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = FantasticMod.proxy.getArmorModel(6);
				if(armorModel != null){

					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.bipedHeadwear.showModel = armorSlot == 0;
					armorModel.bipedBody.showModel = true;
					armorModel.bipedRightArm.showModel = armorSlot == 1;
					armorModel.bipedLeftArm.showModel = armorSlot == 1;
					armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
					armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
					
					if(entityLiving.getHeldItem() != null && entityLiving.getHeldItem().getItem() == Items.bow)
					{
						armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;	
					}
					else
					{
						if(((EntityPlayer)entityLiving).getItemInUseDuration() > 0)
						armorModel.heldItemRight = 3;
					}
					return armorModel;
					}
			
		}
		return armorModel;
	}
	 

	
}
