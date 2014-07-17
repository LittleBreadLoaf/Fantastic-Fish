package fantastic.renders.entity;



import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.entities.EntityClam;
import fantastic.items.FantasticItems;
import fantastic.renders.models.ModelClam;

public class RenderClam extends RenderLiving
{
	private static final ResourceLocation texture2 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/clam.png");
	private static final ResourceLocation texture3 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/clam2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/clam3.png");
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/clam4.png");
	protected ModelClam model;

	public RenderClam(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelClam) mainModel);
	}

	public void renderClam(EntityClam par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderClam((EntityClam) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderClam((EntityClam) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityClam) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			case 2:
				return texture4;
			default:
				return texture1;

		}
	}

	
	/**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleFish((EntityClam)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityClam par1, float par2)
    {
    	GL11.glTranslated(0.0, 0.67, 0.0);
    	GL11.glScaled(0.5, 0.5, 0.5);
    	
    }
    
    
    
    
    @SideOnly(Side.CLIENT)
	protected void renderItem(EntityClam clam, float par2)
    {
		super.renderEquippedItems(clam, par2);
		
			float f1 = 1.0F;
	        GL11.glColor3f(f1, f1, f1);
	        float f2;

	        if (clam.getHasPearl() == 0 && !clam.getIsClosed())
	        {
	            GL11.glPushMatrix();

	            if (this.mainModel.isChild)
	            {
	                f2 = 1.0F;
	                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
	                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
	                GL11.glScalef(f2, f2, f2);
	            }

	            



	            
	                f2 = 0.45F;
	                GL11.glScalef(f2, f2, f2);

	                GL11.glRotated(-120, 0.0, 0.0, 0.0);
	                GL11.glRotated(70, 0.0, 0.0, 1.0);
	                GL11.glTranslated(0.9, -0.30, -0.47);
	                GL11.glRotated(13, 0.0, 1.0, 0.0);
	                GL11.glRotated(20, 0.0, 0.0, 1.0);
	                GL11.glTranslated(0.0, 0.05, 0.5);
	                
	                

	            this.renderManager.itemRenderer.renderItem(clam, new ItemStack(FantasticItems.pearl, 1), 0);

	            GL11.glPopMatrix();
	        }
		
    }
    
   
    @SideOnly(Side.CLIENT)
    @Override
    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderItem((EntityClam)par1EntityLivingBase, par2);
    }
}
