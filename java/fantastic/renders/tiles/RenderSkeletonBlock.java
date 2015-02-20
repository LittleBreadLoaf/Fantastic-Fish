

package fantastic.renders.tiles;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslated;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.blocks.decoration.TileSkeletonBlock;

public class RenderSkeletonBlock extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private final ResourceLocation TEXTURE = new ResourceLocation(FantasticInfo.ID + ":textures/blocks/skeleton_1.png");

	private TileSkeletonBlock Skeleton = null;
	public static ModelBase model = new ModelBase()
	{

	};
  //fields
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public RenderSkeletonBlock()
  {

	  model.textureHeight = 64;
	  model.textureWidth = 64;
	  
	  head = new ModelRenderer(model, 0, 0);
      head.addBox(-4F, -10F, -4F, 8, 10, 8);
      head.setRotationPoint(0F, 20F, 5F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, -1.989675F, 0.8552113F, 2.007129F);
      body = new ModelRenderer(model, 16, 18);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 20F, 5F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, -1.570796F, 0F, 2.373648F);
      rightarm = new ModelRenderer(model, 40, 18);
      rightarm.addBox(-1F, -2F, -1F, 2, 12, 2);
      rightarm.setRotationPoint(3F, 17F, 4F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0.9075712F, -0.9075712F);
      leftarm = new ModelRenderer(model, 40, 18);
      leftarm.addBox(-1F, -2F, -1F, 2, 12, 2);
      leftarm.setRotationPoint(-1F, 23F, 5F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0.2268928F, -1.570796F);
      rightleg = new ModelRenderer(model, 0, 18);
      rightleg.addBox(-1F, 0F, -1F, 2, 12, 2);
      rightleg.setRotationPoint(2F, 18F, -7F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, -1.117011F, -0.5585054F, 0F);
      leftleg = new ModelRenderer(model, 0, 18);
      leftleg.addBox(-1F, 0F, -1F, 2, 12, 2);
      leftleg.setRotationPoint(-2F, 22F, -7F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, -1.48353F, 0.2443461F, 0F);
  }
  
  public void render(float f5)
  {
	  glDisable(GL_CULL_FACE);
	  head.render(f5);
	    body.render(f5);
	    rightarm.render(f5);
	    leftarm.render(f5);
	    rightleg.render(f5);
	    leftleg.render(f5);
    glEnable(GL_CULL_FACE);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }


  @Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f)
	{
	  float rotation = 0;
	  if(tile instanceof TileSkeletonBlock)
	  {
		  this.Skeleton = (TileSkeletonBlock)tile;
		  rotation = Skeleton.getRotation();
	  }

		glPushMatrix();
		glTranslated(x + 0.5D, y - 1.05D, z + 0.5D);
		glRotatef(rotation, 0F, 1F, 0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(this.TEXTURE);
		this.render(0.0625F);
		glPopMatrix();
	}

@Override
public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) 
{
	glPushMatrix();
	GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	glTranslated(0, 0.3F, 0);
	glRotatef(180F, 1F, 0F, 0F);
	glRotatef(90F, 0F, 1F, 0F);
	FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE);
	this.render(0.0625F);
	GL11.glPopAttrib();
	glPopMatrix();
	
}

@Override
// messed up with model rendering
public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
{

	return false;
}

@Override
public boolean shouldRender3DInInventory(int modelId)
{
	return true;
}

@Override
public int getRenderId()
{
	return FantasticIds.skeletonRenderingID;
}



}
