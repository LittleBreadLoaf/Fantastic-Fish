package fantastic.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import fantastic.FantasticInfo;
import net.minecraft.network.packet.Packet250CustomPayload;

public class FantasticPacket
{
	public static Packet250CustomPayload getPacket(int texture)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			outputStream.writeInt(texture);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new Packet250CustomPayload("Scratch", bos.toByteArray());
	}
}