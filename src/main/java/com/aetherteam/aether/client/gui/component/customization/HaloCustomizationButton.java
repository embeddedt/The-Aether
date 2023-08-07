package com.aetherteam.aether.client.gui.component.customization;

import com.aetherteam.aether.client.gui.screen.perks.AetherCustomizationsScreen;
import com.aetherteam.aether.perk.CustomizationsOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class HaloCustomizationButton extends CustomizationButton {
    public HaloCustomizationButton(AetherCustomizationsScreen screen, ButtonType buttonType, ColorBox colorBox, int x, int y, int width, int height, int xTexStart, int yTexStart, int yDiffTex, ResourceLocation texture, int textureWidth, int textureHeight, OnPress onPress, Component message) {
        super(screen, buttonType, colorBox, x, y, width, height, xTexStart, yTexStart, yDiffTex, texture, textureWidth, textureHeight, onPress, message);
    }

    /**
     * If this is a save button, it will only be active if the color input is valid and has changed, or if the display option has changed.<br>
     * If this is an undo button, it will be active if the text has changed or the display option has changed.
     * @return The {@link Boolean} result.
     */
    @Override
    public boolean isActive() {
        if (this.buttonType == ButtonType.SAVE) {
            return super.isActive() && ((this.colorBox.hasValidColor() && this.colorBox.hasTextChanged()) || (this.screen.haloEnabled != CustomizationsOptions.INSTANCE.isHaloEnabled()));
        } else {
            return super.isActive() && (this.colorBox.hasTextChanged() || (this.screen.haloEnabled != CustomizationsOptions.INSTANCE.isHaloEnabled()));
        }
    }
}
