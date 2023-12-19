package org.lukadevrij.pingit;

import org.bukkit.plugin.java.JavaPlugin;
import org.lukadevrij.pingit.commands.PingItCommand;

public final class PingIt extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("pingit").setExecutor(new PingItCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
