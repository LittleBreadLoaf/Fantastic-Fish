 
 
package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import fantastic.FantasticDebug;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityCreepedo;
import fantastic.entities.EntityFantasticFish;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTuna;
 
public class ModelBasicFish extends ModelBase
{
  //fields
    ModelRenderer headtop;
    ModelRenderer Lwisker;
    ModelRenderer Rwisker;
    ModelRenderer unihorn;
    ModelRenderer headfin;
    ModelRenderer hornL;
    ModelRenderer hornR;
    ModelRenderer suckermouth;
    ModelRenderer mouth;
    ModelRenderer bodysection1;
    ModelRenderer frontfinL;
    ModelRenderer frontfinR;
    ModelRenderer bodysection2;
    ModelRenderer sidefinL;
    ModelRenderer sidefinR;
    ModelRenderer bodysection3;
    ModelRenderer bodysection4;
    ModelRenderer bodysection5;
    ModelRenderer backfinL;
    ModelRenderer backfinR;
    ModelRenderer bodysection6;
    ModelRenderer tail;
    ModelRenderer altsidefinL;
    ModelRenderer altsidefinR;
    ModelRenderer topfin;
    ModelRenderer bottemfin;
   
  public ModelBasicFish()
  {
    textureWidth = 128;
    textureHeight = 64;
     
      headtop = new ModelRenderer(this, 0, 0);
      headtop.addBox(-3F, 0F, 0F, 6, 8, 7);
      headtop.setRotationPoint(0F, 1F, -14F);
      headtop.setTextureSize(128, 64);
      headtop.mirror = true;
      setRotation(headtop, 0.7853982F, 0F, 0F);
      Lwisker = new ModelRenderer(this, 0, 15);
      Lwisker.addBox(2F, -1F, -1F, 0, 7, 9);
      Lwisker.setRotationPoint(0F, 1F, -14F);
      Lwisker.setTextureSize(128, 64);
      Lwisker.mirror = true;
      setRotation(Lwisker, 0F, 0.2617994F, -0.2617994F);
      Rwisker = new ModelRenderer(this, 0, 15);
      Rwisker.addBox(-2F, -1F, -1F, 0, 7, 9);
      Rwisker.setRotationPoint(0F, 1F, -14F);
      Rwisker.setTextureSize(128, 64);
      Rwisker.mirror = true;
      setRotation(Rwisker, 0F, -0.2617994F, 0.2617994F);
      unihorn = new ModelRenderer(this, 19, 0);
      unihorn.addBox(-3F, -3F, 2F, 8, 1, 1);
      unihorn.setRotationPoint(0F, 1F, -14F);
      unihorn.setTextureSize(128, 64);
      unihorn.mirror = true;
      setRotation(unihorn, 0.7853982F, 1.570796F, -0.2617994F);
      headfin = new ModelRenderer(this, 40, 42);
      headfin.addBox(0F, -5F, 1F, 0, 9, 13);
      headfin.setRotationPoint(0F, 1F, -14F);
      headfin.setTextureSize(128, 64);
      headfin.mirror = true;
      setRotation(headfin, 0.8552113F, 0F, 0F);
      hornL = new ModelRenderer(this, 70, 45);
      hornL.addBox(0F, 1F, 5F, 1, 1, 10);
      hornL.setRotationPoint(0F, 1F, -14F);
      hornL.setTextureSize(128, 64);
      hornL.mirror = true;
      setRotation(hornL, 0.9250245F, 0.2617994F, 0.2617994F);
      hornR = new ModelRenderer(this, 70, 45);
      hornR.addBox(-1F, 1F, 5F, 1, 1, 10);
      hornR.setRotationPoint(0F, 1F, -14F);
      hornR.setTextureSize(128, 64);
      hornR.mirror = true;
      setRotation(hornR, 0.9250245F, -0.2617994F, -0.2617994F);
      suckermouth = new ModelRenderer(this, 106, 34);
      suckermouth.addBox(-2.5F, 0F, 0F, 5, 5, 5);
      suckermouth.setRotationPoint(0F, 1F, -14F);
      suckermouth.setTextureSize(128, 64);
      suckermouth.mirror = true;
      setRotation(suckermouth, 0F, 0F, 0F);
      mouth = new ModelRenderer(this, 0, 15);
      mouth.addBox(-2.5F, -4F, -2F, 5, 6, 3);
      mouth.setRotationPoint(0F, 4F, -9F);
      mouth.setTextureSize(128, 64);
      mouth.mirror = true;
      setRotation(mouth, 0.8726646F, 0F, 0F);
      bodysection1 = new ModelRenderer(this, 26, 4);
      bodysection1.addBox(-4F, -5F, 0F, 8, 10, 5);
      bodysection1.setRotationPoint(0F, 1F, -9F);
      bodysection1.setTextureSize(128, 64);
      bodysection1.mirror = true;
      setRotation(bodysection1, 0F, 0F, 0F);
      frontfinL = new ModelRenderer(this, 82, 36);
      frontfinL.addBox(2F, 5F, -1F, 0, 10, 9);
      frontfinL.setRotationPoint(0F, 0F, -4F);
      frontfinL.setTextureSize(128, 64);
      frontfinL.mirror = true;
      setRotation(frontfinL, 0.3316126F, 0.1396263F, -0.2617994F);
      frontfinR = new ModelRenderer(this, 82, 36);
      frontfinR.addBox(-2F, 5F, -1F, 0, 10, 9);
      frontfinR.setRotationPoint(0F, 0F, -4F);
      frontfinR.setTextureSize(128, 64);
      frontfinR.mirror = true;
      setRotation(frontfinR, 0.3316126F, -0.1396263F, 0.2617994F);
      bodysection2 = new ModelRenderer(this, 52, 0);
      bodysection2.addBox(-4.466667F, -5.466667F, 0F, 9, 11, 8);
      bodysection2.setRotationPoint(0F, 0F, 4F);
      bodysection2.setTextureSize(128, 64);
      bodysection2.mirror = true;
      setRotation(bodysection2, 0F, 0F, 0F);
      sidefinL = new ModelRenderer(this, 0, 16);
      sidefinL.addBox(0F, -6F, 0F, 0, 12, 15);
      sidefinL.setRotationPoint(4F, 0F, 1F);
      sidefinL.setTextureSize(128, 64);
      sidefinL.mirror = true;
      setRotation(sidefinL, 0F, 0.7853982F, 0F);
      sidefinR = new ModelRenderer(this, 0, 16);
      sidefinR.addBox(0F, -6F, 0F, 0, 12, 15);
      sidefinR.setRotationPoint(-4F, 0F, 1F);
      sidefinR.setTextureSize(128, 64);
      sidefinR.mirror = true;
      setRotation(sidefinR, 0F, -0.7853982F, 0F);
      bodysection3 = new ModelRenderer(this, 86, 2);
      bodysection3.addBox(-4F, -4F, 0F, 8, 9, 8);
      bodysection3.setRotationPoint(0F, -1F, 7F);
      bodysection3.setTextureSize(128, 64);
      bodysection3.mirror = true;
      setRotation(bodysection3, 0F, 0F, 0F);
      bodysection4 = new ModelRenderer(this, 29, 19);
      bodysection4.addBox(-3.5F, -3F, 0F, 7, 7, 5);
      bodysection4.setRotationPoint(0F, 0F, 7F);
      bodysection4.setTextureSize(128, 64);
      bodysection4.mirror = true;
      setRotation(bodysection4, 0F, 0F, 0F);
      bodysection5 = new ModelRenderer(this, 53, 21);
      bodysection5.addBox(-2.5F, -2F, 0F, 5, 5, 5);
      bodysection5.setRotationPoint(0F, 0F, 4F);
      bodysection5.setTextureSize(128, 64);
      bodysection5.mirror = true;
      setRotation(bodysection5, 0F, 0F, 0F);
      backfinL = new ModelRenderer(this, 80, 21);
      backfinL.addBox(1F, 3F, 2F, 0, 11, 13);
      backfinL.setRotationPoint(0F, 0F, 4F);
      backfinL.setTextureSize(128, 64);
      backfinL.mirror = true;
      setRotation(backfinL, 0F, 0F, -0.2617994F);
      backfinR = new ModelRenderer(this, 80, 21);
      backfinR.addBox(-1F, 3F, 2F, 0, 11, 13);
      backfinR.setRotationPoint(0F, 0F, 4F);
      backfinR.setTextureSize(128, 64);
      backfinR.mirror = true;
      setRotation(backfinR, 0F, 0F, 0.2617994F);
      bodysection6 = new ModelRenderer(this, 73, 24);
      bodysection6.addBox(-1F, -1F, 0F, 2, 3, 4);
      bodysection6.setRotationPoint(0F, 0F, 4F);
      bodysection6.setTextureSize(128, 64);
      bodysection6.mirror = true;
      setRotation(bodysection6, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 23);
      tail.addBox(0F, -2F, -2F, 0, 20, 20);
      tail.setRotationPoint(0F, 0F, 4F);
      tail.setTextureSize(128, 64);
      tail.mirror = true;
      setRotation(tail, 0.7853982F, 0F, 0F);
      altsidefinL = new ModelRenderer(this, 72, 19);
      altsidefinL.addBox(-2F, 0F, 0F, 19, 0, 15);
      altsidefinL.setRotationPoint(4F, 1F, -6F);
      altsidefinL.setTextureSize(128, 64);
      altsidefinL.mirror = true;
      setRotation(altsidefinL, 0F, 0F, 0.2617994F);
      altsidefinR = new ModelRenderer(this, 72, 19);
      altsidefinR.addBox(-2F, 0F, 0F, 19, 0, 15);
      altsidefinR.setRotationPoint(-4F, 1F, -6F);
      altsidefinR.setTextureSize(128, 64);
      altsidefinR.mirror = true;
      setRotation(altsidefinR, 0F, 0F, 2.879793F);
      topfin = new ModelRenderer(this, 40, 11);
      topfin.addBox(0F, -10F, -6F, 0, 12, 20);
      topfin.setRotationPoint(0F, -5F, 6F);
      topfin.setTextureSize(128, 64);
      topfin.mirror = true;
      setRotation(topfin, -0.2268928F, 0F, 0F);
      bottemfin = new ModelRenderer(this, 40, 23);
      bottemfin.addBox(0F, -1F, -6F, 0, 12, 20);
      bottemfin.setRotationPoint(0F, 4F, 5F);
      bottemfin.setTextureSize(128, 64);
      bottemfin.mirror = true;
      setRotation(bottemfin, 0.2443461F, 0F, 0F);
      
      
      bodysection1.addChild(bodysection2);
      bodysection2.addChild(bodysection3);
      bodysection2.addChild(sidefinL);
      bodysection2.addChild(sidefinR);
      bodysection2.addChild(frontfinL);
      bodysection2.addChild(frontfinR);
      bodysection2.addChild(bottemfin);
      bodysection3.addChild(altsidefinL);
      bodysection3.addChild(altsidefinR);
      bodysection3.addChild(bodysection4);
      bodysection4.addChild(bodysection5);
      bodysection4.addChild(backfinL);
      bodysection4.addChild(backfinR);
      bodysection5.addChild(bodysection6);
      bodysection6.addChild(tail);
      bodysection2.addChild(topfin);
      
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    headtop.render(f5);
    Lwisker.render(f5);
    Rwisker.render(f5);
    unihorn.render(f5);
    headfin.render(f5);
    hornL.render(f5);
    hornR.render(f5);
    suckermouth.render(f5);
    mouth.render(f5);
    bodysection1.render(f5);
    //frontfinL.render(f5);
    //frontfinR.render(f5);
    //bodysection2.render(f5);
    //sidefinL.render(f5);
    //sidefinR.render(f5);
    //bodysection3.render(f5);
    //bodysection4.render(f5);
    //bodysection5.render(f5);
    //backfinL.render(f5);
    //backfinR.render(f5);
    //bodysection6.render(f5);
    //tail.render(f5);
    //altsidefinL.render(f5);
    //altsidefinR.render(f5);
    //topfin.render(f5);
    //bottemfin.render(f5);
  }
   
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
   
  //int extraSpeed = 1;
  //float sizeChange = 1;
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    EntityFantasticFish _fish = (EntityFantasticFish)entity;
    
    this.mouth.rotateAngleX = 0.17F*(MathHelper.cos(f2 * 0.06662F) ) + 0.8726646F;
    
//  if(entity instanceof EntityBasicFish)
//  {
//  	EntityBasicFish Fish = (EntityBasicFish)entity;
//  	extraSpeed = Fish.extraSpeed;
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}
//}
//  if(entity instanceof EntitySalmon)
//  {
//  	EntitySalmon Fish = (EntitySalmon)entity;
//  	extraSpeed = Fish.extraSpeed;
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}
//  }
//  if(entity instanceof EntityTuna)
//  {
//  	EntityTuna Fish = (EntityTuna)entity;
//  	extraSpeed = Fish.extraSpeed;
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}
//  }
//  if(entity instanceof EntityCaveFish)
//  {
//  	EntityCaveFish Fish = (EntityCaveFish)entity;
//  	extraSpeed = Fish.extraSpeed;
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}
//  }
//  if(entity instanceof EntityFeeder)
//  {
//  	EntityFeeder Fish = (EntityFeeder)entity;
//  	extraSpeed = Fish.extraSpeed; 
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}  
//}
//  if(entity instanceof EntityMossy)
//  {
//  	EntityMossy Fish = (EntityMossy)entity;
//  	extraSpeed = Fish.extraSpeed;
//  	if(Fish.isInWater())
//  	{
//  		sizeChange = (float)0.7/Fish.getRenderSize();
//  		if(Fish.getRenderSize() < 0.9F)
//  			sizeChange = 1.3F;
//  	}
//  	else
//  	{
//  		sizeChange = 1;
//  	}
//  	
//
//}
//  
//  
    //FantasticDebug.Output("TAIL SPEED "+Float.toString(_fish.GetTailFlapSpeed()),true);
    this.bodysection1.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F) );
    this.bodysection2.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F - (float)(Math.PI/6)) );
    this.bodysection3.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F - (float)(Math.PI/3)) );
    this.bodysection4.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F - (float)(Math.PI/2)) );
    this.bodysection5.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F - (float)(2*Math.PI/3)) );
    this.bodysection6.rotateAngleY = 0.2F *(MathHelper.cos(f2 * _fish.currentSpeed *  _fish.GetTailFlapSpeed() * 0.527F - (float)(5*Math.PI/6)) );

    
//    this.bodysection1.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F) );
//    this.bodysection2.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F - (float)(Math.PI/6)) );
//    this.bodysection3.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F - (float)(Math.PI/3)) );
//    this.bodysection4.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F - (float)(Math.PI/2)) );
//    this.bodysection5.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F - (float)(2*Math.PI/3)) );
//    this.bodysection6.rotateAngleY = 0.2F *(MathHelper.cos(f2 *extraSpeed * sizeChange * 0.527F - (float)(5*Math.PI/6)) );
    
   
  }
}