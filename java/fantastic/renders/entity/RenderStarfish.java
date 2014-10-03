package fantastic.renders.entity;



import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityStarfish;
import fantastic.renders.models.ModelStarfish;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderStarfish extends RenderLiving
{
	private static final ResourceLocation texture2 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar.png");
	private static final ResourceLocation texture3 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar3.png");
	private static final ResourceLocation texture5 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar4.png");
	private static final ResourceLocation texture6 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar5.png");
	private static final ResourceLocation texture7 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar6.png");
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/seastar7.png");
	protected ModelStarfish model;

	public RenderStarfish(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelStarfish) mainModel);
	}

	public void renderStarfish(EntityStarfish par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderStarfish((EntityStarfish) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderStarfish((EntityStarfish) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityStarfish) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			case 2:
				return texture4;
			case 3: 
				return texture5;
			case 4:
				return texture6;
			case 5:
				return texture7;
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
        this.scaleFish((EntityStarfish)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityStarfish par1, float par2)
    {
    	
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glTranslated(0.0, 1.38, 0.0);
    }

	
	
	
	
}
