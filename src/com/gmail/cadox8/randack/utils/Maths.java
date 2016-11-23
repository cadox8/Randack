package com.gmail.cadox8.randack.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.particles.ParticleEffect;

public class Maths {

	//TODO: Better Code

	private static HashMap<Player, Integer> countdown_id = new HashMap<Player, Integer>();
	private static HashMap<Location, Integer> countdown_id_2 = new HashMap<Location, Integer>();

	//For Players
	public static void rotationEffect(final Player p, final ParticleEffect pe, final float radius, final Boolean randomColor){
		if(!countdown_id.containsKey(p)){
			final double radialsPerStep = Math.PI / 30;
			int i = Bukkit.getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float step = 0;

				public void run(){
					Location loc = p.getLocation();

					loc.add(0, 5, 0);
					loc.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);

					if(randomColor){
						pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, loc);
					}else{
						pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, loc);
					}
					step++;
				}
			}, 10L, 10L).getTaskId();

			countdown_id.put(p, i);
		}else{
			stopRotation(p);
		}

	}

	public static void radarEffect(final Player p, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 0.2f;
		final double radialsPerStep = Math.PI / 18;

		if(!countdown_id.containsKey(p)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float j = 0.0F;

				public void run(){
					Location loc = p.getLocation();

					loc.setY(loc.getY() + 2.0D);

					for(int k = 0; k < 5F; k++){
						loc.setX(loc.getX() + Math.sin(this.j * radialsPerStep) * radius);
						loc.setY(loc.getY());
						loc.setZ(loc.getZ() + Math.cos(this.j * radialsPerStep) * radius);

						if(randomColor){
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, loc);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, loc);
						}
						this.j += 0.3F;
					}
					if(this.j >= 360.0F){
						this.j = 0.0F;
					}
				}
			}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);
		}else{
			stopRotation(p);
		}
	}

	public static void spiraleEffect(final Player p, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 3.7f;
		final int lineNumber = 1;
		final float heightEcart = 0.4f;
		final float MaximumHeight = 5.0f;

		if(!countdown_id.containsKey(p)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float i = 0f;

				public void run(){
					for(int k = 0; k < lineNumber; k++){
						Location l = p.getLocation();

						double x = Math.sin(i * radius);
						double y = Math.cos(i * radius);
						double z = i * heightEcart;
						Vector v = new Vector(x, z, y);

						l.add(v);

						if(randomColor){
							pe.display(0, 0, 0, 1, 1, l);
						}else{
							pe.display(0, 0, 0, 0, 1, l);
						}
					}
					i += 0.1f;
					if(i > MaximumHeight){
						i = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);
		}else{
			stopRotation(p);
		}
	}

	public static void tornadoEffect(final Player p, final ParticleEffect pe, final Boolean randomColor){
		if(!countdown_id.containsKey(p)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){

				final float LineNumber = 3f;
				float j = 0.0f;
				final float radius = 0.3f;
				final float heightEcart = 0.01f;

				public void run(){
					Location loc = p.getLocation();
					loc.setY(loc.getY() + 2);

					for(int k = 0; k < LineNumber; k++){
						loc.add(Math.cos(j) * radius, j * heightEcart, Math.sin(j) * radius);

						if(randomColor){
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, loc);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, loc);
						}
					}
					j += 0.2f;
					if(j > 50){
						j = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);

		}else{
			stopRotation(p);
		}
	}

	public static void stopRotation(Player p){
		if(countdown_id.containsKey(p)){
			Bukkit.getServer().getScheduler().cancelTask(countdown_id.get(p));
			countdown_id.remove(p);
		}
	}

	//For Locations
	public static void rotationEffect(final Location l, final ParticleEffect pe, final float radius, final Boolean randomColor){
		if(!countdown_id_2.containsKey(l)){
			final double radialsPerStep = Math.PI / 30;
			int i = Bukkit.getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float step = 0;

				public void run(){
					l.add(0, 5, 0);
					l.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);

					if(randomColor){
						pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l);
					}else{
						pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l);
					}
					step++;
				}
			}, 10L, 10L).getTaskId();

			countdown_id_2.put(l, i);
		}else{
			stopRotation(l);
		}

	}

	public static void radarEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 0.2f;
		final double radialsPerStep = Math.PI / 18;

		if(!countdown_id_2.containsKey(l)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float j = 0.0F;

				public void run(){
					l.setY(l.getY() + 2.0D);

					for(int k = 0; k < 5F; k++){
						l.setX(l.getX() + Math.sin(this.j * radialsPerStep) * radius);
						l.setY(l.getY());
						l.setZ(l.getZ() + Math.cos(this.j * radialsPerStep) * radius);

						if(randomColor){
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l);
						}
						this.j += 0.3F;
					}
					if(this.j >= 360.0F){
						this.j = 0.0F;
					}
				}
			}, 1L, 1L).getTaskId();
			countdown_id_2.put(l, i);
		}else{
			stopRotation(l);
		}
	}

	public static void spiraleEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 3.7f;
		final int lineNumber = 1;
		final float heightEcart = 0.4f;
		final float MaximumHeight = 5.0f;

		if(!countdown_id_2.containsKey(l)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float i = 0f;

				public void run(){
					for(int k = 0; k < lineNumber; k++){
						double x = Math.sin(i * radius);
						double y = Math.cos(i * radius);
						double z = i * heightEcart;
						Vector v = new Vector(x, z, y);

						l.add(v);

						if(randomColor){
							pe.display(0, 0, 0, 1, 1, l);
						}else{
							pe.display(0, 0, 0, 0, 1, l);
						}
					}
					i += 0.1f;
					if(i > MaximumHeight){
						i = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id_2.put(l, i);
		}else{
			stopRotation(l);
		}
	}

	public static void tornadoEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		if(!countdown_id_2.containsKey(l)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){

				final float LineNumber = 3f;
				float j = 0.0f;
				final float radius = 0.3f;
				final float heightEcart = 0.01f;

				public void run(){
					l.setY(l.getY() + 2);

					for(int k = 0; k < LineNumber; k++){
						l.add(Math.cos(j) * radius, j * heightEcart, Math.sin(j) * radius);

						if(randomColor){
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l);
						}
					}
					j += 0.2f;
					if(j > 50){
						j = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id_2.put(l, i);

		}else{
			stopRotation(l);
		}
	}

	public static void stopRotation(Location l){
		if(countdown_id_2.containsKey(l)){
			Bukkit.getServer().getScheduler().cancelTask(countdown_id_2.get(l));
			countdown_id_2.remove(l);
		}
	}
}
