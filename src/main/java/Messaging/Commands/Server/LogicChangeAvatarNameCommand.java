package com.nosteam.nostbrawl.Messaging.Commands.Server;

import java.io.DataOutputStream;

import java.lang.Thread;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Utils.createMessage;

import com.nosteam.nostbrawl.Database.DataBase;

public class LogicChangeAvatarNameCommand extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 24111, 
				version = 0;

	public LogicChangeAvatarNameCommand(PlayerSession plr, DataOutputStream Writer) {
		
		super(100);
		this.writer = Writer;
		this.player = plr;
		//this.state = state;

	}

	public void encode() {

		this.writeVint(201);
		this.writeString(this.player.name);
		this.writeVint(0);

		new DataBase(this.player).replaceValue("name", this.player.name);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
