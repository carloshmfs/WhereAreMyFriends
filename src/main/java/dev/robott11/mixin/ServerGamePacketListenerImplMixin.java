package dev.robott11.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.robott11.WhereAreMyFriends;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @Shadow
    private ServerPlayer player;

	@Inject(at = @At("TAIL"), method = "tick")
	private void onTick(CallbackInfo info) {
        UUID playerUUID = this.player.getUUID();
        Vec3 playerPos = this.player.position();
        WhereAreMyFriends.playersPosition.put(playerUUID, playerPos);
	}
}
