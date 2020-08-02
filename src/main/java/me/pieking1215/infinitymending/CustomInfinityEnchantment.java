package me.pieking1215.infinitymending;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class CustomInfinityEnchantment extends InfinityEnchantment {

    public CustomInfinityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, slots);
    }

    public boolean canApplyTogether(Enchantment ench) {
        // copy of Enchantment::canApplyTogether
        return this != ench;
    }
}
