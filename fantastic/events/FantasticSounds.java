package fantastic.events;

import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import fantastic.FantasticInfo;

public class FantasticSounds
{

	private static final String Fantastic = FantasticInfo.ID.toLowerCase() + ":";

	public static String[] soundFiles = { "clamShut.ogg", "lobster_hurt.ogg", "lobster_idle1.ogg", "lobster_idle2.ogg"};

    
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		for (String soundFile : soundFiles)
		{
			try
			{
				event.manager.soundPoolSounds.addSound(Fantastic + soundFile);
				System.out.println("Sound file loaded: " + soundFile);

			} catch (Exception e)
			{
				System.out.println("Failed loading sound file: " + soundFile);
			}
		}	
	}

	
}