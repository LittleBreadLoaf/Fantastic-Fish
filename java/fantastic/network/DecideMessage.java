package fantastic.network;

import fantastic.FantasticMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class DecideMessage implements IMessage
{
	private int id;

	public DecideMessage(){}
	
	
	public DecideMessage(int id)
	{
		this.id = id;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		id = buf.readInt();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeInt(id);
		
	}
	public static class Handler implements IMessageHandler<DecideMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(DecideMessage message, MessageContext ctx)
		{
			EntityPlayer player = (ctx.getServerHandler().playerEntity);
			 if(message.id == 0)
			 {
				 if(player instanceof EntityPlayerMP)
					 FantasticMod.network.sendTo(new MoveMessage(0.2F), (EntityPlayerMP)player);
			 }
			 
			return null;
		}
	}

}
