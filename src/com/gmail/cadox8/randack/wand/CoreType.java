package com.gmail.cadox8.randack.wand;

public enum CoreType{

	UNICORN_HORN(3.5, 3.8), DONKEY_HAIR();

	private double morePower;
	private double lessMana;

	CoreType(){
	}

	CoreType(double morePower, double lessMana){
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
