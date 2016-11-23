package com.gmail.cadox8.randack.utils;

import java.util.Random;

public class NumberUtils {

	public static int randInt(int max){
		Random r = new Random();

		int i = r.nextInt(max) * (r.nextBoolean() ? -1 : 1);

		return i;
	}
}
