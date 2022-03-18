package me.gerald.hack.gui.ogGUI.oldComps.settings;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gerald.hack.GeraldHack;
import me.gerald.hack.gui.api.SettingComponent;
import me.gerald.hack.module.Module;
import me.gerald.hack.module.modules.client.ClickGui;
import me.gerald.hack.module.modules.client.Description;
import me.gerald.hack.setting.settings.BoolSetting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class OldBoolComponent extends SettingComponent {
    public Module module;
    public BoolSetting setting;

    public OldBoolComponent(Module module, BoolSetting setting, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.module = module;
        this.setting = setting;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x, y, x + width, y + height + 1, new Color((int) GeraldHack.INSTANCE.moduleManager.getModule(ClickGui.class).color.getR(), (int) GeraldHack.INSTANCE.moduleManager.getModule(ClickGui.class).color.getG(), (int) GeraldHack.INSTANCE.moduleManager.getModule(ClickGui.class).color.getB()).getRGB());
        Gui.drawRect(x + 1, y, x + width - 1, y + height, isInside(mouseX, mouseY) ? new Color(30, 30, 30, 240).getRGB() : new Color(15, 15, 15, 240).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(setting.getName() + " " + ChatFormatting.GRAY + (setting.getValue() ? "True" : "False"), x + 5, y + 2, module.isEnabled() ? -1 : isInside(mouseX, mouseY) ? new Color(160, 160, 160).getRGB() : new Color(130, 130, 130).getRGB());
        if(isInside(mouseX, mouseY)) {
            GeraldHack.INSTANCE.moduleManager.getModule(Description.class).setName("A boolean setting.");
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if(isInside(mouseX, mouseY)) {
            setting.cycle();
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) { }

    @Override
    public void keyTyped(char keyChar, int key) { }

    @Override
    public int getHeight() {
        return height;
    }
}
