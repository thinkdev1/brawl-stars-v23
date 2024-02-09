package com.nosteam.nostbrawl.Messaging.Messages.Client;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Messaging.Messages.Server.KeepAliveOkMessage;

import com.nosteam.nostbrawl.Utils.ByteStream;

public class KeepAliveMessage extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;

	public KeepAliveMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public KeepAliveMessage decode() {
		return this;
	}

	public void process() {
		new KeepAliveOkMessage(this.player, this.writer).encode();
	}
}
