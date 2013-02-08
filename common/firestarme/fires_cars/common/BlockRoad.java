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

	public class BlockRoad extends Block {
		
		private int textureArray[] = {1,3,4};
		private int meta = 0;
		private ItemStack brushStack;
		private Item brush = fires_carsMain.Brush;
		
		public BlockRoad(int par1, int par2){
			super(par1, par2, Material.rock);
			this.setCreativeTab(CreativeTabs.tabBlock);
			this.setRequiresSelfNotify();
			this.setHardness(89.3F);
			this.setResistance(89.5F);
			this.setStepSound(soundStoneFootstep);
			this.setTextureFile("firestarme.fires_cars.common.texture.png");
			
			
		}
		
		public String getTextureFile () {
			return fires_carsCommonProxy.Block_png;
		}
		
		public static Block addBlock(int ID){
			
			Block block;
			
			block = (new BlockRoad(200,0)).setHardness(5F).setResistance(2.0F).setBlockName("block_road");
			Item.itemsList[ID] = new ItemBlockRoad(ID-256, block).setItemName("Road");
			MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
			LanguageRegistry.addName(block,"Road");	
			
			return block;
		}
		
		
		public int getBlockTextureFromSideAndMetadata(int side,int meta)
	    {	
			int texture = 0;
			
			if(side == 1)
			{
			return textureArray[meta];
			}
			else if(side == 0)
			{
				texture = 2;
			}
			else
			{
				texture = 0;
			}
			return texture;	
		}
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer Player, int par6, float par7, float par8, float par9)
	{
	
		if(Player.getCurrentEquippedItem().getItem().shiftedIndex == fires_carsMain.Brush.shiftedIndex)
		{
		meta = meta +1;
		if(meta == 3){meta = 0;}	
		world.setBlockMetadataWithNotify(par2, par3, par4,meta);
		return true;
		}
		else
		{
		return false;
		}
	}
	}