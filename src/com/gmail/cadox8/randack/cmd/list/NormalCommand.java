package com.gmail.cadox8.randack.cmd.list;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.utils.Messages;

public class NormalCommand {

	private String f = ChatColor.GRAY + " => ";

	private ChatColor dg = ChatColor.DARK_GREEN;
	private ChatColor y = ChatColor.YELLOW;

	public void normalCommand(Player p, String[] args){
		p.sendMessage(" ");
		p.sendMessage(Messages.prefix + y + "Randack Help");
		p.sendMessage(dg + "/avc play" + f + y + "Play AC");
		p.sendMessage(dg + "/avc achievements" + f + y + "View your achievements");
		p.sendMessage(dg + "/avc angels" + f + y + "View your angels");
		p.sendMessage(dg + "/avc managers" + f + y + "View avariable Managers");
		p.sendMessage(dg + "/avc reset" + f + y + "Re-start your game");
		p.sendMessage(dg + "/avc admin" + f + y + "To see admin commands");

		p.sendMessage(" ");
	}

	public void adminCommand(Player p, String[] args){
		if(!p.hasPermission("avc.admin")){
			//	p.sendMessage(Messages.noPerms);
			return;
		}

		p.sendMessage(" ");
		p.sendMessage(Messages.prefix + ChatColor.AQUA + "AVC Admin Help");

		p.sendMessage(dg + "/avc debug");
		p.sendMessage(y + "Debug command (See Console)");
		p.sendMessage(" ");

		p.sendMessage(" ");
	}
}
