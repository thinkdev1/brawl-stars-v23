package com.nosteam.nostbrawl.Messaging.Messages.Server.Login;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Utils.createMessage;

public class LoginOkMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 20104,
				version = 1;

	public LoginOkMessage(PlayerSession plr, DataOutputStream Writer) {

		super(50);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		// Account ID
		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);

		// Home ID
		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);
		
		this.writeString(this.player.token);
		
		System.out.println("[Server] LoginOkMessage was sended with ID: " + type);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
