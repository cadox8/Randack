package com.gmail.cadox8.randack.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.api.LightAPI;
import com.gmail.cadox8.randack.spells.list.lumos.Lumos;

public class SpellManager {

	private HashMap<Player, Spell> playerSpell = new HashMap<Player, Spell>();
	private HashMap<Player, Integer> timeSpell = new HashMap<Player, Integer>();

	public void addSpellPlayer(Player p, Spell spell){
		if(hasSpell(p, spell)){
			return;
		}
		List<String> spells = getStringPlayerSpells(p);

		spells.add(spell.getName());

		Randack.getRandackAPI().getFiles().getPlayers().set(p.getName() + ".spells", spells);
		Randack.getRandackAPI().getFiles().saveFiles();
	}

	public void removeSpellPlayer(Player p, Spell spell){
		if(!hasSpell(p, spell)){
			return;
		}
		List<String> spells = getStringPlayerSpells(p);

		spells.remove(spell.getName());

		Randack.getRandackAPI().getFiles().getPlayers().set(p.getName() + ".spells", spells);
		Randack.getRandackAPI().getFiles().saveFiles();
	}

	public void setPlayerSpell(Player p, Spell spell){
		if(getPlayerSpell(p).equals(spell)){
			return;
		}
		playerSpell.put(p, spell);
	}

	public void nextPlayerSpell(Player p){
		setPlayerSpell(p, getNextSpell(p));
	}

	private Spell getNextSpell(Player p){
		List<Spell> spells = getPlayerSpells(p);
		Spell spell = null;

		for(int x = 0; x < spells.size(); x++){
			if(!spells.get(x).equals(getPlayerSpell(p)) && spells.get(x + 1).enabled()){
				spell = spells.get(x + 1);
			}
		}

		return spell;
	}

	public boolean hasSpell(Player p, Spell spell){
		if(getPlayerSpells(p).contains(spell)){
			return true;
		}
		return false;
	}

	private List<String> getStringPlayerSpells(Player p){
		return Randack.getRandackAPI().getFiles().getPlayers().getStringList(p.getName() + ".spells");
	}

	private List<Spell> getPlayerSpells(Player p){
		List<Spell> spells = new ArrayList<Spell>();

		for(String s : getStringPlayerSpells(p)){
			spells.add(Spell.getSpellByName(s));
		}

		return spells;
	}

	public Spell getPlayerSpell(Player p){
		return playerSpell.get(p);
	}

	public void manaSpell(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Randack.getRandack(), new Runnable(){
			@Override
			public void run(){
				for(Player p : Bukkit.getOnlinePlayers()){
					if(playerSpell.containsKey(p)){
						Spell s = playerSpell.get(p);
						if(s.manaXTime()){
							if(!timeSpell.containsKey(p)){
								timeSpell.put(p, 0);
							}
							int g = timeSpell.get(p);
							timeSpell.put(p, g++);

							if(timeSpell.get(p) == 5){
								Randack.getRandackAPI().getManaAPI().removeMana(p, s.getManaCost());
							}

							if(s == new Lumos()){
								LightAPI.moveLight(LightAPI.light.get(p), p.getLocation());
								LightAPI.light.put(p, p.getLocation());
							}
						}
					}
				}
			}
		}, 1L, 20L);
	}
}
