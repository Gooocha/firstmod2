package net.kovalevbelov.firstmod.item;

import com.mojang.blaze3d.shaders.Effect;
import com.mojang.datafixers.util.Pair;
import cpw.mods.modlauncher.EnumerationHelper;
import net.kovalevbelov.firstmod.Firstmod;
import net.kovalevbelov.firstmod.basicinfo.ModArmorMaterials;
import net.minecraft.client.AttackIndicatorStatus;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Tiers.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Firstmod.MOD_ID);
    //  public static final FoodProperties BREAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
    public static final RegistryObject<Item> PIZDUN_MEAT = ITEMS.register("pizdun_meat",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.6F)
                    .build())));
    public static final RegistryObject<Item> NECRO_SWORD = ITEMS.register("necro_sword",
            () -> new SwordItem(DIAMOND, 15, 4.0f, new Item.Properties()));
    public static final RegistryObject<Item> NECRO_HELMET = ITEMS.register("necro_helmet",
            () -> new ArmorItem(ArmorTiers.NECRO ,EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> NECRO_BOOTS = ITEMS.register("necro_boots",
            () -> new ArmorItem(ArmorTiers.NECRO ,EquipmentSlot.FEET, new Item.Properties()));
    public static final RegistryObject<Item> NECRO_CHESTPLATE = ITEMS.register("necro_chestplate",
            () -> new ArmorItem(ArmorTiers.NECRO ,EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> NECRO_LEGGINS = ITEMS.register("necro_leggins",
            () -> new ArmorItem(ArmorTiers.NECRO ,EquipmentSlot.LEGS, new Item.Properties()));


    public static final RegistryObject<Item> NECRO_ORE = ITEMS.register("necro_ore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NECRO_INGOT = ITEMS.register("necro_ingot",
            () -> new Item(new Item.Properties()));
    public static class ArmorTiers{
        public static final ArmorMaterial NECRO = new ModArmorMaterials(
            "NECRO",
                new int[]{ 20,30,40,15},
                300,
                SoundEvents.BAT_LOOP,
                0.0f,
                0.0f,
                () -> Ingredient.of(ModItems.NECRO_INGOT.get())


        );
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
