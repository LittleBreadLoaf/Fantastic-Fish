package fantastic.animations.common.animations.SerpentBoss;

import fantastic.animations.common.mcacommonlibrary.animation.Channel;
import fantastic.animations.common.mcacommonlibrary.animation.KeyFrame;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;
import fantastic.animations.common.mcacommonlibrary.math.Vector3f;

public class ChannelWhirlpool extends Channel {
	public ChannelWhirlpool(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("bodypeice7", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice5", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice13", new Quaternion(-0.022557564F, 0.25783417F, -0.08418597F, 0.9622502F));
frame0.modelRenderersRotations.put("bodypeice10", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice12", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame0.modelRenderersRotations.put("bodypeice11", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice1", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice3", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice2", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice6", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice8", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice4", new Quaternion(0.0F, 0.0F, -0.043619387F, 0.99904823F));
frame0.modelRenderersRotations.put("bodypeice9", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame0.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame0.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame0.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame0.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice4", new Vector3f(47.0F, 40.0F, 20.0F));
frame0.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(0, frame0);

KeyFrame frame2 = new KeyFrame();
frame2.modelRenderersRotations.put("bodypeice4", new Quaternion(0.030843563F, -0.7064338F, -0.030843563F, 0.7064338F));
frame2.modelRenderersTranslations.put("bodypeice4", new Vector3f(-20.0F, 40.0F, 47.0F));
keyFrames.put(2, frame2);

KeyFrame frame4 = new KeyFrame();
frame4.modelRenderersRotations.put("jaw", new Quaternion(0.1650476F, 0.0F, 0.0F, 0.9862856F));
frame4.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.043619387F, 0.99904823F, 1.906664E-9F, -4.3669786E-8F));
frame4.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame4.modelRenderersTranslations.put("bodypeice4", new Vector3f(-47.0F, 40.0F, -20.0F));
keyFrames.put(4, frame4);

KeyFrame frame6 = new KeyFrame();
frame6.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.030843563F, 0.7064338F, -0.030843563F, 0.7064338F));
frame6.modelRenderersTranslations.put("bodypeice4", new Vector3f(20.0F, 40.0F, -47.0F));
keyFrames.put(6, frame6);

KeyFrame frame8 = new KeyFrame();
frame8.modelRenderersRotations.put("bodypeice7", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice5", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice13", new Quaternion(-0.022557564F, 0.25783417F, -0.08418597F, 0.9622502F));
frame8.modelRenderersRotations.put("bodypeice10", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice12", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame8.modelRenderersRotations.put("bodypeice11", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice1", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice3", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice2", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice6", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice8", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice4", new Quaternion(0.0F, 0.0F, -0.043619387F, 0.99904823F));
frame8.modelRenderersRotations.put("bodypeice9", new Quaternion(0.011289528F, 0.2585727F, 0.042133093F, 0.9650065F));
frame8.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame8.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame8.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame8.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame8.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice4", new Vector3f(47.0F, 40.0F, 20.0F));
frame8.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(8, frame8);

}
}