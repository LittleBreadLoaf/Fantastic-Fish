// Date: 8/1/2014 8:28:47 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package fantastic.renders.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSingleTank extends ModelBiped
{
  //fields
    ModelRenderer straps;
    ModelRenderer airtanks;
    ModelRenderer tanktop1L;
    ModelRenderer tanktop2L;
  
  public ModelSingleTank(float f)
  {
	  super(f, 0, 64, 64);
    textureWidth = 64;
    textureHeight = 64;
    
    straps = new ModelRenderer(this, 41, 35);
    straps.addBox(-4F, 0F, -2F, 8, 12, 4);
    straps.setRotationPoint(0F, 0F, 0F);
    straps.setTextureSize(64, 64);
    straps.mirror = true;
    setRotation(straps, 0F, 0F, 0F);
    airtanks = new ModelRenderer(this, 40, 51);
    airtanks.addBox(-2F, 1F, 2F, 4, 9, 4);
    airtanks.setRotationPoint(0F, 0F, 0F);
    airtanks.setTextureSize(64, 64);
    airtanks.mirror = true;
    setRotation(airtanks, 0F, 0F, 0F);
    tanktop1L = new ModelRenderer(this, 32, 51);
    tanktop1L.addBox(-1F, 0F, 3F, 2, 1, 2);
    tanktop1L.setRotationPoint(0F, 0F, 0F);
    tanktop1L.setTextureSize(64, 64);
    tanktop1L.mirror = true;
    setRotation(tanktop1L, 0F, 0F, 0F);
    tanktop2L = new ModelRenderer(this, 28, 54);
    tanktop2L.addBox(-1.5F, 0.5F, 2.5F, 3, 1, 3);
    tanktop2L.setRotationPoint(0F, 0F, 0F);
    tanktop2L.setTextureSize(64, 64);
    tanktop2L.mirror = true;
    setRotation(tanktop2L, 0F, 0F, 0F);
      
      this.bipedBody.addChild(straps);
      this.bipedBody.addChild(airtanks);
      this.bipedBody.addChild(tanktop1L);
      this.bipedBody.addChild(tanktop2L);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  
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
  }

}
