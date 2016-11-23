package com.gmail.cadox8.randack.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.mage.Mage;
import com.gmail.cadox8.randack.spells.Spell;

public class WandInteract implements Listener {

	private Randack plugin;

	public WandInteract(Randack Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack i = p.getInventory().getItemInMainHand();

		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(i.getType() == Material.STICK){
				if(i.hasItemMeta() && i.getItemMeta().hasLore()){
					if(Long.parseLong(ChatColor.stripColor(i.getItemMeta().getLore().get(3))) == Mage.getMageID(p)){

						Randack.getRandackAPI().getSpellManager().nextPlayerSpell(p);
					}
				}
			}
		}

		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
			if(i.getType() == Material.STICK){
				if(i.hasItemMeta() && i.getItemMeta().hasLore()){
					if(Long.parseLong(ChatColor.stripColor(i.getItemMeta().getLore().get(3))) == Mage.getMageID(p)){
						Spell s = Randack.getRandackAPI().getSpellManager().getPlayerSpell(p);

						s.spellEffects();
					}
				}
			}
		}
	}
}
