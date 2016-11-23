package com.gmail.cadox8.randack.spells.list.lumos;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.spells.Spell;

public class Lumos extends Spell {

	public Lumos(){
		super(0, "Lumos", 5);
	}

	@Override
	public boolean enabled(){
		return false;
	}

	@Override
	public boolean canGetCrafting(){
		return true;
	}

	@Override
	public List<ItemStack> getCrafting(){
		ItemStack g = new ItemStack(Material.GLOWSTONE_DUST);

		return Randack.getRandackAPI().getRecipeManager().getTableRecipe(g, null, g, null, Spell.getParchment(), null, g, null, g);
	}

	@Override
	public double time(){
		return 0;
	}

	@Override
	public boolean manaXTime(){
		return true;
	}

	@Override
	public void spellEffects(){
	}
}
