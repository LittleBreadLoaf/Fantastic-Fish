package fantastic.animations.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fantastic.animations.common.EntitySerpentBoss;

public class RenderSerpentBoss extends RenderLiving {

	public static final ResourceLocation SerpentBoss_texture = new ResourceLocation("fantastic", "textures/models/mobs/stone_serpent.png");
	public static ModelSerpentBoss modelSerpentBoss = new ModelSerpentBoss();	
	public static float modelHeight = 2F;
	
	public RenderSerpentBoss()
    {
        super(modelSerpentBoss, 1F);
    }
	
	@Override
	public void doRender(Entity _entity, double posX, double posY, double posZ, float var8, float var9) {
		EntitySerpentBoss entity = (EntitySerpentBoss) _entity;
		
		entity.getAnimationHandler().animationsUpdate();
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		super.doRender(_entity, posX, posY, posZ, var8, var9);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f)
	{
		GL11.glRotatef(180F, 0, 1F, 0F);
		GL11.glRotatef(180F, 0, 0, 1F);
		GL11.glTranslatef(0, modelHeight, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return SerpentBoss_texture;
	}
}