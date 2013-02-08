package firestarme.fires_cars.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockTest extends Block{



	public BlockTest(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(89.3F);
		this.setResistance(89.5F);
		this.setStepSound(soundStoneFootstep);
		this.setTextureFile("firestarme.fires_cars.common.texture.png");
	}

	public static Block addBlock(int ID)
	{
		Block block;
		block = (new BlockTest(ID,0)).setHardness(5F).setResistance(2.0F).setBlockName("test");
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
			
			LanguageRegistry.addName(block,"test");
			GameRegistry.registerBlock(block);
		
	return block;	
	}
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer Player, int par6, float par7, float par8, float par9)
	{
		WorldGenOilResivoir instance = new WorldGenOilResivoir();
		
		instance.generate(world, null, par2, par3, par4);
		
		return true;
	}
	
	
	
	
	
	
}
