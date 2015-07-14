package me.ryandw11.coins;



import java.util.UUID;

import me.ryandw11.coins.core.Main;

public class Manager {
	
	
	private final Main plugin;
	
	public Manager(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean hasAccount(UUID pid){
		
		return plugin.bal.contains(pid.toString());
		
	}
	
	
	public int getBalance(UUID pid){
		return plugin.bal.getInt(pid.toString());
	}
	
	public void setBalance(UUID pid, int amount){
		
		plugin.bal.set(pid.toString(), amount);
		plugin.saveFile();
		
	}

	
	
	
}
