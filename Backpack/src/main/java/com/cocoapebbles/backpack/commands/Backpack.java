package com.cocoapebbles.backpack.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.cocoapebbles.backpack.Main;

public class Backpack implements CommandExecutor {
    private Main plugin;
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel,
                             String[] args) {
        if(!(sender instanceof Player))
        {
            sender.sendMessage("You must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        String name = player.getUniqueId().toString();
        Inventory inventory = (Inventory) plugin.invMap.get(name);
        player.openInventory(inventory);
        player.sendMessage(ChatColor.AQUA + "Backpack mode activated!");
        return true;
        // TODO Auto-generated method stub
    }

    public Backpack(Main pl){plugin=pl;};
}
