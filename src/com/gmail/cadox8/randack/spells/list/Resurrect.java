package com.gmail.cadox8.randack.spells.list;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import com.gmail.cadox8.randack.particles.ParticleEffect;
import com.gmail.cadox8.randack.spells.Spell;
import com.gmail.cadox8.randack.utils.Maths;

public class Resurrect extends Spell {

	public Resurrect(){
		super(2, "Resurrect", 35);
	}

	@Override
	public boolean enabled(){
		return true;
	}

	@Override
	public boolean canGetCrafting(){
		return false;
	}

	@Override
	public List<ItemStack> getCrafting(){
		return null;
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
		Location l = p.getEyeLocation();

		//Spawn Zombies (NMS)
		Maths.createPolygon(5, l, ParticleEffect.FLAME, false);

		l.getWorld().spawnEntity(l, EntityType.ZOMBIE);
	}
}
