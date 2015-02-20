package fantastic.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHermitCrab extends ModelBase
{
      //fields
    ModelRenderer shellbig;
    ModelRenderer shellmedium;
    ModelRenderer shellsmall;
    ModelRenderer body;
    ModelRenderer legs;
    ModelRenderer claws;
    ModelRenderer antenna;
      
      public ModelHermitCrab()
      {
        shellbig = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);;
        shellbig.addBox(-1.5F, -2F, 0F, 3, 3, 3);
        shellbig.setRotationPoint(0F, 23F, 0F);
        setRotation(shellbig, 0F, 0F, 0F);
        shellbig.mirror = true;
        shellmedium = new ModelRenderer(this, 0, 7).setTextureSize(64, 32);;
        shellmedium.addBox(-1F, -1F, 0F, 2, 2, 2);
        shellmedium.setRotationPoint(-0.3F, 23F, 2F);
        setRotation(shellmedium, 0F, 0F, 0F);
        shellmedium.mirror = true;
        shellsmall = new ModelRenderer(this, 0, 12).setTextureSize(64, 32);;
        shellsmall.addBox(-0.5F, -0.5F, 0F, 1, 1, 1);
        shellsmall.setRotationPoint(-0.5F, 23.3F, 3.5F);
        setRotation(shellsmall, 0F, 0F, 0F);
        shellsmall.mirror = true;
        body = new ModelRenderer(this, 0, 15).setTextureSize(64, 32);;
        body.addBox(-0.5F, -0.5F, -4F, 1, 1, 4);
        body.setRotationPoint(0F, 22.5F, 2F);
        setRotation(body, 0F, 0F, 0F);
        body.mirror = true;
        legs = new ModelRenderer(this, 0, 24).setTextureSize(64, 32);;
        legs.addBox(-1F, 0F, -1F, 2, 2, 2);
        legs.setRotationPoint(0F, 22.1F, -0.4F);
        setRotation(legs, 0F, 0F, 0F);
        legs.mirror = true;
        claws = new ModelRenderer(this, 9, 24).setTextureSize(64, 32);;
        claws.addBox(-1F, 0F, -2F, 2, 2, 2);
        claws.setRotationPoint(0F, 22.5F, -0.2F);
        setRotation(claws, 0F, 0F, 0F);
        claws.mirror = true;
        antenna = new ModelRenderer(this, 0, 21).setTextureSize(64, 32);;
        antenna.addBox(-0.5F, -1F, -1F, 1, 1, 1);
        antenna.setRotationPoint(0F, 22F, -1.5F);
        setRotation(antenna, -0.5585054F, 0F, 0F);
        antenna.mirror = true;
      }

      public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
      {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5,entity);
        shellbig.render(f5);
        shellmedium.render(f5);
        shellsmall.render(f5);
        body.render(f5);
        legs.render(f5);
        claws.render(f5);
        antenna.render(f5);
      }

      public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
      {
        super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
      }
      
      private void setRotation(ModelRenderer model, float x, float y, float z)
      {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
      }
}
