package me.ryandw11.coins.listner;

import me.ryandw11.coins.Manager;
import me.ryandw11.coins.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinListener implements Listener {
	
	private final Manager account;
	
	

	

	public onJoinListener(Manager account){
		this.account = account;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player p = (Player) event.getPlayer();
		
			

		
		if(!account.hasAccount(p.getUniqueId())){
			account.setBalance(p.getUniqueId(), 10);
			p.sendMessage(ChatColor.GREEN + "You have a coin account! Do /coin to see the coins you have!");
			
		}
		
	}
}
