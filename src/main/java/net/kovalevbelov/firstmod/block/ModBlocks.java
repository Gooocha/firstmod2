package net.kovalevbelov.firstmod.block;

import net.kovalevbelov.firstmod.Firstmod;
import net.kovalevbelov.firstmod.block.custom.ModFlammableRotatedPillarBlock;
import net.kovalevbelov.firstmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Firstmod.MOD_ID);
   public static final RegistryObject<Block> NECRO_BLOCK = registerBlock("necro_block",
           () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NECRO_BLOCK_ORE = registerBlock("necro_block_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN).destroyTime(1), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> NECRO_LOG = registerBlock("necro_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> NECRO_WOOD = registerBlock("necro_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> STRIPPED_NECRO_LOG = registerBlock("stripped_necro_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BAMBOO_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> STRIPPED_NECRO_WOOD = registerBlock("stripped_necro_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BAMBOO_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> NECRO_PLANKS = registerBlock("necro_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.CHAIN))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> NECRO_LEAVES = registerBlock("necro_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LEAVES )
                    .strength(5f).sound(SoundType.CHAIN)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Block> NECRO_SAPLING = registerBlock("necro_sapling",
            () -> new SaplingBlock(null,BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block >RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),
        new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
