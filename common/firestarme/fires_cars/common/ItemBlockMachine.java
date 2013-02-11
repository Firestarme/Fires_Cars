package firestarme.fires_cars.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.World;

public class ItemBlockMachine extends ItemBlock {

	public ItemBlockMachine(int id,Block PorousRock) {
		super(id);
		setHasSubtypes(true);
		setItemName("Machine");
	}
	
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + BlockPorousRock.subNames[itemstack.getItemDamage()];
	}

}


