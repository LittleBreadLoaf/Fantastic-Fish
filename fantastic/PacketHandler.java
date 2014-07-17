package fantastic;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	public PacketHandler(){}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		if(packet.channel.equals(FantasticInfo.CHANNEL))
		{
			handleExtendedProperties(packet, player);
		}
		
		
	}
	

	private void handleExtendedProperties(Packet250CustomPayload packet, Player player)
	{
		
	}

	

}
