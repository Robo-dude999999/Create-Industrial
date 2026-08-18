package net.mcreator.createindustrial.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.createindustrial.world.inventory.ControlledSlotInserterGUIMenu;
import net.mcreator.createindustrial.init.CreateIndustrialModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ControlledSlotInserterGUIScreen extends AbstractContainerScreen<ControlledSlotInserterGUIMenu> implements CreateIndustrialModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox num;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("create_industrial:textures/screens/controlled_slot_inserter_gui.png");

	public ControlledSlotInserterGUIScreen(ControlledSlotInserterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 138;
		this.imageHeight = 47;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("num"))
				num.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		num.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (num.isFocused())
			return num.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String numValue = num.getValue();
		super.resize(minecraft, width, height);
		num.setValue(numValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.create_industrial.controlled_slot_inserter_gui.label_slot_id_to_insert_into"), 8, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		num = new EditBox(this.font, this.leftPos + 10, this.topPos + 20, 118, 18, Component.translatable("gui.create_industrial.controlled_slot_inserter_gui.num"));
		num.setMaxLength(8192);
		num.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "num", content, false);
		});
		num.setHint(Component.translatable("gui.create_industrial.controlled_slot_inserter_gui.num"));
		this.addWidget(this.num);
	}
}