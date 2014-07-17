package fantastic.renders.entity;



import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityPatrick;
import fantastic.renders.models.ModelPatrick;

public class RenderPatrick extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/patrick.png");
protected ModelPatrick model;

	public RenderPatrick(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelPatrick) mainModel);
	}

	public void renderPatrick(EntityPatrick par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderPatrick((EntityPatrick) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderPatrick((EntityPatrick) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		
		return texture;

		
	}

	
	/**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleFish((EntityPatrick)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityPatrick par1, float par2)
    {
    	
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glTranslated(0.0, 1.38, 0.0);
    }

	
	
	
	
}
