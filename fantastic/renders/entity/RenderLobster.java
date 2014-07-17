package fantastic.renders.entity;



import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityLobster;
import fantastic.renders.models.ModelLobster;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderLobster extends RenderLiving
{
	private static final ResourceLocation texture2 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/lobster_blue.png");
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/lobster_red.png");
	protected ModelLobster model;

	public RenderLobster(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelLobster) mainModel);
	}

	public void renderLobster(EntityLobster par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderLobster((EntityLobster) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderLobster((EntityLobster) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityLobster) entity).getTexture())
		{
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
        this.scaleLobster((EntityLobster)par1EntityLivingBase, par2);
    }
    
    protected void scaleLobster(EntityLobster par1, float par2)
    {
    	
        GL11.glTranslated(0.0, 0.44, 0.0);
        GL11.glScaled(0.7F, 0.7F, 0.7F);
    }

	
}
