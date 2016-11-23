package com.gmail.cadox8.randack.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LightAPI {

	private static Method getWorldServer;
	private static Constructor<?> blockPosition;
	private static Class<?> skyBlock;

	public static HashMap<Player, Location> light = new HashMap<Player, Location>();

	public static void createLight(World world, int x, int y, int z, int light){
		try{
			getWorldServer = Packet.getOBCClass("CraftWorld").getMethod("getHandle");
			blockPosition = Packet.getNMSClass("BlockPosition").getConstructor(int.class, int.class, int.class);
			skyBlock = Packet.getNMSClass("EnumSkyBlock");

			getWorldServer.setAccessible(true);
			getWorldServer.invoke(skyBlock.getEnumConstants()[0], blockPosition.newInstance(x, y, z), light);
		}catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e){
			e.printStackTrace();
		}
	}

	public static void moveLight(Location l, Location l2){
		deleteLight(l.getWorld(), (int) l.getX(), (int) l.getY(), (int) l.getZ());
		createLight(l.getWorld(), (int) l.getX(), (int) l.getY(), (int) l.getZ(), 15);
	}

	public static void deleteLight(World world, int x, int y, int z){
		recalculateLight(world, x, y, z);
	}

	private static void recalculateLight(World world, int x, int y, int z){
		try{
			getWorldServer = Packet.getOBCClass("CraftWorld").getMethod("getHandle");
			blockPosition = Packet.getNMSClass("BlockPosition").getConstructor(int.class, int.class, int.class);
			skyBlock = Packet.getNMSClass("EnumSkyBlock");

			getWorldServer.setAccessible(true);
			getWorldServer.invoke(skyBlock.getEnumConstants()[0], blockPosition.newInstance(x, y, z));
		}catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e){
			e.printStackTrace();
		}
	}
}
