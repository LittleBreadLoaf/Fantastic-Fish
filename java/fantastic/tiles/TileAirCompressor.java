package fantastic.tiles;

import net.minecraft.nbt.NBTTagCompound;
import fantastic.FantasticMod;


public class TileAirCompressor extends TileFantastic 
{
	private boolean hasDoubleTank;
	private boolean hasSingleTank;
	private int tankDamage = 0;
	
	public TileAirCompressor()
	{
		                          
	}
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && this.getTankDamage() % 2 == 0)
		{
			if(this.hasDoubleTank || this.hasSingleTank)
			{
				if(this.tankDamage > 0)
				{
					this.tankDamage--;
					this.worldObj.playSound(xCoord, yCoord, zCoord, "tile.piston.in", 1.0F, 1.0F, true);		    	

				}
			}
		}
		else if(!this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && this.getTankDamage() % 2 != 0)
		{
			if(this.hasDoubleTank || this.hasSingleTank)
			{
				if(this.tankDamage > 0)
				{
					this.tankDamage--;
					this.worldObj.playSound(xCoord, yCoord, zCoord, "tile.piston.out", 1.0F, 1.0F, true);

				}
				
			}
		}
		
	}

	public void setDoubleTank(boolean var1)
	{
		this.hasDoubleTank = var1;
	}
	public void setSingleTank(boolean var1)
	{
		this.hasSingleTank = var1;
	}
	public void setTankDamage(int var1)
	{
		this.tankDamage = var1;
	}
	
	public boolean getDoubleTank()
	{
		return hasDoubleTank;
	}
	public boolean getSingleTank()
	{
		return hasSingleTank;
	}
	public int getTankDamage()
	{
		return tankDamage;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setBoolean("Double", hasDoubleTank);
		compound.setBoolean("Single", hasSingleTank);
		compound.setInteger("Damage", tankDamage);

	}
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.setDoubleTank(compound.getBoolean("Double"));
		this.setSingleTank(compound.getBoolean("Single"));
		this.setTankDamage(compound.getInteger("Damage"));

	}
	
	
}