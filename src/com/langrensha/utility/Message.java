package com.langrensha.utility;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Message extends ArrayList {
	private static final long serialVersionUID = 1L;
	@Expose
	private byte eventType;
	private final static Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();

	public Message(byte eventType) {
		this.eventType = eventType;
		// collection = new ArrayList();
		add(this.eventType);
	}

	public Message(byte eventType, Object o) {
		this(eventType);
		add(o);
	}

	public Message(byte eventType, Object o1, Object o2) {
		this(eventType);
		add(o1);
		add(o2);
	}


	public String toJson() {
		return gson.toJson(this);
	}

	// public void fromJson(){
	// gson.f
	// }
	public String toString() {
		return gson.toJson(this);
	}

	public byte getEventType() {
		return eventType;
	}

}
