package com.gmail.cadox8.randack.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Packet {

	public static void sendPacket(Player player, Object packet){
		try{
			Object handle = player.getClass().getMethod("getHandle").invoke(player);
			Object playerConnect = handle.getClass().getField("playerConnection").get(handle);
			playerConnect.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnect, packet);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Class<?> getNMSClass(String name){
		String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		try{
			return Class.forName("net.minecraft.server." + version + "." + name);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}

	public static Class<?> getOBCClass(String name){
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
		String className = "org.bukkit.craftbukkit." + version + name;
		Class<?> clazz = null;
		try{
			clazz = Class.forName(className);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return clazz;
	}
}
