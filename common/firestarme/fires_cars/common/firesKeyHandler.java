package firestarme.fires_cars.common;


import java.util.EnumSet;

import org.lwjgl.input.Keyboard;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;

public class firesKeyHandler extends KeyHandler{
	
	public static int currentKey = 0;

	static KeyBinding KeyBind[] = { 
		new KeyBinding("forward", Keyboard.KEY_W), 
		new KeyBinding("back", Keyboard.KEY_S),
		new KeyBinding("left", Keyboard.KEY_A),
		new KeyBinding("Right", Keyboard.KEY_D) 
		};

	
	public firesKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(KeyBind,new boolean[]{false});
	}



	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
	
		currentKey = kb.keyCode;
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		
		currentKey = 0;
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}
   

    
}


