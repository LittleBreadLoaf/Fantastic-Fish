package fantastic.network;
 
 
import io.netty.buffer.ByteBuf; 
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer; 
 

 
import cpw.mods.fml.common.network.simpleimpl.IMessage; 
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler; 
import cpw.mods.fml.common.network.simpleimpl.MessageContext; 
import cpw.mods.fml.relauncher.Side; 
import fantastic.FantasticDebug;
import fantastic.FantasticMod;
import fantastic.entities.EntityFantasticFish;


public class TailSpeedMessage implements IMessage, IMessageHandler<TailSpeedMessage, IMessage> 
{ 
    private int entityId;
    private float tailSpeedMult;


    public TailSpeedMessage() 
    { 
    } 


    public TailSpeedMessage(int anEntityId,float aTailSpeedMult) 
    { 
        entityId=anEntityId;
        tailSpeedMult=aTailSpeedMult;


    } 


    @Override 
    public void fromBytes(ByteBuf buf) 
    { 
        entityId = buf.readInt(); 
        tailSpeedMult = buf.readFloat(); 
    } 


    @Override 
    public void toBytes(ByteBuf buf) 
    { 
        buf.writeInt(entityId); 
        buf.writeFloat(tailSpeedMult); 
    } 


	@Override
	public IMessage onMessage(TailSpeedMessage message, MessageContext ctx) 
	{
		if (message!=null)
		{
			FantasticDebug.Output("MESSAGE RECEIVED. Entity: "+Integer.toString(message.entityId)+" Tail Speed:"+Float.toString(message.tailSpeedMult),true);
			EntityPlayer player = FantasticMod.proxy.getPlayerFromMessage(ctx);
			if (player!=null)
			{
				Entity _ent = player.worldObj.getEntityByID(message.entityId);
				if (_ent!=null)
				{
					((EntityFantasticFish)_ent).SetCurrentTailFlapSpeedMult(message.tailSpeedMult);
					FantasticDebug.Output("New tail speed set to: Entity: "+Integer.toString(message.entityId)+" Tail Speed:"+Float.toString(message.tailSpeedMult),true);
					return null;
					
				}
				else
				{
					FantasticDebug.Output("Entity IS NULL! ",true);
				}
				
				
			}
			else
			{
				FantasticDebug.Output("PLAYER IS NULL!",true);
			}
		}
		else
		{
			FantasticDebug.Output("MESSAGE IS NULL!",true);
		}
		return null;
	
	} 
} 
