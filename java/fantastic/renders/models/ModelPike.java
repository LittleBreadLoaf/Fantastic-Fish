package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPike extends ModelBase
{
  //fields
    ModelRenderer snout_top;
    ModelRenderer head_top;
    ModelRenderer head;
    ModelRenderer _jaw;
    ModelRenderer bodysegment1;
    ModelRenderer frontfinL;
    ModelRenderer frontfinR;
    ModelRenderer bodysegment2;
    ModelRenderer bodysegment3;
    ModelRenderer backfinL;
    ModelRenderer backfinR;
    ModelRenderer bodysegment4;
    ModelRenderer topfin;
    ModelRenderer bottemfin;
    ModelRenderer bodysegment5;
    ModelRenderer bodysegment6;
    ModelRenderer tail;
  
  public ModelPike()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      snout_top = new ModelRenderer(this, 0, 44);
      snout_top.addBox(-2F, -1.5F, -6.8F, 4, 3, 8);
      snout_top.setRotationPoint(0F, 1F, -18F);
      snout_top.setTextureSize(128, 128);
      snout_top.mirror = true;
      setRotation(snout_top, -0.0872665F, 0F, 0F);
      head_top = new ModelRenderer(this, 0, 31);
      head_top.addBox(-1.5F, -3F, -3F, 3, 3, 10);
      head_top.setRotationPoint(0F, 1F, -18F);
      head_top.setTextureSize(128, 128);
      head_top.mirror = true;
      setRotation(head_top, 0.3490659F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, 0F, 0F, 6, 8, 7);
      head.setRotationPoint(0F, 1F, -18F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0.7853982F, 0F, 0F);
      _jaw = new ModelRenderer(this, 0, 15);
      _jaw.addBox(-2.5F, -12F, -1F, 5, 13, 3);
      _jaw.setRotationPoint(0F, 5F, -14F);
      _jaw.setTextureSize(128, 128);
      _jaw.mirror = true;
      setRotation(_jaw, 1.343904F, 0F, 0F);
      bodysegment1 = new ModelRenderer(this, 26, 0);
      bodysegment1.addBox(-4F, -5F, 0F, 8, 10, 7);
      bodysegment1.setRotationPoint(0F, 1F, -13F);
      bodysegment1.setTextureSize(128, 128);
      bodysegment1.mirror = true;
      setRotation(bodysegment1, 0F, 0F, 0F);
      frontfinL = new ModelRenderer(this, 102, 26);
      frontfinL.addBox(2F, 5F, -3F, 0, 14, 13);
      frontfinL.setRotationPoint(0F, 1F, -9F);
      frontfinL.setTextureSize(128, 128);
      frontfinL.mirror = true;
      setRotation(frontfinL, 0.3316126F, 0.1396263F, -0.2617994F);
      //frontfinR.mirror = true;
      frontfinR = new ModelRenderer(this, 102, 26);
      frontfinR.addBox(-2F, 5F, -3F, 0, 14, 13);
      frontfinR.setRotationPoint(0F, 1F, -9F);
      frontfinR.setTextureSize(128, 128);
      frontfinR.mirror = true;
      setRotation(frontfinR, 0.3316126F, -0.1396263F, 0.2617994F);
      frontfinR.mirror = false;
      bodysegment2 = new ModelRenderer(this, 56, 0);
      bodysegment2.addBox(-4.466667F, -5.466667F, 0F, 9, 11, 18);
      bodysegment2.setRotationPoint(0F, 1F, -7F);
      bodysegment2.setTextureSize(128, 128);
      bodysegment2.mirror = true;
      setRotation(bodysegment2, 0F, 0F, 0F);
      bodysegment3 = new ModelRenderer(this, 27, 20);
      bodysegment3.addBox(-4F, -4F, 0F, 8, 9, 12);
      bodysegment3.setRotationPoint(0F, 0F, 11F);
      bodysegment3.setTextureSize(128, 128);
      bodysegment3.mirror = true;
      setRotation(bodysegment3, 0F, 0F, 0F);
      backfinL = new ModelRenderer(this, 69, 57);
      backfinL.addBox(2F, 3F, 1F, 0, 14, 10);
      backfinL.setRotationPoint(0F, 0F, 11F);
      backfinL.setTextureSize(128, 128);
      backfinL.mirror = true;
      setRotation(backfinL, 0.2617994F, 0F, -0.2617994F);
      //backfinR.mirror = true;
      backfinR = new ModelRenderer(this, 69, 57);
      backfinR.addBox(-2F, 3F, 1F, 0, 14, 10);
      backfinR.setRotationPoint(0F, 0F, 11F);
      backfinR.setTextureSize(128, 128);
      backfinR.mirror = true;
      setRotation(backfinR, 0.2617994F, 0F, 0.2617994F);
      backfinR.mirror = false;
      bodysegment4 = new ModelRenderer(this, 67, 30);
      bodysegment4.addBox(-3.5F, -3F, 0F, 7, 7, 8);
      bodysegment4.setRotationPoint(0F, 0F, 22F);
      bodysegment4.setTextureSize(128, 128);
      bodysegment4.mirror = true;
      setRotation(bodysegment4, 0F, 0F, 0F);
      topfin = new ModelRenderer(this, 0, 51);
      topfin.addBox(0F, -17F, 0F, 0, 15, 14);
      topfin.setRotationPoint(0F, 0F, 22F);
      topfin.setTextureSize(128, 128);
      topfin.mirror = true;
      setRotation(topfin, -0.2268928F, 0F, 0F);
      bottemfin = new ModelRenderer(this, 40, 55);
      bottemfin.addBox(0F, 3F, -1F, 0, 12, 13);
      bottemfin.setRotationPoint(0F, 0F, 22F);
      bottemfin.setTextureSize(128, 128);
      bottemfin.mirror = true;
      setRotation(bottemfin, 0.2443461F, 0F, 0F);
      bodysegment5 = new ModelRenderer(this, 41, 42);
      bodysegment5.addBox(-2.5F, -2F, 0F, 5, 5, 8);
      bodysegment5.setRotationPoint(0F, 0F, 29F);
      bodysegment5.setTextureSize(128, 128);
      bodysegment5.mirror = true;
      setRotation(bodysegment5, 0F, 0F, 0F);
      bodysegment6 = new ModelRenderer(this, 69, 46);
      bodysegment6.addBox(-1F, -1F, 0F, 2, 3, 4);
      bodysegment6.setRotationPoint(0F, 0F, 36F);
      bodysegment6.setTextureSize(128, 128);
      bodysegment6.mirror = true;
      setRotation(bodysegment6, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 66);
      tail.addBox(0F, -2F, -2F, 0, 26, 26);
      tail.setRotationPoint(0F, 0F, 39F);
      tail.setTextureSize(128, 128);
      tail.mirror = true;
      setRotation(tail, 0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    snout_top.render(f5);
    head_top.render(f5);
    head.render(f5);
    _jaw.render(f5);
    bodysegment1.render(f5);
    frontfinL.render(f5);
    frontfinR.render(f5);
    bodysegment2.render(f5);
    bodysegment3.render(f5);
    backfinL.render(f5);
    backfinR.render(f5);
    bodysegment4.render(f5);
    topfin.render(f5);
    bottemfin.render(f5);
    bodysegment5.render(f5);
    bodysegment6.render(f5);
    tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
