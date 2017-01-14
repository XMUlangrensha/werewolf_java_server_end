package com.langrensha.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.google.gson.annotations.Expose;

public class Role {

	@Expose
	protected int id;
	@Expose
	protected String name;
	@Expose
	protected ImageIcon icon;
	@Expose
	protected boolean isSheriff;
	@Expose
	protected int loverId;
	public static final int CUPID = 1;
	public static final int HUNTER = 2;
	public static final int SEER = 3;
	public static final int THIEF = 4;
	public static final int VILLAGER = 5;
	public static final int WITCH = 6;
	public static final int WOLF = 7;
	@Expose
	protected int status;
	public static final int ALIVE = 1;//
	public static final int KILLED = 2;//
	public static final int POISONED = 3;//
	public static final int SUICIDED = 4;//
	public static final int HUNTED = 5;//
	public static final int EXECUTED = 6;//
	@Expose
	protected int aliveDay;
	protected static int deadCount = 0;
	@Expose
	protected int deadNum;

	public int getAliveDay() {
		return aliveDay;
	}

	public void setAliveDay(int aliveDay) {
		this.aliveDay = aliveDay;
	}

	@Expose
	private List<String> voteList;

	public List<String> getVoteList() {
		return voteList;
	}

	public static String toRoleName(int roleId) {
		String str = null;
		switch (roleId) {
		case CUPID:
			str = "丘比特";
			break;
		case HUNTER:
			str = "猎人";
			break;
		case SEER:
			str = "预言家";
			break;
		case THIEF:
			str = "盗贼";
			break;
		case VILLAGER:
			str = "村民";
			break;
		case WITCH:
			str = "女巫";
			break;
		case WOLF:
			str = "狼人";
			break;
		}
		return str;
	}

	public Role(int id) {
		this.id = id;
		this.name = toRoleName(this.id);
		this.loverId = 0;
		this.status = ALIVE;
		this.isSheriff = false;
		this.voteList = new ArrayList<String>();
		this.aliveDay = 1;
		this.deadNum = 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLoverId() {
		return loverId;
	}

	public void setLoverId(int loverId) {
		this.loverId = loverId;
	}

	// public void suicide() {
	// this.status = SUICIDED;
	// }

	public void setStatus(int type) {
		this.status = type;
		if (this.status != ALIVE) {
			deadCount++;
			this.deadNum = deadCount;
		} else {
			deadCount--;
			this.deadNum = 0;
		}
	}

	public int getStatus() {
		return status;
	}

	public boolean isSheriff() {
		return isSheriff;
	}

	public void setSheriff(boolean isSheriff) {
		this.isSheriff = isSheriff;
	}

}
