package fantastic.animations.common.animations.SerpentBoss;

import fantastic.animations.common.mcacommonlibrary.animation.Channel;
import fantastic.animations.common.mcacommonlibrary.animation.KeyFrame;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;
import fantastic.animations.common.mcacommonlibrary.math.Vector3f;

public class ChannelPosedIdle extends Channel {
	public ChannelPosedIdle(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame0.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame0.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, -0.011289528F, -0.042133093F, 0.9650065F));
frame0.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame0.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame0.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame0.modelRenderersTranslations.put("bodypeice4", new Vector3f(0.0F, 15.0F, 0.0F));
frame0.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(0, frame0);

KeyFrame frame1 = new KeyFrame();
frame1.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame1.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, -0.053371772F, -0.030814212F, 0.96359557F));
frame1.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame1.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame1.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame1.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(1, frame1);

KeyFrame frame2 = new KeyFrame();
frame2.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame2.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame2.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, -0.09535242F, -0.01943667F, 0.9603504F));
frame2.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame2.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame2.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(2, frame2);

KeyFrame frame3 = new KeyFrame();
frame3.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame3.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame3.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, 0.0030127317F, 0.1560939F, 0.8391066F));
frame3.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame3.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame3.modelRenderersTranslations.put("bodypeice4", new Vector3f(-10.0F, 76.0F, 16.0F));
keyFrames.put(3, frame3);

KeyFrame frame4 = new KeyFrame();
frame4.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame4.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame4.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, 0.011289528F, 0.042133093F, 0.9650065F));
frame4.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame4.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame4.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(4, frame4);

KeyFrame frame5 = new KeyFrame();
frame5.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame5.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, 0.053371772F, 0.030814212F, 0.96359557F));
frame5.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame5.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame5.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame5.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(5, frame5);

KeyFrame frame6 = new KeyFrame();
frame6.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame6.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame6.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, 0.09535242F, 0.01943667F, 0.9603504F));
frame6.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame6.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame6.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(6, frame6);

KeyFrame frame7 = new KeyFrame();
frame7.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame7.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame7.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, -0.0030127317F, -0.1560939F, 0.8391066F));
frame7.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame7.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame7.modelRenderersTranslations.put("bodypeice4", new Vector3f(-10.0F, 76.0F, 16.0F));
keyFrames.put(7, frame7);

KeyFrame frame8 = new KeyFrame();
frame8.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame8.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame8.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, -0.011289528F, -0.042133093F, 0.9650065F));
frame8.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame8.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame8.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(8, frame8);

KeyFrame frame9 = new KeyFrame();
frame9.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame9.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, -0.053371772F, -0.030814212F, 0.96359557F));
frame9.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame9.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame9.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame9.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(9, frame9);

KeyFrame frame10 = new KeyFrame();
frame10.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame10.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame10.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, -0.09535242F, -0.01943667F, 0.9603504F));
frame10.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame10.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame10.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(10, frame10);

KeyFrame frame11 = new KeyFrame();
frame11.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame11.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame11.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, 0.0030127317F, 0.1560939F, 0.8391066F));
frame11.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame11.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame11.modelRenderersTranslations.put("bodypeice4", new Vector3f(-10.0F, 76.0F, 16.0F));
keyFrames.put(11, frame11);

KeyFrame frame12 = new KeyFrame();
frame12.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame12.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame12.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, 0.011289528F, 0.042133093F, 0.9650065F));
frame12.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame12.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame12.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(12, frame12);

KeyFrame frame13 = new KeyFrame();
frame13.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame13.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, 0.053371772F, 0.030814212F, 0.96359557F));
frame13.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame13.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame13.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame13.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(13, frame13);

KeyFrame frame14 = new KeyFrame();
frame14.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame14.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame14.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, 0.09535242F, 0.01943667F, 0.9603504F));
frame14.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame14.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame14.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(14, frame14);

KeyFrame frame15 = new KeyFrame();
frame15.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame15.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame15.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, -0.0030127317F, -0.1560939F, 0.8391066F));
frame15.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("bodypeice4", new Vector3f(10.0F, 76.0F, 16.0F));
keyFrames.put(15, frame15);

KeyFrame frame17 = new KeyFrame();
frame17.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame17.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, -0.053371772F, -0.030814212F, 0.96359557F));
frame17.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame17.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame17.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame17.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(17, frame17);

KeyFrame frame16 = new KeyFrame();
frame16.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame16.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame16.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, -0.011289528F, -0.042133093F, 0.9650065F));
frame16.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame16.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame16.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame16.modelRenderersTranslations.put("tail1", new Vector3f(0.0F, 0.0F, 0.0F));
frame16.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame16.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(16, frame16);

KeyFrame frame19 = new KeyFrame();
frame19.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame19.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame19.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, 0.0030127317F, 0.1560939F, 0.8391066F));
frame19.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame19.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame19.modelRenderersTranslations.put("bodypeice4", new Vector3f(-10.0F, 76.0F, 16.0F));
keyFrames.put(19, frame19);

KeyFrame frame18 = new KeyFrame();
frame18.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame18.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame18.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, -0.09535242F, -0.01943667F, 0.9603504F));
frame18.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame18.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame18.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(18, frame18);

KeyFrame frame21 = new KeyFrame();
frame21.modelRenderersRotations.put("bodypeice10", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame21.modelRenderersRotations.put("bodypeice2", new Quaternion(0.2601644F, 0.053371772F, 0.030814212F, 0.96359557F));
frame21.modelRenderersRotations.put("bodypeice6", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame21.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame21.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame21.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(21, frame21);

KeyFrame frame20 = new KeyFrame();
frame20.modelRenderersRotations.put("bodypeice13", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame20.modelRenderersRotations.put("bodypeice5", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame20.modelRenderersRotations.put("bodypeice1", new Quaternion(0.2585727F, 0.011289528F, 0.042133093F, 0.9650065F));
frame20.modelRenderersRotations.put("bodypeice9", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame20.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame20.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame20.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame20.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(20, frame20);

KeyFrame frame23 = new KeyFrame();
frame23.modelRenderersRotations.put("bodypeice12", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame23.modelRenderersRotations.put("bodypeice8", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame23.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.5210814F, -0.0030127317F, -0.1560939F, 0.8391066F));
frame23.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame23.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame23.modelRenderersTranslations.put("bodypeice4", new Vector3f(10.0F, 76.0F, 16.0F));
keyFrames.put(23, frame23);

KeyFrame frame22 = new KeyFrame();
frame22.modelRenderersRotations.put("bodypeice7", new Quaternion(0.13706586F, 0.09741411F, 0.07474848F, 0.9829223F));
frame22.modelRenderersRotations.put("bodypeice11", new Quaternion(0.13706586F, -0.09741411F, -0.07474848F, 0.9829223F));
frame22.modelRenderersRotations.put("bodypeice3", new Quaternion(0.2612609F, 0.09535242F, 0.01943667F, 0.9603504F));
frame22.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame22.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame22.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(22, frame22);

}
}