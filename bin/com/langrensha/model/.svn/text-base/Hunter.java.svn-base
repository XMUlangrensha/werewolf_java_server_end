package com.langrensha.model;

public class Hunter extends Role {
	private boolean hasGun;

	public Hunter() {
		super(HUNTER);
		this.hasGun = true;
	}

	public boolean hasGun() {
		return hasGun;
	}

	public void setHasGun(boolean hasGun) {
		this.hasGun = hasGun;
	}

	public boolean hunt(Player toHuntPlayer) {
		if (hasGun && (status == Role.KILLED || status == Role.EXECUTED)) {
			toHuntPlayer.getRole().status = Role.HUNTED;
			hasGun = false;
			return true;
		}
		return false;
	}
}
