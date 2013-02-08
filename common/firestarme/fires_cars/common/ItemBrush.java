package firestarme.fires_cars.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemBrush extends Item {

	public ItemBrush(int par1,int par2) {
		super(par1);
		this.setIconIndex(par2);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureFile("firestarme/fires_cars/items.png");
		this.setFull3D();
		
	}
	
	
	public String getTextureFile () {
		return fires_carsCommonProxy.Item_png;
	}
}
