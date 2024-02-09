package com.nosteam.nostbrawl.Messaging.Messages.Client.Login;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Messaging.Messages.Server.Login.LoginOkMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Server.Home.OwnHomeDataMessage;

import com.nosteam.nostbrawl.Database.DataBase;
import com.nosteam.nostbrawl.Utils.Helpers;

public class LoginMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;
	public int major, minor, build;
	public String fingerprint_sha;

	public LoginMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public LoginMessage decode() {

		this.player.high_id = this.readInt();
		this.player.low_id = this.readInt();
		this.player.token = this.readString();
		
		this.major = this.readInt();
		this.minor = this.readInt();
		this.build = this.readInt();
		
		this.fingerprint_sha = this.readString();
		
		this.readInt();

		// change this part if you're going to make a database.
		//this.player.high_id = 0;
		//this.player.low_id = 1;
		//this.player.token = new Helpers().randomToken();

		return this;
	}

	public void process() {
	  
	  if (this.player.low_id != 0) {
	    new LoginOkMessage(this.player, this.writer).encode();
	    new DataBase(this.player).loadAccount();
	    new OwnHomeDataMessage(this.player, this.writer).encode();
	  }
	  else {
	    this.player.low_id = 1;
	    this.player.high_id = 0;
	    this.player.token = new Helpers().randomToken();
	      
	    new LoginOkMessage(this.player, this.writer).encode();
	    new OwnHomeDataMessage(this.player, this.writer).encode();
	  }
	}
}