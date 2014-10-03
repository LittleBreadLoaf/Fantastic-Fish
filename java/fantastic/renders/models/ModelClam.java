 
package fantastic.renders.models;

import fantastic.entities.EntityClam;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
public class ModelClam extends ModelBase
{
  //fields
    ModelRenderer shellbackleft;
    ModelRenderer bottomshell_center;
    ModelRenderer shellback_right;
    ModelRenderer bottom_shell_right;
    ModelRenderer bottem_shell_left;
    ModelRenderer topshell_center;
    ModelRenderer top_shell_right;
    ModelRenderer top_shell_left;
   
  public ModelClam()
  {
    textureWidth = 64;
    textureHeight = 64;
     
      shellbackleft = new ModelRenderer(this, 37, 0);
      shellbackleft.mirror = true;
      shellbackleft.addBox(4F, 0F, 1F, 7, 1, 5);
      shellbackleft.setRotationPoint(0F, 0F, 0F);
      shellbackleft.setTextureSize(64, 64);
      shellbackleft.mirror = true;
      setRotation(shellbackleft, 0F, -0.5235988F, 0F);
      shellbackleft.mirror = false;
      bottomshell_center = new ModelRenderer(this, 0, 0);
      bottomshell_center.addBox(-4F, 0F, -13F, 8, 3, 21);
      bottomshell_center.setRotationPoint(0F, 0F, 0F);
      bottomshell_center.setTextureSize(64, 64);
      bottomshell_center.mirror = true;
      setRotation(bottomshell_center, 0F, 0F, 0F);
      shellback_right = new ModelRenderer(this, 37, 0);
      shellback_right.addBox(-11F, 0F, 1F, 7, 1, 5);
      shellback_right.setRotationPoint(0F, 0F, 0F);
      shellback_right.setTextureSize(64, 64);
      shellback_right.mirror = true;
      setRotation(shellback_right, 0F, 0.5235988F, 0F);
      bottom_shell_right = new ModelRenderer(this, 0, 24);
      bottom_shell_right.addBox(-5F, 0F, -13F, 8, 2, 17);
      bottom_shell_right.setRotationPoint(0F, 0F, 0F);
      bottom_shell_right.setTextureSize(64, 64);
      bottom_shell_right.mirror = true;
      setRotation(bottom_shell_right, 0.026F, 0.5235988F, 0.0872665F);
      bottem_shell_left = new ModelRenderer(this, 0, 24);
      bottem_shell_left.mirror = true;
      bottem_shell_left.addBox(-3F, 0F, -13F, 8, 2, 17);
      bottem_shell_left.setRotationPoint(0F, 0F, 0F);
      bottem_shell_left.setTextureSize(64, 64);
      bottem_shell_left.mirror = true;
      setRotation(bottem_shell_left, 0.026F, -0.5235988F, -0.0872665F);
      bottem_shell_left.mirror = false;
      topshell_center = new ModelRenderer(this, 0, 0);
      topshell_center.addBox(-4F, -2F, -19F, 8, 3, 21);
      topshell_center.setRotationPoint(0F, -1F, 6F);
      topshell_center.setTextureSize(64, 64);
      topshell_center.mirror = true;
      setRotation(topshell_center, 0.7853982F, 0F, 3.141593F);
      top_shell_right = new ModelRenderer(this, 0, 24);
      top_shell_right.mirror = true;
      top_shell_right.addBox(-5F, -2F, -18F, 8, 2, 17);
      top_shell_right.setRotationPoint(0F, -1F, 6F);
      top_shell_right.setTextureSize(64, 64);
      top_shell_right.mirror = true;
      setRotation(top_shell_right, 0.85F, -0.2F, 2.66F);
      top_shell_right.mirror = false;
      top_shell_left = new ModelRenderer(this, 0, 24);
      top_shell_left.addBox(-3F, -2F, -18F, 8, 2, 17);
      top_shell_left.setRotationPoint(0F, -1F, 6F);
      top_shell_left.setTextureSize(64, 64);
      top_shell_left.mirror = true;
      setRotation(top_shell_left, 0.85F, 0.2F, -2.66F);
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    shellbackleft.render(f5);
    bottomshell_center.render(f5);
    shellback_right.render(f5);
    bottom_shell_right.render(f5);
    bottem_shell_left.render(f5);
    topshell_center.render(f5);
    top_shell_right.render(f5);
    top_shell_left.render(f5);
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
    
    if(entity instanceof EntityClam)
    {
    	EntityClam Clam = (EntityClam)entity;
    	
    	if(Clam.getIsClosed())
    	{
    		this.topshell_center.rotateAngleX = 0.1F;
    		this.topshell_center.rotateAngleY = 0.0F;
    		this.topshell_center.rotateAngleZ = 3.141593F;

    		this.top_shell_left.rotateAngleX = 0.21F;
    		this.top_shell_left.rotateAngleY = 0.45F;
    		this.top_shell_left.rotateAngleZ = -2.86F;

    		this.top_shell_right.rotateAngleX = 0.21F;
    		this.top_shell_right.rotateAngleY = -0.45F;
    		this.top_shell_right.rotateAngleZ = 2.86F;
    	}
    	else
    	{
    		this.topshell_center.rotateAngleX = 0.7853982F;
    		this.topshell_center.rotateAngleY = 0.0F;
    		this.topshell_center.rotateAngleZ = 3.141593F;

    		this.top_shell_left.rotateAngleX = 0.85F;
    		this.top_shell_left.rotateAngleY = 0.2F;
    		this.top_shell_left.rotateAngleZ = -2.66F;

    		this.top_shell_right.rotateAngleX = 0.85F;
    		this.top_shell_right.rotateAngleY = -0.2F;
    		this.top_shell_right.rotateAngleZ = 2.66F;
    	}
    }
    
  }
 
}