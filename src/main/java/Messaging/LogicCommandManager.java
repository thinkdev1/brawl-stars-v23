package com.nosteam.nostbrawl.Messaging;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

import com.nosteam.nostbrawl.Utils.ByteStream;

public class LogicCommandManager extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;
	public int commandID;

	public LogicCommandManager(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public LogicCommandManager decode() {
	  this.readVint();
	  this.readVint();
	  this.readVint();
	  this.readVint();
	  this.commandID = this.readVint();

		return this;
	}

	public void process() {
		System.out.println("Command Id: " + this.commandID);
	}
}