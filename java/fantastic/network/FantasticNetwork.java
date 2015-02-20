package fantastic.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fantastic.FantasticMod;

public class FantasticNetwork 
{

	public static SimpleNetworkWrapper network;
	
	public static void Init()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel("FantasticChannel");
		network.registerMessage(DecideMessage.Handler.class, DecideMessage.class, 0, Side.SERVER);
		network.registerMessage(MoveMessage.Handler.class, MoveMessage.class, 1, Side.CLIENT);
		network.registerMessage(ACMessage.Handler.class, ACMessage.class, 2, Side.SERVER);
		network.registerMessage(TailSpeedMessage.class, TailSpeedMessage.class, 3, Side.CLIENT);
	}
	
	
	
}
