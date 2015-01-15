package fantastic.animations.common.animations.SerpentBoss;

import fantastic.animations.common.mcacommonlibrary.animation.Channel;
import fantastic.animations.common.mcacommonlibrary.animation.KeyFrame;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;
import fantastic.animations.common.mcacommonlibrary.math.Vector3f;

public class ChannelDying extends Channel {
	public ChannelDying(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame1 = new KeyFrame();
frame1.modelRenderersRotations.put("bodypeice11", new Quaternion(0.0F, -0.28401536F, 0.0F, 0.95881975F));
frame1.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(1, frame1);

KeyFrame frame2 = new KeyFrame();
frame2.modelRenderersRotations.put("bodypeice5", new Quaternion(0.21838707F, -0.22598507F, -0.07567115F, 0.9463148F));
frame2.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame2.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame2.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(2, frame2);

KeyFrame frame3 = new KeyFrame();
frame3.modelRenderersRotations.put("bodypeice12", new Quaternion(0.0F, -0.309017F, 0.0F, 0.95105654F));
frame3.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame3.modelRenderersRotations.put("bodypeice6", new Quaternion(0.12036024F, -0.17813009F, -0.03157895F, 0.9761075F));
frame3.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.38330466F, -0.08717103F, -0.08408368F, 0.9156467F));
frame3.modelRenderersRotations.put("bodypeice9", new Quaternion(0.006554185F, -0.2502942F, -0.025343152F, 0.9678159F));
frame3.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame3.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame3.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame3.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 64.0F, 19.0F));
frame3.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(3, frame3);

KeyFrame frame4 = new KeyFrame();
frame4.modelRenderersRotations.put("bodypeice7", new Quaternion(0.016630098F, -0.19008291F, -0.085554436F, 0.9778918F));
frame4.modelRenderersRotations.put("bodypeice13", new Quaternion(0.0F, -0.26723838F, 0.0F, 0.96363044F));
frame4.modelRenderersRotations.put("bodypeice10", new Quaternion(0.00211114F, -0.2419127F, -0.00846732F, 0.9702588F));
frame4.modelRenderersRotations.put("jaw", new Quaternion(0.21643962F, 0.0F, 0.0F, 0.976296F));
frame4.modelRenderersRotations.put("bodypeice1", new Quaternion(-0.23344538F, 0.0F, 0.0F, 0.9723699F));
frame4.modelRenderersRotations.put("bodypeice3", new Quaternion(-0.17101006F, 0.17101006F, 0.03015369F, 0.96984625F));
frame4.modelRenderersRotations.put("bodypeice8", new Quaternion(0.01682726F, -0.27512324F, -0.058683623F, 0.9594687F));
frame4.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.3893853F, -0.09089498F, -0.096166156F, 0.91152024F));
frame4.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame4.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame4.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame4.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame4.modelRenderersTranslations.put("bodypeice4", new Vector3f(-41.0F, 63.0F, 18.0F));
frame4.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(4, frame4);

KeyFrame frame5 = new KeyFrame();
frame5.modelRenderersRotations.put("jaw", new Quaternion(0.33380687F, 0.0F, 0.0F, 0.9426415F));
frame5.modelRenderersRotations.put("bodypeice2", new Quaternion(-0.060526263F, 0.13028274F, 0.007968434F, 0.98959565F));
frame5.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.3577226F, -0.105478495F, -0.08802952F, 0.9236664F));
frame5.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame5.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame5.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame5.modelRenderersTranslations.put("bodypeice4", new Vector3f(-43.0F, 65.0F, 19.0F));
frame5.modelRenderersTranslations.put("eyeL", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(5, frame5);

KeyFrame frame6 = new KeyFrame();
frame6.modelRenderersRotations.put("jaw", new Quaternion(0.06104854F, 0.0F, 0.0F, 0.9981348F));
frame6.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.37084568F, -0.074431725F, -0.11520825F, 0.9185099F));
frame6.modelRenderersRotations.put("head", new Quaternion(0.25057504F, 0.24184851F, -0.064803116F, 0.9351588F));
frame6.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame6.modelRenderersTranslations.put("bodypeice4", new Vector3f(-36.0F, 64.0F, 18.0F));
frame6.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(6, frame6);

KeyFrame frame7 = new KeyFrame();
frame7.modelRenderersRotations.put("bodypeice5", new Quaternion(0.20027767F, -0.20877278F, 0.016345825F, 0.9570975F));
frame7.modelRenderersRotations.put("jaw", new Quaternion(0.06104854F, 0.0F, 0.0F, 0.9981348F));
frame7.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.36509666F, -0.08204225F, -0.09856694F, 0.9220944F));
frame7.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame7.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame7.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame7.modelRenderersTranslations.put("bodypeice4", new Vector3f(-41.0F, 63.0F, 19.0F));
keyFrames.put(7, frame7);

KeyFrame frame8 = new KeyFrame();
frame8.modelRenderersRotations.put("bodypeice10", new Quaternion(0.07022179F, -0.07887185F, -0.0032056207F, 0.9944033F));
frame8.modelRenderersRotations.put("jaw", new Quaternion(0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame8.modelRenderersRotations.put("bodypeice3", new Quaternion(-0.17341019F, -0.051540855F, -0.009088044F, 0.98345804F));
frame8.modelRenderersRotations.put("bodypeice6", new Quaternion(0.16231772F, -0.22029307F, -0.20342824F, 0.94007486F));
frame8.modelRenderersRotations.put("bodypeice8", new Quaternion(-0.004810535F, -0.27559537F, 0.016776329F, 0.9611153F));
frame8.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.3577226F, -0.105478495F, -0.08802952F, 0.9236664F));
frame8.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame8.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame8.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame8.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 64.0F, 18.0F));
frame8.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(8, frame8);

KeyFrame frame9 = new KeyFrame();
frame9.modelRenderersRotations.put("bodypeice7", new Quaternion(0.04970962F, -0.19009192F, 0.018540256F, 0.98033166F));
frame9.modelRenderersRotations.put("bodypeice11", new Quaternion(0.0F, -0.1391731F, 0.0F, 0.99026805F));
frame9.modelRenderersRotations.put("bodypeice2", new Quaternion(-0.07821723F, -0.07821723F, -0.0061558303F, 0.9938441F));
frame9.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.386701F, -0.060931224F, -0.12101123F, 0.9121985F));
frame9.modelRenderersRotations.put("head", new Quaternion(0.16437311F, -0.17339888F, 0.06541936F, 0.9688316F));
frame9.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame9.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame9.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame9.modelRenderersTranslations.put("bodypeice4", new Vector3f(-41.0F, 63.0F, 18.0F));
frame9.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(9, frame9);

KeyFrame frame10 = new KeyFrame();
frame10.modelRenderersRotations.put("bodypeice12", new Quaternion(0.0F, -0.12186935F, 0.0F, 0.99254614F));
frame10.modelRenderersRotations.put("jaw", new Quaternion(0.309017F, 0.0F, 0.0F, 0.95105654F));
frame10.modelRenderersRotations.put("bodypeice1", new Quaternion(-0.23905823F, -0.1259869F, 0.041030686F, 0.9619225F));
frame10.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.38330466F, -0.08717103F, -0.08408368F, 0.9156467F));
frame10.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame10.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame10.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame10.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 64.0F, 17.0F));
keyFrames.put(10, frame10);

KeyFrame frame11 = new KeyFrame();
frame11.modelRenderersRotations.put("bodypeice13", new Quaternion(0.0F, -0.1478094F, 0.0F, 0.9890159F));
frame11.modelRenderersRotations.put("bodypeice5", new Quaternion(0.21838707F, -0.22598507F, -0.07567115F, 0.9463148F));
frame11.modelRenderersRotations.put("bodypeice10", new Quaternion(0.00211114F, -0.2419127F, -0.00846732F, 0.9702588F));
frame11.modelRenderersRotations.put("bodypeice3", new Quaternion(-0.1717408F, 0.14556384F, 0.025666833F, 0.9739905F));
frame11.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.31686383F, -0.05670675F, -0.1021899F, 0.94124323F));
frame11.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame11.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame11.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame11.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame11.modelRenderersTranslations.put("bodypeice4", new Vector3f(-41.0F, 62.0F, 17.0F));
keyFrames.put(11, frame11);

KeyFrame frame12 = new KeyFrame();
frame12.modelRenderersRotations.put("bodypeice7", new Quaternion(0.016630098F, -0.19008291F, -0.085554436F, 0.9778918F));
frame12.modelRenderersRotations.put("jaw", new Quaternion(0.27563736F, 0.0F, 0.0F, 0.9612617F));
frame12.modelRenderersRotations.put("bodypeice11", new Quaternion(0.0F, -0.28401536F, 0.0F, 0.95881975F));
frame12.modelRenderersRotations.put("bodypeice2", new Quaternion(-0.060656115F, 0.11299206F, 0.006910891F, 0.99171865F));
frame12.modelRenderersRotations.put("bodypeice6", new Quaternion(0.12036024F, -0.17813009F, -0.03157895F, 0.9761075F));
frame12.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.32971215F, -0.09870172F, -0.1095227F, 0.93249816F));
frame12.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame12.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame12.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame12.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 63.0F, 19.0F));
keyFrames.put(12, frame12);

KeyFrame frame13 = new KeyFrame();
frame13.modelRenderersRotations.put("bodypeice12", new Quaternion(0.0F, -0.309017F, 0.0F, 0.95105654F));
frame13.modelRenderersRotations.put("bodypeice1", new Quaternion(-0.22607887F, -0.04727444F, -0.10076353F, 0.9677294F));
frame13.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.26846963F, 0.047561783F, -0.041088097F, 0.96123546F));
frame13.modelRenderersRotations.put("head", new Quaternion(0.327156F, 0.2529107F, -0.03349562F, 0.9098808F));
frame13.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame13.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame13.modelRenderersTranslations.put("bodypeice4", new Vector3f(-43.0F, 66.0F, 19.0F));
frame13.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(13, frame13);

KeyFrame frame14 = new KeyFrame();
frame14.modelRenderersRotations.put("bodypeice13", new Quaternion(0.0F, -0.26723838F, 0.0F, 0.96363044F));
frame14.modelRenderersRotations.put("bodypeice3", new Quaternion(0.004517015F, 0.25877962F, 0.016857728F, 0.9657787F));
frame14.modelRenderersRotations.put("bodypeice8", new Quaternion(0.01682726F, -0.27512324F, -0.058683623F, 0.9594687F));
frame14.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.3690486F, -0.03038285F, -0.08736991F, 0.9247954F));
frame14.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
frame14.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
frame14.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
frame14.modelRenderersTranslations.put("bodypeice4", new Vector3f(-43.0F, 65.0F, 17.0F));
keyFrames.put(14, frame14);

KeyFrame frame15 = new KeyFrame();
frame15.modelRenderersRotations.put("bodypeice5", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame15.modelRenderersRotations.put("jaw", new Quaternion(0.5591929F, 0.0F, 0.0F, 0.8290376F));
frame15.modelRenderersRotations.put("bodypeice2", new Quaternion(0.013545543F, 0.25846434F, 0.050552655F, 0.964602F));
frame15.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.38330466F, -0.08717103F, -0.08408368F, 0.9156467F));
frame15.modelRenderersTranslations.put("bodypeice5", new Vector3f(0.0F, 0.0F, -32.0F));
frame15.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame15.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame15.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 64.0F, 20.0F));
keyFrames.put(15, frame15);

KeyFrame frame17 = new KeyFrame();
frame17.modelRenderersRotations.put("bodypeice7", new Quaternion(0.011289528F, -0.2585727F, -0.042133093F, 0.9650065F));
frame17.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.21534175F, -0.017989837F, -0.03972284F, 0.97556466F));
frame17.modelRenderersRotations.put("head", new Quaternion(0.25660482F, 0.12607862F, -0.033782665F, 0.9576622F));
frame17.modelRenderersTranslations.put("bodypeice7", new Vector3f(0.0F, 0.0F, -32.0F));
frame17.modelRenderersTranslations.put("bodypeice4", new Vector3f(-46.0F, 62.0F, 20.0F));
frame17.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
keyFrames.put(17, frame17);

KeyFrame frame16 = new KeyFrame();
frame16.modelRenderersRotations.put("bodypeice1", new Quaternion(0.013545543F, 0.25846434F, 0.050552655F, 0.964602F));
frame16.modelRenderersRotations.put("bodypeice6", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame16.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.27405718F, -0.05387312F, -0.03356973F, 0.9596163F));
frame16.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
frame16.modelRenderersTranslations.put("bodypeice6", new Vector3f(0.0F, 0.0F, -32.0F));
frame16.modelRenderersTranslations.put("bodypeice4", new Vector3f(-42.0F, 64.0F, 20.0F));
keyFrames.put(16, frame16);

KeyFrame frame19 = new KeyFrame();
frame19.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.006060234F, 0.1735424F, -0.034369294F, 0.9842078F));
frame19.modelRenderersRotations.put("head", new Quaternion(0.36964384F, 0.23911761F, -0.09904577F, 0.8923991F));
frame19.modelRenderersRotations.put("bodypeice9", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame19.modelRenderersTranslations.put("bodypeice4", new Vector3f(-46.0F, 62.0F, 20.0F));
frame19.modelRenderersTranslations.put("head", new Vector3f(0.0F, -6.0F, 40.0F));
frame19.modelRenderersTranslations.put("bodypeice9", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(19, frame19);

KeyFrame frame18 = new KeyFrame();
frame18.modelRenderersRotations.put("bodypeice8", new Quaternion(0.005693473F, -0.13040197F, -0.043246217F, 0.9905013F));
frame18.modelRenderersTranslations.put("bodypeice8", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(18, frame18);

KeyFrame frame21 = new KeyFrame();
frame21.modelRenderersRotations.put("bodypeice11", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame21.modelRenderersRotations.put("bodypeice2", new Quaternion(0.06876975F, 0.40016878F, 0.027089125F, 0.91345596F));
frame21.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.01250686F, 0.35814965F, -0.032581486F, 0.9330117F));
frame21.modelRenderersTranslations.put("bodypeice11", new Vector3f(0.0F, 0.0F, -32.0F));
frame21.modelRenderersTranslations.put("bodypeice2", new Vector3f(0.0F, 0.0F, 32.0F));
frame21.modelRenderersTranslations.put("bodypeice4", new Vector3f(-21.0F, 62.0F, 47.0F));
keyFrames.put(21, frame21);

KeyFrame frame20 = new KeyFrame();
frame20.modelRenderersRotations.put("bodypeice10", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame20.modelRenderersRotations.put("bodypeice1", new Quaternion(0.06876975F, 0.40016878F, 0.027089125F, 0.91345596F));
frame20.modelRenderersTranslations.put("bodypeice10", new Vector3f(0.0F, 0.0F, -32.0F));
frame20.modelRenderersTranslations.put("bodypeice1", new Vector3f(0.0F, 0.0F, 32.0F));
keyFrames.put(20, frame20);

KeyFrame frame23 = new KeyFrame();
frame23.modelRenderersRotations.put("bodypeice13", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame23.modelRenderersTranslations.put("bodypeice13", new Vector3f(0.0F, 0.0F, -32.0F));
keyFrames.put(23, frame23);

KeyFrame frame22 = new KeyFrame();
frame22.modelRenderersRotations.put("bodypeice12", new Quaternion(0.014918708F, -0.3416946F, -0.040988814F, 0.93879825F));
frame22.modelRenderersRotations.put("jaw", new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F));
frame22.modelRenderersRotations.put("bodypeice3", new Quaternion(0.062922806F, 0.3989218F, -0.00836429F, 0.9147853F));
frame22.modelRenderersTranslations.put("bodypeice12", new Vector3f(0.0F, 0.0F, -32.0F));
frame22.modelRenderersTranslations.put("jaw", new Vector3f(0.0F, 0.0F, 0.0F));
frame22.modelRenderersTranslations.put("bodypeice3", new Vector3f(0.0F, 0.0F, 0.0F));
keyFrames.put(22, frame22);

KeyFrame frame24 = new KeyFrame();
frame24.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.074975155F, 0.60178113F, -0.041683763F, 0.79404074F));
frame24.modelRenderersTranslations.put("bodypeice4", new Vector3f(13.0F, 62.0F, 59.0F));
keyFrames.put(24, frame24);

KeyFrame frame27 = new KeyFrame();
frame27.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.084710285F, 0.83706725F, -0.013526898F, 0.54033285F));
frame27.modelRenderersTranslations.put("bodypeice4", new Vector3f(29.0F, 57.0F, 36.0F));
keyFrames.put(27, frame27);

KeyFrame frame29 = new KeyFrame();
frame29.modelRenderersRotations.put("bodypeice4", new Quaternion(-0.007850678F, 0.9737765F, 0.034005024F, 0.22481401F));
frame29.modelRenderersTranslations.put("bodypeice4", new Vector3f(46.0F, 51.0F, 18.0F));
keyFrames.put(29, frame29);

}
}