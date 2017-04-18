package com.cocoapebbles.ScottsPluginHoe.events.inventory;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class PrepareAnvil implements Listener {
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent event) {
		AnvilInventory anvilInv = (AnvilInventory) event.getInventory();
		// first check if there is a diamond hoe present
		if (anvilInv.contains(Material.DIAMOND_HOE)) {

			Player player = (Player) event.getViewers().get(0);
			// check next if anvil contains fire_aspect II book

			ItemStack[] contents = anvilInv.getContents();
			player.sendMessage(anvilInv.getTitle().toString());
			player.sendMessage(anvilInv.getName().toString());
			if (contents.length >= 2) {
				ItemStack hoe = contents[0];
				ItemStack book = contents[1];
				if (book.getType().toString() == "ENCHANTED_BOOK") {
					EnchantmentStorageMeta anvilitem_meta = (EnchantmentStorageMeta) book
							.getItemMeta();
					if (anvilitem_meta
							.hasStoredEnchant(Enchantment.FIRE_ASPECT)) {
						int enchant_level = anvilitem_meta
								.getStoredEnchantLevel(Enchantment.FIRE_ASPECT);

						player.sendMessage("Book initial");
						// check hoe now
						if (hoe.getType().toString() == "DIAMOND_HOE") {
							if (!hoe.getItemMeta().hasEnchants()) {
								player.sendMessage("hoe_flag set to true");
								ItemStack item = new ItemStack(
										Material.DIAMOND_HOE);
								ItemMeta itemMeta = item.getItemMeta();
								ArrayList<String> my_lore = new ArrayList<String>();
								my_lore.add("A flame-infused hoe");
								itemMeta.setLore(my_lore);
								itemMeta.setDisplayName("Hoe of Hellfire");
								item.setItemMeta(itemMeta);
								item.addUnsafeEnchantment(
										Enchantment.FIRE_ASPECT, enchant_level);

								event.setResult(item);
							}

						}

					}
				}

			}
		}
	}
}
