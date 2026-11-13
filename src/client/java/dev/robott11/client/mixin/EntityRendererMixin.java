package dev.robott11.client.mixin;

import net.minecraft.client.renderer.entity.EntityRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

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
	private void cancelPoseStackTranslate(PoseStack poseStack, double x, double y, double z) {
        return;
	}
}
