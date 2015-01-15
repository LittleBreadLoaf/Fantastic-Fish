package fantastic.animations.common.animations.SerpentBoss;

import fantastic.animations.common.mcacommonlibrary.animation.Channel;
import fantastic.animations.common.mcacommonlibrary.animation.KeyFrame;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;
import fantastic.animations.common.mcacommonlibrary.math.Vector3f;

public class ChannelBite extends Channel {
	public ChannelBite(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame0.modelRenderersRotations.put("head", new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame0.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(0, frame0);

KeyFrame frame2 = new KeyFrame();
frame2.modelRenderersRotations.put("jaw", new Quaternion(0.32556814F, 0.0F, 0.0F, 0.94551855F));
frame2.modelRenderersRotations.put("head", new Quaternion(0.11320321F, 0.0F, 0.0F, 0.9935719F));
frame2.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame2.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(2, frame2);

KeyFrame frame4 = new KeyFrame();
frame4.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame4.modelRenderersRotations.put("head", new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame4.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame4.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(4, frame4);

}
}