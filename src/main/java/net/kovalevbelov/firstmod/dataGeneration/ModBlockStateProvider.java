package net.kovalevbelov.firstmod.dataGeneration;

import net.kovalevbelov.firstmod.Firstmod;
import net.kovalevbelov.firstmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider  {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Firstmod.MOD_ID,  exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockWithItem(ModBlocks.NECRO_BLOCK_ORE);
        BlockWithItem(ModBlocks.NECRO_BLOCK);
        BlockWithItem(ModBlocks.NECRO_PLANKS);
        BlockWithItem(ModBlocks.NECRO_LEAVES);

        simpleBlockItem(ModBlocks.NECRO_LOG.get(), models().withExistingParent("firstomd:necro_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.NECRO_WOOD.get(), models().withExistingParent("firstomd:necro_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_NECRO_LOG.get(), models().withExistingParent("firstomd:stripped_necro_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_NECRO_WOOD.get(), models().withExistingParent("firstomd:stripped_necro_wood", "minecraft:block/cube_column"));

        logBlock(((RotatedPillarBlock) ModBlocks.NECRO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.NECRO_WOOD.get(),blockTexture(ModBlocks.NECRO_LOG.get()),blockTexture(ModBlocks.NECRO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_NECRO_WOOD.get(), new ResourceLocation(Firstmod.MOD_ID,"block/stripped_necro_log"),
                new ResourceLocation(Firstmod.MOD_ID,"block/stripped_necro_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_NECRO_WOOD.get(), new ResourceLocation(Firstmod.MOD_ID,"block/stripped_necro_log"),
                new ResourceLocation(Firstmod.MOD_ID,"block/stripped_necro_log"));
    }

    private void BlockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));

    }
}
