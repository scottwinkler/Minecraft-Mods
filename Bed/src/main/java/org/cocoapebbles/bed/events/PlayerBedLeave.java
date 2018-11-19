package org.cocoapebbles.bed.events;


import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.cocoapebbles.bed.Main;

public class PlayerBedLeave implements Listener {
    private Main plugin;
    private ChatColor chatColor = ChatColor.GOLD;
    private String[] msgs = {
            "An army that marches under the true cross cannot be beaten!",
            "Deus Vult!",
            "Insta-bed is a service brought to you by Southern prosperity",
            "Buy LightSpeed briefs",
            "Never trust a Northern lord",
            "Long live the King",
            "Today would be a good day for a crusade",
            "It is good to be the King",
            "Food please",
            "Stone please",
            "Wood Please",
            "Gold please",
            "/cheese steak jimmy's",
            "I just wanted to be loved",
            "Wenk Wenk",
            "Who wants to play video games?",
            "A lemon gives by taking",
            "I am alone and you made me like this",
            "Lemon need not squeeze lemon to survive",
            "For the emperor!",
            "The voices in my head are telling me to do horrible things!",
            "Who are you again?",
            "Thankfully, children are easy to kill",
            "May you be sewn into the belly of a dead camel!"
    };
    public String getRandomMessage(){
        int randomNum = (int) (Math.random()*msgs.length);
        return msgs[randomNum];
    }
    public void destroyBed(Block block){
        Bed bed = (Bed) block.getBlockData();
        BlockFace blockFace = bed.getFacing();
        World world = block.getWorld();
        Location location = block.getLocation();
        if (blockFace== BlockFace.EAST){
            world.getBlockAt(location.add(1,0,0)).setType(Material.AIR);
        }
        else if (blockFace==BlockFace.WEST){
            world.getBlockAt(location.subtract(1,0,0)).setType(Material.AIR);
        }
        else if (blockFace==BlockFace.SOUTH){
            world.getBlockAt(location.add(0,0,1)).setType(Material.AIR);
        }
        else if (blockFace==BlockFace.NORTH){
            world.getBlockAt(location.subtract(0,0,1)).setType(Material.AIR);
        }
        block.setType(Material.AIR);
    }
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event){

        Block block = event.getBed();
        Player player = (Player) event.getPlayer();

        if (block.getType()==Material.PINK_BED){
            player.sendMessage(chatColor + getRandomMessage());
            destroyBed(block);
        }

    }
    public PlayerBedLeave(Main plugin){
        this.plugin = plugin;
    }
}
