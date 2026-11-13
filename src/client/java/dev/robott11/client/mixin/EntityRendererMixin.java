package dev.robott11.client.mixin;

import net.minecraft.client.renderer.entity.EntityRenderer;

import org.joml.Quaternionf;
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
            target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"
        ),
        remap = false
    )
	private void cancelPoseStackScale(PoseStack poseStack, float x, float y, float z) {
        WhereAreMyFriends.LOGGER.info(String.format("%f %f %f", x, y, z));
	}

	@Redirect(
        method = "renderNameTag",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/blaze3d/vertex/PoseStack;mulPose(Lorg/joml/Quaternionf;)V"
        ),
        remap = false
    )
	private void cancelPoseStackMulPose(PoseStack poseStack, Quaternionf quaternionf) {
        WhereAreMyFriends.LOGGER.info("cancelPoseStackMulPose()");
	}
}
