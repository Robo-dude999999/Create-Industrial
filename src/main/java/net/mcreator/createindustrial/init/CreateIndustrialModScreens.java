/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.createindustrial.client.gui.SealedVaccumChamberGUIScreen;
import net.mcreator.createindustrial.client.gui.ControlledSlotInserterGUIScreen;
import net.mcreator.createindustrial.client.gui.ControlledSlotExporterGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class CreateIndustrialModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(CreateIndustrialModMenus.SEALED_VACCUM_CHAMBER_GUI.get(), SealedVaccumChamberGUIScreen::new);
		event.register(CreateIndustrialModMenus.CONTROLLED_SLOT_INSERTER_GUI.get(), ControlledSlotInserterGUIScreen::new);
		event.register(CreateIndustrialModMenus.CONTROLLED_SLOT_EXPORTER_GUI.get(), ControlledSlotExporterGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}