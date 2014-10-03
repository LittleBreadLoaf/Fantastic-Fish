package fantastic.renders.entity;



import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityMantaRay;
import fantastic.renders.models.ModelMantaRay;

public class RenderMantaRay extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/manta_ray.png");
	protected ModelMantaRay model;

	public RenderMantaRay(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelMantaRay) mainModel);
	}

	public void renderMantaRay(EntityMantaRay par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderMantaRay((EntityMantaRay) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderMantaRay((EntityMantaRay) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
				return texture1;
	}

	
	/**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleFish((EntityMantaRay)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityMantaRay par1, float par2)
    {
    	float scale = (float)par1.getRenderSize();
        GL11.glScalef(scale, scale, scale);
    }

	
	
	
	protected void func_82430_a(EntityMantaRay par1, float par2, float par3, float par4)
    {
	
        
        GL11.glTranslatef(0.0F, (float)(-1.0F), 0.0F);
        
        super.rotateCorpse((EntityLivingBase)par1, par2, par3, 0);

    }
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
    {
        this.func_82430_a((EntityMantaRay)par1EntityLivingBase, par2, par3, par4);
        
    }
}
