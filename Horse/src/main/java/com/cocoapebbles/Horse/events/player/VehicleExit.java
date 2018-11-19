package com.cocoapebbles.Horse.events.player;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;



public class VehicleExit implements Listener {
    @EventHandler
    public void onVehicleExit(VehicleExitEvent event)
    {
        Vehicle v = event.getVehicle();
        if(!v.getName().equals("Roach")){return;}
        v.remove();
        Player player =(Player) event.getExited();
        player.sendMessage(ChatColor.AQUA+ "Roach disappears");
        World world=player.getWorld();
        world.playSound(player.getLocation(),Sound.ENTITY_HORSE_ANGRY, 3,1);
        world.spawnParticle(Particle.EXPLOSION_LARGE,player.getLocation(), 1);
    }
    public VehicleExit(){}
}
