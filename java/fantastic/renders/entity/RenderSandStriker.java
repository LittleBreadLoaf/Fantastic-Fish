package fantastic.renders.entity;



import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.entities.EntitySailfish;
import fantastic.entities.EntitySandStriker;
import fantastic.renders.models.ModelLongSnout;

public class RenderSandStriker extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/sand_striker.png");
	protected ModelLongSnout model;

	public RenderSandStriker(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelLongSnout) mainModel);
	}

	public void renderSandStriker(EntitySandStriker par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderSandStriker((EntitySandStriker) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderSandStriker((EntitySandStriker) par1, par2, par3, par4, par5, par6);
		
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
        this.scaleFish((EntitySandStriker)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntitySandStriker par1, float par2)
    {
    	float scale = (1);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

	
	
	
	protected void func_82430_a(EntitySandStriker par1, float par2, float par3, float par4)
    {
		float par6 = 0;
		if ( par1.worldObj.getBlock((int)par1.posX, (int)par1.posY - 1, (int)par1.posZ) != Blocks.sand)
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
      
        GL11.glTranslatef(0.0F, (float)(-0.7F), 0.0F);
        
        super.rotateCorpse((EntityLivingBase)par1, par2, par3, par6);

    }
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
    {
        this.func_82430_a((EntitySandStriker)par1EntityLivingBase, par2, par3, par4);
        
    }
}
