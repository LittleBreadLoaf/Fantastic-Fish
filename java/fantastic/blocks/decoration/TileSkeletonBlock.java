package fantastic.blocks.decoration;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;




public class TileSkeletonBlock extends TileEntity
{
	
	private float rotation;
	
	public TileSkeletonBlock(float rot)
	{
		super();
		rotation = rot;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
	}
	
	public void setRotation(float rot)
	{
		this.rotation = rot;
	}
	
	public float getRotation()
	{
		return this.rotation;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) 
	{

		compound.setFloat("Rotation", this.getRotation());
		super.writeToNBT(compound);

	}
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		this.setRotation(compound.getFloat("Rotation"));
		super.readFromNBT(compound);
	

	}
	
	
	public Packet getDescriptionPacket() {
	    NBTTagCompound tagCompound = new NBTTagCompound();
	    writeToNBT(tagCompound);
	    return null;
	}
	

}