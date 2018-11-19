package com.cocoapebbles.Horse;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.cocoapebbles.Horse.commands.SummonHorse;
import com.cocoapebbles.Horse.events.inventory.InventoryClick;
import com.cocoapebbles.Horse.events.player.VehicleExit;
public class Main extends JavaPlugin implements Listener{


    @Override
    public void onEnable(){
        registerCommands();
        registerEvents();
        registerConfig();
    }
    @Override
    public void onDisable(){}


    public void registerCommands(){
        getCommand("horse").setExecutor(new SummonHorse());
    }
    public void registerEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new VehicleExit(), this);
        pm.registerEvents(new InventoryClick(),this);
    }
    public void registerConfig()
    {
    }
}
