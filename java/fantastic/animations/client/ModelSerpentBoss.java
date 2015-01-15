package fantastic.animations.client;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import fantastic.animations.client.MCAClientLibrary.MCAModelRenderer;
import fantastic.animations.common.EntitySerpentBoss;
import fantastic.animations.common.mcacommonlibrary.MCAVersionChecker;
import fantastic.animations.common.mcacommonlibrary.animation.AnimationHandler;
import fantastic.animations.common.mcacommonlibrary.math.Matrix4f;
import fantastic.animations.common.mcacommonlibrary.math.Quaternion;

public class ModelSerpentBoss extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 1;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer bodypeice4;
MCAModelRenderer bodypeice3;
MCAModelRenderer bodypeice5;
MCAModelRenderer sidefin1L;
MCAModelRenderer sidefin2L;
MCAModelRenderer sidefin3L;
MCAModelRenderer sidefin1R;
MCAModelRenderer sidefin3R;
MCAModelRenderer sidefin2R;
MCAModelRenderer bodypeice2;
MCAModelRenderer bodypeice6;
MCAModelRenderer bodypeice1;
MCAModelRenderer bodypeice7;
MCAModelRenderer backfin1;
MCAModelRenderer backfin3;
MCAModelRenderer backfin4;
MCAModelRenderer head;
MCAModelRenderer bodypeice8;
MCAModelRenderer eyeR;
MCAModelRenderer eyeL;
MCAModelRenderer jaw;
MCAModelRenderer horn3L;
MCAModelRenderer horn2L;
MCAModelRenderer horn1L;
MCAModelRenderer horn3R;
MCAModelRenderer horn2R;
MCAModelRenderer horn1R;
MCAModelRenderer headtop2;
MCAModelRenderer headtop1;
MCAModelRenderer bodypeice9;
MCAModelRenderer bodypeice10;
MCAModelRenderer bodypeice11;
MCAModelRenderer bodypeice12;
MCAModelRenderer bodypeice13;
MCAModelRenderer tail1;
MCAModelRenderer tail2;
MCAModelRenderer tail6;
MCAModelRenderer tail4;
MCAModelRenderer tail3;
MCAModelRenderer tail5;
public ModelSerpentBoss()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 128;
textureHeight = 512;

bodypeice4 = new MCAModelRenderer(this, "bodypeice4", 32, 139);
bodypeice4.mirror = false;
bodypeice4.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice4.setInitialRotationPoint(0.0F, 15.0F, 0.0F);
bodypeice4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice4.setTextureSize(128, 512);
parts.put(bodypeice4.boxName, bodypeice4);

bodypeice3 = new MCAModelRenderer(this, "bodypeice3", 32, 139);
bodypeice3.mirror = false;
bodypeice3.addBox(-8.0F, -8.0F, 0.0F, 16, 16, 32);
bodypeice3.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
bodypeice3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice3.setTextureSize(128, 512);
parts.put(bodypeice3.boxName, bodypeice3);
bodypeice4.addChild(bodypeice3);

bodypeice5 = new MCAModelRenderer(this, "bodypeice5", 32, 139);
bodypeice5.mirror = false;
bodypeice5.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice5.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice5.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice5.setTextureSize(128, 512);
parts.put(bodypeice5.boxName, bodypeice5);
bodypeice4.addChild(bodypeice5);

sidefin1L = new MCAModelRenderer(this, "sidefin1L", 0, 323);
sidefin1L.mirror = false;
sidefin1L.addBox(-4.0F, 0.0F, -43.0F, 4, 4, 36);
sidefin1L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin1L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27059805F, -0.65328145F, -0.27059805F, 0.65328145F)).transpose());
sidefin1L.setTextureSize(128, 512);
parts.put(sidefin1L.boxName, sidefin1L);
bodypeice4.addChild(sidefin1L);

sidefin2L = new MCAModelRenderer(this, "sidefin2L", 52, 327);
sidefin2L.mirror = false;
sidefin2L.addBox(20.0F, -12.0F, -61.0F, 3, 3, 27);
sidefin2L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin2L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27202776F, -0.35048687F, -0.10715458F, 0.8897628F)).transpose());
sidefin2L.setTextureSize(128, 512);
parts.put(sidefin2L.boxName, sidefin2L);
bodypeice4.addChild(sidefin2L);

sidefin3L = new MCAModelRenderer(this, "sidefin3L", -56, 365);
sidefin3L.mirror = false;
sidefin3L.addBox(-40.0F, 2.0F, -65.0F, 36, 0, 57);
sidefin3L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin3L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27059805F, -0.65328145F, -0.27059805F, 0.65328145F)).transpose());
sidefin3L.setTextureSize(128, 512);
parts.put(sidefin3L.boxName, sidefin3L);
bodypeice4.addChild(sidefin3L);

sidefin1R = new MCAModelRenderer(this, "sidefin1R", 0, 323);
sidefin1R.mirror = true;
sidefin1R.addBox(0.0F, 0.0F, -43.0F, 4, 4, 36);
sidefin1R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin1R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27059805F, 0.65328145F, 0.27059805F, 0.65328145F)).transpose());
sidefin1R.setTextureSize(128, 512);
parts.put(sidefin1R.boxName, sidefin1R);
bodypeice4.addChild(sidefin1R);

sidefin3R = new MCAModelRenderer(this, "sidefin3R", -56, 365);
sidefin3R.mirror = true;
sidefin3R.addBox(4.0F, 2.0F, -65.0F, 36, 0, 57);
sidefin3R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin3R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27059805F, 0.65328145F, 0.27059805F, 0.65328145F)).transpose());
sidefin3R.setTextureSize(128, 512);
parts.put(sidefin3R.boxName, sidefin3R);
bodypeice4.addChild(sidefin3R);

sidefin2R = new MCAModelRenderer(this, "sidefin2R", 52, 327);
sidefin2R.mirror = true;
sidefin2R.addBox(-23.0F, -12.0F, -61.0F, 3, 3, 27);
sidefin2R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
sidefin2R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.27202776F, 0.35048687F, 0.10715458F, 0.8897628F)).transpose());
sidefin2R.setTextureSize(128, 512);
parts.put(sidefin2R.boxName, sidefin2R);
bodypeice4.addChild(sidefin2R);

bodypeice2 = new MCAModelRenderer(this, "bodypeice2", 32, 139);
bodypeice2.mirror = false;
bodypeice2.addBox(-8.0F, -8.0F, 0.0F, 16, 16, 32);
bodypeice2.setInitialRotationPoint(0.0F, 0.0F, 32.0F);
bodypeice2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice2.setTextureSize(128, 512);
parts.put(bodypeice2.boxName, bodypeice2);
bodypeice3.addChild(bodypeice2);

bodypeice6 = new MCAModelRenderer(this, "bodypeice6", 32, 139);
bodypeice6.mirror = false;
bodypeice6.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice6.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice6.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice6.setTextureSize(128, 512);
parts.put(bodypeice6.boxName, bodypeice6);
bodypeice5.addChild(bodypeice6);

bodypeice1 = new MCAModelRenderer(this, "bodypeice1", 32, 139);
bodypeice1.mirror = false;
bodypeice1.addBox(-8.0F, -8.0F, 0.0F, 16, 16, 32);
bodypeice1.setInitialRotationPoint(0.0F, 0.0F, 32.0F);
bodypeice1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice1.setTextureSize(128, 512);
parts.put(bodypeice1.boxName, bodypeice1);
bodypeice2.addChild(bodypeice1);

bodypeice7 = new MCAModelRenderer(this, "bodypeice7", 32, 139);
bodypeice7.mirror = false;
bodypeice7.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice7.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice7.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice7.setTextureSize(128, 512);
parts.put(bodypeice7.boxName, bodypeice7);
bodypeice6.addChild(bodypeice7);

backfin1 = new MCAModelRenderer(this, "backfin1", 0, 323);
backfin1.mirror = false;
backfin1.addBox(-2.0F, -4.0F, -44.0F, 4, 4, 36);
backfin1.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
backfin1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.70710677F, 0.0F, 0.0F, 0.70710677F)).transpose());
backfin1.setTextureSize(128, 512);
parts.put(backfin1.boxName, backfin1);
bodypeice6.addChild(backfin1);

backfin3 = new MCAModelRenderer(this, "backfin3", -56, 365);
backfin3.mirror = false;
backfin3.addBox(-39.0F, 0.0F, -65.0F, 36, 0, 57);
backfin3.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
backfin3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.49999997F, -0.49999997F, 0.49999997F, 0.49999997F)).transpose());
backfin3.setTextureSize(128, 512);
parts.put(backfin3.boxName, backfin3);
bodypeice6.addChild(backfin3);

backfin4 = new MCAModelRenderer(this, "backfin3", 52, 327);
backfin4.mirror = false;
backfin4.addBox(-1.5F, 22.0F, -63.0F, 3, 3, 27);
backfin4.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
backfin4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.4617486F, 0.0F, 0.0F, 0.8870108F)).transpose());
backfin4.setTextureSize(128, 512);
parts.put(backfin4.boxName, backfin4);
bodypeice6.addChild(backfin4);

head = new MCAModelRenderer(this, "head", 0, 0);
head.mirror = false;
head.addBox(-9.0F, -12.0F, -12.0F, 18, 25, 32);
head.setInitialRotationPoint(0.0F, -6.0F, 40.0F);
head.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F)).transpose());
head.setTextureSize(128, 512);
parts.put(head.boxName, head);
bodypeice1.addChild(head);

bodypeice8 = new MCAModelRenderer(this, "bodypeice8", 32, 139);
bodypeice8.mirror = false;
bodypeice8.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice8.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice8.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice8.setTextureSize(128, 512);
parts.put(bodypeice8.boxName, bodypeice8);
bodypeice7.addChild(bodypeice8);

eyeR = new MCAModelRenderer(this, "eyeR", 0, 0);
eyeR.mirror = true;
eyeR.addBox(-15.0F, -1.0F, -5.0F, 5, 8, 12);
eyeR.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
eyeR.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.19956572F, 0.27459973F, -0.07960425F, 0.93724686F)).transpose());
eyeR.setTextureSize(128, 512);
parts.put(eyeR.boxName, eyeR);
head.addChild(eyeR);

eyeL = new MCAModelRenderer(this, "eyeL", 0, 0);
eyeL.mirror = false;
eyeL.addBox(10.0F, -1.0F, -5.0F, 5, 8, 12);
eyeL.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
eyeL.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.19956572F, -0.27459973F, 0.07960425F, 0.93724686F)).transpose());
eyeL.setTextureSize(128, 512);
parts.put(eyeL.boxName, eyeL);
head.addChild(eyeL);

jaw = new MCAModelRenderer(this, "jaw", 0, 57);
jaw.mirror = false;
jaw.addBox(-8.5F, -8.0F, -2.0F, 17, 12, 24);
jaw.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
jaw.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.1305262F, 0.0F, 0.0F, 0.9914449F)).transpose());
jaw.setTextureSize(128, 512);
parts.put(jaw.boxName, jaw);
head.addChild(jaw);

horn3L = new MCAModelRenderer(this, "horn3L", 92, 14);
horn3L.mirror = false;
horn3L.addBox(25.0F, 12.0F, -31.0F, 3, 3, 14);
horn3L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn3L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07629127F, 0.23272574F, -0.018315913F, 0.9693724F)).transpose());
horn3L.setTextureSize(128, 512);
parts.put(horn3L.boxName, horn3L);
head.addChild(horn3L);

horn2L = new MCAModelRenderer(this, "horn2L", 91, 46);
horn2L.mirror = false;
horn2L.addBox(17.0F, 10.0F, -26.0F, 4, 4, 14);
horn2L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn2L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07838442F, 0.043484922F, -0.0034223378F, 0.99596846F)).transpose());
horn2L.setTextureSize(128, 512);
parts.put(horn2L.boxName, horn2L);
head.addChild(horn2L);

horn1L = new MCAModelRenderer(this, "horn1L", 60, 69);
horn1L.mirror = false;
horn1L.addBox(4.0F, 10.0F, -26.0F, 5, 5, 25);
horn1L.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn1L.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.02489576F, -0.30891111F, 0.008089122F, 0.9507306F)).transpose());
horn1L.setTextureSize(128, 512);
parts.put(horn1L.boxName, horn1L);
head.addChild(horn1L);

horn3R = new MCAModelRenderer(this, "horn3R", 92, 14);
horn3R.mirror = true;
horn3R.addBox(-27.0F, 12.0F, -31.0F, 3, 3, 14);
horn3R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn3R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07629127F, -0.23272574F, 0.018315913F, 0.9693724F)).transpose());
horn3R.setTextureSize(128, 512);
parts.put(horn3R.boxName, horn3R);
head.addChild(horn3R);

horn2R = new MCAModelRenderer(this, "horn2R", 91, 46);
horn2R.mirror = true;
horn2R.addBox(-20.0F, 10.0F, -26.0F, 4, 4, 14);
horn2R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn2R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07838442F, -0.043484922F, 0.0034223378F, 0.99596846F)).transpose());
horn2R.setTextureSize(128, 512);
parts.put(horn2R.boxName, horn2R);
head.addChild(horn2R);

horn1R = new MCAModelRenderer(this, "horn1R", 60, 69);
horn1R.mirror = true;
horn1R.addBox(-9.0F, 10.0F, -26.0F, 5, 5, 25);
horn1R.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
horn1R.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.02489576F, 0.30891111F, -0.008089122F, 0.9507306F)).transpose());
horn1R.setTextureSize(128, 512);
parts.put(horn1R.boxName, horn1R);
head.addChild(horn1R);

headtop2 = new MCAModelRenderer(this, "headtop2", 0, 93);
headtop2.mirror = false;
headtop2.addBox(-7.5F, -6.0F, -16.0F, 15, 21, 25);
headtop2.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
headtop2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.0784591F, 0.0F, 0.0F, 0.9969173F)).transpose());
headtop2.setTextureSize(128, 512);
parts.put(headtop2.boxName, headtop2);
head.addChild(headtop2);

headtop1 = new MCAModelRenderer(this, "headtop1", 70, 0);
headtop1.mirror = false;
headtop1.addBox(-7.0F, 14.0F, 0.0F, 14, 3, 9);
headtop1.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
headtop1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.1650476F, 0.0F, 0.0F, 0.9862856F)).transpose());
headtop1.setTextureSize(128, 512);
parts.put(headtop1.boxName, headtop1);
head.addChild(headtop1);

bodypeice9 = new MCAModelRenderer(this, "bodypeice9", 32, 139);
bodypeice9.mirror = false;
bodypeice9.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice9.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice9.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice9.setTextureSize(128, 512);
parts.put(bodypeice9.boxName, bodypeice9);
bodypeice8.addChild(bodypeice9);

bodypeice10 = new MCAModelRenderer(this, "bodypeice10", 32, 139);
bodypeice10.mirror = false;
bodypeice10.addBox(-8.0F, -8.0F, -32.0F, 16, 16, 32);
bodypeice10.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice10.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice10.setTextureSize(128, 512);
parts.put(bodypeice10.boxName, bodypeice10);
bodypeice9.addChild(bodypeice10);

bodypeice11 = new MCAModelRenderer(this, "bodypeice11", 32, 187);
bodypeice11.mirror = false;
bodypeice11.addBox(-7.0F, -7.0F, -32.0F, 14, 14, 32);
bodypeice11.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice11.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice11.setTextureSize(128, 512);
parts.put(bodypeice11.boxName, bodypeice11);
bodypeice10.addChild(bodypeice11);

bodypeice12 = new MCAModelRenderer(this, "bodypeice12", 32, 233);
bodypeice12.mirror = false;
bodypeice12.addBox(-6.0F, -6.0F, -32.0F, 12, 12, 32);
bodypeice12.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice12.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice12.setTextureSize(128, 512);
parts.put(bodypeice12.boxName, bodypeice12);
bodypeice11.addChild(bodypeice12);

bodypeice13 = new MCAModelRenderer(this, "bodypeice13", 32, 278);
bodypeice13.mirror = false;
bodypeice13.addBox(-5.0F, -5.0F, -32.0F, 10, 10, 32);
bodypeice13.setInitialRotationPoint(0.0F, 0.0F, -32.0F);
bodypeice13.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bodypeice13.setTextureSize(128, 512);
parts.put(bodypeice13.boxName, bodypeice13);
bodypeice12.addChild(bodypeice13);

tail1 = new MCAModelRenderer(this, "tail1", 0, 250);
tail1.mirror = false;
tail1.addBox(-3.0F, 23.0F, -23.0F, 6, 30, 6);
tail1.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail1.setTextureSize(128, 512);
parts.put(tail1.boxName, tail1);
bodypeice13.addChild(tail1);

tail2 = new MCAModelRenderer(this, "tail2", 0, 224);
tail2.mirror = false;
tail2.addBox(-2.0F, 53.0F, -22.0F, 4, 20, 4);
tail2.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail2.setTextureSize(128, 512);
parts.put(tail2.boxName, tail2);
bodypeice13.addChild(tail2);

tail6 = new MCAModelRenderer(this, "tail6", 0, 224);
tail6.mirror = false;
tail6.addBox(-2.0F, -72.0F, -22.0F, 4, 20, 4);
tail6.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail6.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail6.setTextureSize(128, 512);
parts.put(tail6.boxName, tail6);
bodypeice13.addChild(tail6);

tail4 = new MCAModelRenderer(this, "tail4", 0, 349);
tail4.mirror = false;
tail4.addBox(0.0F, -69.0F, -94.0F, 0, 50, 75);
tail4.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail4.setTextureSize(128, 512);
parts.put(tail4.boxName, tail4);
bodypeice13.addChild(tail4);

tail3 = new MCAModelRenderer(this, "tail3", 0, 200);
tail3.mirror = false;
tail3.addBox(-1.0F, 73.0F, -21.0F, 2, 20, 2);
tail3.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail3.setTextureSize(128, 512);
parts.put(tail3.boxName, tail3);
bodypeice13.addChild(tail3);

tail5 = new MCAModelRenderer(this, "tail5", 0, 250);
tail5.mirror = false;
tail5.addBox(-3.0F, -52.0F, -23.0F, 6, 30, 6);
tail5.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
tail5.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
tail5.setTextureSize(128, 512);
parts.put(tail5.boxName, tail5);
bodypeice13.addChild(tail5);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntitySerpentBoss entity = (EntitySerpentBoss)par1Entity;

//Render every non-child part
bodypeice4.render(par7);

AnimationHandler.performAnimationInModel(parts, entity);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name) != null ? parts.get(name) : null;
}
}