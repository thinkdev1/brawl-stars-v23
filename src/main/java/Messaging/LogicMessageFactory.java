package com.nosteam.nostbrawl.Messaging;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

import com.nosteam.nostbrawl.Messaging.Messages.Client.Login.ClientHelloMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Client.Login.LoginMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Client.Battle.GoHomeFromOfflinePractiseMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Client.AnalyticsEventMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Client.KeepAliveMessage;
import com.nosteam.nostbrawl.Messaging.Messages.Client.SetNameMessage;
import com.nosteam.nostbrawl.Messaging.LogicCommandManager;

public class LogicMessageFactory {

	public PlayerSession player;

	public LogicMessageFactory(PlayerSession a1) {
		this.player = a1;
	}

	public void process(int type, byte[] payload, DataOutputStream writer) {

		switch (type) {
		case 10100:
			new ClientHelloMessage(this.player, payload, writer)
			.decode()
			.process();
			System.out.println("[Client] ClientHelloMessage was sended. ID: " + type);
			break;
		case 10101:
			new LoginMessage(this.player, payload, writer)
			.decode()
			.process();
			System.out.println("[Client] LoginMessage was sended. ID: " + type);
			break;
		case 10110:
		    new AnalyticsEventMessage(this.player, payload, writer)
		    .decode()
		    .process();
		    System.out.println("[Client] AnalyticsEventMessage was sended. ID: " + type);
		    break;
		case 10212:
		  new SetNameMessage(this.player, payload, writer)
		  .decode()
		  .process();
		  System.out.println("[Client] SetNameMessage was sended. ID: " + type);
		  break;
		case 14102:
		    new LogicCommandManager(this.player, payload, writer)
		    .decode()
		    .process();
		    System.out.println("[Client] LogicCommandManager was sended. ID: " + type);
		    break;
		case 14109:
			new GoHomeFromOfflinePractiseMessage(this.player, payload, writer)
			.decode()
			.process();
			System.out.println("[Client] GoHomeFromOfflinePractiseMessage was sended. ID: " + type);
			break;
		default:
			System.out.println("[Client] Unknown message was sended. ID: " + type);
			break;
		}
	}
}
