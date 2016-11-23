package com.gmail.cadox8.randack.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.cadox8.randack.cmd.list.NormalCommand;

public class CMD implements CommandExecutor {

	private NormalCommand normal = new NormalCommand();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p;
		if(sender instanceof Player){
			p = (Player) sender;
		}else{
			sender.sendMessage("This command only can be executed by player");
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("randack")){
			if(args.length == 0){
				normal.normalCommand(p, args);
			}
		}
		return false;
	}
}
