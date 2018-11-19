package com.cocoapebbles.backpack;

import java.util.HashMap;

import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.cocoapebbles.backpack.commands.Backpack;
import com.cocoapebbles.backpack.events.player.PlayerJoin;
import com.cocoapebbles.backpack.events.player.PlayerQuit;
public class Main extends JavaPlugin implements Listener{

    public HashMap<String,Inventory> invMap;
    @Override
    public void onEnable(){
        registerCommands();
        registerEvents();
        registerConfig();
        invMap=new HashMap<String,Inventory>();
    }
    @Override
    public void onDisable(){}


    public void registerCommands(){
        getCommand("bp").setExecutor(new Backpack(this));
    }
    public void registerEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this),this);
    }
    public void registerConfig()
    {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    public void instantiateInventorys()
    {

    }
}
