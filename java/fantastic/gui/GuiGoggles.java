
package fantastic.gui;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.armor.FantasticArmor;

@SideOnly(Side.CLIENT)
public class GuiGoggles extends Gui
{
	private Minecraft mc;

	public GuiGoggles(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	int upSize = 0;
	int overSize = 0;
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        int var6 = var5.getScaledWidth();
        int var7 = var5.getScaledHeight();
        int var233 = var7 - 38;
        int var181 =  var6 - 115;
        ItemStack helm = this.mc.thePlayer.getEquipmentInSlot(4);
        ItemStack gear = this.mc.thePlayer.getEquipmentInSlot(3);
        ItemStack pants = this.mc.thePlayer.getEquipmentInSlot(2);
        ItemStack boots = this.mc.thePlayer.getEquipmentInSlot(1);
        
		if(event.isCancelable() || event.type != ElementType.HELMET)
		{
			return;
		}

	
		if(!this.mc.thePlayer.isInsideOfMaterial(Material.water))
		{
			return;
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
        FontRenderer var8 = this.mc.fontRenderer;
        
        
        if (helm != null && (helm.getItem() == FantasticArmor.goggles))
        {
        	this.mc.mcProfiler.startSection("goggles");
        	int var111 = var7;
        	GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
            GL11.glFogf(GL11.GL_FOG_DENSITY, 0.02F);

        }
        
        else if (helm != null && gear != null && pants != null && boots != null 
        		&& helm.getItem() == FantasticArmor.diverHelm
        		&& gear.getItem() == FantasticArmor.diverChest
        		&& pants.getItem() == FantasticArmor.diverPants
        		&& boots.getItem() == FantasticArmor.diverBoots)
        {
        	GL11.glEnable(GL11.GL_FOG);
        	GL11.glFogf(GL11.GL_FOG_DENSITY, 0.1F);
        	GL11.glDisable(GL11.GL_FOG);
        	
        	
        	
        	
        }
       
        this.mc.mcProfiler.endSection();

       
            
        
	}

}
