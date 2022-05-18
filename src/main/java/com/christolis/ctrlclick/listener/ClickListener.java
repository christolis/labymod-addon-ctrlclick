package com.christolis.ctrlclick.listener;

import com.christolis.ctrlclick.CtrlClick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

/**
 * @author Christolis
 */
public class ClickListener extends Listener {

    /**
     * Called when a user uses a mouse button and
     * has the client window focused. Used on this
     * listener to simulate a right-click whenever
     * a certain input combination is activated.
     *
     * @param event An instance of the event
     */
    @SubscribeEvent
    public void onClick(InputEvent.MouseInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        GameSettings gs = mc.gameSettings;

        // If LCTRL + LMB is being pressed
        if (gs.keyBindAttack.isPressed() && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            if (!CtrlClick.enabled) return;
            KeyBinding.onTick(mc.gameSettings.keyBindUseItem.getKeyCode());
        }
    }
}
