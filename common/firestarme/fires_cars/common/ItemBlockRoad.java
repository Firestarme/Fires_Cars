package firestarme.fires_cars.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.World;

public class ItemBlockRoad extends ItemBlock {

	public ItemBlockRoad(int par1, Block road) {
		super(par1);
		 this.setHasSubtypes(true);
		 this.setCreativeTab(CreativeTabs.tabBlock);
	 }
	
	
	 public String getItemNameIS(ItemStack itemstack) 
	 {
	  return getItemName() + ".Road";
	 }
	 
	 public int getMetadata(int par1)
	    {
	        return par1;
	    }
	
}


