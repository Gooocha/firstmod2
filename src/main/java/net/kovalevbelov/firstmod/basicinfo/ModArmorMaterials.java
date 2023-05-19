package net.kovalevbelov.firstmod.basicinfo;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public record ModArmorMaterials(String name, int[] protection, int enchantability, SoundEvent equipSound, float toughness, float knockResistance, Supplier<Ingredient> repairMaterial)implements ArmorMaterial {
    private static final int[] DURABILITY_PER_HEALTH = new int[]{15,15,15,15};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return 0;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex() ];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {

        return "armor";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
