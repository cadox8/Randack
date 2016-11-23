package com.gmail.cadox8.randack;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.cadox8.randack.events.MagicTable;
import com.gmail.cadox8.randack.events.WandInteract;

public class Randack extends JavaPlugin {

	private static Randack plugin;

	private static RandackAPI randackAPI;

	public void onEnable(){
		plugin = this;
		randackAPI = new RandackAPI();

		registerEvents();

		randackAPI.getFiles().setupFiles();
		randackAPI.getRecipeManager().loadRecipes();
		randackAPI.getSpellManager().manaSpell();
	}

	private void registerEvents(){
		new MagicTable(this);
		new WandInteract(this);
	}

	public static Randack getRandack(){
		return plugin;
	}

	public static RandackAPI getRandackAPI(){
		return randackAPI;
	}
}
