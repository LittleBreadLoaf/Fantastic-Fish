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
import fantastic.entities.sharks.EntityBasicShark;
import fantastic.entities.sharks.EntityBasicShark.Type;
import fantastic.renders.models.ModelBasicShark;
import fantastic.renders.models.ModelLongSnout;

public class RenderBasicShark extends RenderLiving
{
	private static final ResourceLocation Basic = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/basic_shark.png");
	private static final ResourceLocation GreatWhite = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/great_white.png");
	private static final ResourceLocation Bull = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/bull_shark.png");
	private static final ResourceLocation Tiger = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/tiger_shark.png");
	private static final ResourceLocation Hammer = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/hammerhead.png");
	
	
	protected ModelBasicShark model;

	public RenderBasicShark(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelBasicShark) mainModel);
	}

	public void renderBasicShark(EntityBasicShark par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender(par1, par2, par3, par4, par5, par6);
		
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderBasicShark((EntityBasicShark) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderBasicShark((EntityBasicShark) par1, par2, par3, par4, par5, par6);
		
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if(entity instanceof EntityBasicShark){
			
		switch(((EntityBasicShark)entity).sharkType)
		{
		case GREAT :
				return GreatWhite;
		case TIGER :
				return Tiger;
		case BULL :
				return Bull;
		case HAMMER :
				return Hammer;
		default :
				return Basic;
		}
		}
		return Basic;
	}

	
	/**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleFish((EntityBasicShark)par1EntityLivingBase, par2);
    }
    
    protected void scaleFish(EntityBasicShark par1, float par2)
    {
    	float scale = 1.0F;

    		switch(par1.sharkType)
    		{
    		
    		case GREAT :
				scale = 1.6F;
				break;
    		case TIGER :
    			scale = 1.3F;
    			break;
    		case BULL :
				scale = 0.8F;
				break;
    		case HAMMER :
				scale = 1.1F;
				break;
    		default :
				scale = 1.0F;
    			
    		}
    	
        GL11.glScalef(scale, scale, scale);
    }

	
	
	
	protected void func_82430_a(EntityBasicShark par1, float par2, float par3, float par4)
    {
		float par6 = 0;
      
		
		float inWater = 1.0F;
		float outOfWater = 1.0F;

		switch(par1.sharkType)
		{
		
		case GREAT :
			inWater = 2.0F;
			outOfWater = 1.1F;
			break;
		case TIGER :
			inWater = 1.6F;
			outOfWater = 1.1F;
			break;
		case BULL :
			inWater = 0.9F;
			outOfWater = 0.5F;
			break;
		case HAMMER :
			inWater = 1.3F;
			outOfWater = 1.0F;
			break;
		default :
			inWater = 1.3F;
			outOfWater = 1.0F;
			
		}
		if(par1.isInWater())
			GL11.glTranslatef(0.0F, (float)(-inWater), 0.0F);
		else
			GL11.glTranslatef(0.0F, (float)(-outOfWater), 0.0F);

        
        super.rotateCorpse((EntityLivingBase)par1, par2, par3, par6);

    }
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
    {
        this.func_82430_a((EntityBasicShark)par1EntityLivingBase, par2, par3, par4);
        
    }
}
