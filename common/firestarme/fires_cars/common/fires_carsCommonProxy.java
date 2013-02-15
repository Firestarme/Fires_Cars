package firestarme.fires_cars.common;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import net.minecraft.src.KeyBinding;

public class fires_carsCommonProxy {

	public static String Block_png = ("/firestarme/fires_cars/block.png");
	public static String Item_png = ("/firestarme/fires_cars/items.png");
	
	public void registerRenderers()
	{
		//server side, no renderer
		
	}
	
	public static void registerKeyBindingHandler()
	 {
	  KeyBinding[] keybind = new KeyBinding[]{};
	  KeyBindingRegistry.registerKeyBinding(new firesKeyHandler(keybind));
	 }
}
