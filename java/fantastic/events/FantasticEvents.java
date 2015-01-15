package fantastic.events;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticIds;
import fantastic.armor.FantasticArmor;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityBlooper;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityClam;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityLobster;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntityNurseShark;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTuna;
import fantastic.entities.sharks.EntityBasicShark;
import fantastic.items.FantasticItems;
import fantastic.proxies.CommonProxy;

public class FantasticEvents 
{
	
	public static CommonProxy proxy = new CommonProxy();
	Random rand = new Random();
	private int texture = 0;

	
	@SubscribeEvent
	public void onLivingSpawnEvent(LivingSpawnEvent event)
	{
		
		if(event.entity instanceof EntityBasicShark)
		{
			if(((EntityBasicShark)event.entity).getHasNotSpawned())
			{
				if(rand.nextInt(100 - FantasticIds.sharkSpawnRate) == 0 )
					event.entity.setDead();
				((EntityBasicShark)event.entity).setHasNotSpawned(false);
			}
			
		}
		float renderSize = 0.9F;
		int waters = 0;
		for(int k = -10; k<=10; k++)
		{
			if(event.world.getBlock((int)event.entity.posX, (int)event.entity.posY, (int)event.entity.posZ + k) == Blocks.water)
			{
				waters++;
			}
		}
		
		if(waters <= FantasticIds.tier1Depth)
		{
			if(rand.nextInt(101 - FantasticIds.smallSpawnRate) <= 1)
			{
				renderSize = 0.5F;
			}
			else
			{
				renderSize = 0.25F;
			}
		}
		else if(waters <= FantasticIds.tier2Depth)
		{
			if(rand.nextInt(101 - FantasticIds.mediumSpawnRate) <= 1)
			{
				renderSize = (0.8F);
			}
			else
			{
				renderSize = (0.5F);
			}
		}
		else if(waters <= FantasticIds.tier3Depth)
		{
			if(rand.nextInt(101 - FantasticIds.smallSpawnRate) <= 1)
			{
				renderSize = (0.5F);
			}
			else if(rand.nextInt(101 - FantasticIds.mediumSpawnRate) <= 1)
			{
				renderSize = (0.8F);
			}
			else if(rand.nextInt(101 - FantasticIds.bigSpawnRate) <= 1)
			{
				renderSize = (1.0F);
			}
			
			else
			{
				renderSize = (0.8F);
			}
		}
		else if(waters <= FantasticIds.tier4Depth)
		{
			if(rand.nextInt(101 - FantasticIds.mediumSpawnRate) <= 1)
			{
				renderSize = (0.8F);
			}
			else if(rand.nextInt(101 - FantasticIds.bigSpawnRate) <= 1)
			{
				renderSize = (1.0F);
			}
			else if(rand.nextInt(101 - FantasticIds.largeSpawnRate) <= 1)
			{
				renderSize = (1.3F);
			}
			else
			{
				renderSize = (0.8F);
			}
		}
		else if(waters > FantasticIds.tier5Depth)
		{
			if(rand.nextInt(101 - FantasticIds.mediumSpawnRate) <= 1)
			{
				renderSize = (0.8F);
			}
			else if(rand.nextInt(101 - FantasticIds.bigSpawnRate) <= 1)
			{
				renderSize = (1.0F);
			}
			else if (rand.nextInt(101 - FantasticIds.largeSpawnRate) <= 1)
			{
				renderSize = (1.3F);
			}
			else if(rand.nextInt(1001 - FantasticIds.legendarySpawnRate) <= 1)
			{
				renderSize = (1.8F);
			}
			else
			{
				renderSize = (1.0F);
			}
		}
		
		
		if(event.entity instanceof EntityBasicFish)
		{
			EntityBasicFish Fish = (EntityBasicFish)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
		if(event.entity instanceof EntityCaveFish)
		{
			EntityCaveFish Fish = (EntityCaveFish)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
		if(event.entity instanceof EntitySalmon)
		{
			EntitySalmon Fish = (EntitySalmon)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
		if(event.entity instanceof EntityFeeder)
		{
			EntityFeeder Fish = (EntityFeeder)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
		if(event.entity instanceof EntityMossy)
		{
			EntityMossy Fish = (EntityMossy)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
		if(event.entity instanceof EntityTuna)
		{
			EntityTuna Fish = (EntityTuna)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
				if(Fish.getRenderSize() == 0.9F)
					Fish.setRenderSize(0.8F);
			
			}
		}
	}

	@SubscribeEvent
	public void onSpawnEvent(EntityJoinWorldEvent event)
	{
		
		
		float renderSize = 0.9F;
		
		if(event.entity instanceof EntityBasicFish)
		{
			EntityBasicFish Fish = (EntityBasicFish)event.entity;
			if(Fish.getHasNotSpawned())
			{
				if(rand.nextInt(10) == 0)
					Fish.setRenderSize(1.8F);
				else if(rand.nextInt(9) == 0)
					Fish.setRenderSize(1.3F);
				else if(rand.nextInt(5) == 0)
					Fish.setRenderSize(1.0F);
				else if(rand.nextInt(4) == 0)
					Fish.setRenderSize(0.8F);
				else if(rand.nextInt(2) == 0)
					Fish.setRenderSize(0.5F);
				else 
					Fish.setRenderSize(0.25F);
				
			

			BiomeGenBase spawnBiome = event.entity.worldObj.getBiomeGenForCoords((int)Fish.posX, (int)Fish.posZ);
			if(spawnBiome == BiomeGenBase.jungle || spawnBiome == BiomeGenBase.jungleHills || spawnBiome == BiomeGenBase.mesa
					|| spawnBiome == BiomeGenBase.mesaPlateau || spawnBiome == BiomeGenBase.mesaPlateau_F)
			{
				if(rand.nextInt(11) == 0)
				{
					this.texture = 2;
				}
				else
				{
					if(rand.nextInt(2) == 0)
					{
						this.texture = 4;
					}
					else
					{
						this.texture = 1;
					}
				}
			}
			else if(spawnBiome == BiomeGenBase.swampland)
			{
				if(rand.nextInt(11) == 0)
				{
					this.texture = 0;
				}
				else
				{
					if(rand.nextInt(2) == 0)
					{
						this.texture = 4;
					}
					else
					{
						this.texture = 1;
					}
				}
			}
			else if(spawnBiome == BiomeGenBase.ocean || spawnBiome == BiomeGenBase.deepOcean)
			{
				if(rand.nextInt(11) == 0)
				{
					this.texture = 3;
				}
				else
				{
					if(rand.nextInt(2) == 0)
					{
						this.texture = 4;
					}
					else
					{
						this.texture = 1;
					}
				}
			}
			else if(spawnBiome == BiomeGenBase.mushroomIsland || spawnBiome == BiomeGenBase.mushroomIslandShore)
			{
				if(rand.nextInt(11) == 0)
				{
					this.texture = 5;
				}
				else
				{
					if(rand.nextInt(2) == 0)
					{
						this.texture = 4;
					}
					else
					{
						this.texture = 1;
					}
				}
			}
			else
			{
				if(rand.nextInt(2) == 0)
				{
					this.texture = 4;
				}
				else
				{
					this.texture = 1;
				}
			}
			
			Fish.setTexture(texture);
			Fish.setHasNotSpawned(false);
			}
		}
			
		if(event.entity instanceof EntityCaveFish)
		{
			EntityCaveFish CaveFish = (EntityCaveFish)event.entity;
			
			if(CaveFish.getHasNotSpawned())
			{
				CaveFish.setRenderSize(renderSize);
				
				if(CaveFish.posY > 40 && event.world.getClosestPlayerToEntity(CaveFish, 5) == null)
				{
					CaveFish.setDead();
				}
			}
			CaveFish.setHasNotSpawned(false);
		}
		
		if(event.entity instanceof EntitySalmon)
		{
			EntitySalmon Salmon = (EntitySalmon)event.entity;
			
			if(Salmon.getHasNotSpawned())
			{
				Salmon.setRenderSize(renderSize);

			}
			Salmon.setHasNotSpawned(false);
		}
		
		if(event.entity instanceof EntityFeeder)
		{
			EntityFeeder Feeder = (EntityFeeder)event.entity;
	
			if(Feeder.getHasNotSpawned())
			{
				Feeder.setRenderSize(renderSize);
			}
			Feeder.setHasNotSpawned(false);
		}
		
		if(event.entity instanceof EntityMossy)
		{
			EntityMossy Feeder = (EntityMossy)event.entity;

			if(Feeder.getHasNotSpawned())
			{
				Feeder.setRenderSize(renderSize);
			}
			Feeder.setHasNotSpawned(false);
		}
		if(event.entity instanceof EntityTuna)
		{
			EntityTuna Feeder = (EntityTuna)event.entity;

			if(Feeder.getHasNotSpawned())
			{
				Feeder.setRenderSize(renderSize);
			}
			Feeder.setHasNotSpawned(false);
		}
		
		
		
	}
	
	
	
	
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
	
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack helm = player.getEquipmentInSlot(4);
			ItemStack chest = player.getEquipmentInSlot(3);
			ItemStack pants = player.getEquipmentInSlot(2);
			ItemStack boots = player.getEquipmentInSlot(1);
			PlayerInfo info = PlayerInfo.get(player);
			
			
			if(helm != null && chest != null && pants != null && boots != null && 
					helm.getItem() == FantasticArmor.diverHelm && chest.getItem() == FantasticArmor.diverChest &&
					pants.getItem() == FantasticArmor.diverPants && boots.getItem() == FantasticArmor.diverBoots)
			{
				player.stepHeight = 1.0F;
				if(player.isInsideOfMaterial(Material.water))
				{
					if(info.getDiverAir() < 8400)
					{
						player.setAir(300);
						info.addAir(1);
					}
			
					
					
					player.moveEntity(0, -0.15F, 0);
				}
				
			}
			else
			{
				player.stepHeight = 0.6F;
			}
			
			
		}
		
		if(event.entityLiving instanceof EntitySquid)
		{
			
			if(((EntitySquid)event.entityLiving).hasCustomNameTag() && ((EntitySquid)event.entityLiving).getCustomNameTag().equals("Blooper"))
			{
				EntityBlooper blooper = new EntityBlooper(event.entityLiving.worldObj);
				blooper.setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, 0.0F, 0.0F);
				if(!event.entityLiving.worldObj.isRemote)
				event.entityLiving.worldObj.spawnEntityInWorld(blooper);
				blooper.setCustomNameTag("Blooper");
				event.entityLiving.setDead();
			}
		}
	}
	
	
	//Jumping and Falling
	

	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityNurseShark || event.entityLiving instanceof EntityBasicShark)
		{
			event.entityLiving.motionY -= 0.12F;
		}
		
		
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack helm = player.getEquipmentInSlot(4);
			ItemStack chest = player.getEquipmentInSlot(3);
			ItemStack pants = player.getEquipmentInSlot(2);
			ItemStack boots = player.getEquipmentInSlot(1);
			
			if(helm != null && chest != null && pants != null && boots != null && 
					helm.getItem() == FantasticArmor.diverHelm && chest.getItem() == FantasticArmor.diverChest &&
					pants.getItem() == FantasticArmor.diverPants && boots.getItem() == FantasticArmor.diverBoots)
			{
				player.motionY -= 0.15F;
			}
		}
		
		
	}
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event)
	{
		
	}

	
	
	
	//When Hurt
	

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		if(event.entityLiving instanceof EntityLobster)
		{
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				event.source.getEntity().attackEntityFrom(DamageSource.cactus, 0.5F);
			}
		}
		if(event.entityLiving instanceof EntityClam)
		{
			EntityClam clam = (EntityClam)event.entityLiving;
			if(event.source.getEntity() instanceof EntityPlayer && clam.getIsClosed())
			{
				EntityPlayer player = (EntityPlayer)event.source.getEntity();
				if(player.getCurrentEquippedItem() != null  )
				{
						if(player.getCurrentEquippedItem().getItem() != Items.wooden_pickaxe 
					&& player.getCurrentEquippedItem().getItem() != Items.stone_pickaxe && player.getCurrentEquippedItem().getItem() != Items.iron_pickaxe
					&& player.getCurrentEquippedItem().getItem() != Items.diamond_pickaxe)
				
					event.setCanceled(true);
				}
			}
		}
		if(event.entityLiving instanceof EntityBasicShark)
		{
			EntityBasicShark shark = (EntityBasicShark)event.entityLiving;
			shark.attackTimer = 60;
		}
		
		
	}
		
	
	

	@SubscribeEvent
	public void onItemTossEvent(ItemTossEvent event)
	{
		
	}
	
	

	@SubscribeEvent
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		if(event.target instanceof EntitySquid)
		{
			if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == FantasticItems.fishingNet)
			{
				event.entityPlayer.getCurrentEquippedItem().damageItem(5, event.entityPlayer);
				
				ItemStack squid = new ItemStack(FantasticItems.squid, 1);
				if(((EntitySquid)event.target).hasCustomNameTag())
				squid.setStackDisplayName(((EntitySquid)event.target).getCustomNameTag());
				EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.target.posX, event.target.posY, event.target.posZ, squid);
				event.target.setDead();
				if(!event.entityPlayer.worldObj.isRemote)
				{
					event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
				}
			}
			
		}
		
	}

	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		
	}
	
	
	
	
	
	
	
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer &&
				event.entity.getExtendedProperties(PlayerInfo.FantasticPlayer) == null)
				{
					PlayerInfo.register(((EntityPlayer) event.entity));
				}
	}
	
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{

		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityBasicShark)
		{

				((EntityBasicShark)event.source.getEntity()).setHungry(1200);
				((EntityBasicShark)event.source.getEntity()).heal(2.0F);
			
			
		}
		if(!event.entity.worldObj.isRemote)
		{
			if(event.entity instanceof EntityPlayer)
			{
				EntityPlayer player = ((EntityPlayer)event.entity);
				PlayerInfo.saveProxyData(player);
			}
		}
		
	}


	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{	
		
		
		if(event.entity instanceof EntityPlayer)
		{

			if(!event.world.isRemote)
				PlayerInfo.loadProxyData((EntityPlayer) event.entity);
			
		}

	}
	
	@SubscribeEvent
	public void onPlayerUseItem(PlayerUseItemEvent.Start event)
	{
		if(event.item != null && event.item.getItem() == Items.fishing_rod)
		{
			if(event.entityPlayer.fishEntity != null)
			{
				EntityFishHook hook = (EntityFishHook)event.entityPlayer.fishEntity;
				if(hook.field_146043_c == null || !(hook.field_146043_c instanceof EntityWaterMob))
					return;
				
				System.out.println(hook.field_146043_c);
				double moveX = (hook.posX - event.entityPlayer.posX);
				double moveY = (hook.posY - event.entityPlayer.posY);
				double moveZ = (hook.posZ - event.entityPlayer.posZ);
				double angle = Math.atan2(moveZ, moveX);
				
				moveX = -(Math.cos(angle));
				moveZ = -(Math.sin(angle));
				moveY = 0.02F;
				hook.field_146043_c.addVelocity(moveX, moveY, moveZ);
				event.setCanceled(true);
			}
		}
	}
	
	
	
}
