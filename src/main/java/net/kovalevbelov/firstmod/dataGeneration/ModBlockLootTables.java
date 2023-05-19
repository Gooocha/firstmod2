package net.kovalevbelov.firstmod.dataGeneration;

import net.kovalevbelov.firstmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.awt.font.TextHitInfo;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        dropSelf(ModBlocks.NECRO_BLOCK.get());
        dropSelf(ModBlocks.NECRO_BLOCK_ORE.get());

        this.dropSelf(ModBlocks.NECRO_LOG.get());
        this.dropSelf(ModBlocks.NECRO_PLANKS.get());
        this.dropSelf(ModBlocks.NECRO_SAPLING.get());
        this.dropSelf(ModBlocks.NECRO_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_NECRO_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_NECRO_WOOD.get());

        this.add(ModBlocks.NECRO_LEAVES.get(), (block )->
                createLeavesDrops(block,ModBlocks.NECRO_LEAVES.get(),NORMAL_LEAVES_SAPLING_CHANCES));
    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
