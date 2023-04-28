package main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public static final Main instance = getPlugin(Main.class);
    private final List<Listener> listeners = new ArrayList<>();
    QS qs;

    @Override
    public void onLoad() {
        qs = new QS(instance);
        qs.onLoad();
        super.onLoad();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        for(Listener l : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(l, this);
        }
        qs.onEnable();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        qs.onDisable();
        super.onDisable();
    }

    public void registerListeners(Listener l) {
        listeners.add(l);
    }
}
