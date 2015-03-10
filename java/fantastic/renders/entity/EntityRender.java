package fantastic.renders.entity;


import net.minecraft.client.renderer.entity.RenderFish;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fantastic.animations.client.ModelSerpentBoss;
import fantastic.animations.client.RenderSerpentBoss;
import fantastic.animations.common.EntitySerpentBoss;
import fantastic.entities.EntityBarracuda;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityBlooper;
import fantastic.entities.EntityCatfish;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityClam;
import fantastic.entities.EntityCreepedo;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityFungus;
import fantastic.entities.EntityHermitCrab;
import fantastic.entities.EntityLobster;
import fantastic.entities.EntityMantaRay;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntityMusky;
import fantastic.entities.EntityNurseShark;
import fantastic.entities.EntityPatrick;
import fantastic.entities.EntityPike;
import fantastic.entities.EntityReinforcedFishingHook;
import fantastic.entities.EntitySailfish;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntitySmallCrab;
import fantastic.entities.EntityStarfish;
import fantastic.entities.EntityTrout;
import fantastic.entities.EntityTuna;
import fantastic.entities.sharks.EntityWhiteTipShark;
import fantastic.renders.models.ModelBasicFish;
import fantastic.renders.models.ModelBasicShark;
import fantastic.renders.models.ModelBlooper;
import fantastic.renders.models.ModelClam;
import fantastic.renders.models.ModelHermitCrab;
import fantastic.renders.models.ModelLobster;
import fantastic.renders.models.ModelLongSnout;
import fantastic.renders.models.ModelMantaRay;
import fantastic.renders.models.ModelNurseShark;
import fantastic.renders.models.ModelPatrick;
import fantastic.renders.models.ModelPike;
import fantastic.renders.models.ModelSmallCrab;
import fantastic.renders.models.ModelStarfish;

public class EntityRender
{

	public static void renderEntities()
	{
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBasicFish.class, new RenderBasicFish(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLobster.class, new RenderLobster(new ModelLobster(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityClam.class, new RenderClam(new ModelClam(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySalmon.class, new RenderSalmon(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityStarfish.class, new RenderStarfish(new ModelStarfish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFeeder.class, new RenderFeeder(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTuna.class, new RenderTuna(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMossy.class, new RenderMossy(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFungus.class, new RenderFungus(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySailfish.class, new RenderSailfish(new ModelLongSnout(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallCrab.class, new RenderSmallCrab(new ModelSmallCrab(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHermitCrab.class, new RenderHermitCrab(new ModelHermitCrab(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMantaRay.class, new RenderMantaRay(new ModelMantaRay(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCatfish.class, new RenderCatfish(new ModelLongSnout(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteTipShark.class, new RenderBasicShark(new ModelBasicShark(), 0.3F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityGreatWhite.class, new RenderBasicShark(new ModelBasicShark(), 0.3F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBullShark.class, new RenderBasicShark(new ModelBasicShark(), 0.3F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityTigerShark.class, new RenderBasicShark(new ModelBasicShark(), 0.3F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityHammerHead.class, new RenderBasicShark(new ModelBasicShark(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPike.class, new RenderPike(new ModelPike(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMusky.class, new RenderMusky(new ModelPike(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarracuda.class, new RenderBarracuda(new ModelPike(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrout.class, new RenderTrout(new ModelBasicFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityReinforcedFishingHook.class, new RenderFish());

		//RenderingRegistry.registerEntityRenderingHandler(EntityPatrick.class, new RenderPatrick(new ModelPatrick(), 0.3F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityCaveFish.class, new RenderCaveFish(new ModelBasicFish(), 0.3F));
		//		RenderingRegistry.registerEntityRenderingHandler(EntityCreepedo.class, new RenderCreepedo(new ModelBasicFish(), 0.3F));
		//		RenderingRegistry.registerEntityRenderingHandler(EntityNurseShark.class, new RenderNurseShark(new ModelNurseShark(), 0.3F));
		// RenderingRegistry.registerEntityRenderingHandler(EntityBlooper.class, new RenderBlooper(new ModelBlooper(), 0.3F));
		
		
	}

}
