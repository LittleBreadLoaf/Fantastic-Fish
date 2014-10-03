package fantastic.network;

import fantastic.FantasticMod;
import fantastic.armor.FantasticArmor;
import fantastic.tiles.TileAirCompressor;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ACMessage implements IMessage
{
	private float id;
	private TileAirCompressor ACE;

	public ACMessage(){}
	
	
	public ACMessage(TileAirCompressor ACEntity, int id)
	{
		this.ACE = ACEntity;
		this.id = id;
		
	}
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		id = buf.readFloat();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeFloat(id);
		
	}
	public static class Handler implements IMessageHandler<ACMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(ACMessage message, MessageContext ctx)
		{
			EntityPlayer player = FantasticMod.proxy.getPlayerFromMessage(ctx);
			ItemStack boots = player.getEquipmentInSlot(1);
	        TileAirCompressor ACEntity = message.ACE;
	        if(ACEntity != null)
	        {
	        	if(message.id == 0)
	        	{
	        		ACEntity.setSingleTank(false);
	        		ACEntity.setDoubleTank(false);
					ACEntity.setTankDamage(0);
	        	}
	        	if(message.id == 1)
	        	{
	        		ACEntity.setSingleTank(true);
					ACEntity.setTankDamage(player.getCurrentEquippedItem().getItemDamage());
	        	}
	        	if(message.id == 2)
	        	{
	        		ACEntity.setDoubleTank(true);
					ACEntity.setTankDamage(player.getCurrentEquippedItem().getItemDamage());
	        	}
	        }
			return null;
		}
	}

}
