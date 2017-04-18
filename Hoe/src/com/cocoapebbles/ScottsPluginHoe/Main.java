package com.cocoapebbles.ScottsPluginHoe;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.cocoapebbles.ScottsPluginHoe.commands.CreateHoe;
import com.cocoapebbles.ScottsPluginHoe.events.block.BlockBreak;
import com.cocoapebbles.ScottsPluginHoe.events.inventory.PrepareAnvil;
public class Main extends JavaPlugin implements Listener{


	@Override
	public void onEnable(){
		registerCommands();
		registerEvents();
		registerConfig();
		registerCrafting();
	}
	@Override
	public void onDisable(){}
	

	public void registerCommands(){
		getCommand("hoe").setExecutor(new CreateHoe());
	}
	public void registerEvents()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PrepareAnvil(),this);
	}
	public void registerConfig()
	{
	}
	public void registerCrafting()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta itemMeta=item.getItemMeta();
		ArrayList<String> my_lore=new ArrayList<String>();
		my_lore.add("Flame-infused Hoe");
		itemMeta.setLore(my_lore);
		item.setItemMeta(itemMeta);
		item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		ShapelessRecipe recipe = new ShapelessRecipe(item);
		recipe.addIngredient(Material.DIAMOND_HOE);
		recipe.addIngredient(Material.BLAZE_POWDER);
		Bukkit.addRecipe(recipe);
	}
}
