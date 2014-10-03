package fantastic.network;

import fantastic.FantasticMod;
import fantastic.armor.FantasticArmor;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MoveMessage implements IMessage
{
	private float distance;

	public MoveMessage(){}
	
	
	public MoveMessage(float distance)
	{
		this.distance = distance;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		distance = buf.readFloat();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeFloat(distance);
		
	}
	public static class Handler implements IMessageHandler<MoveMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(MoveMessage message, MessageContext ctx)
		{
			EntityPlayer player = FantasticMod.proxy.getPlayerFromMessage(ctx);
			ItemStack boots = player.getEquipmentInSlot(1);
	        
			if(player.isInWater() && boots != null && boots.getItem() == FantasticArmor.flippers)
			player.addVelocity(message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), message.distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
			
			return null;
		}
	}

}
