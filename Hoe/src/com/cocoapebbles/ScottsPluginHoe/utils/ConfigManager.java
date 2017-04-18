package com.cocoapebbles.ScottsPluginHoe.utils;

import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.cocoapebbles.ScottsPluginHoe.Main;


public class ConfigManager {
private Main plugin;
private Player p;
private FileConfiguration fc;
private File file;

	public ConfigManager(Main plugin, Player p) {
		this.plugin = plugin;
		this.p = p;
	}

	public Player getOwner() {
		if (p == null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				plugin.getLogger().warning("Err Player is Null!");
				e.printStackTrace();
			}

		}
		return p;

	}
	public File getFile()
	{
		if(file==null)
		{
			file=new File(getDataFolder(),getOwner().getUniqueId().toString()+".yml");
			if(!file.exists()){
				try{
					file.createNewFile();
				}catch(IOException e){e.printStackTrace();}
			}
		}
		return file;
	}
	public FileConfiguration getConfig()
	{
		if(fc==null)
		{
			fc=YamlConfiguration.loadConfiguration(getFile());
		}
		return fc;
	}
	
	public File getDataFolder()
	{
		File dir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("%20", " "));
		File d = new File(dir.getParentFile().getPath(),plugin.getName());
		if(!d.exists()){d.mkdirs();}
		return d;
	}
	public boolean exists()
	{
		if(fc==null || file == null)
		{
			File temp = new File(getDataFolder(),getOwner().getUniqueId().toString()+".yml");
			if(!temp.exists())
			{
				return false;
			}
			else{
				file=temp;
			}
			return true;
		}
		return true;
	}
	public void saveConfig(){
		try{
			getConfig().save(getFile());
		}catch(IOException e){e.printStackTrace();}
	}
	

}
