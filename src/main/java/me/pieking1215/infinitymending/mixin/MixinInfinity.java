package me.pieking1215.infinitymending.mixin;

import net.minecraft.world.item.enchantment.ArrowInfiniteEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowInfiniteEnchantment.class)
public class MixinInfinity {
    @Inject(method = "checkCompatibility", at = @At("HEAD"), cancellable = true)
    public void injectCheckCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!(p_44590_ instanceof ArrowInfiniteEnchantment));
    }
}
