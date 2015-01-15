package fantastic.animations.common.animations.SerpentBoss;

import java.util.HashMap;

import fantastic.animations.common.mcacommonlibrary.IMCAnimatedEntity;
import fantastic.animations.common.mcacommonlibrary.animation.AnimationHandler;
import fantastic.animations.common.mcacommonlibrary.animation.Channel;

public class AnimationHandlerSerpentBoss extends AnimationHandler {
	/** Map with all the animations. */
	public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();static
{
animChannels.put("pose", new ChannelPose("pose", 16.0F, 16, Channel.LINEAR));
animChannels.put("Posed idle", new ChannelPosedIdle("Posed idle", 8.0F, 24, Channel.LOOP));
animChannels.put("bite", new ChannelBite("bite", 6.0F, 5, Channel.LOOP));
animChannels.put("Dying", new ChannelDying("Dying", 7.0F, 30, Channel.LINEAR));
animChannels.put("whirlpool", new ChannelWhirlpool("whirlpool", 20.0F, 9, Channel.LOOP));
}
	public AnimationHandlerSerpentBoss(IMCAnimatedEntity entity) {
		super(entity);
	}

	@Override
	public void activateAnimation(String name, float startingFrame) {
		super.activateAnimation(animChannels, name, startingFrame);
	}

	@Override
	public void stopAnimation(String name) {
		super.stopAnimation(animChannels, name);
	}

	@Override
	public void fireAnimationEventClientSide(Channel anim, Float frame) {
	}

	@Override
	public void fireAnimationEventServerSide(Channel anim, Float frame) {
	}}