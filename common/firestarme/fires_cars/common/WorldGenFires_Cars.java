package firestarme.fires_cars.common;

import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenFires_Cars implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		 {
		  switch (world.provider.dimensionId)
		  {
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		  }
		
		 }	
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		 
		int Xcoord1 = blockX + random.nextInt(16);
		  int Ycoord1 = random.nextInt(80);
		  int Zcoord1 = blockZ + random.nextInt(16);
		  
		   
		  (new WorldGenOilResivoir()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
