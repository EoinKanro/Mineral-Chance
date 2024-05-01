package com.natamus.mineralchance;

import com.natamus.collective.check.RegisterMod;
import com.natamus.mineralchance.events.MiningEvent;
import com.natamus.mineralchance.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			MiningEvent.onBlockBreak(world, player, pos, state, entity);
		});
	}

	private static void setGlobalConstants() {

	}
}
