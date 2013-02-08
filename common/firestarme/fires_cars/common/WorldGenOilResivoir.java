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
	    
	    
	    GenSliceX(X,Y,Z,world,Oil,8,6,9);
	    
	    
	    
	    
	    
	    
	    
	    return true;
	    } 
	    
	    public int isFilled(int liquid,int liquidLv,int Y)
	    {
	    	int block;
	    	
	    	if(Y > liquidLv)
	    	{
	    		block = liquid;
	    	}
	    	else
	    	{
	    		block = Porous;
	    	}
	    	
	    	return block;
	    }
	    
	    public void GenKeyLineX(int X,int Y,int Z,World world,int Length,int content)
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
	    
	    public void GenKeyLineZ(int X,int Y,int Z,World world,int Length,int content)
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

	    public void GenSliceX(int X,int Y,int Z,World world,int liquid,int liquidLv,int Height,int Width)
	    {
	    	
	    	int SegmentHeight = Height / 3;
	    	int BuildY = Height + Y;
	    	int count = 0;
	    	int TopWidth = (1/2)*SegmentHeight+1*SegmentHeight+2*SegmentHeight;
	    	int buildWidth = TopWidth;
	    	
	    	GenKeyLineX(X,BuildY,Z,world,TopWidth,Imperm);
		    
		    BuildY --;
		    
		    for(;BuildY > 2*SegmentHeight;BuildY--)
		    {
		    	buildWidth += 2;
		    	GenKeyLineX(X,BuildY,Z,world,buildWidth-1,isFilled(liquid,liquidLv,BuildY));
		    	world.setBlockAndMetadataWithNotify(X+buildWidth, BuildY, Z, PorousID, Imperm);
		    	world.setBlockAndMetadataWithNotify(X-buildWidth, BuildY, Z, PorousID, Imperm);
		    }
	    	
		    for(;BuildY > SegmentHeight;BuildY--)
		    {
		    	buildWidth ++ ;
		    	GenKeyLineX(X,BuildY,Z,world,buildWidth,isFilled(liquid,liquidLv,BuildY));
		    }
		    
		    for(;BuildY > Y;BuildY--)
		    {
		    	GenKeyLineX(X,BuildY,Z,world,buildWidth,isFilled(liquid,liquidLv,BuildY));
		    	count ++;
		    	if(count == 2){
		    		count = 0;
		    		buildWidth ++ ;
		    	}
		    }
	    }


}
	    
	    
	    
	
	
	
	

