package com.nosteam.nostbrawl.Messaging.Messages.Client.Battle;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Messaging.Messages.Server.Home.OwnHomeDataMessage;

public class GoHomeFromOfflinePractiseMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	public GoHomeFromOfflinePractiseMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public GoHomeFromOfflinePractiseMessage decode() {
		return this;
	}

	public void process() {

		new OwnHomeDataMessage(this.player, this.writer).encode();
	}
}