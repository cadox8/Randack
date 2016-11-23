package com.gmail.cadox8.randack.wand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.mage.Mage;

public class WandManager {

	public Wand generatePlayerWand(){
		return new Wand(getRandomWood(), getRandomCore());
	}

	private WoodType getRandomWood(){
		return WoodType.values()[new Random().nextInt(WoodType.values().length)];
	}

	private CoreType getRandomCore(){
		return CoreType.values()[new Random().nextInt(CoreType.values().length)];
	}

	public boolean hasItems(List<ItemStack> givenItems){
		if(givenItems.equals(getItems())){
			return true;
		}
		return false;
	}

	public List<String> getWandLore(Wand w, Mage mage){
		List<String> lore = new ArrayList<String>();

		lore.add(ChatColor.GRAY + "Wood: " + ChatColor.AQUA + w.getWoodType());
		lore.add(ChatColor.GRAY + "Core: " + ChatColor.AQUA + w.getCoreType());
		lore.add(ChatColor.YELLOW + "===================");
		lore.add(ChatColor.WHITE + "" + mage.getMageID());

		return lore;
	}

	private List<ItemStack> getItems(){
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemStack(Material.STICK));
		items.add(null);
		items.add(new ItemStack(Material.ENDER_PEARL));
		items.add(null);
		items.add(new ItemStack(Material.DIAMOND));
		items.add(null);
		items.add(new ItemStack(Material.ENDER_PEARL));
		items.add(null);
		items.add(new ItemStack(Material.STICK));

		return items;
	}
}
