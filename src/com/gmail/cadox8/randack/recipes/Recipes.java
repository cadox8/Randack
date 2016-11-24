package com.gmail.cadox8.randack.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import com.gmail.cadox8.randack.spells.Spell;

public class Recipes {

	public ShapelessRecipe getParchment(){
		ItemStack parchment = Spell.getParchment();

		ShapelessRecipe parchmentRecipe = new ShapelessRecipe(parchment);

		parchmentRecipe.addIngredient(Material.PAPER);
		parchmentRecipe.addIngredient(Material.INK_SACK);

		return parchmentRecipe;
	}

	public ShapedRecipe getRing(){
		ItemStack ring = Spell.getParchment();

		ShapedRecipe ringRecipe = new ShapedRecipe(ring);

		ringRecipe.shape("BBB", "BCB", "BBB");

		ringRecipe.setIngredient('B', Material.GOLD_NUGGET);
		ringRecipe.setIngredient('C', Material.FEATHER);

		return ringRecipe;
	}

}
