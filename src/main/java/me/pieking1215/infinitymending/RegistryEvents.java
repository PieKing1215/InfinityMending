package me.pieking1215.infinitymending;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ObjectHolder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    @ObjectHolder("minecraft:infinity")
    public static final Enchantment INFINITY = new CustomInfinityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND).setRegistryName("minecraft:infinity");

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(
            INFINITY
        );

        try{
            setFinalStatic(ObfuscationReflectionHelper.findField(Enchantments.class, "f_44952_"), INFINITY); // override original INFINITY
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
