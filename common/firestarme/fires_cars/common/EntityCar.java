package firestarme.fires_cars.common;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityCar extends EntityVehicle {

	public EntityCar(World par1World) {
		super(par1World);
		this.dropItem(fires_carsMain.CarID, 1);
        this.yOffset = this.height / 2.0F;
        this.setSize(0.9F*2, 0.9F*2);
        this.acceleration = 0.2F;
		this.isOffroad = false;
		this.maxSpeed = 5;
		this.climbAcceleration = 0;
	}

	public EntityCar(World par1World,double X,double Y,double Z){
		this(par1World);
        this.setPosition(X, Y + (double)this.yOffset + 2, Z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
		this.prevPosX = X;
		this.prevPosY = Y;
		this.prevPosZ = Z;
		this.rotationYaw = par1World.getClosestPlayer(X, Y, Z, 10).rotationYawHead;
		
	}
	
	
	@Override
	protected void entityInit() {
	
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	
//public double getMountedYOffset()
	//{
	        //return (double)this.height * 0.0D - 0.30000001192092896D;
	//}
	
	public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            double var1 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
            double var3 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
        	
            this.riddenByEntity.setPosition(this.posX + var1, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), var3);
        }
    }
}
	
    

	


