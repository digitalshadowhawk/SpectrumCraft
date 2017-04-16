package com.shadowhawk.spectrum;

import org.apache.logging.log4j.Logger;

import com.shadowhawk.spectrum.proxy.CommonProxy;
import com.shadowhawk.spectrum.registry.ModBlocks;
import com.shadowhawk.spectrum.registry.ModItems;
import com.shadowhawk.spectrum.world.ModWorldGen;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SpectrumCraft.MODID, name = SpectrumCraft.MODNAME, version = SpectrumCraft.VERSION)
public class SpectrumCraft {
	
		public static boolean allowSpectriumGen = false;
	    public static final String
	            MODID = "spectrum",
	            MODNAME = "Spectrum Craft",
	            VERSION = "";

	    /** Custom Creative Tab */
	    public static final CreativeTabs modtab = new CreativeTabs("modtab") {
	        @Override
	        @MethodsReturnNonnullByDefault
	        public ItemStack getTabIconItem() {
	            return new ItemStack(ModItems.spectriumDust);
	        }
	    };

	    @Mod.Instance(value = SpectrumCraft.MODID)
	    public static SpectrumCraft instance;

	    @SidedProxy(clientSide = "com.shadowhawk.spectrum.proxy.ClientProxy", serverSide = "com.shadowhawk.spectrum.proxy.ServerProxy")
	    public static CommonProxy proxy;

	    public static Logger logger;

	    @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        logger = event.getModLog();
	        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

	        config.load();
	        
	        allowSpectriumGen = config.getBoolean("allowSpectriumGen", Configuration.CATEGORY_GENERAL, true, "Generates Spectrium Ore");
	        
	        config.save();

	        ModItems.preInit();
	        ModBlocks.preInit();

	        proxy.preInit(event);
	        GameRegistry.registerWorldGenerator(new ModWorldGen(allowSpectriumGen), 0);
	    }


	    @Mod.EventHandler
	    public void init(FMLInitializationEvent event) {
	        proxy.init(event);
	    }
	}
