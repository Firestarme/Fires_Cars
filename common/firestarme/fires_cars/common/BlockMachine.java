package firestarme.fires_cars.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockMachine extends Block{

	public BlockMachine(int par1, int par2) {
		super(par1, par2,Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
		this.setHardness(89.3F);
		this.setResistance(89.5F);
		this.setStepSound(soundMetalFootstep);
	}

	static String subNames[] = {"Drilling Derrik"};
	
	
	public static Block addBlock(int ID){
		
		Block block;
		block = (new BlockMachine(ID,0)).setHardness(5F).setResistance(2.0F).setBlockName("block_porousRock");
		Item.itemsList[ID] = new ItemBlockPorousRock(ID-256, block).setItemName("PorousRock");
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
		
		for (int i = 0; i < 1; i++) {
			ItemStack BlockStack = new ItemStack(block, 1, i);
			
			LanguageRegistry.addName(BlockStack,subNames[BlockStack.getItemDamage()]);
		}
			
		return block;
	}
	
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityMachine();
	
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }


    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
