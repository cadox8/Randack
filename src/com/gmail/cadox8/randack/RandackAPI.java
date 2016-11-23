package com.gmail.cadox8.randack;

import com.gmail.cadox8.randack.api.ManaAPI;
import com.gmail.cadox8.randack.files.Files;
import com.gmail.cadox8.randack.recipes.RecipeManager;
import com.gmail.cadox8.randack.spells.SpellManager;
import com.gmail.cadox8.randack.wand.WandManager;

public class RandackAPI {

	private Files files = new Files();
	private WandManager wandManager = new WandManager();
	private SpellManager spellManager = new SpellManager();
	private RecipeManager recipeManager = new RecipeManager();

	private ManaAPI manaAPI = new ManaAPI();

	public Files getFiles(){
		return files;
	}

	/**
	 * Get Wand Manager
	 *
	 * @return WandManager
	 */
	public WandManager getWandManager(){
		return wandManager;
	}

	public SpellManager getSpellManager(){
		return spellManager;
	}

	public RecipeManager getRecipeManager(){
		return recipeManager;
	}

	public ManaAPI getManaAPI(){
		return manaAPI;
	}
}
