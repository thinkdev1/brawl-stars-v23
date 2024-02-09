package com.nosteam.nostbrawl.Messaging.Messages.Client;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Messaging.Commands.Server.LogicChangeAvatarNameCommand;

import com.nosteam.nostbrawl.Utils.ByteStream;

public class SetNameMessage extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;
	public String username;
	public int state;

	public SetNameMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public SetNameMessage decode() {
	  this.username = this.readString();
	  this.state = this.readVint();

		return this;
	}

	public void process() {
		if (this.username.length() != 0) {
		  if (this.username.length() >= 2) {
		    this.player.name = this.username;
		    new LogicChangeAvatarNameCommand(this.player, writer).encode();
		  }
		  else {
		    ;
		  }
		}
		else {
		  ;
		}
	}
}