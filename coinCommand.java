package me.ryandw11.coins.commands;

import me.ryandw11.coins.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class coinCommand implements CommandExecutor {
	
	private Manager account;
	public coinCommand(Manager account){
		this.account = account;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		
		if(args.length == 0){
			if(!account.hasAccount(p.getUniqueId())){
				p.sendMessage(ChatColor.RED + "Oh noes! looks like an error has happend. Please contact and admin! (Spit: no account null)"); // player has no account. Check manager class if happens!
				return true;
			}
			p.sendMessage(ChatColor.GREEN + "================[" + ChatColor.GOLD + "Coins" + ChatColor.GREEN + "]================");
			p.sendMessage(ChatColor.GREEN + "Coins: " + ChatColor.GOLD + account.getBalance(p.getUniqueId()));
			p.sendMessage(ChatColor.GREEN + "Do you want do learn how to get coins? If so do /coin ?");
			p.sendMessage(ChatColor.GREEN + "=======================================");
		}
		//               0    0     1      2       total of 3
		// it would be /coin set (name) (ammount)
		if(args.length == 3){
			if(args[0].equalsIgnoreCase("set")){
				if(p.hasPermission("coin.set") || p.isOp()){
					Player getPlayer = Bukkit.getServer().getPlayer(args[1]);
					if(!getPlayer.isOnline()){
						p.sendMessage(ChatColor.RED + "That player is not online!");
						return true;
					}
					else{
						int amount = 0;
						try{
							amount = Integer.parseInt(args[2]);
						}catch(Exception e){
							p.sendMessage(ChatColor.DARK_RED + "That is not an amount or amount is too high!");
							return true;
						}
						account.setBalance(getPlayer.getUniqueId(), amount);
						p.sendMessage(ChatColor.GREEN + "You have payed that player: " + amount);
						
					
					
					
					
					
					}//end of command run
				}
				else{ // no perm
					p.sendMessage(ChatColor.RED + "You do not have perm for this command!");
				}
				
			}//end of cheker
		}//end of length == 3
		
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("?")){
				p.sendMessage(ChatColor.GREEN + "================[" + ChatColor.GOLD + "Coins Help" + ChatColor.GREEN + "]================");
				p.sendMessage(ChatColor.GREEN + "/coin set (Player) (Amount) : Sets the amount of a players account!");
				p.sendMessage(ChatColor.GREEN + "/coin : Shows there balence");
				p.sendMessage(ChatColor.GREEN + "/coin ? : Shows this help page");
				p.sendMessage(ChatColor.GREEN + "              How to get coins:");
				p.sendMessage("Custom Message goes here! edit in the config file!");
				p.sendMessage(ChatColor.GOLD + "Version 1.0 Author: Ryandw11");
				p.sendMessage(ChatColor.GREEN + "============================================");
			}
		}//end of length cheker!

		return false;
	}//end of cmd run

}
