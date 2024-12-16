package com.smilf.unitool.items;

import com.smilf.unitool.ItemConfig.MultiToolItemDiamond;
import com.smilf.unitool.ItemConfig.MultiToolItemUnlimited;
import com.smilf.unitool.unitool;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Регистрация предметов
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, unitool.MODID);

    // Регистрация первого мультиинструмента
    public static final RegistryObject<Item> DIAMOND_MULTI_TOOL = ITEMS.register("diamond_multi_tool",
            () -> new MultiToolItemDiamond(Tiers.DIAMOND, 6, -2.8F, new Item.Properties().stacksTo(1).durability(1561)));

    // Регистрация второго мультиинструмента (если нужен)
    public static final RegistryObject<Item> UNLIMITED_MULTI_TOOL = ITEMS.register("unlimited_multi_tool",
            () -> new MultiToolItemUnlimited(Tiers.NETHERITE, 10, -2.5F, new Item.Properties().stacksTo(1).durability(5031)));
}