package com.gmail.cadox8.randack.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import com.gmail.cadox8.randack.Randack;
import com.gmail.cadox8.randack.particles.ParticleEffect;

public class Maths {

	private static HashMap<Location, Integer> countdown_id = new HashMap<Location, Integer>();

	private static int range = 500;

	public static void rotationEffect(final Location l, final ParticleEffect pe, final float radius, final Boolean randomColor){
		if(!countdown_id.containsKey(l)){
			final double radialsPerStep = Math.PI / 30;
			int i = Bukkit.getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float step = 0;

				public void run(){
					l.add(0, 5, 0);
					l.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);

					if(randomColor){
						pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
					}else{
						pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
					}
					step++;
				}
			}, 10L, 10L).getTaskId();

			countdown_id.put(l, i);
		}else{
			stopRotation(l);
		}

	}

	public static void radarEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 0.2f;
		final double radialsPerStep = Math.PI / 18;

		if(!countdown_id.containsKey(l)){
			int i = Bukkit.getServer().getScheduler().runTaskTimer(Randack.getRandack(), new Runnable(){
				float j = 0.0F;

				public void run(){
					l.setY(l.getY() + 2.0D);

					for(int k = 0; k < 5F; k++){
						l.setX(l.getX() + Math.sin(this.j * radialsPerStep) * radius);
						l.setY(l.getY());
						l.setZ(l.getZ() + Math.cos(this.j * radialsPerStep) * radius);

						if(randomColor){
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
						}
						this.j += 0.3F;
					}
					if(this.j >= 360.0F){
						this.j = 0.0F;
					}
				}
			}, 1L, 1L).getTaskId();
			countdown_id.put(l, i);
		}else{
			stopRotation(l);
		}
	}

	public static void spiraleEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		final float radius = 3.7f;
		final int lineNumber = 1;
		final float heightEcart = 0.4f;
		final float MaximumHeight = 5.0f;

		if(!countdown_id.containsKey(l)){
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
							pe.display(0, 0, 0, 1, 1, l, range);
						}else{
							pe.display(0, 0, 0, 0, 1, l, range);
						}
					}
					i += 0.1f;
					if(i > MaximumHeight){
						i = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id.put(l, i);
		}else{
			stopRotation(l);
		}
	}

	public static void tornadoEffect(final Location l, final ParticleEffect pe, final Boolean randomColor){
		if(!countdown_id.containsKey(l)){
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
							pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
						}else{
							pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
						}
					}
					j += 0.2f;
					if(j > 50){
						j = 0;
					}
				}

			}, 1L, 1L).getTaskId();
			countdown_id.put(l, i);

		}else{
			stopRotation(l);
		}
	}

	public static void stopRotation(final Location l){
		if(countdown_id.containsKey(l)){
			Bukkit.getServer().getScheduler().cancelTask(countdown_id.get(l));
			countdown_id.remove(l);
		}
	}

	public static void drawSphere(final Location l, final ParticleEffect pe, final Boolean randomColor){
		for(double i = 0; i <= Math.PI; i += Math.PI / 10){
			double radius = Math.sin(i);
			double y = Math.cos(i);
			for(double a = 0; a < Math.PI * 2; a += Math.PI / 10){
				double x = Math.cos(a) * radius;
				double z = Math.sin(a) * radius;

				l.add(x, y, z);

				if(randomColor){
					pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
				}else{
					pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
				}

				l.subtract(x, y, z);
			}
		}
	}

	public static void createPolygon(final int points, final Location l, final ParticleEffect pe, final Boolean randomColor){
		for(int iteration = 0; iteration < points; iteration++){
			double angle = 360.0 / points * iteration;

			angle = Math.toRadians(angle);

			double x = Math.cos(angle);
			double z = Math.sin(angle);

			l.add(x, 0, z);

			if(randomColor){
				pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
			}else{
				pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
			}

			l.subtract(x, 0, z);
		}
	}

	public static void createFullPolygon(final int points, final Location l, final ParticleEffect pe, final Boolean randomColor){
		for(int iteration = 0; iteration < points; iteration++){
			double angle = 360.0 / points * iteration;
			double nextAngle = 360.0 / points * (iteration + 1);

			angle = Math.toRadians(angle);
			nextAngle = Math.toRadians(nextAngle);

			double x = Math.cos(angle);
			double z = Math.sin(angle);
			double x2 = Math.cos(nextAngle);
			double z2 = Math.sin(nextAngle);
			double deltaX = x2 - x;
			double deltaZ = z2 - z;
			double distance = Math.sqrt((deltaX - x) * (deltaX - x) + (deltaZ - z) * (deltaZ - z));

			for(double d = 0; d < distance - .1; d += .1){
				l.add(x + deltaX * d, 0, z + deltaZ * d);

				if(randomColor){
					pe.display(0.0F, 0.0F, 0.0F, 1.0F, 1, l, range);
				}else{
					pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, range);
				}

				l.subtract(x + deltaX * d, 0, z + deltaZ * d);
			}
		}
	}
}
