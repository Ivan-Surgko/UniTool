package com.smilf.unitool.ItemConfig;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;

public class MultiToolItemDiamond extends PickaxeItem {

    public MultiToolItemDiamond(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState blockState) {
        Block block = blockState.getBlock();
        // Проверка для блоков, которые можно добывать
        return super.isCorrectToolForDrops(stack, blockState) ||
                blockState.is(BlockTags.DIRT) || // Земля
                blockState.is(BlockTags.SAND) || // Песок
                blockState.is(BlockTags.LOGS) || // Дерево (ствол)
                block.equals(Blocks.CRAFTING_TABLE); // Верстак
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        // Устанавливаем скорость разрушения для различных блоков
        if (state.is(BlockTags.DIRT) || state.is(BlockTags.SAND)) {
            return 10.0F;
        } else if (state.is(BlockTags.LOGS) || state.is(BlockTags.PLANKS) || state.is(BlockTags.FENCES) ||
                state.is(BlockTags.FENCE_GATES) || state.is(BlockTags.DOORS) || state.is(BlockTags.TRAPDOORS) ||
                state.is(BlockTags.SLABS) || state.is(Blocks.CRAFTING_TABLE)) {
            return 12.0F; // Деревянные блоки и верстак
        } else if (state.is(Blocks.STONE) || state.is(Blocks.COBBLESTONE) || state.is(Blocks.DIAMOND_ORE)) {
            return 15.0F; // Каменные блоки
        }
        return super.getDestroySpeed(stack, state);
    }
}