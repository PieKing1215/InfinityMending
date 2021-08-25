package me.pieking1215.infinitymending;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.ArrowInfiniteEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;

public class CustomInfinityEnchantment extends ArrowInfiniteEnchantment {

    public CustomInfinityEnchantment(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, slots);
    }

    public boolean checkCompatibility(Enchantment ench) {
        // copy of Enchantment::checkCompatibility
        return this != ench;
    }
}
