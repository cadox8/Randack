package com.gmail.cadox8.randack.spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.spells.list.Appearance;
import com.gmail.cadox8.randack.spells.list.lumos.Lumos;
import com.gmail.cadox8.randack.utils.ItemsMaker;

public abstract class Spell {

	private int id;

	private String name;
	private double manaCost;

	protected static Player p;

	public Spell(int id, String name, double manaCost){
		this.id = id;

		this.name = name;
		this.manaCost = manaCost;
	}

	public int getID(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

	public double getManaCost(){
		return manaCost;
	}

	public static Spell getSpellByName(String name){
		for(Spell s : getAllSpells()){
			if(s.getName().toLowerCase().equalsIgnoreCase(name)){
				return s;
			}
		}
		return null;
	}

	public static List<Spell> getAllSpells(){
		List<Spell> spells = new ArrayList<Spell>();

		spells.add(new Lumos());
		spells.add(new Appearance(p));

		return spells;
	}

	public static ItemStack getParchment(){
		return new ItemsMaker().withName("Parchment").withMaterial(Material.PAPER).build();
	}

	//
	public abstract boolean enabled();

	public abstract boolean canGetCrafting();

	public abstract List<ItemStack> getCrafting();

	public abstract double time();

	public abstract boolean manaXTime();

	public abstract void spellEffects();
}
