package com.gmail.cadox8.randack.mage;

import java.util.Random;

import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.files.Files;
import com.gmail.cadox8.randack.wand.Wand;

public class Mage {

	private Player p;

	private Wand wand;

	private long mageID;

	private static Files files = Randack.getRandackAPI().getFiles();

	public Mage(Player p, Wand wand){
		this.p = p;
		this.wand = wand;
		this.mageID = new Random().nextLong();

		generateMage();
	}

	private void generateMage(){
		files.getPlayers().set(p.getName() + ".id", mageID);

		files.getPlayers().set(p.getName() + ".wood", wand.getWoodType().toString());
		files.getPlayers().set(p.getName() + ".core", wand.getCoreType().toString());

		files.getPlayers().set(p.getName() + ".power", wand.getCoreType().getMorePower() + wand.getWoodType().getMorePower() + 20);
		files.getPlayers().set(p.getName() + ".mana", 100);
		files.getPlayers().set(p.getName() + ".manaRegen", 2.3);
		files.getPlayers().set(p.getName() + ".lessMana", wand.getCoreType().getLessMana() + wand.getWoodType().getLessMana() + 3.4);

		//files.getPlayers().set(p.getName() + ".spells", Arrays.asList("lumos"));

		files.saveFiles();
	}

	public long getMageID(){
		return mageID;
	}

	public static long getMageID(Player p){
		return files.getPlayers().getLong(p.getName() + ".id");
	}
}
