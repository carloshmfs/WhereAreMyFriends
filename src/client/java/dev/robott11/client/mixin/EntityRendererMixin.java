package dev.robott11.client.mixin;

import net.minecraft.client.renderer.entity.EntityRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import dev.robott11.WhereAreMyFriends;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @ModifyVariable(
        method = "renderNameTag",
        at = @At(value = "STORE"),
        ordinal = 0
    )
    private boolean overwriteDiscrete(boolean isNotDiscrete) {
        return true;
    }
}
