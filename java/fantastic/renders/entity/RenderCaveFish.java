package fantastic.renders.entity;



import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntityCaveFish;
import fantastic.renders.models.ModelBasicFish;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class RenderCaveFish extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/cavefish.png");
	protected ModelBasicFish model;

	public RenderCaveFish(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelBasicFish) mainModel);
	}

	public void renderCaveFish(EntityCaveFish par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderCaveFish((EntityCaveFish) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderCaveFish((EntityCaveFish) par1, par2, par3, par4, par5, par6);
		
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
        this.scaleFish((EntityCaveFish)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityCaveFish par1, float par2)
    {
    	float scale = (float)par1.getRenderSize();
        GL11.glScalef(scale, scale, scale);
    }

	
	
	
	protected void func_82430_a(EntityCaveFish par1, float par2, float par3, float par4)
    {
		float par6 = 0;
		if (par1.getIsOutOfWater() == 0 && par1.worldObj.getBlock((int)par1.posX, (int)par1.posY - 1, (int)par1.posZ) != Blocks.water)
        {
        	
            par4 = 90F + par1.rotationYaw;
            par6 = 90F;
        }
        else
        {
        	par4 = 0;
        	par6 = 0;
        }

        GL11.glRotatef(par6, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(par4, 1.0F, 0.0F, 0.0F);
        if(par1.getRenderSize() == 1.8F)
        {
            GL11.glTranslatef(0.0F, (float)(1.4F)*(-par1.getRenderSize()), 0.0F);
        }
        else if(par1.getRenderSize() == 1.3F)
        {
        	GL11.glTranslatef(0.0F, (float)(1.2F)*(-par1.getRenderSize()), 0.0F);
        }
        else if(par1.getRenderSize() == 1.0F)
        {
        	GL11.glTranslatef(0.0F, (float)(1.0F)*(-par1.getRenderSize()), 0.0F);
        }
        else if(par1.getRenderSize() == 0.8F)
        {
        	GL11.glTranslatef(0.0F, (float)(0.9F)*(-par1.getRenderSize()), 0.0F);
        }
        else
        {

            GL11.glTranslatef(0.0F, (float)(-0.7F * par1.getRenderSize()), 0.0F);
        }
        super.rotateCorpse((EntityLivingBase)par1, par2, par3, par6);

    }
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
    {
        this.func_82430_a((EntityCaveFish)par1EntityLivingBase, par2, par3, par4);
        
    }
}
