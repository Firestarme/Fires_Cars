package firestarme.fires_cars.common;

	import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;

	public class BlockPorousRock extends Block {
		
		private int meta = 0;
		
		public BlockPorousRock(int par1, int par2){
			super(par1, par2, Material.rock);
			this.setCreativeTab(CreativeTabs.tabBlock);
			this.setRequiresSelfNotify();
			this.setHardness(89.3F);
			this.setResistance(89.5F);
			this.setStepSound(soundStoneFootstep);
			this.setTextureFile("firestarme.fires_cars.common.texture.png");
			
			
		}
		
		final static String[] subNames = {
			"Porous Rock", "Oil Reservior",  "Brine Aquifyer", "Impermiable Rock"
		};
		
		public String getTextureFile () {
			return fires_carsCommonProxy.Block_png;
		}
		
		
		public int getBlockTextureFromSideAndMetadata(int side,int meta)
	    {	
		return meta + 5;
		}
	
		@SideOnly(Side.CLIENT)
	    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	    {
	        for (int var4 = 0; var4 < 4; ++var4)
	        {
	            par3List.add(new ItemStack(par1, 1, var4));
	        }
	    }
		
public static Block addBlock(int ID){
			
			Block block;
			block = (new BlockPorousRock(ID,0)).setHardness(5F).setResistance(2.0F).setBlockName("block_porousRock");
			Item.itemsList[ID] = new ItemBlockPorousRock(ID-256, block).setItemName("PorousRock");
			MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
			
			for (int i = 0; i < 4; i++) {
				ItemStack BlockStack = new ItemStack(block, 1, i);
				
				LanguageRegistry.addName(BlockStack,subNames[BlockStack.getItemDamage()]);
			}
				
			return block;
		}
		
	
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
}