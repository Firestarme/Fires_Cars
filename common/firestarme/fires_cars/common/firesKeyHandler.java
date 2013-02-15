package firestarme.fires_cars.common;


import java.util.EnumSet;

import org.lwjgl.input.Keyboard;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;

public class firesKeyHandler extends KeyHandler{
	
	public static int currentKey = 0;
	public static boolean Accelerate;
	public static boolean Brake;

	static KeyBinding KeyBind[] = { 
		new KeyBinding("Accelerate", Keyboard.KEY_C),
		new KeyBinding("Brake", Keyboard.KEY_Z)
		};

		
	
	public firesKeyHandler(KeyBinding[] keyBindings) {
		super(KeyBind,new boolean[]{false,false});
	}


	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
	
		switch(kb.keyCode)
		{
		case Keyboard.KEY_Z :
			Brake = true;
			break;
			
		case Keyboard.KEY_C :
			Accelerate = true;
			break;
		
		}
		
		
		
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		
		switch(kb.keyCode)
		{
		case Keyboard.KEY_Z :
			Brake = false;
			break;
			
		case Keyboard.KEY_C :
			Accelerate = false;
			break;
		
		}
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}
   

    
}


