package com.christolis.ctrlclick;

import com.christolis.ctrlclick.listener.ClickListener;
import com.christolis.ctrlclick.listener.Listener;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for the LabyMod Addon
 *
 * @author Christolis
 */
public class CtrlClick extends LabyModAddon {

    public static boolean enabled;

    /** Keeps track of all the addon listeners */
    private static final ArrayList<Listener> listeners = new ArrayList<Listener>();

    static {
        listeners.add(new ClickListener());
    }

    /**
     * Called when the addon gets enabled
     */
    @Override
    public void onEnable() {
        for (Listener l : listeners) {
            getApi().registerForgeListener(l);
        }
    }

    /**
     * Called when this addon's config was loaded and is ready to use
     */
    @Override
    public void loadConfig() {
        enabled = !getConfig().has("enabled") || getConfig().get("enabled").getAsBoolean();
    }

    /**
     * Called when the addon's ingame settings should be filled
     *
     * @param list a list containing the addon's settings' elements
     */
    @Override
    protected void fillSettings(List<SettingsElement> list) {
        list.add(new BooleanElement(
                "Enabled",
                this,
                new ControlElement.IconData(Material.LEVER),
                "enabled",
                enabled));
    }
}
