package me.pieking1215.infinitymending;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ObjectHolder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    @ObjectHolder("minecraft:infinity")
    public static final Enchantment INFINITY = new CustomInfinityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND).setRegistryName("minecraft:infinity");

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(
            INFINITY
        );

        try{
            setFinalStatic(ObfuscationReflectionHelper.findField(Enchantments.class, "field_185312_x"), INFINITY); // override original INFINITY
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }

}
