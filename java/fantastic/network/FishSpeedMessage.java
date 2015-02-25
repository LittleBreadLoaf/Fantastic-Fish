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


public class FishSpeedMessage implements IMessage, IMessageHandler<FishSpeedMessage, IMessage> 
{ 
    private int entityId;
    private float speed;


    public FishSpeedMessage() 
    { 
    } 


    public FishSpeedMessage(int anEntityId,float aSpeed) 
    { 
        entityId=anEntityId;
        speed=aSpeed;


    } 


    @Override 
    public void fromBytes(ByteBuf buf) 
    { 
        entityId = buf.readInt(); 
        speed = buf.readFloat(); 
    } 


    @Override 
    public void toBytes(ByteBuf buf) 
    { 
        buf.writeInt(entityId); 
        buf.writeFloat(speed); 
    } 


	@Override
	public IMessage onMessage(FishSpeedMessage message, MessageContext ctx) 
	{
		if (message!=null)
		{
			FantasticDebug.Output("MESSAGE RECEIVED. Entity: "+Integer.toString(message.entityId)+" Speed:"+Float.toString(message.speed));
			EntityPlayer player = FantasticMod.proxy.getPlayerFromMessage(ctx);
			if (player!=null)
			{
				Entity _ent = player.worldObj.getEntityByID(message.entityId);
				if (_ent!=null)
				{
					((EntityFantasticFish)_ent).SetCurrentSpeed(message.speed);
					FantasticDebug.Output("New speed set to: Entity: "+Integer.toString(message.entityId)+" Speed:"+Float.toString(message.speed));
					return null;
					
				}
				else
				{
					FantasticDebug.Output("Entity IS NULL! ",true);
				}
				
				
			}
			else
			{
				FantasticDebug.Output("PLAYER IS NULL!");
			}
		}
		else
		{
			FantasticDebug.Output("MESSAGE IS NULL!",true);
		}
		return null;
	
	} 
} 
