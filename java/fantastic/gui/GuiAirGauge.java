
package fantastic.gui;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.armor.FantasticArmor;
import fantastic.events.PlayerInfo;

@SideOnly(Side.CLIENT)
public class GuiAirGauge extends Gui
{
	private Minecraft mc;
	private static final ResourceLocation texture = new ResourceLocation(FantasticInfo.ID.toLowerCase(), "textures/guis/air_gauge.png");

	public GuiAirGauge(Minecraft mc)
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
        
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

	
		if(!this.mc.thePlayer.isInsideOfMaterial(Material.water))
		{
			return;
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.getTextureManager().bindTexture(texture);
        FontRenderer var8 = this.mc.fontRenderer;
        

        if (gear != null && (gear.getItem() == FantasticArmor.scubaTank || gear.getItem() == FantasticArmor.singleTank))
        {
        	int var111 = var7;
        	float var22 = (float)gear.getItemDamage()/(float)gear.getMaxDamage();
        	var22 = (int)(var22*576);
        	
        	
        	if(var22 >= 512)
        		overSize = 64;
        	else if(var22 >= 256)
        		overSize = 32;
        	else
        		overSize = 0;
        	
        	if(var22 % 32 == 0)
        		upSize = (int)(var22);
        	
        	if(upSize >= 512)
        		upSize -=256;
        	
        	else if(upSize >= 256)
        		upSize -= 256;
        	
        	this.drawTexturedModalRect(var181, var233, overSize, upSize, 32, 32);
        
        
        	int var12 =  1953999;
        }
        
        else if (helm != null && gear != null && pants != null && boots != null 
        		&& helm.getItem() == FantasticArmor.diverHelm
        		&& gear.getItem() == FantasticArmor.diverChest
        		&& pants.getItem() == FantasticArmor.diverPants
        		&& boots.getItem() == FantasticArmor.diverBoots)
        {
        	PlayerInfo info = PlayerInfo.get(mc.thePlayer);
        	int var111 = var7;
        	float var22 = (float)info.getDiverAir()/(float)8400;
        	var22 = (int)(var22*576);
        	
        	
        	if(var22 >= 512)
        		overSize = 64;
        	else if(var22 >= 256)
        		overSize = 32;
        	else
        		overSize = 0;
        	
        	if(var22 % 32 == 0)
        		upSize = (int)(var22);
        	
        	if(upSize >= 512)
        		upSize -=256;
        	
        	else if(upSize >= 256)
        		upSize -= 256;
        	
        	this.drawTexturedModalRect(var181, var233, overSize, upSize, 32, 32);
        
        
        	int var12 =  1953999;
        	
        	
        	
        	
        }
       
        this.mc.mcProfiler.endSection();

       
            
        
	}

}
