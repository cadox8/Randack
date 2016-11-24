package com.gmail.cadox8.randack.cmd.list.admin;

import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.spells.Spell;

public class TestSpellCommand {

	public void testSpell(Player p, String[] args){
		Spell s = Spell.getSpellByName(args[1]);

		Spell.setPlayer(p);

		s.spellEffects();
	}
}
