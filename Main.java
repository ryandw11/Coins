package me.ryandw11.coins.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;







import me.ryandw11.coins.Manager;
import me.ryandw11.coins.commands.coinCommand;
import me.ryandw11.coins.listner.onJoinListener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public Main plugin;
	
	public File balfile = new File(getDataFolder() + "/coindata.yml");
	public FileConfiguration bal = YamlConfiguration.loadConfiguration(balfile);
	
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The tester plugin has been enabled!"); // prints into the log
		loadMethoid();
		loadFile();
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The tester plugin has been disabled!"); // same thing
		saveFile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void saveFile(){
		
		try{
			bal.save(balfile);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	
	public void loadFile(){
		if(balfile.exists()){
			try {
				bal.load(balfile);
			} catch (IOException | InvalidConfigurationException e) {

				e.printStackTrace();
			}
		}
		else{
			try {
				bal.save(balfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadMethoid(){
		this.getCommand("coin").setExecutor(new coinCommand(new Manager(this)));
		Bukkit.getServer().getPluginManager().registerEvents(new onJoinListener(new Manager(this)), this);
	}

}
