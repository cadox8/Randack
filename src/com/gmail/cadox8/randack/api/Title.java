package com.gmail.cadox8.randack.api;

import java.lang.reflect.Constructor;

import org.bukkit.entity.Player;

public class Title {

	public static void sendTitle(Player player, String text, int fadeI, int time, int fadeO){
		try{
			Object e = Packet.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
			Object titleChat = Packet.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + text + "\"}");
			Constructor<?> title = Packet.getNMSClass("PacketPlayOutTitle").getConstructor(Packet.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Packet.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
			Object packet = title.newInstance(e, titleChat, fadeI, time, fadeO);
			Packet.sendPacket(player, packet);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void sendSubtitle(Player player, String text, int fadeI, int time, int fadeO){
		try{
			Object e = Packet.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
			Object titleChat = Packet.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + text + "\"}");
			Constructor<?> title = Packet.getNMSClass("PacketPlayOutTitle").getConstructor(Packet.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Packet.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
			Object packet = title.newInstance(e, titleChat, fadeI, time, fadeO);
			Packet.sendPacket(player, packet);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
