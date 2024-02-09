package com.nosteam.nostbrawl.Messaging.Messages.Server.Home;

import java.io.DataOutputStream;

import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Utils.ByteStream;
import com.nosteam.nostbrawl.Utils.createMessage;
import com.nosteam.nostbrawl.Utils.EventsManager;

import com.nosteam.nostbrawl.Database.DataBase;

public class OwnHomeDataMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 24101,
				version = 0;

	public OwnHomeDataMessage(PlayerSession plr, DataOutputStream Writer) {

		super(5000);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {
	  
	  new DataBase(this.player).loadAccount();

		this.writeVint(0);
		this.writeVint(0);

		this.writeVint(this.player.trophies); // Trophies
		this.writeVint(this.player.highest_trophies); // Highest Trophies

		this.writeVint(0);
		this.writeVint(this.player.trophy_road); // unlocked trophy road rewards
		this.writeVint(99999); // exp

		this.writeScId(28, this.player.profile_icon); // Profile Icon id
		this.writeScId(43, this.player.name_color); // Player name color id

		this.writeVint(0);

		this.writeVint(1); // Selected skins array
		this.writeScId(29, this.player.skin_id);

		this.writeVint(this.player.csv.getSkinsCount()); // Unlocked skins array
		for (int ID : this.player.csv.getSkinsIDs()) {
			this.writeScId(29, ID);
		}

		this.writeVint(0);
		this.writeVint(0);
		this.writeVint(0);

		this.writeBoolean(false);
		this.writeVint(1);
		this.writeBoolean(true);

		this.writeVint(this.player.tokensdoubler); // token doubler count
		this.writeVint(3600); // season end timer

		this.writeVint(0);
		this.writeVint(0);
		this.writeVint(0);
		this.writeVint(0);
		this.writeByte(8);

		this.writeBoolean(false);
		this.writeBoolean(false);
		this.writeBoolean(false);

		this.writeVint(0); // change name cost
		this.writeVint(0); // time left to change name

		this.writeVint(0); // shop array
		this.writeVint(0);
		this.writeVint(this.player.battle_tokens); // Battle Tokens
		this.writeVint(0);

		this.writeVint(0);

		this.writeVint(this.player.tickets); // Tickets count

		this.writeVint(0);

		this.writeScId(16, this.player.brawler_id); // Selected Brawler

		this.writeString("RU"); // region
		this.writeString("Nost Team"); // supported cc

		this.writeVint(0);
		this.writeVint(0);
		this.writeVint(0);
		this.writeVint(0);

		this.writeVint(2019049);
		this.writeVint(100); // Tokens for a brawl box
		// SHOP BRAWL BOX
		this.writeVint(10);
		// SHOP BIGBOX
		this.writeVint(30);
		this.writeVint(3);
		// SHOP MEGABOX
		this.writeVint(80);
		this.writeVint(10);
		// SHOP TOKENDOUBLER
		this.writeVint(50);
		this.writeVint(1000);

		this.writeVint(500);

		this.writeVint(50);
		this.writeVint(999900);

		this.writeVint(1);
		this.writeVint(1);

		int[][] events = EventsManager.events;

		// event slots ids
		this.writeVint(events.length + 1);
		for (int x = 0; x < events.length + 1 ; x++) {
			this.writeVint(x);
		}
		// end

		// EventSlots
		this.writeVint(events.length); // count
		for (int index = 0; index < events.length; index++) {
			this.writeVint(index + 1);
			this.writeVint(index + 1); // index
			this.writeVint(0); // new event timer
			this.writeVint(99999); // timer
			this.writeVint(0); // New event reward ammount
			this.writeScId(15, events[index][0]); // map ID
			this.writeVint(3); // status
			this.writeString();
			this.writeVint(0);
			this.writeVint(0); // pp game played
			this.writeVint(0); // pp games left
			this.writeVint(events[index].length - 1); // Modifiers count
			for (int m  = 1; m < events[index].length; m++) {
				this.writeVint(events[index][m]); // Modifier ID
			}
			this.writeVint(16); // special event difficulty level
		}
		// end
		this.writeVint(0); // next event slots array
		// shop
		this.writeVint(8);
		int[] i_1 = {20, 35, 75, 140, 290, 480, 800, 1250};
		for (int i : i_1) {
			this.writeVint(i);
		}
		this.writeVint(8);
		int[] i_2 = {1, 2, 3, 4, 5, 10, 15, 20};
		for (int i : i_2) {
			this.writeVint(i);
		}
		this.writeVint(3);
		int[] i_3 = {10, 30, 80};
		for (int i : i_3) {
			this.writeVint(i);
		}
		this.writeVint(3);
		int[] i_4 = {6, 20, 60};
		for (int i : i_4) {
			this.writeVint(i);
		}
		this.writeVint(4);
		int[] i_5 = {20, 50, 140, 280};
		for (int i : i_5) {
			this.writeVint(i);
		}
		this.writeVint(4);
		int[] i_6 = {150, 400, 1200, 2600};
		for (int i : i_6) {
			this.writeVint(i);
		}
		// end
		this.writeVint(0);
		this.writeVint(200);
		this.writeVint(20);

		this.writeVint(8640);
		this.writeVint(10);
		this.writeVint(5);

		this.writeVint(6);

		this.writeVint(50);
		this.writeVint(604800);

		this.writeBoolean(true);

		this.writeVint(0); // array

		this.writeVint(1); // menu theme
		this.writeInt(1);
		this.writeInt(41000000); // theme id

		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);

		this.writeVint(0); // array
		this.writeBoolean(true);
		this.writeVint(0);
		this.writeVint(0);
		// player data
		this.writeVint(this.player.high_id);
		this.writeVint(this.player.low_id);

		this.writeVint(this.player.high_id);
		this.writeVint(this.player.low_id);

		this.writeVint(this.player.high_id);
		this.writeVint(this.player.low_id);

		if (this.player.name == "Guest") {
		  this.writeString("Guest");
		  this.writeVint(0);
		  new DataBase(this.player).createAccount();
		}
		else {
		  this.writeString(this.player.name);
		  this.writeVint(1);
		}

		this.writeInt(0);
		this.writeVint(8);

		// Unlocked Brawlers & Resources Array

		int brawlers_count = this.player.csv.getBrawlersCount();
		Integer[] brawlers_ids = this.player.csv.getBrawlersIDs();

		this.writeVint(brawlers_count + 4);

		for (int ID : this.player.csv.getBrawlersUnlockIDs()) {
			this.writeScId(23, ID);
			this.writeVint(1);
		}

		this.writeScId(5, 1);
		this.writeVint(this.player.brawl_boxes); // brawl boxes

		this.writeScId(5, 8);
		this.writeVint(this.player.gold); // gold

		this.writeScId(5, 9);
		this.writeVint(this.player.big_boxes); // big boxes

		this.writeScId(5, 10);
		this.writeVint(99999); // star points

		// Brawlers Trophies array
		this.writeVint(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeScId(16, ID);
			this.writeVint(0);
		}

		// Brawlers Rank Trophies array
		this.writeVint(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeScId(16, ID);
			this.writeVint(0);
		}

		this.writeVint(0);

		// Brawlers PowerPoints array
		this.writeVint(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeScId(16, ID);
			this.writeVint(0);
		}

		// Brawlers levels array
		this.writeVint(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeScId(16, ID);
			this.writeVint(8);
		}

		// unlocked/selected special abilities array
		this.writeVint(this.player.csv.getBrawlersSpecialAbilitiesCount());
		for (int ID : this.player.csv.getBrawlersSpecialAbilitiesIDs()) {
			this.writeScId(23, ID);
			if (ID == this.player.sp_id) {
				this.writeVint(2);
			} else {
				this.writeVint(1);
			}
		}

		this.writeVint(0);

		this.writeVint(this.player.gems); // gems
		this.writeVint(0);
		this.writeVint(1);
		for (int i = 0; i < 8; i++) {
			this.writeVint(0);
		}
		this.writeVint(2); // Tutorial state
		this.writeVint(0);
		
		System.out.println("[Server] OwnHomeDataMessage was sended. ID: " + type);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
