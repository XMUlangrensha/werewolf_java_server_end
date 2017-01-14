package com.langrensha.model;

public class Witch extends Role {
	private boolean hasMedicine;
	private boolean hasPoison;
	public static final boolean SAVE = true;
	public static final boolean POISON = false;

	public Witch() {
		super(WITCH);
		hasMedicine = true;
		hasPoison = true;
	}

	public boolean save(Player toSavePlayer) {
		if (hasMedicine) {
			hasMedicine = false;
			toSavePlayer.getRole().status = ALIVE;
			return true;
		}
		return false;
	}

	public boolean poison(Player toPoisonPlayer) {
		if (hasPoison) {
			hasPoison = false;
			toPoisonPlayer.getRole().status = POISONED;
			return true;
		}
		return false;
	}
}
