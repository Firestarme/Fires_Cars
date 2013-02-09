package firestarme.fires_cars.common;

import java.util.List;

import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Render;
import net.minecraft.src.TileEntity;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.WorldProvider;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "Fire1", name = "Fire's cars", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class fires_carsMain extends BaseMod{
		
		@Instance("tutorial")
		public static fires_carsMain instance;
		
		@SidedProxy(clientSide="firestarme.fires_cars.client.fires_carsClientProxy", serverSide="firestarme.fires_cars.common.CommonProxy")
		public static fires_carsCommonProxy proxy;
		public Object main = this;
		public BaseMod firesCars = this;
		public static int RoadID = 200;
		public static int BrushID = 1000;
		public static int porousRockID = 201;
		public static int CarID = 1001;
		public static int TestID = 202;
		public static Block Road;
		public static Block Test;
		public static Item Brush;
		public static Item Car;
		public static Render carR = new RenderCar();
		public static Block pourousRock;
		@PreInit
		public void preInit(FMLPreInitializationEvent event) {
			
		}

		@Init
		public void init(FMLInitializationEvent event) {
			
		Road = BlockRoad.addBlock(RoadID);
		
		pourousRock = BlockPorousRock.addBlock(porousRockID);
		
		Test = BlockTest.addBlock(TestID);
		
		Brush = (new ItemBrush(BrushID,0)).setItemName("paint brush");
		LanguageRegistry.addName(Brush, "Paint Brush");
		Item.itemsList[BrushID] = Brush;
		
		EntityRegistry.registerModEntity(EntityCar.class, "car", 1,main, 80, 3, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityCar.class, carR);
		
		Car = (new ItemCar(CarID)).setItemName("ItemCar");
		LanguageRegistry.addName(Car, "Car");
		Item.itemsList[CarID] = Car;
		
		GameRegistry.registerWorldGenerator(new WorldGenFires_Cars());
		
		
		}
		

		@PostInit
		public static void postInit(FMLPostInitializationEvent event) {
		
		}

		@Override
		public String getVersion() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void load() {
			// TODO Auto-generated method stub
		}
	}

