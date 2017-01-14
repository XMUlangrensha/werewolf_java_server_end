package com.langrensha.client;

public class Event {
	public static final byte CLIENT_INFO = 0;
	public static final byte SERVER_ROOM = 1;
	public static final byte SERVER_JOINED_COUNT = 2;

	public static final byte SERVER_ALL_ROLE_INFO = 10;
	public static final byte SERVER_ALL_PLAYER_INFO = 11;
	public static final byte SERVER_ROLE_INFO = 12;
	public static final byte SERVER_CLOSE_EYES = 13;
	public static final byte SERVER_OPEN_EYES = 14;
	public static final byte SERVER_GAME_RESULT = 15;
	public static final byte SERVER_YOU_ARE_DEAD = 16;

	public static final byte SERVER_SPEECH_START = 23;
	public static final byte CLIENT_SPEECH_OVER = 24;
	public static final byte SERVER_VOTE_START = 25;
	public static final byte CLIENT_VOTE_ACTION = 26;
	public static final byte SERVER_VOTE_OVER = 27;

	/* 竞选 */
	public static final byte SERVER_ELECTION_START = 20;
	public static final byte CLIENT_ELECTION_ACTION = 21;
	public static final byte SERVER_ELECTION_OVER = 22;
	public static final byte SERVER_SHERRIF_ID = 28;

	/* 盗贼 */
	public static final byte SERVER_THIEF_START = 30;
	public static final byte CLIENT_THIEF_ACTION = 31;
	public static final byte SERVER_THIEF_OVER = 32;

	/* 丘比特 */
	public static final byte SERVER_CUPID_START = 40;
	public static final byte CLIENT_CUPID_ACTION = 41;
	public static final byte SERVER_CUPID_OVER = 42;

	/* 预言家 */
	public static final byte SERVER_SEER_START = 50;
	public static final byte CLIENT_SEER_ACTION = 51;
	public static final byte SERVER_SEER_OVER = 52;

	/* 狼人 */
	public static final byte SERVER_WOLF_START = 60;
	public static final byte CLIENT_WOLF_ACTION = 61;
	public static final byte SERVER_WOLF_ATTEMP_START = 62;
	public static final byte SERVER_WOLF_ATTEMP_OVER = 63;
	public static final byte SERVER_WOLF_OVER = 64;

	/* 女巫 */
	public static final byte SERVER_WITCHSAVE_START = 70;
	public static final byte CLIENT_WITCHSAVE_ACTION = 71;
	public static final byte SERVER_WITCHSAVE_OVER = 72;
	public static final byte SERVER_WITCHPOISON_START = 73;
	public static final byte CLIENT_WITCHPOISON_ACTION = 74;
	public static final byte SERVER_WITCHPOISON_OVER = 75;

	/* 猎人 */
	public static final byte SERVER_HUNTER_START = 80;
	public static final byte CLIENT_HUNTER_ACTION = 81;
	public static final byte SERVER_HUNTER_OVER = 82;

	/* 警长 */
	public static final byte SERVER_SHERIFF_START = 90;
	public static final byte CLIENT_SHERIFF_ACTION = 91;
	public static final byte SERVER_SHERIFF_OVER = 92;

	/* 村民 */
	public static final byte SERVER_VILLAGER_START = 100;
	public static final byte SERVER_EXECUTE_ID = 103;

	/* 死亡名单 */
	public static final byte SERVER_NIGHT_DEATH = 110;

	/* 游戏结果 */
	public static final int ON_GAME = 0;
	public static final int WOLF_WIN = 1;
	public static final int VILLAGER_WIN = 2;
	public static final int LOVER_WIN = 3;
	public static final int EQUAL = 4;

	public static String toEventName(byte eventType) {
		String str = null;
		switch (eventType) {
		case CLIENT_INFO:
			str = "用户信息";
			break;
		default:
			break;
		}
		return str;
	}
}
