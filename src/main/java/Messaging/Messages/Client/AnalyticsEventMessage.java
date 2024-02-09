package com.nosteam.nostbrawl.Messaging.Messages.Client;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

import com.nosteam.nostbrawl.Utils.ByteStream;

public class AnalyticsEventMessage extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;
	
    public String Type;
    public String Event;

	public AnalyticsEventMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public AnalyticsEventMessage decode() {
		Type = this.readString();
		Event = this.readString();
		
		return this;
	}

	public void process() {
		System.out.println("[Client] " + Type + " " + Event);
	}
}
