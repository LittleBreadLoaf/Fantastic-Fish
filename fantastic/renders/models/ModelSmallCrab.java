package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmallCrab extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer eyeR;
    ModelRenderer eyeL;
    ModelRenderer armL;
    ModelRenderer armR;
    ModelRenderer clawL;
    ModelRenderer clawR;
    ModelRenderer leg1L;
    ModelRenderer leg2L;
    ModelRenderer leg3L;
    ModelRenderer leg1R;
    ModelRenderer leg2R;
    ModelRenderer leg3R;
    ModelRenderer Bleg1R;
    ModelRenderer Bleg2R;
    ModelRenderer Bleg1L;
    ModelRenderer Bleg2L;
   
  public ModelSmallCrab()
  {
    textureWidth = 16;
    textureHeight = 16;
     
      body = new ModelRenderer(this, 0, 0);
      body.addBox(-3F, -3F, -1F, 6, 6, 2);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(16, 16);
      body.mirror = true;
      setRotation(body, -1.518436F, 0F, 0F);
      eyeR = new ModelRenderer(this, 0, 8);
      eyeR.addBox(-2F, -2F, -3F, 1, 1, 1);
      eyeR.setRotationPoint(0F, 0F, 0F);
      eyeR.setTextureSize(16, 16);
      eyeR.mirror = true;
      setRotation(eyeR, 0.1745329F, 0F, 0F);
      eyeL = new ModelRenderer(this, 0, 8);
      eyeL.addBox(1F, -2F, -3F, 1, 1, 1);
      eyeL.setRotationPoint(0F, 0F, 0F);
      eyeL.setTextureSize(16, 16);
      eyeL.mirror = true;
      setRotation(eyeL, 0.1745329F, 0F, 0F);
      armL = new ModelRenderer(this, 4, 8);
      armL.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      armL.setRotationPoint(2.5F, 0.5F, -2.5F);
      armL.setTextureSize(16, 16);
      armL.mirror = true;
      setRotation(armL, -1.500983F, -0.7853982F, 0F);
      armR = new ModelRenderer(this, 4, 8);
      armR.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      armR.setRotationPoint(-2.5F, 0.5F, -2.5F);
      armR.setTextureSize(16, 16);
      armR.mirror = true;
      setRotation(armR, -1.500983F, 0.7853982F, 0F);
      clawL = new ModelRenderer(this, 0, 11);
      clawL.addBox(1F, 0F, -0.5F, 3, 3, 1);
      clawL.setRotationPoint(2.5F, 0.5F, -2.5F);
      clawL.setTextureSize(16, 16);
      clawL.mirror = true;
      setRotation(clawL, -1.53589F, 0.5235988F, 0F);
      clawR = new ModelRenderer(this, 0, 11);
      clawR.addBox(-4F, 0F, -0.5F, 3, 3, 1);
      clawR.setRotationPoint(-2.5F, 0.5F, -2.5F);
      clawR.setTextureSize(16, 16);
      clawR.mirror = true;
      setRotation(clawR, -1.53589F, -0.5235988F, 0F);
      leg1L = new ModelRenderer(this, 8, 8);
      leg1L.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg1L.setRotationPoint(3F, 0F, -1.5F);
      leg1L.setTextureSize(16, 16);
      leg1L.mirror = true;
      setRotation(leg1L, 0.6108652F, 1.832596F, 0F);
      leg2L = new ModelRenderer(this, 8, 8);
      leg2L.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg2L.setRotationPoint(3F, 0F, 0F);
      leg2L.setTextureSize(16, 16);
      leg2L.mirror = true;
      setRotation(leg2L, 0.6108652F, 1.570796F, 0F);
      leg3L = new ModelRenderer(this, 8, 8);
      leg3L.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg3L.setRotationPoint(3F, 0F, 1.5F);
      leg3L.setTextureSize(16, 16);
      leg3L.mirror = true;
      setRotation(leg3L, 0.6108652F, 1.308997F, 0F);
      leg1R = new ModelRenderer(this, 8, 8);
      leg1R.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg1R.setRotationPoint(-3F, 0F, -1.5F);
      leg1R.setTextureSize(16, 16);
      leg1R.mirror = true;
      setRotation(leg1R, 0.6108652F, -1.832596F, 0F);
      leg2R = new ModelRenderer(this, 8, 8);
      leg2R.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg2R.setRotationPoint(-3F, 0F, 0F);
      leg2R.setTextureSize(16, 16);
      leg2R.mirror = true;
      setRotation(leg2R, 0.6108652F, -1.570796F, 0F);
      leg3R = new ModelRenderer(this, 8, 8);
      leg3R.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      leg3R.setRotationPoint(-3F, 0F, 1.5F);
      leg3R.setTextureSize(16, 16);
      leg3R.mirror = true;
      setRotation(leg3R, 0.6108652F, -1.308997F, 0F);
      Bleg1R = new ModelRenderer(this, 4, 8);
      Bleg1R.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      Bleg1R.setRotationPoint(-2F, 0F, 2.5F);
      Bleg1R.setTextureSize(16, 16);
      Bleg1R.mirror = true;
      setRotation(Bleg1R, -0.7853982F, 2.443461F, 0F);
      Bleg2R = new ModelRenderer(this, 4, 8);
      Bleg2R.addBox(0.5F, 1F, 0F, 1, 2, 1);
      Bleg2R.setRotationPoint(-2F, 0F, 2.5F);
      Bleg2R.setTextureSize(16, 16);
      Bleg2R.mirror = true;
      setRotation(Bleg2R, -0.7853982F, -2.792527F, 0F);
      Bleg1L = new ModelRenderer(this, 4, 8);
      Bleg1L.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      Bleg1L.setRotationPoint(2F, 0F, 2.5F);
      Bleg1L.setTextureSize(16, 16);
      Bleg1L.mirror = true;
      setRotation(Bleg1L, -0.7853982F, -2.443461F, 0F);
      Bleg2L = new ModelRenderer(this, 4, 8);
      Bleg2L.addBox(-1.5F, 1F, 0F, 1, 2, 1);
      Bleg2L.setRotationPoint(2F, 0F, 2.5F);
      Bleg2L.setTextureSize(16, 16);
      Bleg2L.mirror = true;
      setRotation(Bleg2L, -0.7853982F, 2.792527F, 0F);
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    eyeR.render(f5);
    eyeL.render(f5);
    armL.render(f5);
    armR.render(f5);
    clawL.render(f5);
    clawR.render(f5);
    leg1L.render(f5);
    leg2L.render(f5);
    leg3L.render(f5);
    leg1R.render(f5);
    leg2R.render(f5);
    leg3R.render(f5);
    Bleg1R.render(f5);
    Bleg2R.render(f5);
    Bleg1L.render(f5);
    Bleg2L.render(f5);
  }
   
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
   
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if(f1 < 0.000001)
    {
    	this.Bleg1L.rotateAngleZ = -0.04F*(MathHelper.cos(f2 * 0.3662F) );
    	this.Bleg1R.rotateAngleZ = 0.04F*(MathHelper.cos(f2 * 0.3662F) );
    	this.Bleg2L.rotateAngleZ = -0.06F*(MathHelper.cos(f2 * 0.3662F) );
    	this.Bleg2R.rotateAngleZ = 0.06F*(MathHelper.cos(f2 * 0.3662F) );
    	

        this.clawL.rotateAngleX = 0.012F*(MathHelper.cos(f2 * 0.1862F) ) - 1.53589F;
        this.clawL.rotateAngleY = 0.015F*(MathHelper.cos(f2 * 0.1762F) ) + 0.5235988F;
        this.clawR.rotateAngleX = 0.013F*(MathHelper.cos(f2 * 0.1562F) ) - 1.53589F;
        this.clawR.rotateAngleY = 0.011F*(MathHelper.cos(f2 * 0.1262F) ) -  0.5235988F;
        
        

        
    }
    else
    {
    this.leg1R.rotateAngleX = MathHelper.sin(f * 1.6662F - (float)(Math.PI/4)) * 0.5F * f1 + 0.6108652F;
    this.leg2R.rotateAngleX = MathHelper.sin(f * 1.6662F) * 0.5F * f1 + 0.6108652F;
    this.leg3R.rotateAngleX = MathHelper.sin(f * 1.6662F + (float)(Math.PI/4)) * 0.5F * f1 + 0.6108652F;
    
    this.leg1L.rotateAngleX = -MathHelper.sin(f * 1.6662F - (float)(Math.PI/4)) * 0.5F * f1 + 0.6108652F;
    this.leg2L.rotateAngleX = -MathHelper.sin(f * 1.6662F) * 0.5F * f1 + 0.6108652F;
    this.leg3L.rotateAngleX = -MathHelper.sin(f * 1.6662F + (float)(Math.PI/4)) * 0.5F * f1 + 0.6108652F;
  }
  }
 
}