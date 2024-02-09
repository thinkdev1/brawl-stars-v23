package com.nosteam.nostbrawl.Messaging.Messages.Server;
import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Utils.createMessage;

public class KeepAliveOkMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 20100, 
				version = 0;

	public KeepAliveOkMessage(PlayerSession plr, DataOutputStream Writer) {
		
		super(28);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
