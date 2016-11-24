package com.gmail.cadox8.randack.events;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.mage.Mage;
import com.gmail.cadox8.randack.particles.ParticleEffect;
import com.gmail.cadox8.randack.utils.ItemsMaker;
import com.gmail.cadox8.randack.utils.Maths;
import com.gmail.cadox8.randack.utils.Messages;
import com.gmail.cadox8.randack.utils.Sounds;
import com.gmail.cadox8.randack.wand.Wand;

public class MagicTable implements Listener {

	private Randack plugin;

	public MagicTable(Randack Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	private List<ItemStack> items;
	private Location l;

	private String invName = "Magic Crafting";

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();

		if(e.getBlock().getType() == Material.ENCHANTMENT_TABLE){
			if(e.getBlock().getRelative(BlockFace.DOWN).getType() == Material.MOSSY_COBBLESTONE){
				p.sendMessage(Messages.tablePlaced);

				p.playSound(p.getLocation(), Sounds.AMBIENCE_THUNDER.bukkitSound(), 10f, 1f);

				for(int y = -2; y < 2; y++){
					ParticleEffect.PORTAL.display(new Vector(0, y, 0), 3, e.getBlock().getLocation(), 5);
				}

				p.playSound(e.getBlock().getLocation(), Sounds.AMBIENCE_THUNDER.bukkitSound(), 10f, 1f);

				return;
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();

		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(p.getInventory().getItemInMainHand().getType() == Material.AIR){
				if(e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE){
					if(e.getClickedBlock().getRelative(BlockFace.DOWN).getType() == Material.MOSSY_COBBLESTONE){
						e.setCancelled(true);
						p.getOpenInventory().close();

						l = e.getClickedBlock().getLocation();

						Inventory i = Bukkit.createInventory(null, InventoryType.DISPENSER, invName);

						p.openInventory(i);
					}
				}
			}
		}
	}

	@EventHandler
	public void onInvClose(InventoryCloseEvent e){
		Inventory i = e.getInventory();
		Player p = (Player) e.getPlayer();

		if(i.getName().equalsIgnoreCase(invName)){
			items = Arrays.asList(i.getContents());

			//Spells
			if(Randack.getRandackAPI().getRecipeManager().hasAllItems(items)){
				if(Randack.getRandackAPI().getSpellManager().hasSpell(p, Randack.getRandackAPI().getRecipeManager().getCraftedSpell())){
					p.sendMessage(Messages.hasSpell);
					return;
				}
				Randack.getRandackAPI().getSpellManager().addSpellPlayer(p, Randack.getRandackAPI().getRecipeManager().getCraftedSpell());

				p.playSound(l, Sounds.VILLAGER_YES.bukkitSound(), 10f, 1f);
				Maths.spiraleEffect(l, ParticleEffect.REDSTONE, true);

				p.sendMessage(Messages.learnedSpell + Randack.getRandackAPI().getRecipeManager().getCraftedSpell().getName());

				Bukkit.getScheduler().scheduleSyncDelayedTask(Randack.getRandack(), new Runnable(){
					@Override
					public void run(){
						Maths.stopRotation(l);
					}
				}, 40L);
				return;
			}

			//Wand
			if(Randack.getRandackAPI().getWandManager().hasItems(items)){

				Wand w = Randack.getRandackAPI().getWandManager().generatePlayerWand();

				Mage mage = new Mage(p, w);

				ItemStack item = new ItemsMaker().withMaterial(Material.STICK).withName("Wand").withLore(Randack.getRandackAPI().getWandManager().getWandLore(w, mage)).build();

				p.playSound(l, Sounds.ENDERDRAGON_GROWL.bukkitSound(), 10f, 1f);
				Maths.spiraleEffect(l, ParticleEffect.REDSTONE, true);

				l.getWorld().dropItem(l.add(0, 1, 0), item);

				return;
			}
		}
	}

	@EventHandler
	public void onPickUpWand(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		ItemStack i = e.getItem().getItemStack();

		if(i.hasItemMeta() && i.getItemMeta().hasLore()){
			if(Long.parseLong(ChatColor.stripColor(i.getItemMeta().getLore().get(3))) != Mage.getMageID(p)){
				e.setCancelled(true);
			}
		}
	}
}
