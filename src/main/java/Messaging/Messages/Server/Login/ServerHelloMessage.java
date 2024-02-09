package com.nosteam.nostbrawl.Messaging.Messages.Server.Login;
import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Utils.createMessage;

public class ServerHelloMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 20100, 
				version = 0;

	public ServerHelloMessage(PlayerSession plr, DataOutputStream Writer) {
		
		super(28);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		this.writeInt(24);
		for (var index = 0; index < 24; index++) {
			this.writeByte(0xFF);
		}
		System.out.println("[Server] ServerHelloMessage was sended with ID: " + type);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
