package firestarme.fires_cars.common;

import net.minecraft.src.AABBPool;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import org.lwjgl.input.Keyboard;

public class EntityVehicle extends Entity{
	
	public float speed = 0;
	public float maxSpeed;
	public float fallSpeed = 0;
	public float maxFallSpeed = 0.4F;
	public float acceleration;
	public float drag;
	public float yaw;
	public boolean isOffroad = false;
	public float climbAcceleration;
	public float climb = 0F;
	public boolean mounted = false;
	public Entity passenger;
	public double velocityX;
	public double velocityY;
	public double velocityZ;
	public float velocityX2;
	public float velocityY2;
	public float velocityZ3;
	
	
	public EntityVehicle(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}
	
	
	 
     

     
	
	public void addSpeed(float Sp){
		if(speed < maxSpeed){
			speed = speed + Sp;
		}
	}

	public void addfallSpeed(float Fsp){
		if(fallSpeed < maxFallSpeed){
			fallSpeed = fallSpeed + Fsp;
		}
	}
	
	public void applyDrag(){
		
		if(speed > 0.01){
			this.addSpeed(-drag);
		}else if(speed < 0.01){
			this.speed = 0;
		}else{
			speed = 0;
		}
		
	}

	   public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	    {
	        if (this.func_85032_ar())
	        {
	            return false;
	        }
	        else if (!this.worldObj.isRemote && !this.isDead)
	        {

	                this.dropItemWithOffset(fires_carsMain.Car.shiftedIndex, 1, 0.0F);
	                this.setDead();
	            }

	            return true;
	     }

	   
	  public void onUpdate(){
	   
		if(this.riddenByEntity != null){
		
			 this.motionX += this.riddenByEntity.motionX;
             this.motionZ += this.riddenByEntity.motionZ;
				
			
			
		if(this.rotationYaw > this.riddenByEntity.rotationYaw){
			
			this.rotationYaw -= 0.5;
			
		}else if(this.rotationYaw < this.riddenByEntity.rotationYaw){
			
			this.rotationYaw += 0.5;
				
			}
			
		
			
			
			if(this.isCollidedHorizontally){
				
				if(isOffroad == true){
				
				climb = 1;
				this.addfallSpeed(-climbAcceleration);
				this.addSpeed(-1.3F * acceleration);
				
				}else{
					
					speed = 0;
					
				}
		}
		}else{
		
		
			this.applyDrag();
			
		}
		  
		if(this.isCollidedVertically == false){
		
			climb = -1;
			this.addfallSpeed(0.01F);
			
		
		}else{
			
				climb = 0;
			fallSpeed = 0;
			
		}
		move();
		this.updateRiderPosition();
	   }

	   public void move()
       {
               if(riddenByEntity != null)
               {
                       velocityZ = Math.cos(rotationYaw * 0.0174532925) * speed;
                       velocityX = Math.sin(rotationYaw* 0.0174532925) * -speed;
                       if(isCollidedHorizontally)             
                       {
                               velocityY = -fallSpeed;               
                       }
                       
                      this.motionX  += velocityX;
                      this.motionY = 0;
                      this.motionZ += velocityZ;
                       
                       
                       
                       
                       this.moveEntity(this.motionX,this.motionY,this.motionZ);
               }
       }       

               

	   public boolean interact(EntityPlayer par1EntityPlayer)
	    {
	        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
	        {
	            return true;
	        }
	        else
	        {
	            if (!this.worldObj.isRemote)
	            {
	                par1EntityPlayer.mountEntity(this);
	            }

	            return true;
	        }
	    }
	   
	   
	   
	    public AxisAlignedBB getCollisionBox(Entity par1Entity)
	    {
	    	if(par1Entity == this.riddenByEntity)
	    	{
	    		return null;
	    	}	
	    	else
	    	{
	    		return par1Entity.boundingBox;
	    	}
	    }


	    public AxisAlignedBB getBoundingBox()
	    {
	       return this.boundingBox;
	    }
}





