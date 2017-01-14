package com.langrensha.model;

import com.langrensha.dao.*;

public class Cupid extends Role {
	public Cupid() {
		super(CUPID);
	}

	public void shoot(Player first,Player second) {
		first.getRole().setLoverId(second.getId());
		second.getRole().setLoverId(first.getId());
		
	}
}
