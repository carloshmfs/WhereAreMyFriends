package dev.robott11;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhereAreMyFriends implements ModInitializer {
	public static final String MOD_ID = "wherearemyfriends";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static HashMap<UUID, Vec3> playersPosition = new HashMap<>();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
