package org.tlesis.squakeplusplus.event;

import fi.dy.masa.malilib.interfaces.IWorldLoadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.tlesis.squakeplusplus.data.DataManager;

public class WorldLoadListener implements IWorldLoadListener {
    
    @Override
    public void onWorldLoadPre(ClientWorld worldBefore, ClientWorld worldAfter, MinecraftClient mc) {
        // Save the settings before the integrated server gets shut down
        if (worldBefore != null) {
            DataManager.save();
        }
    }

    @Override
    public void onWorldLoadPost(ClientWorld worldBefore, ClientWorld worldAfter, MinecraftClient mc) {

        if (worldAfter != null) {
            DataManager.load();
        } else {
            DataManager.clear();
        }
    }
}
