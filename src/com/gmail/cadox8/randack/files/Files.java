package com.gmail.cadox8.randack.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Files {

	private File filePlayers = new File("plugins/Magic/players.yml");
	private YamlConfiguration players = YamlConfiguration.loadConfiguration(filePlayers);

	public void setupFiles(){
		if(!filePlayers.exists()){
			filePlayers.mkdir();
		}
		saveFiles();
	}

	public void saveFiles(){
		try{
			players.save(filePlayers);
			players.load(filePlayers);
		}catch(IOException | InvalidConfigurationException e){
			e.printStackTrace();
		}
	}

	public YamlConfiguration getPlayers(){
		return players;
	}
}
