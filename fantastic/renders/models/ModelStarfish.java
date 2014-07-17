package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
public class ModelStarfish extends ModelBase
{
  //fields
    ModelRenderer Shape11;
    ModelRenderer Shape13;
    ModelRenderer Shape12;
    ModelRenderer Shape21;
    ModelRenderer Shape23;
    ModelRenderer Shape22;
    ModelRenderer Shape31;
    ModelRenderer Shape33;
    ModelRenderer Shape32;
    ModelRenderer Shape41;
    ModelRenderer Shape43;
    ModelRenderer Shape42;
    ModelRenderer Shape51;
    ModelRenderer Shape53;
    ModelRenderer Shape52;
   
  public ModelStarfish()
  {
    textureWidth = 64;
    textureHeight = 32;
     
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(-1F, -1F, 0F, 2, 2, 7);
      Shape11.setRotationPoint(0F, 0F, 0F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, -0.1396263F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 18, 0);
      Shape13.mirror = true;
      Shape13.addBox(-2F, -0.5F, 1F, 1, 1, 8);
      Shape13.setRotationPoint(0F, 0F, 0F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, -0.0872665F, 0.1396263F, 0F);
      Shape13.mirror = false;
      Shape12 = new ModelRenderer(this, 18, 0);
      Shape12.addBox(1F, -0.5F, 1F, 1, 1, 8);
      Shape12.setRotationPoint(0F, 0F, 0F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, -0.0872665F, -0.1396263F, 0F);
      Shape21 = new ModelRenderer(this, 0, 0);
      Shape21.addBox(-1F, -1F, 0F, 2, 2, 7);
      Shape21.setRotationPoint(0F, 0F, 0F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, -0.1396263F, 1.32645F, 0F);
      Shape23 = new ModelRenderer(this, 18, 0);
      Shape23.mirror = true;
      Shape23.addBox(-2F, -0.5F, 1F, 1, 1, 8);
      Shape23.setRotationPoint(0F, 0F, 0F);
      Shape23.setTextureSize(64, 32);
      Shape23.mirror = true;
      setRotation(Shape23, -0.0872665F, 1.466077F, 0F);
      Shape23.mirror = false;
      Shape22 = new ModelRenderer(this, 18, 0);
      Shape22.addBox(1F, -0.5F, 1F, 1, 1, 8);
      Shape22.setRotationPoint(0F, 0F, 0F);
      Shape22.setTextureSize(64, 32);
      Shape22.mirror = true;
      setRotation(Shape22, -0.0872665F, 1.186824F, 0F);
      Shape31 = new ModelRenderer(this, 0, 0);
      Shape31.addBox(-1F, -1F, 0F, 2, 2, 7);
      Shape31.setRotationPoint(0F, 0F, 0F);
      Shape31.setTextureSize(64, 32);
      Shape31.mirror = true;
      setRotation(Shape31, -0.1396263F, 2.530727F, 0F);
      Shape33 = new ModelRenderer(this, 18, 0);
      Shape33.mirror = true;
      Shape33.addBox(-2F, -0.5F, 1F, 1, 1, 8);
      Shape33.setRotationPoint(0F, 0F, 0F);
      Shape33.setTextureSize(64, 32);
      Shape33.mirror = true;
      setRotation(Shape33, -0.0872665F, 2.670354F, 0F);
      Shape33.mirror = false;
      Shape32 = new ModelRenderer(this, 18, 0);
      Shape32.addBox(1F, -0.5F, 1F, 1, 1, 8);
      Shape32.setRotationPoint(0F, 0F, 0F);
      Shape32.setTextureSize(64, 32);
      Shape32.mirror = true;
      setRotation(Shape32, -0.0872665F, 2.391101F, 0F);
      Shape41 = new ModelRenderer(this, 0, 0);
      Shape41.addBox(-1F, -1F, 0F, 2, 2, 7);
      Shape41.setRotationPoint(0F, 0F, 0F);
      Shape41.setTextureSize(64, 32);
      Shape41.mirror = true;
      setRotation(Shape41, -0.1396263F, -2.530727F, 0F);
      Shape43 = new ModelRenderer(this, 18, 0);
      Shape43.mirror = true;
      Shape43.addBox(-2F, -0.5F, 1F, 1, 1, 8);
      Shape43.setRotationPoint(0F, 0F, 0F);
      Shape43.setTextureSize(64, 32);
      Shape43.mirror = true;
      setRotation(Shape43, -0.0872665F, -2.391101F, 0F);
      Shape43.mirror = false;
      Shape42 = new ModelRenderer(this, 18, 0);
      Shape42.addBox(1F, -0.5F, 1F, 1, 1, 8);
      Shape42.setRotationPoint(0F, 0F, 0F);
      Shape42.setTextureSize(64, 32);
      Shape42.mirror = true;
      setRotation(Shape42, -0.0872665F, -2.670354F, 0F);
      Shape51 = new ModelRenderer(this, 0, 0);
      Shape51.addBox(-1F, -1F, 0F, 2, 2, 7);
      Shape51.setRotationPoint(0F, 0F, 0F);
      Shape51.setTextureSize(64, 32);
      Shape51.mirror = true;
      setRotation(Shape51, -0.1396263F, -1.32645F, 0F);
      Shape53 = new ModelRenderer(this, 18, 0);
      Shape53.mirror = true;
      Shape53.addBox(-2F, -0.5F, 1F, 1, 1, 8);
      Shape53.setRotationPoint(0F, 0F, 0F);
      Shape53.setTextureSize(64, 32);
      Shape53.mirror = true;
      setRotation(Shape53, -0.0872665F, -1.186824F, 0F);
      Shape53.mirror = false;
      Shape52 = new ModelRenderer(this, 18, 0);
      Shape52.addBox(1F, -0.5F, 1F, 1, 1, 8);
      Shape52.setRotationPoint(0F, 0F, 0F);
      Shape52.setTextureSize(64, 32);
      Shape52.mirror = true;
      setRotation(Shape52, -0.0872665F, -1.466077F, 0F);
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape11.render(f5);
    Shape13.render(f5);
    Shape12.render(f5);
    Shape21.render(f5);
    Shape23.render(f5);
    Shape22.render(f5);
    Shape31.render(f5);
    Shape33.render(f5);
    Shape32.render(f5);
    Shape41.render(f5);
    Shape43.render(f5);
    Shape42.render(f5);
    Shape51.render(f5);
    Shape53.render(f5);
    Shape52.render(f5);
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