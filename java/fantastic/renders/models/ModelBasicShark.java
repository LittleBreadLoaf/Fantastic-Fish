package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import fantastic.entities.sharks.EntityBasicShark;
import fantastic.entities.sharks.EntityHammerHead;

public class ModelBasicShark extends ModelBase
{
  //fields
    ModelRenderer _jaw;
    ModelRenderer hammerheadeyeR;
    ModelRenderer hammerheadeyeL;
    ModelRenderer hammerHead;
    ModelRenderer headtop;
    ModelRenderer bodysegment1;
    ModelRenderer bodysegment2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape5;
    ModelRenderer bodysegment3;
    ModelRenderer bodysegment4;
    ModelRenderer backbottomfinR;
    ModelRenderer backbottomfinL;
    ModelRenderer bodysegment5;
    ModelRenderer bodysegment6;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelBasicShark()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      _jaw = new ModelRenderer(this, 0, 25);
      _jaw.addBox(-5.5F, -13F, -3F, 11, 14, 4);
      _jaw.setRotationPoint(0F, 7F, -13F);
      _jaw.setTextureSize(128, 128);
      _jaw.mirror = true;
      setRotation(_jaw, 1.22173F, 0F, 0F);
      hammerheadeyeR = new ModelRenderer(this, 55, 117);
      hammerheadeyeR.mirror = true;
      hammerheadeyeR.addBox(-16F, -1.5F, -14.5F, 3, 3, 7);
      hammerheadeyeR.setRotationPoint(0F, 0F, 0F);
      hammerheadeyeR.setTextureSize(128, 128);
      hammerheadeyeR.mirror = true;
      setRotation(hammerheadeyeR, -0.3490659F, 0F, 0F);
      hammerheadeyeR.mirror = false;
      hammerheadeyeL = new ModelRenderer(this, 55, 117);
      hammerheadeyeL.addBox(12F, -1.5F, -14.5F, 3, 3, 7);
      hammerheadeyeL.setRotationPoint(0F, 0F, 0F);
      hammerheadeyeL.setTextureSize(128, 128);
      hammerheadeyeL.mirror = true;
      setRotation(hammerheadeyeL, -0.3490659F, 0F, 0F);
      hammerHead = new ModelRenderer(this, 0, 111);
      hammerHead.addBox(-13F, -1F, -14F, 25, 2, 5);
      hammerHead.setRotationPoint(0F, 0F, -0F);
      hammerHead.setTextureSize(128, 128);
      hammerHead.mirror = true;
      setRotation(hammerHead, -0.3490659F, 0F, 0F);
      headtop = new ModelRenderer(this, 0, 0);
      headtop.addBox(-6F, -5F, -13F, 12, 10, 15);
      headtop.setRotationPoint(0F, 1F, -13F);
      headtop.setTextureSize(128, 128);
      headtop.mirror = true;
      setRotation(headtop, 0.3490659F, 0F, 0F);
      bodysegment1 = new ModelRenderer(this, 86, 0);
      bodysegment1.addBox(-7F, -5F, 0F, 14, 15, 7);
      bodysegment1.setRotationPoint(0F, 1F, -13F);
      bodysegment1.setTextureSize(128, 128);
      bodysegment1.mirror = true;
      setRotation(bodysegment1, 0F, 0F, 0F);
      bodysegment2 = new ModelRenderer(this, 78, 22);
      bodysegment2.addBox(-8F, -5.466667F, 0F, 16, 16, 9);
      bodysegment2.setRotationPoint(0F, 0F, 6F);
      bodysegment2.setTextureSize(128, 128);
      bodysegment2.mirror = true;
      setRotation(bodysegment2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 43);
      Shape1.addBox(-0.5F, -1F, 6F, 1, 10, 15);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0.916556F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 68);
      Shape2.addBox(7F, 6F, -5F, 14, 1, 12);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0.122173F, -0.5235988F, 0.2617994F);
      Shape2.mirror = true;
      Shape5 = new ModelRenderer(this, 22, 82);
      Shape5.addBox(-21F, 6F, -5F, 14, 1, 12);
      Shape5.setRotationPoint(0F, 0F, 0F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0.122173F, 0.5235988F, -0.2617994F);
      Shape5.mirror = false;
      bodysegment3 = new ModelRenderer(this, 82, 47);
      bodysegment3.addBox(-6.5F, -4F, 0F, 13, 15, 10);
      bodysegment3.setRotationPoint(0F, -1F, 9F);
      bodysegment3.setTextureSize(128, 128);
      bodysegment3.mirror = true;
      setRotation(bodysegment3, 0F, 0F, 0F);
      bodysegment4 = new ModelRenderer(this, 90, 72);
      bodysegment4.addBox(-5.5F, -3F, 0F, 11, 11, 8);
      bodysegment4.setRotationPoint(0F, 0F, 10F);
      bodysegment4.setTextureSize(128, 128);
      bodysegment4.mirror = true;
      setRotation(bodysegment4, 0F, 0F, 0F);
      backbottomfinR = new ModelRenderer(this, 0, 88);
      backbottomfinR.mirror = true;
      backbottomfinR.addBox(-1F, 8F, 0F, 1, 5, 4);
      backbottomfinR.setRotationPoint(0F, 0F, -7F);
      backbottomfinR.setTextureSize(128, 128);
      backbottomfinR.mirror = true;
      setRotation(backbottomfinR, 0.5061455F, 0F, 0.3141593F);
      backbottomfinR.mirror = false;
      backbottomfinL = new ModelRenderer(this, 0, 88);
      backbottomfinL.addBox(1F, 8F, 0F, 1, 5, 4);
      backbottomfinL.setRotationPoint(0F, 0F, -7F);
      backbottomfinL.setTextureSize(128, 128);
      backbottomfinL.mirror = true;
      setRotation(backbottomfinL, 0.5061455F, 0F, -0.3141593F);
      bodysegment5 = new ModelRenderer(this, 98, 91);
      bodysegment5.addBox(-3.5F, -2F, 0F, 7, 8, 8);
      bodysegment5.setRotationPoint(0F, 0F, 7F);
      bodysegment5.setTextureSize(128, 128);
      bodysegment5.mirror = true;
      setRotation(bodysegment5, 0F, 0F, 0F);
      bodysegment6 = new ModelRenderer(this, 110, 107);
      bodysegment6.addBox(-1.5F, -1F, 0F, 3, 5, 6);
      bodysegment6.setRotationPoint(0F, 0F, 7F);
      bodysegment6.setTextureSize(128, 128);
      bodysegment6.mirror = true;
      setRotation(bodysegment6, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 81);
      Shape3.addBox(-0.5F, -1F, -4F, 1, 13, 17);
      Shape3.setRotationPoint(0F, 0F, 5F);
      Shape3.setTextureSize(128, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0.9424778F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 71);
      Shape4.addBox(-0.5F, -8F, 1F, 1, 4, 3);
      Shape4.setRotationPoint(0F, 0F, -7F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, -0.8726646F, 0F, 0F);
      
      headtop.addChild(hammerHead);
      headtop.addChild(hammerheadeyeL);
      headtop.addChild(hammerheadeyeR);
      bodysegment1.addChild(bodysegment2);
      bodysegment2.addChild(bodysegment3);
      bodysegment2.addChild(Shape1);
      bodysegment2.addChild(Shape2);
      bodysegment2.addChild(Shape5);
      bodysegment3.addChild(bodysegment4);
      bodysegment4.addChild(bodysegment5);
      bodysegment5.addChild(bodysegment6);
      bodysegment5.addChild(backbottomfinL);
      bodysegment5.addChild(backbottomfinR);
      bodysegment6.addChild(Shape3);
      bodysegment6.addChild(Shape4);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    _jaw.render(f5);
    headtop.render(f5);
    bodysegment1.render(f5);
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
    EntityBasicShark Shark = (EntityBasicShark)entity;
    EntityPlayer target = Shark.worldObj.getClosestPlayerToEntity(Shark, 5);
    double distance = 0;
    if(target != null)
    	distance = Shark.getDistanceToEntity(target);
    
    
    if(distance <= 5 && !(Shark instanceof EntityHammerHead))
    {
    	this._jaw.rotateAngleX = 0.6F *(float) Math.sin(distance * Math.PI/5) + 1.22173F;
    	this.headtop.rotateAngleX = - 0.6F *(float) Math.sin(distance * Math.PI/5) + 0.3490659F;
    }
    else
    {
    	this._jaw.rotateAngleX = 1.22173F;
    	this.headtop.rotateAngleX = 0.3490659F;
    }
    	
    this.headtop.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F + (float)(Math.PI/6)) );
    this._jaw.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F + (float)(Math.PI/6)) );
    
    this.bodysegment1.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F) );
    this.bodysegment2.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/6)) );
    this.bodysegment3.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/3)) );
    this.bodysegment4.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/2)) );
    this.bodysegment5.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F - (float)(2*Math.PI/3)) );
    this.bodysegment6.rotateAngleY = 0.15F *(MathHelper.cos(f2  * 0.327F - (float)(5*Math.PI/6)) );
    

	this.headtop.rotateAngleZ = 0F;
    this._jaw.rotateAngleZ = 0F;
    
    this.bodysegment1.rotateAngleZ = 0F;
    this.bodysegment2.rotateAngleZ = 0F;
    this.bodysegment3.rotateAngleZ = 0F;
    this.bodysegment4.rotateAngleZ = 0F;
    this.bodysegment5.rotateAngleZ = 0F;
    this.bodysegment6.rotateAngleZ = 0F;

    if(!entity.isInWater())
    {
    	this.headtop.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F + (float)(Math.PI/6)) );
        this._jaw.rotateAngleZ = -0.1F *(MathHelper.cos(f2  * 0.327F + (float)(Math.PI/6)) );
        
        this.bodysegment1.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F) );
        this.bodysegment2.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/6)) );
        this.bodysegment3.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/3)) );
        this.bodysegment4.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F - (float)(Math.PI/2)) );
        this.bodysegment5.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F - (float)(2*Math.PI/3)) );
        this.bodysegment6.rotateAngleZ = 0.1F *(MathHelper.cos(f2  * 0.327F - (float)(5*Math.PI/6)) );
    }
    
  }
}
