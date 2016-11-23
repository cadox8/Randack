package com.gmail.cadox8.randack.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsMaker {

	private Material material;

	private String name;
	private int amount = 1;
	private short data;
	private List<String> lore = new ArrayList<>();

	public ItemsMaker withMaterial(Material material){
		this.material = material;
		return this;
	}

	public ItemsMaker withAmount(int amount){
		this.amount = amount;
		return this;
	}

	public ItemsMaker withName(String name){
		this.name = name;
		return this;
	}

	public ItemsMaker withLore(String line){
		lore.add(line);
		return this;
	}

	public ItemsMaker withLore(String... lines){
		lore.addAll(Arrays.asList(lines));
		return this;
	}

	public ItemsMaker withLore(List<String> lines){
		lore.addAll(lines);
		return this;
	}

	public ItemsMaker withData(int data){
		this.data = (short) data;
		return this;
	}

	public ItemStack build(){
		ItemStack item = new ItemStack(material, amount, data);
		ItemMeta meta = item.getItemMeta();
		if(name != null){
			meta.setDisplayName(name);
		}
		if(!lore.isEmpty()){
			meta.setLore(lore);
		}

		item.setItemMeta(meta);

		return item;
	}
}
