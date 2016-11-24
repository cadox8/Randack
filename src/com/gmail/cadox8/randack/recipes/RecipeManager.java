package com.gmail.cadox8.randack.recipes;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.spells.Spell;

public class RecipeManager {

	private Recipes recipes = new Recipes();

	private Spell craftedSpell;

	public void loadRecipes(){

		Bukkit.getServer().addRecipe(recipes.getParchment());
		Bukkit.getServer().addRecipe(recipes.getRing());

	}

	public List<ItemStack> getTableRecipe(ItemStack... i){
		return Arrays.asList(i);
	}

	//Test code
	public boolean hasAllItems(List<ItemStack> items){
		for(Spell s : Spell.getAllSpells()){
			if(s.getCrafting().equals(items)){
				craftedSpell = s;
				return true;
			}
		}
		return false;
	}
	//

	public Spell getCraftedSpell(){
		return craftedSpell;
	}
}
