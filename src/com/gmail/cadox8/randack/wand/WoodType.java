package com.gmail.cadox8.randack.wand;

public enum WoodType{

	ACACIA(3.4, 1.3), OAK(), SPRUCE(2.9, 0), BIRCH(0, 5.6), JUNGLE(1.2, 3.4), DARK_OAK(7.6, 3.0);

	private double morePower;
	private double lessMana;

	WoodType(){
	}

	WoodType(double morePower, double lessMana){
		this.morePower = morePower;
		this.lessMana = lessMana;
	}

	public double getMorePower(){
		return morePower;
	}

	public double getLessMana(){
		return lessMana;
	}
}
