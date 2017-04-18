package com.cocoapebbles.ScottsPluginHoe.events.block;




import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


import com.cocoapebbles.ScottsPluginHoe.Main;

public class BlockBreak implements Listener {
	Main plugin;
@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals("A flame-infused hoe"))
		 {
		Block block = event.getBlock();
	
		if (block.getType() == Material.POTATO) {
			Player player = event.getPlayer();
			int potatoes = 1;
			String thisname = "org.bukkit.craftbukkit.v1_11_R1.block.CraftBlockState@62695c0";
			if (block.getState().toString().equals(thisname)) {
				potatoes = (int) Math.ceil(Math.random() * 4);
			}

			block.setType(Material.AIR);
			Location blockLocation=block.getLocation();
			Location dirtLocation=block.getLocation();
			dirtLocation.setY(blockLocation.getY()-1);
			World world = player.getWorld();
			world.spawnParticle(Particle.LAVA, blockLocation,3);
			world.spawnParticle(Particle.FLAME, dirtLocation,1);
			world.playSound(blockLocation, Sound.ENTITY_GENERIC_BURN, 0.5f,0.6f);
			world.dropItem(blockLocation, new ItemStack(
					Material.BAKED_POTATO, potatoes));
		}

}}}


