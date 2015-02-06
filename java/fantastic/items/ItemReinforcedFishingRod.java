package fantastic.items;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticDebug;
import fantastic.FantasticInfo;
import fantastic.FantasticMod;
import fantastic.Names;
import fantastic.entities.EntityReinforcedFishingHook;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class ItemReinforcedFishingRod extends ItemFishingRod
{
    private EntityReinforcedFishingHook deployedHook = null;
	
    @SideOnly(Side.CLIENT)
    private IIcon castIcon;
    
    @SideOnly(Side.CLIENT)
    private IIcon uncastIcon;

	//private IIcon reelingIcon;


    public ItemReinforcedFishingRod()
    {
        super();

    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister p_94581_1_)
    {
     
    	//this.uncastIcon = p_94581_1_.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.ReinforcedFishingRod_UnlocalizedName+"_uncast");
        this.castIcon = p_94581_1_.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.ReinforcedFishingRod_UnlocalizedName+"_cast");
        this.itemIcon = p_94581_1_.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.ReinforcedFishingRod_UnlocalizedName+"_uncast");
        //this.reelingIcon = p_94581_1_.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.ReinforcedFishingRod_UnlocalizedName+"_reeling");
        
        this.setCreativeTab(FantasticItems.tabFantastic);
    }


    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
  @Override
   public ItemStack onItemRightClick(ItemStack aStack, World aWorld, EntityPlayer aPlayer)
  {
      if (aPlayer.fishEntity != null)
      {
    	  ReelIn(aPlayer, aWorld);
      }
      else
      {
    	  deployedHook = new EntityReinforcedFishingHook(aWorld, aPlayer); 
          if (!aWorld.isRemote)
          {
        	  aWorld.spawnEntityInWorld(deployedHook);
    
          }

          aPlayer.swingItem();
          aWorld.playSoundAtEntity(aPlayer,"fantastic:throwLine",0.75F,1.0F);
      }

      return aStack;
  }
  
  	private void ReelIn(EntityPlayer aPlayer, World aWorld)
  	{
  		FantasticDebug.Output("REELING");
   		aWorld.playSoundAtEntity(aPlayer, "fantastic:reelSmooth", 1.0F,1.0F);
        if (!aWorld.isRemote)
        {
        	Vec3 vec3 = Vec3.createVectorHelper(aPlayer.posX - deployedHook.posX, aPlayer.posY - deployedHook.posY, aPlayer.posZ - deployedHook.posZ).normalize();
        	deployedHook.setVelocity(vec3.xCoord*0.3D,0,vec3.zCoord*0.3D);
        }

  	}


    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 0;
    }
    
    @Override
    public IIcon getIcon(ItemStack thisItem, int pass)
    {
    	return castIcon;

    }
    
	@SubscribeEvent
	public void onMouseEvent(MouseEvent event)
	{ 
		FantasticDebug.Output("Button" + Integer.toString(event.button) + "State: "+Boolean.toString(event.buttonstate));
	}

}