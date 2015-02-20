package fantastic.renders.entity;

import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityHermitCrab;
import fantastic.renders.models.ModelHermitCrab;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderHermitCrab extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/hermitcrab_tan.png");
	private static final ResourceLocation texture2 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/hermitcrab_blue.png");
	private static final ResourceLocation texture3 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/hermitcrab_yellow.png");
	private static final ResourceLocation texture4 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/hermitcrab_pink.png");
	
	protected ModelHermitCrab model;

	public RenderHermitCrab(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelHermitCrab) mainModel);
	}

	public void renderHermitCrab(EntityHermitCrab par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHermitCrab((EntityHermitCrab) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHermitCrab((EntityHermitCrab) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityHermitCrab) entity).getTexture())
		{
			case 2:
				return texture4;
			case 1:
				return texture3;
			case 0:
				return texture2;
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
        this.scaleHermitCrab((EntityHermitCrab)par1EntityLivingBase, par2);
    }
    
    protected void scaleHermitCrab(EntityHermitCrab par1, float par2)
    {
    	
        GL11.glTranslated(0.0, 0.45, 0.0);
        GL11.glScaled(1.5F, 1.5F, 1.5F);
        //if(par1.worldObj.getClosestPlayerToEntity(par1, 8) != null)
        	GL11.glRotated(90, 0, 1, 0);
    }

	
}
