 
package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
 
public class ModelLobster extends ModelBase
{
  //fields
    ModelRenderer head2;
    ModelRenderer eyeL;
    ModelRenderer eyeR;
    ModelRenderer head1;
    ModelRenderer mainbody;
    ModelRenderer Lwisker;
    ModelRenderer Rwisker;
    ModelRenderer legRB1;
    ModelRenderer legRB2;
    ModelRenderer legRM1;
    ModelRenderer legRM2;
    ModelRenderer legRF1;
    ModelRenderer legRF2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail;
    ModelRenderer armL1;
    ModelRenderer armL2;
    ModelRenderer clawL1;
    ModelRenderer clawL2;
    ModelRenderer armR1;
    ModelRenderer armR2;
    ModelRenderer clawR1;
    ModelRenderer clawR2;
    ModelRenderer legLB1;
    ModelRenderer legLB2;
    ModelRenderer legLF1;
    ModelRenderer legLF2;
    ModelRenderer legLM1;
    ModelRenderer legLM2;
   
  public ModelLobster()
  {
    textureWidth = 128;
    textureHeight = 128;
     
      head2 = new ModelRenderer(this, 0, 11);
      head2.addBox(-1.5F, -0.3F, -6.5F, 3, 4, 8);
      head2.setRotationPoint(0F, 10F, 0F);
      head2.setTextureSize(128, 128);
      head2.mirror = true;
      setRotation(head2, -0.3490659F, 0F, 0F);
      eyeL = new ModelRenderer(this, 14, 14);
      eyeL.addBox(-2F, -1F, -6F, 1, 1, 2);
      eyeL.setRotationPoint(0F, 10F, 0F);
      eyeL.setTextureSize(128, 128);
      eyeL.mirror = true;
      setRotation(eyeL, -0.2617994F, -0.7853982F, 0F);
      eyeR = new ModelRenderer(this, 14, 14);
      eyeR.mirror = true;
      eyeR.addBox(1F, -1F, -6F, 1, 1, 2);
      eyeR.setRotationPoint(0F, 10F, 0F);
      eyeR.setTextureSize(128, 128);
      eyeR.mirror = true;
      setRotation(eyeR, -0.2617994F, 0.7853982F, 0F);
      eyeR.mirror = false;
      head1 = new ModelRenderer(this, 0, 0);
      head1.addBox(-2F, -2.5F, -6F, 4, 4, 7);
      head1.setRotationPoint(0F, 10F, 0F);
      head1.setTextureSize(128, 128);
      head1.mirror = true;
      setRotation(head1, 0F, 0F, 0F);
      mainbody = new ModelRenderer(this, 28, 0);
      mainbody.addBox(-3F, -2F, 0F, 6, 6, 10);
      mainbody.setRotationPoint(0F, 10F, 0F);
      mainbody.setTextureSize(128, 128);
      mainbody.mirror = true;
      setRotation(mainbody, 0F, 0F, 0F);
      Lwisker = new ModelRenderer(this, 57, -4);
      Lwisker.addBox(1F, -7F, -10F, 0, 7, 20);
      Lwisker.setRotationPoint(0F, 10F, 0F);
      Lwisker.setTextureSize(128, 128);
      Lwisker.mirror = true;
      setRotation(Lwisker, 0F, 0F, 0.2617994F);
      Rwisker = new ModelRenderer(this, 57, -4);
      Rwisker.mirror = true;
      Rwisker.addBox(-1F, -7F, -10F, 0, 7, 20);
      Rwisker.setRotationPoint(0F, 10F, 0F);
      Rwisker.setTextureSize(128, 128);
      Rwisker.mirror = true;
      setRotation(Rwisker, 0F, 0F, -0.2617994F);
      Rwisker.mirror = false;
      legRB1 = new ModelRenderer(this, 88, 8);
      legRB1.mirror = true;
      legRB1.addBox(-6F, -0.5F, -0.5F, 6, 1, 1);
      legRB1.setRotationPoint(-2F, 14F, 5F);
      legRB1.setTextureSize(128, 128);
      legRB1.mirror = true;
      setRotation(legRB1, 0F, 0F, 0.7853982F);
      legRB1.mirror = false;
      legRB2 = new ModelRenderer(this, 88, 10);
      legRB2.mirror = true;
      legRB2.addBox(-5F, -6.5F, -0.5F, 5, 1, 1);
      legRB2.setRotationPoint(0F, 0F, 0F);
      legRB2.setTextureSize(128, 128);
      legRB2.mirror = true;
      setRotation(legRB2, 0F, 0F, -1.5707964F);
      legRB2.mirror = false;
      legRM1 = new ModelRenderer(this, 88, 8);
      legRM1.mirror = true;
      legRM1.addBox(-6F, -0.5F, -0.5F, 6, 1, 1);
      legRM1.setRotationPoint(-2F, 14F, 3F);
      legRM1.setTextureSize(128, 128);
      legRM1.mirror = true;
      setRotation(legRM1, 0F, 0F, 0.7853982F);
      legRM1.mirror = false;
      legRM2 = new ModelRenderer(this, 88, 10);
      legRM2.mirror = true;
      legRM2.addBox(-5F, -6.5F, -0.5F, 5, 1, 1);
      legRM2.setRotationPoint(0F, 0F, 0F);
      legRM2.setTextureSize(128, 128);
      legRM2.mirror = true;
      setRotation(legRM2, 0F, 0F, -1.5707964F);
      legRM2.mirror = false;
      legRF1 = new ModelRenderer(this, 88, 8);
      legRF1.mirror = true;
      legRF1.addBox(-6F, -0.5F, -0.5F, 6, 1, 1);
      legRF1.setRotationPoint(-2F, 14F, 1F);
      legRF1.setTextureSize(128, 128);
      legRF1.mirror = true;
      setRotation(legRF1, 0F, 0F, 0.7853982F);
      legRF1.mirror = false;
      legRF2 = new ModelRenderer(this, 88, 10);
      legRF2.mirror = true;
      legRF2.addBox(-5F, -6.5F, -0.5F, 5, 1, 1);
      legRF2.setRotationPoint(0F, 0F, 0F);
      legRF2.setTextureSize(128, 128);
      legRF2.mirror = true;
      setRotation(legRF2, 0F, 0F, -1.5707964F);
      legRF2.mirror = false;
      tail1 = new ModelRenderer(this, 33, 16);
      tail1.addBox(-2.5F, -1.5F, -1F, 5, 4, 6);
      tail1.setRotationPoint(0F, 0F, 10F);
      tail1.setTextureSize(128, 128);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0F);
      tail2 = new ModelRenderer(this, 34, 26);
      tail2.addBox(-2F, -1F, -1F, 4, 3, 5);
      tail2.setRotationPoint(0F, 0F, 5F);
      tail2.setTextureSize(128, 128);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, 0F);
      tail3 = new ModelRenderer(this, 35, 34);
      tail3.addBox(-1.5F, -0.5F, 0F, 3, 2, 4);
      tail3.setRotationPoint(0F, 0F, 3F);
      tail3.setTextureSize(128, 128);
      tail3.mirror = true;
      setRotation(tail3, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 7, 31);
      tail.addBox(1F, 0F, 1F, 8, 0, 8);
      tail.setRotationPoint(0F, 0F, 0F);
      tail.setTextureSize(128, 128);
      tail.mirror = true;
      setRotation(tail, 0F, -0.7853982F, 0F);
      armL1 = new ModelRenderer(this, 96, 0);
      armL1.addBox(0F, 0F, 0F, 2, 7, 1);
      armL1.setRotationPoint(2F, 13F, 0F);
      armL1.setTextureSize(128, 128);
      armL1.mirror = true;
      setRotation(armL1, 0.55F, 2.3853982F, -1.994395F);
      armL2 = new ModelRenderer(this, 80, 0);
      armL2.addBox(-1F, -2F, -5F, 3, 3, 5);
      armL2.setRotationPoint(6F, 10F, -3F);
      armL2.setTextureSize(128, 128);
      armL2.mirror = true;
      setRotation(armL2, 0F, 0F, 0F);
      clawL1 = new ModelRenderer(this, 60, 0);
      clawL1.addBox(-1F, -2F, -9F, 5, 3, 9);
      clawL1.setRotationPoint(0F, -1F, -4F);
      clawL1.setTextureSize(128, 128);
      clawL1.mirror = true;
      setRotation(clawL1, 0.5235988F, 0.2617994F, 0F);
      clawL2 = new ModelRenderer(this, 51, 0);
      clawL2.addBox(-2F, -1F, -6F, 3, 2, 6);
      clawL2.setRotationPoint(-1F, 0.5F, -2F);
      clawL2.setTextureSize(128, 128);
      clawL2.mirror = true;
      setRotation(clawL2, 0F, 0F, 0F);
      armR1 = new ModelRenderer(this, 96, 0);
      armR1.mirror = true;
      armR1.addBox(-2F, 0F, 0F, 2, 7, 1);
      armR1.setRotationPoint(-2F, 13F, 0F);
      armR1.setTextureSize(128, 128);
      armR1.mirror = true;
      setRotation(armR1, 0.55F, -2.3853982F, 1.994395F);
      armR1.mirror = false;
      armR2 = new ModelRenderer(this, 80, 0);
      armR2.mirror = true;
      armR2.addBox(-2F, -2F, -5F, 3, 3, 5);
      armR2.setRotationPoint(-6F, 10F, -3F);
      armR2.setTextureSize(128, 128);
      armR2.mirror = true;
      setRotation(armR2, 0F, 0F, 0F);
      armR2.mirror = false;
      clawR1 = new ModelRenderer(this, 60, 0);
      clawR1.mirror = true;
      clawR1.addBox(-4F, -2F, -9F, 5, 3, 9);
      clawR1.setRotationPoint(0F, -1F, -4F);
      clawR1.setTextureSize(128, 128);
      clawR1.mirror = true;
      setRotation(clawR1, 0.5235988F, -0.2617994F, 0F);
      clawR1.mirror = false;
      clawR2 = new ModelRenderer(this, 51, 0);
      clawR2.mirror = true;
      clawR2.addBox(-1F, -1F, -6F, 3, 2, 6);
      clawR2.setRotationPoint(1F, 0.5F, -2F);
      clawR2.setTextureSize(128, 128);
      clawR2.mirror = true;
      setRotation(clawR2, 0F, 0F, 0F);
      clawR2.mirror = false;
      legLB1 = new ModelRenderer(this, 88, 8);
      legLB1.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
      legLB1.setRotationPoint(2F, 14F, 5F);
      legLB1.setTextureSize(128, 128);
      legLB1.mirror = true;
      setRotation(legLB1, 0F, 0F, -0.7853982F);
      legLB2 = new ModelRenderer(this, 88, 10);
      legLB2.addBox(0F, -6.5F, -0.5F, 5, 1, 1);
      legLB2.setRotationPoint(0F, 0F, 0F);
      legLB2.setTextureSize(128, 128);
      legLB2.mirror = true;
      setRotation(legLB2, 0F, 0F, 1.5707964F);
      legLF1 = new ModelRenderer(this, 88, 8);
      legLF1.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
      legLF1.setRotationPoint(2F, 14F, 1F);
      legLF1.setTextureSize(128, 128);
      legLF1.mirror = true;
      setRotation(legLF1, 0F, 0F, -0.7853982F);
      legLF2 = new ModelRenderer(this, 88, 10);
      legLF2.addBox(0F, -6.5F, -0.5F, 5, 1, 1);
      legLF2.setRotationPoint(0F, 0F, 0F);
      legLF2.setTextureSize(128, 128);
      legLF2.mirror = true;
      setRotation(legLF2, 0F, 0F, 1.5707964F);
      legLM1 = new ModelRenderer(this, 88, 8);
      legLM1.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
      legLM1.setRotationPoint(2F, 14F, 3F);
      legLM1.setTextureSize(128, 128);
      legLM1.mirror = true;
      setRotation(legLM1, 0F, 0F, -0.7853982F);
      legLM2 = new ModelRenderer(this, 88, 10);
      legLM2.addBox(0F, -6.5F, -0.5F, 5, 1, 1);
      legLM2.setRotationPoint(0F, 0F, 0F);
      legLM2.setTextureSize(128, 128);
      legLM2.mirror = true;
      setRotation(legLM2, 0F, 0F, 1.5707964F);
      
      mainbody.addChild(tail1);
      tail1.addChild(tail2);
      tail2.addChild(tail3);
      tail3.addChild(tail);
      
      legRB1.addChild(legRB2);
      legRM1.addChild(legRM2);
      legRF1.addChild(legRF2);
      
      legLB1.addChild(legLB2);
      legLM1.addChild(legLM2);
      legLF1.addChild(legLF2);
      
      armL2.addChild(clawL1);
      armR2.addChild(clawR1);
      clawL1.addChild(clawL2);
      clawR1.addChild(clawR2);
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head2.render(f5);
    eyeL.render(f5);
    eyeR.render(f5);
    head1.render(f5);
    mainbody.render(f5);
    Lwisker.render(f5);
    Rwisker.render(f5);
    legRB1.render(f5);
    //legRB2.render(f5);
    legRM1.render(f5);
    //legRM2.render(f5);
    legRF1.render(f5);
    //legRF2.render(f5);
    //tail1.render(f5);
    //tail2.render(f5);
    //tail3.render(f5);
    //tail.render(f5);
    armL1.render(f5);
    armL2.render(f5);
    //clawL1.render(f5);
    //clawL2.render(f5);
    armR1.render(f5);
    armR2.render(f5);
    //clawR1.render(f5);
    //clawR2.render(f5);
    legLB1.render(f5);
    //legLB2.render(f5);
    legLF1.render(f5);
    //legLF2.render(f5);
    legLM1.render(f5);
    //legLM2.render(f5);
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
    	this.tail1.rotateAngleX = 0.04F*(MathHelper.cos(f2 * 0.3662F) );
    	this.tail2.rotateAngleX = 0.04F*(MathHelper.cos(f2 * 0.3662F) );
    	this.tail3.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.3662F) );
    	

        this.eyeL.rotateAngleY = 0.012F*(MathHelper.cos(f2 * 0.1862F) ) - 0.7853982F;
        this.eyeL.rotateAngleX = 0.015F*(MathHelper.cos(f2 * 0.1762F) ) -0.2617994F;
        this.eyeR.rotateAngleY = 0.013F*(MathHelper.cos(f2 * 0.1562F) ) + 0.7853982F;
        this.eyeR.rotateAngleX = 0.011F*(MathHelper.cos(f2 * 0.1262F) ) - 0.2617994F;
        
        

        
    }
    else
    {
        


        this.legRB1.rotateAngleY = MathHelper.sin(f * 1.6662F - (float)(Math.PI/4)) * 0.5F * f1 + 0.2617994F;
        this.legRM1.rotateAngleY = MathHelper.sin(f * 1.6662F) * 0.5F * f1;
        this.legRF1.rotateAngleY = MathHelper.sin(f * 1.6662F + (float)(Math.PI/4)) * 0.5F * f1 - 0.2617994F;

//        this.legRB1.rotateAngleY = MathHelper.sin(f * 1.0662F - (float)(Math.PI/4)) * 0.5F * f1;
//        this.legRM1.rotateAngleY = MathHelper.sin(f * 1.0662F) * 0.5F * f1;
//        this.legRF1.rotateAngleY = MathHelper.sin(f * 1.0662F + (float)(Math.PI/4)) * 0.5F * f1;
//        
        this.legLB1.rotateAngleY = MathHelper.sin(f * 1.6662F - (float)(Math.PI/4)) * 0.5F * f1 - 0.2617994F;
        this.legLM1.rotateAngleY = MathHelper.sin(f * 1.6662F) * 0.5F * f1;
        this.legLF1.rotateAngleY = MathHelper.sin(f * 1.6662F + (float)(Math.PI/4)) * 0.5F * f1 + 0.2617994F;
//
//        this.legLB1.rotateAngleY = -MathHelper.sin(f * 1.0662F - (float)(Math.PI/4)) * 0.5F * f1;
//        this.legLM1.rotateAngleY = -MathHelper.sin(f * 1.0662F) * 0.5F * f1;
//        this.legLF1.rotateAngleY = -MathHelper.sin(f * 1.0662F + (float)(Math.PI/4)) * 0.5F * f1;
        
        
        
        
    }
    
    
    if(entity.worldObj.getClosestPlayerToEntity(entity, 3) != null)
    {

    	this.clawL2.rotateAngleY = 0.22F*(MathHelper.cos(f2 * 0.1962F) );
    	this.clawR2.rotateAngleY = -0.22F*(MathHelper.cos(f2 * 0.1962F) );
    

    	this.armL2.rotateAngleX = 0.04F*(MathHelper.cos(f2 * 0.1862F) ) - 0.75F;
    	this.armR2.rotateAngleX = -0.05F*(MathHelper.cos(f2 * 0.1862F) ) - 0.75F;
    	this.armL2.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.1862F) ) - 0.3F;
    	this.armR2.rotateAngleZ = -0.03F*(MathHelper.cos(f2 * 0.1862F) ) + 0.3F;
    	this.armL2.rotateAngleY = 0.03F*(MathHelper.cos(f2 * 0.1862F) ) - 0.65F;
    	this.armR2.rotateAngleY = -0.04F*(MathHelper.cos(f2 * 0.1862F) ) + 0.65F;
        
    }
    else
    {
    	this.clawL2.rotateAngleY = 0.12F*(MathHelper.cos(f2 * 0.1862F) );
    	this.clawR2.rotateAngleY = -0.12F*(MathHelper.cos(f2 * 0.1862F) );
    

    	this.armL2.rotateAngleX = 0.04F*(MathHelper.cos(f2 * 0.1862F) );
    	this.armR2.rotateAngleX = -0.05F*(MathHelper.cos(f2 * 0.1862F) );
    	this.armL2.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.1862F) );
    	this.armR2.rotateAngleZ = -0.03F*(MathHelper.cos(f2 * 0.1862F) );
    	this.armL2.rotateAngleY = 0.03F*(MathHelper.cos(f2 * 0.1862F) );
    	this.armR2.rotateAngleY = -0.04F*(MathHelper.cos(f2 * 0.1862F) );
    	
    }
    

	this.Lwisker.rotateAngleZ = 0.04F*(MathHelper.cos(f2 * 0.1862F) );
	this.Rwisker.rotateAngleZ = -0.04F*(MathHelper.cos(f2 * 0.1862F) );
    
  }
 
}