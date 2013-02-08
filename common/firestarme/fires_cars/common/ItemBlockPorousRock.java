package firestarme.fires_cars.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.World;

public class ItemBlockPorousRock extends ItemBlock {

	public ItemBlockPorousRock(int id,Block PorousRock) {
		super(id);
		setHasSubtypes(true);
		setItemName("PorousRock");
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


