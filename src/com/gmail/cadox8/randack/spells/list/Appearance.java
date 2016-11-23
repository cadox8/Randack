package com.gmail.cadox8.randack.spells.list;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.particles.ParticleEffect;
import com.gmail.cadox8.randack.spells.Spell;
import com.gmail.cadox8.randack.utils.Maths;
import com.gmail.cadox8.randack.utils.NumberUtils;
import com.gmail.cadox8.randack.utils.Sounds;

public class Appearance extends Spell {

	public Appearance(Player p){
		super(1, "Appearance", 50);

		Spell.p = p;
	}

	@Override
	public boolean enabled(){
		return true;
	}

	@Override
	public boolean canGetCrafting(){
		return true;
	}

	@Override
	public List<ItemStack> getCrafting(){
		ItemStack e = new ItemStack(Material.ENDER_PEARL);

		return Randack.getRandackAPI().getRecipeManager().getTableRecipe(e, null, e, null, Spell.getParchment(), null, e, null, e);
	}

	@Override
	public double time(){
		return 0;
	}

	@Override
	public boolean manaXTime(){
		return false;
	}

	@Override
	public void spellEffects(){
		double x = p.getLocation().getX() + NumberUtils.randInt(100);
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ() + NumberUtils.randInt(100);
		Location l = new Location(p.getWorld(), x, y, z);

		Maths.tornadoEffect(p, ParticleEffect.PORTAL, false);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Randack.getRandack(), new Runnable(){
			@Override
			public void run(){
				p.teleport(l);
				Maths.stopRotation(p);
				p.playSound(p.getLocation(), Sounds.ENDERMAN_TELEPORT.bukkitSound(), 10f, 10f);
			}
		}, 40L);
	}
}
