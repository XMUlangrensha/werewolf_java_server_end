package com.langrensha.model;

import com.langrensha.dao.*;

public class Seer extends Role {
	public Seer() {
		super(SEER);
	}

	public int see(Player toSeePlayer) {
		return toSeePlayer.getRole().id;
	}
}
