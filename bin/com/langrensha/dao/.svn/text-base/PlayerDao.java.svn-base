package com.langrensha.dao;

import java.util.ArrayList;
import java.util.List;

import com.langrensha.model.*;
import com.langrensha.utility.Message;

public class PlayerDao {

	private List<Player> list;

	public int getCount() {
		return list.size();
	}

	public List<Player> getList() {
		return list;
	}

	public List<Player> getPlayersByIds(List<Integer> ids) {
		List<Player> list = new ArrayList<Player>();
		for (int id : ids)
			list.add(get(id));
		return list;
	}

	public PlayerDao() {
		list = new ArrayList<Player>();
	}

	public boolean add(Player player) {
		return list.add(player);
	}

	public boolean set(int playerId, Player newPlayer) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == playerId) {
				if (list.set(i, newPlayer) != null)
					return true;
			}
		}
		return false;
	}

	/**
	 * 由id得到某一玩家
	 * 
	 * @param playerId
	 * @return
	 */
	public Player get(int playerId) {
		for (Player p : list) {
			if (playerId == p.getId())
				return p;
		}
		return null;
	}

	/**
	 * 得到同一角色的所有玩家
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Player> getPlayersByRole(int roleId) {
		List<Player> pList = new ArrayList<Player>();
		for (Player p : list) {
			if (roleId == p.getRole().getId()) {
				pList.add(p);
			}
		}
		return pList;
	}

	public List<Player> getDeadPlayers(int day) {
		List<Player> pList = new ArrayList<Player>();
		for (Player p : list) {
			Role role = p.getRole();
			if (role.getStatus() != Role.ALIVE && role.getAliveDay() == day) {
				pList.add(p);
			}
		}
		return pList;
	}

	public List<Player> getAlivePlayers() {
		List<Player> pList = new ArrayList<Player>();
		for (Player p : list) {
			Role role = p.getRole();
			if (role.getStatus() == Role.ALIVE) {
				pList.add(p);
			}
		}
		return pList;
	}

	/**
	 * 通知指定玩家
	 * 
	 * @param playerId
	 * @param msg
	 */
	public void send(int playerId, Message msg) {
		String str = msg.toJson();
		Player p = get(playerId);
		if (p != null)
			p.output(str);
	}

	/**
	 * 转换为玩家角色名数组
	 * 
	 * @return
	 */
	public String[] toRoleNames() {
		String[] roleNames = new String[list.size() + 1];
		for (Player p : list)
			roleNames[p.getId()] = p.getRole().getName();
		return roleNames;
	}

	public String recv(int playerId) {
		return get(playerId).input();
	}

	public void vote(int voteId, int toVoteId) {
		Player votePlayer = get(voteId);
		Player toVotePlayer = get(toVoteId);
		votePlayer.getRole().getVoteList().add(toVotePlayer.getName());

	}

	public void theifAction(Player tp, int roleId) {
		Thief thief = (Thief) tp.getRole();
		Role newRole = thief.steal(roleId);
		tp.setRole(newRole);
	}

	public void cupidAction(Player cp, int firstId, int secondId) {
		Cupid cupid = (Cupid) cp.getRole();
		Player first = get(firstId);
		Player second = get(secondId);
		cupid.shoot(first, second);
	}

	public int seerAction(Player sp, int toSeeId) {
		Seer seer = (Seer) sp.getRole();
		Player toSeePlayer = get(toSeeId);
		return seer.see(toSeePlayer);
	}

	public int[] wolfAction(Player wp, int toKillId) {
		Wolf wolf = (Wolf) wp.getRole();
		Player toKillPlayer = get(toKillId);
		wolf.kill(toKillPlayer);
		// 情侣殉情
		int secondId = loverAction(toKillPlayer);
		if (secondId != 0) {
			int[] deadIds = { toKillId, secondId };
			return deadIds;
		} else {
			int[] deadIds = { toKillId };
			return deadIds;
		}

	}

	public int[] witchSaveAction(Player wip, int toSaveId) {
		Witch witch = (Witch) wip.getRole();
		Player toSavePlayer = get(toSaveId);
		if (witch.save(toSavePlayer)) {
			// 情侣也复活
			int secondId = toSavePlayer.getRole().getLoverId();
			if (secondId != 0) {
				Role secondRole = get(secondId).getRole();
				if (secondRole.getStatus() == Role.SUICIDED) {
					secondRole.setStatus(Role.ALIVE);
					int[] surviveIds = { toSaveId, secondId };
					return surviveIds;
				}
			}
			int[] surviveIds = { toSaveId };
			return surviveIds;
		} else
			return null;
	}

	public int[] witchPoisonAction(Player wip, int toPoisonId) {
		Witch witch = (Witch) wip.getRole();
		Player toPoisonPlayer = get(toPoisonId);
		if (witch.poison(toPoisonPlayer)) {
			// 情侣殉情
			int secondId = loverAction(toPoisonPlayer);
			if (secondId != 0) {
				int[] deadIds = { toPoisonId, secondId };
				return deadIds;
			} else {
				int[] deadIds = { toPoisonId };
				return deadIds;
			}
		} else
			return null;
	}

	private int loverAction(Player first_player) {
		int secondId = first_player.getRole().getLoverId();
		if (secondId != 0) {
			Role secondRole = get(secondId).getRole();
			if (secondRole.getStatus() == Role.ALIVE) {
				secondRole.setStatus(Role.SUICIDED);
			}
		}
		return secondId;

	}

	public int[] hunterAction(Player hp, int toHuntId) {
		Hunter hunter = (Hunter) hp.getRole();
		Player toHuntPlayer = get(toHuntId);
		if (hunter.hunt(toHuntPlayer)) {
			// 情侣殉情
			int secondId = loverAction(toHuntPlayer);
			if (secondId != 0) {
				int[] deadIds = { toHuntId, secondId };
				return deadIds;
			} else {
				int[] deadIds = { toHuntId };
				return deadIds;
			}
		}
		return null;
	}

	public int[] viliagerAction(int toExecuteId) {
		Player toExecutePlayer = get(toExecuteId);
		toExecutePlayer.getRole().setStatus(Role.EXECUTED);
		// 情侣殉情
		int secondId = loverAction(toExecutePlayer);
		if (secondId != 0) {
			int[] deadIds = { toExecuteId, secondId };
			return deadIds;
		} else {
			int[] deadIds = { toExecuteId };
			return deadIds;
		}
	}

	public Player getSheriff() {
		for (Player p : list)
			if (p.getRole().isSheriff())
				return p;
		return null;
	}

	public boolean setSheriff(int sheriffId) {
		for (Player p : list)
			if (p.getId() == sheriffId) {
				p.getRole().setSheriff(true);
				return true;
			}
		return false;
	}

	public void sheriffAction(Player oldSheriff, int newSheriffId) {
		oldSheriff.getRole().setSheriff(false);
		get(newSheriffId).getRole().setSheriff(true);
	}

}
