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
	
	

	    public boolean generate(World world, Random par2Random, int X, int Y, int Z)
	    {
	        while (world.isAirBlock(X, Y, Z) && Y > 2)
	        {
	            --Y;
	        }
	    
	    
	    int BuildX = X;
	    int BuildY = 1;
	    int BuildZ = Z;
	    int Length = 10;
	    
	    
	    //GenSliceX(X,Y,Z,world,Oil,8,6,9);
	    GenVertLine(X,Y,Z,world,10,2,Brine);
	    
	    
	    
	    
	    
	    
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
	    
	    private void GenVertLine(int X,int Y,int Z,World world,int length,int liquidLv,int liquid)
	    {
	    	
	    	world.setBlockAndMetadataWithNotify(X, Y, Z, PorousID, Imperm);
	    	
	    	for(int i = 1; i < length + 1; i ++)
	    	{
	    		world.setBlockAndMetadataWithNotify(X, Y + i, Z, PorousID, isFilled(liquid,liquidLv,length - i));
	    	}	
	    	
	    	world.setBlockAndMetadataWithNotify(X, Y + length + 1, Z, PorousID, Imperm);
	    }

	    public void GenSliceX(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height,int Width)
	    {
	    	int HeightSegment = Height / 4;
	    	
	    	for(int i = 0; i < Width / 2; i ++ )
	    	{
	    		
	    		
	    		
	    	}
	    	
	    }

}
	    
	    
	    
	
	
	
	

