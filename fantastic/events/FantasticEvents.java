package fantastic.events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.ForgeSubscribe;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityLobster;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTuna;
import fantastic.proxies.CommonProxy;

public class FantasticEvents 
{
	
	public static CommonProxy proxy = new CommonProxy();
	Random rand = new Random();
	private int texture = 0;

	
	@ForgeSubscribe
	public void onLivingSpawnEvent(LivingSpawnEvent event)
	{
		float renderSize = 0.9F;
		int waters = 0;
		for(int k = -10; k<=10; k++)
		{
			if(event.world.getBlockId((int)event.entity.posX, (int)event.entity.posY, (int)event.entity.posZ + k) == Block.waterStill.blockID)
			{
				waters++;
			}
		}
		
		if(waters <= 2)
		{
			if(rand.nextInt(7) == 0)
			{
				renderSize = 0.5F;
			}
			else
			{
				renderSize = 0.25F;
			}
		}
		else if(waters <= 4)
		{
			if(rand.nextInt(15) == 0)
			{
				renderSize = (0.8F);
			}
			else
			{
				renderSize = (0.5F);
			}
		}
		else if(waters <= 7)
		{
			if(rand.nextInt(20) == 0)
			{
				renderSize = (1.0F);
			}
			else if(rand.nextInt(10) == 0)
			{
				renderSize = (0.8F);
			}
			else
			{
				renderSize = (0.5F);
			}
		}
		else if(waters <= 10)
		{
			if(rand.nextInt(20) == 0)
			{
				renderSize = (1.3F);
			}
			else if(rand.nextInt(10) == 0)
			{
				renderSize = (1.0F);
			}
			else if(rand.nextInt(5) == 0)
			{
				renderSize = (0.8F);
			}
			else
			{
				renderSize = (0.5F);
			}
		}
		else if(waters > 15)
		{
			if(rand.nextInt(50) == 0)
			{
				renderSize = (1.8F);
			}
			else if (rand.nextInt(30) == 0)
			{
				renderSize = (1.3F);
			}
			else if(rand.nextInt(15) == 0)
			{
				renderSize = (1.0F);
			}
			else if(rand.nextInt(10) == 0)
			{
				renderSize = (0.8F);
			}
			else
			{
				renderSize = (0.5F);
			}
		}
		
		
		if(event.entity instanceof EntityBasicFish)
		{
			EntityBasicFish Fish = (EntityBasicFish)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
		if(event.entity instanceof EntityCaveFish)
		{
			EntityCaveFish Fish = (EntityCaveFish)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
		if(event.entity instanceof EntitySalmon)
		{
			EntitySalmon Fish = (EntitySalmon)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
		if(event.entity instanceof EntityFeeder)
		{
			EntityFeeder Fish = (EntityFeeder)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
		if(event.entity instanceof EntityMossy)
		{
			EntityMossy Fish = (EntityMossy)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
		if(event.entity instanceof EntityTuna)
		{
			EntityTuna Fish = (EntityTuna)event.entity;
			if(Fish.getRenderSize() == 0.9F)
			{
				Fish.setRenderSize(renderSize);
			
			}
		}
	}
	
	@ForgeSubscribe
	public void onSpawnEvent(EntityJoinWorldEvent event)
	{
		
		float renderSize = 0.9F;
		if(event.entity instanceof EntityBasicFish)
		{
			EntityBasicFish Fish = (EntityBasicFish)event.entity;
			if(Fish.getHasNotSpawned())
			{
				Fish.setRenderSize(renderSize);
			

			BiomeGenBase spawnBiome = event.entity.worldObj.getBiomeGenForCoords((int)Fish.posX, (int)Fish.posZ);
			if(spawnBiome == BiomeGenBase.jungle || spawnBiome == BiomeGenBase.jungleHills)
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
			else if(spawnBiome == BiomeGenBase.ocean)
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
	
	
	//On Death
	
	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		
	}
	
	
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
	
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack par1 = player.getCurrentItemOrArmor(4);
			
		}
	}
	
	
	//Jumping and Falling
	
	
	@ForgeSubscribe
	public void onLivingJumpEvent(LivingJumpEvent event)
	{
		
		
	}
	@ForgeSubscribe
	public void onLivingFallEvent(LivingFallEvent event)
	{
		
	}
	
	
	
	//When Hurt
	
	
	@ForgeSubscribe
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		if(event.entityLiving instanceof EntityLobster)
		{
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				event.source.getEntity().attackEntityFrom(DamageSource.cactus, 0.5F);
			}
		}
		
	}
		
	
	
	
	@ForgeSubscribe
	public void onItemTossEvent(ItemTossEvent event)
	{
		
	}
	
	
	
	@ForgeSubscribe
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		
	}
	
	@ForgeSubscribe
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		
	}

	
}
