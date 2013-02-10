package firestarme.fires_cars.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenOilResivoir extends WorldGenerator {
	
	int PorousID = fires_carsMain.pourousRock.blockID;
	int Porous = 0;
	int Oil = 1;
	int Brine = 2;
	int Imperm = 3;
	int ModeX = 1;
	int ModeZ = 2;
	
	

	    public boolean generate(World world, Random par2Random, int X, int Y, int Z)
	    {
	        while (world.isAirBlock(X, Y, Z) && Y > 2)
	        {
	            --Y;
	        }
	    
	    if(par2Random.nextInt(200)==0)
	    {
	        
	    int Liquid;
	    
	    if(par2Random.nextInt(100) > 75)
	    {
	    	Liquid = Oil;
	    }
	    else
	    {
	    	Liquid = Brine;
	    }
	    
	   int  Height = par2Random.nextInt(25) + 5;
	   int  LiquidLv = par2Random.nextInt(Height -4) +4;
	    
	    if(par2Random.nextBoolean())
	    {
	    	GenResivoirX(X,1,Z,world,Liquid,LiquidLv,Height);
	    }
	    else
	    {
	    	GenResivoirZ(X,1,Z,world,Liquid,LiquidLv,Height);
	    }
	    
	    System.out.println("resivoirGen: X="+X+" Y="+Y+" Z="+Z);
	    
	    }
	    return true;
	    } 
	    
	    public int isFilled(int liquid,int liquidLv,int Y)
	    {
	    	int block;
	    	
	    	if(Y < liquidLv)
	    	{
	    		block = liquid;
	    	}
	    	else
	    	{
	    		block = Porous;
	    	}
	    	
	    	return block;
	    }
	    
	    private void GenKeyLineX(int X,int Y,int Z,World world,int Length,int content)
	    {
	    	
	    	for(int i = 0;i < Length;i ++)
	    	{
	    		world.setBlockAndMetadataWithNotify(X + 1 + i, Y, Z, PorousID, content);
	    	}
	    	
	    	world.setBlockAndMetadataWithNotify(X + Length + 1, Y, Z, PorousID, Imperm);
	    
	    	for(int i = 0;i < Length;i ++)
	    	{
	    		world.setBlockAndMetadataWithNotify(X - 1 - i, Y, Z, PorousID, content);
	    	}
	    	
	    	world.setBlockAndMetadataWithNotify(X - Length - 1, Y, Z, PorousID, Imperm);
	    	
	    	world.setBlockAndMetadataWithNotify(X,Y,Z,PorousID,content);
	    
	    }
	    
	    private void GenKeyLineZ(int X,int Y,int Z,World world,int Length,int content)
	    {
	    	
	    	for(int i = 0;i < Length;i ++)
	    	{
	    		world.setBlockAndMetadataWithNotify(X, Y, Z + 1 + i, PorousID, content);
	    	}
	    	
	    	world.setBlockAndMetadataWithNotify(X, Y, Z + Length + 1, PorousID, Imperm);
	    
	    	for(int i = 0;i < Length;i ++)
	    	{
	    		world.setBlockAndMetadataWithNotify(X, Y, Z - 1 - i, PorousID, content);
	    	}
	    	
	    	world.setBlockAndMetadataWithNotify(X, Y, Z - Length - 1, PorousID, Imperm);
	    	
	    	world.setBlockAndMetadataWithNotify(X,Y,Z,PorousID,content);
	    
	    }
	    
	    private void GenVertLine(int X,int Y,int Z,World world,int length,int liquidLv,int liquid,int compHeight,int Mode)
	    {
	    	
	    	world.setBlockAndMetadata(X, Y, Z, PorousID, Imperm);
	    	
	    	for(int i = 1; i < length + 1; i ++)
	    	{
	    		world.setBlockAndMetadata(X, Y + i, Z, PorousID, isFilled(liquid,liquidLv,compHeight - i));
	    		
	    		if(world.getBlockId(X + 1, Y + i, Z) != PorousID && Mode == ModeX)
	    		{
	    			world.setBlockAndMetadataWithNotify(X + 1, Y + i, Z, PorousID, Imperm);
	    		}
	    		else if(world.getBlockId(X - 1, Y + i, Z) != PorousID && Mode == ModeX)
	    		{
	    			world.setBlockAndMetadataWithNotify(X - 1, Y + i, Z, PorousID, Imperm);
	    		}
	    		else if(world.getBlockId(X, Y + i, Z - 1) != PorousID && Mode == ModeZ)
	    		{
	    			world.setBlockAndMetadataWithNotify(X, Y + i, Z - 1, PorousID, Imperm);
	    		}
	    		else if(world.getBlockId(X, Y + i, Z + 1) != PorousID && Mode == ModeZ)
	    		{
	    			world.setBlockAndMetadataWithNotify(X, Y + i, Z + 1, PorousID, Imperm);
	    		}
	    	}	
	    	
	    	world.setBlockAndMetadata(X, Y + length + 1, Z, PorousID, Imperm);
	    }

	    private void GenSliceX(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height,int compHeight)
	    {
	    	// y = stretch(x - (xoffset))^2 + height vertex = (xoffset,height)
	    	
	    	double stretch = -0.125;
	    	float var1 = (float) Math.sqrt(-Height / stretch);
	    	int width = (int) ((X + var1) - (X - var1));
	    	int y;
	    	int buildWidth = (width-1)/2;
	    	
	    	if(width < 0){ width *= -1; } 
	    	
	    	y = (int) Height;
	    	GenVertLine(X,Y,Z,world,y,liquidLv,liquid,compHeight,ModeX);
	    	
	    	for(int x = X; x < X + buildWidth; x++)
	    	{
	    		y = (int) (stretch*(Math.pow(x - X, 2)) + Height);
		    	GenVertLine(x,Y,Z,world,y,liquidLv,liquid,compHeight,ModeX);
	    	}
	    	
	    	for(int x = X; x > X - buildWidth; x--)
	    	{
	    		y = (int) (stretch*(Math.pow(x - X, 2)) + Height);
	    		GenVertLine(x,Y,Z,world,y,liquidLv,liquid,compHeight,ModeX);
	    	}
	    	
	    }

	    private void GenSliceZ(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height,int compHeight)
	    {
	    	// y = stretch(x - (xoffset))^2 + height vertex = (xoffset,height)
	    	
	    	double stretch = -0.125;
	    	float var1 = (float) Math.sqrt(-Height / stretch);
	    	int width = (int) ((Z + var1) - (Z - var1));
	    	int y;
	    	int buildWidth = (width-1)/2;
	    	
	    	if(width < 0){ width *= -1; } 
	    	
	    	
	    	y = (int) Height;
	    	GenVertLine(X,Y,Z,world,y,liquidLv,liquid,compHeight,ModeZ);
	    	
	    	for(int z = Z; z < Z + buildWidth; z++)
	    	{
	    		y = (int) (stretch*(Math.pow(z - Z, 2)) + Height);
		    	GenVertLine(X,Y,z,world,y,liquidLv,liquid,compHeight,ModeZ);
	    	}
	    	
	    	for(int z = Z; z > Z - buildWidth; z--)
	    	{
	    		y = (int) (stretch*(Math.pow(z - Z, 2)) + Height);
	    		GenVertLine(X,Y,z,world,y,liquidLv,liquid,compHeight,ModeZ);
	    	}
	    	
	    }
	    
	    private void GenResivoirZ(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height)
	    {
// y = stretch(x - (xoffset))^2 + height vertex = (xoffset,height)
	    	
	    	double stretch = -0.125/4;
	    	float var1 = (float) Math.sqrt(-Height / stretch);
	    	int length = (int) ((X + var1) - (X - var1));
	    	int y;
	    	int buildLen = (length-1)/2;
	    	
	    	if(length < 0){ length *= -1; } 
	    	
	    	y = (int) Height;
	    	GenSliceX(X,Y,Z,world,liquid,liquidLv,y,Height);
	    	
	    	for(int z = Z; z < Z + buildLen; z++)
	    	{
	    		y = (int) (stretch*(Math.pow(z - Z, 2)) + Height);
	    		GenSliceX(X,Y,z,world,liquid,liquidLv,y,Height);
	    	}
	    	
	    	for(int z = Z; z > Z - buildLen; z--)
	    	{
	    		y = (int) (stretch*(Math.pow(z - Z, 2)) + Height);
	    		GenSliceX(X,Y,z,world,liquid,liquidLv,y,Height);
	    	}
	    }
	    
	    private void GenResivoirX(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height)
	    {
// y = stretch(x - (xoffset))^2 + height vertex = (xoffset,height)
	    	
	    	double stretch = -0.125/4;
	    	float var1 = (float) Math.sqrt(-Height / stretch);
	    	int length = (int) ((X + var1) - (X - var1));
	    	int y;
	    	int buildLen = (length-1)/2;
	    	
	    	if(length < 0){ length *= -1; } 
	    	
	    	
	    	y = (int) Height;
	    	GenSliceZ(X,Y,Z,world,liquid,liquidLv,y,Height);
	    	
	    	for(int x = X; x < X + buildLen; x++)
	    	{
	    		y = (int) (stretch*(Math.pow(x - X, 2)) + Height);
	    		GenSliceZ(x,Y,Z,world,liquid,liquidLv,y,Height);
	    	}
	    	
	    	for(int x = X; x > X - buildLen; x--)
	    	{
	    		y = (int) (stretch*(Math.pow(x - X, 2)) + Height);
	    		GenSliceZ(x,Y,Z,world,liquid,liquidLv,y,Height);
	    	}
	    }
}
	    
	    
	    
	
	
	
	

