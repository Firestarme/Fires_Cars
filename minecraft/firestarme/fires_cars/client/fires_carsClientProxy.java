package firestarme.fires_cars.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import firestarme.fires_cars.common.RenderMachine;
import firestarme.fires_cars.common.TileEntityMachine;
import firestarme.fires_cars.common.fires_carsCommonProxy;

public class fires_carsClientProxy extends fires_carsCommonProxy {

	public static String Block_png = ("/firestarme/fires_cars/block.png");
	public static String Item_png = ("/firestarme/fires_cars/items.png");
	
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(Block_png);
		MinecraftForgeClient.preloadTexture(Item_png);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachine.class, new RenderMachine());
	}

	


}

	

