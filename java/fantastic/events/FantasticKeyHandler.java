package fantastic.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import fantastic.FantasticMod;
import fantastic.network.DecideMessage;
import fantastic.network.MoveMessage;
public class FantasticKeyHandler
{
	/** Key index for easy handling */
	public static final int SWIM = 0;
	Minecraft mc = Minecraft.getMinecraft();
	EntityPlayer Player = mc.thePlayer;


	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = {"key.swim.desc"};

	/** Default key values */
	private static final int[] keyValues = {Keyboard.KEY_F};
	private final KeyBinding[] keys;

	public FantasticKeyHandler() {
		keys = new KeyBinding[desc.length];
		for(int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding(desc[i], keyValues[i], "key.fantastic.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event bus
	 */	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (FMLClientHandler.instance().getClient().inGameHasFocus);
		{
			if (keys[SWIM].isPressed()) 
			{
				FantasticMod.network.sendToServer(new DecideMessage(0));
			}
			
		}
	}
}