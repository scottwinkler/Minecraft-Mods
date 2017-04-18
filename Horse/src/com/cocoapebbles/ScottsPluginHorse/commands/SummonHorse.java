package com.cocoapebbles.ScottsPluginHorse.commands;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class SummonHorse implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel,
			String[] args) {
		if(!(sender instanceof Player))
		{
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();
		if(player.isInsideVehicle()){player.leaveVehicle();}
		Entity entity = player.getWorld().spawnEntity(location, EntityType.HORSE);
		Horse horse = (Horse) entity;
		horse.setColor(Horse.Color.CREAMY);
		//horse.setVariant(Horse.Variant.HORSE);
		horse.setStyle(Horse.Style.WHITE);
		horse.setAdult();
		horse.setJumpStrength(0.7);
		horse.setTamed(true);
		horse.setVelocity(new Vector(0.4,0.4,0.4));
		ItemStack saddle = new ItemStack(Material.SADDLE);
		ItemMeta itemMeta = saddle.getItemMeta();
	    itemMeta.setDisplayName("Roach's Saddle");
	    saddle.setItemMeta(itemMeta);
		horse.getInventory().setSaddle(saddle);
		horse.setPassenger(player);
		horse.setCustomName("Roach");
		player.sendMessage(ChatColor.GREEN + "Roach appears!");
		player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE,player.getLocation(), 1);
		World world=player.getWorld();
		world.playSound(location, Sound.ENTITY_HORSE_GALLOP,3,1);
		return true;
		// TODO Auto-generated method stub
	}

	public SummonHorse(){};
}
