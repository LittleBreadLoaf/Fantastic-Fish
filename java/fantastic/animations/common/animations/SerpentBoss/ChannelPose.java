package fantastic.animations.common.animations.SerpentBoss;

import fantastic.animations.common.mcacommonlibrary.animation.Channel;
import fantastic.animations.common.mcacommonlibrary.animation.KeyFrame;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;
import fantastic.animations.common.mcacommonlibrary.math.Vector3f;

public class ChannelPose extends Channel {
	public ChannelPose(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("bodypeice1", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("bodypeice3", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("bodypeice2", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("bodypeice4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame0.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame0.modelRenderersTranslations.put("bodypeice4", new Vector3f(0.0F, 15.0F, 0.0F));
keyFrames.put(0, frame0);

KeyFrame frame3 = new KeyFrame();
frame3.modelRenderersRotations.put("bodypeice1", new Quaternion(-0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame3.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
keyFrames.put(3, frame3);

KeyFrame frame4 = new KeyFrame();
frame4.modelRenderersRotations.put("bodypeice2", new Quaternion(-0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame4.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
keyFrames.put(4, frame4);

KeyFrame frame5 = new KeyFrame();
frame5.modelRenderersRotations.put("bodypeice3", new Quaternion(-0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame5.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(5, frame5);

KeyFrame frame6 = new KeyFrame();
frame6.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.6691306F, 0.0F, 0.0F, 0.7431448F));
frame6.modelRenderersTranslations.put("headtop1", new Vector3f(0.0F, 0.0F, 0.0F));
frame6.modelRenderersTranslations.put("bodypeice4", new Vector3f(0.0F, 38.0F, 44.0F));
keyFrames.put(6, frame6);

KeyFrame frame7 = new KeyFrame();
frame7.modelRenderersRotations.put("bodypeice5", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame7.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(7, frame7);

KeyFrame frame8 = new KeyFrame();
frame8.modelRenderersRotations.put("bodypeice6", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame8.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(8, frame8);

KeyFrame frame9 = new KeyFrame();
frame9.modelRenderersRotations.put("bodypeice7", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame9.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(9, frame9);

KeyFrame frame10 = new KeyFrame();
frame10.modelRenderersRotations.put("bodypeice8", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame10.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.2079117F, 0.0F, 0.0F, 0.9781476F));
frame10.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame10.modelRenderersTranslations.put("bodypeice4", new Vector3f(0.0F, 59.0F, 53.0F));
keyFrames.put(10, frame10);

KeyFrame frame11 = new KeyFrame();
frame11.modelRenderersRotations.put("bodypeice9", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame11.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(11, frame11);

KeyFrame frame12 = new KeyFrame();
frame12.modelRenderersRotations.put("bodypeice10", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame12.modelRenderersRotations.put("bodypeice1", new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame12.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
keyFrames.put(12, frame12);

KeyFrame frame13 = new KeyFrame();
frame13.modelRenderersRotations.put("bodypeice11", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame13.modelRenderersRotations.put("bodypeice2", new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame13.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame13.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
keyFrames.put(13, frame13);

KeyFrame frame14 = new KeyFrame();
frame14.modelRenderersRotations.put("bodypeice12", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame14.modelRenderersRotations.put("bodypeice3", new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F));
frame14.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame14.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(14, frame14);

KeyFrame frame15 = new KeyFrame();
frame15.modelRenderersRotations.put("bodypeice7", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice13", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice5", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice10", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice12", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice11", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice6", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice8", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.53729963F, 0.0F, 0.0F, 0.8433914F));
frame15.modelRenderersRotations.put("bodypeice9", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame15.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice4", new Vector3f(0.0F, 76.0F, 16.0F));
frame15.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(15, frame15);

}
}