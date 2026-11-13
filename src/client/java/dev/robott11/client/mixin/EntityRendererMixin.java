package dev.robott11.client.mixin;

import net.minecraft.client.renderer.entity.EntityRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import dev.robott11.WhereAreMyFriends;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
	@Redirect(
        method = "renderNameTag",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V"
        ),
        remap = false
    )
	private void renderNameTagOverwrite(PoseStack poseStack, double x, double y, double z) {
        WhereAreMyFriends.LOGGER.info("renderNameTage()");
	}
}
