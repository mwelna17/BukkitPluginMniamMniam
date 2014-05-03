package pl.moszna.mza;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MosznaPlugin extends JavaPlugin implements Listener{
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable(){
		
	}
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player playa = (Player) sender;
		if(command.getName().equalsIgnoreCase("theThing")){
			this.getServer().broadcastMessage("MOSZNA");
			playa.performCommand("thething");
		}else if(command.getName().equalsIgnoreCase("iliketrains")){
			playa.setHealth(0);
		}
		else if(command.getName().equalsIgnoreCase("Trynkiewicz")){
			playa.setHealth(playa.getHealth() / 2);
			playa.setFoodLevel(0);
			playa.setLevel(0);
			playa.sendMessage( "Zostales zgwalcony przez " + ChatColor.LIGHT_PURPLE + "Trynkiewicza" + ChatColor.RESET + "!!!");
		}
		else if(command.getName().equalsIgnoreCase("Erekcja")){
			Location loc = playa.getLocation();
		    loc.setY(loc.getY() - 1);
		    Block b = loc.getBlock();
		    b.setType(Material.WOOL);
		    Block b2 = playa.getLocation().getBlock();
		    b2.setType(Material.LEVER);
		    
		}
		else if(command.getName().equalsIgnoreCase("heal")){
		playa.setHealth(20);
		playa.setFoodLevel(100);
		playa.sendMessage("Zostales uleczony i nakarmiony");
		}
		else if(command.getName().equalsIgnoreCase("suicide")){
			playa.kickPlayer("You have watched " + ChatColor.RED + "Suicide Mouse.avi");
					
		}
		else if(command.getName().equalsIgnoreCase("Spam")){
			int sint = 0;
			while (sint <= 30){
				playa.chat("Spam");
				sint++;
			}
		}
		else if(command.getName().equalsIgnoreCase("Suprise")){
			playa.setFoodLevel(0);
			playa.setSneaking(isEnabled());
			Location loc = playa.getLocation();
			playa.playEffect(loc, Effect.MOBSPAWNER_FLAMES, null);
			loc.setY(loc.getY() + 2);
			playa.getWorld().spawnEntity(loc, EntityType.CREEPER);
		}
		else if(command.getName().equalsIgnoreCase("Feed")){
			playa.setFoodLevel(100);
			playa.sendMessage("&eMniam Mniam&r");
		}
		else if(command.getName().equalsIgnoreCase("Water")){
			Location loc = playa.getLocation();
			Block b = loc.getBlock();
			b.setType(Material.LAVA);
			playa.sendMessage("Prosze, twoja wod-- znaczy sie " + ChatColor.DARK_RED + "lawa...");
		}
		return true;
	}
	/*
	 @EventHandler
	 public void onMove(PlayerMoveEvent event){
	 Location loc = event.getPlayer().getLocation();
	 loc.setY(loc.getY() - 1);
	 Block b = loc.getBlock();
	 if (b.getType() != Material.AIR && b.getType() != Material.WATER && b.getType() != Material.LAVA && b.getType() != Material.SOUL_SAND && b.getType() != Material.LONG_GRASS) {
	 	b.setType(Material.SNOW_BLOCK);
	 } 
	 */
	}

