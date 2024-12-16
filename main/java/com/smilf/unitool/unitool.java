package com.smilf.unitool;

import com.smilf.unitool.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



@Mod(unitool.MODID)
public class unitool {

    public static final String MODID = "unitool";


        public unitool() {
            var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            // Регистрация предметов
            ModItems.ITEMS.register(modEventBus);
        }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CreativeTabEvents {
        @SubscribeEvent
        public static void onAddCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
            if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                event.accept(ModItems.DIAMOND_MULTI_TOOL.get());
                event.accept(ModItems.UNLIMITED_MULTI_TOOL.get());
            }
        }
    }
}