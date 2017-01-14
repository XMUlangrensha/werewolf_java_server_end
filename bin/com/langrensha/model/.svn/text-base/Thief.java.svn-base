package com.langrensha.model;

public class Thief extends Role {
	public Thief() {
		super(THIEF);
	}

	public Role steal(int newRoleId) {
		Role newRole = null;
		switch (newRoleId) {
		case CUPID:
			newRole = new Cupid();
			break;
		case HUNTER:
			newRole = new Hunter();
			break;
		case SEER:
			newRole = new Seer();
			break;
		case VILLAGER:
			newRole = new Villager();
			break;
		case WITCH:
			newRole = new Witch();
			break;
		case WOLF:
			newRole = new Wolf();
			break;
		}
		return newRole;
	}
}
