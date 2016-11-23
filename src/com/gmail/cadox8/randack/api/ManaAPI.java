package com.gmail.cadox8.randack.api;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.Randack;

public class ManaAPI {

	public HashMap<Player, Double> mana = new HashMap<Player, Double>();
	private HashMap<Player, Double> manaRegen = new HashMap<Player, Double>();

	public void addMana(Player p, double amount){
		mana.put(p, getMana(p) + amount);
	}

	public void removeMana(Player p, double amount){
		mana.put(p, getMana(p) - amount);
	}

	public void loadMana(Player p){
		mana.put(p, Randack.getRandackAPI().getFiles().getPlayers().getDouble(p.getName() + ".mana"));
		manaRegen.put(p, Randack.getRandackAPI().getFiles().getPlayers().getDouble(p.getName() + ".manaRegen"));
	}

	public void saveMana(Player p){
		Randack.getRandackAPI().getFiles().getPlayers().set(p.getName() + ".mana", getMana(p));
		Randack.getRandackAPI().getFiles().getPlayers().set(p.getName() + ".manaRegen", getManaRegen(p));
		Randack.getRandackAPI().getFiles().saveFiles();
	}

	public boolean hasMana(Player p, double mana){
		if(getMana(p) >= mana){
			return true;
		}
		return false;
	}

	public double getMana(Player p){
		return mana.get(p);
	}

	public double getManaRegen(Player p){
		return manaRegen.get(p);
	}
}
