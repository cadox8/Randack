package com.gmail.cadox8.randack.wand;

public class Wand {

	private WoodType wood;
	private CoreType core;

	public Wand(WoodType wood, CoreType core){
		this.wood = wood;
		this.core = core;
	}

	public WoodType getWoodType(){
		return this.wood;
	}

	public CoreType getCoreType(){
		return this.core;
	}
}
