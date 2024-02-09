package com.nosteam.nostbrawl.Messaging.Messages.Client.Login;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Messaging.Messages.Server.Login.ServerHelloMessage;

public class ClientHelloMessage extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;

	public ClientHelloMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public ClientHelloMessage decode() {
		return this;
	}

	public void process() {

		new ServerHelloMessage(this.player, this.writer).encode();
	}
}
