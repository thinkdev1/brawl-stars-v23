package com.nosteam.nostbrawl.Sessions;

import com.nosteam.nostbrawl.CsvReader.CsvReader;
import org.json.*;

public class PlayerSession {
	
	public int high_id, low_id, gold, gems, tickets, map_id, sp_id, brawler_id, skin_id, trophy_road, tutorial, player_experience, profile_icon, brawl_boxes, big_boxes, trophies, highest_trophies, battle_tokens, theme_id, tgid, club_low_id, club_role, solo_wins, duo_wins, TvsT_Wins, tokensdoubler, name_color, starpower, do_not_distrub, room_id, status;
	
	public String token, name, region;
	public CsvReader csv;
	
	public PlayerSession(CsvReader CsvNode) {
		this.name = "Guest";
		this.token = "None";
		this.low_id = 0;
		this.tgid = 0;
		this.high_id = 0;
		this.tutorial = 2;
		this.club_low_id = 0;
		this.club_role = 0;
		this.solo_wins = 0;
		this.duo_wins = 0;
		this.TvsT_Wins = 0;
		this.tokensdoubler = 0;
		this.trophy_road = 95;
		this.player_experience = 0;
		this.profile_icon = 0;
		this.name_color = 0;
		this.brawl_boxes = 0;
		this.big_boxes = 0;
		this.trophies = 0;
		this.highest_trophies = 0;
		this.battle_tokens = 200;
		this.theme_id = 41000000 + 1;
		this.region = "RU";
		this.brawler_id = 0;
		this.gold = 99999;
		this.gems = 99999;
		this.tickets = 99999;
		this.status = 3;
		this.starpower = 76;
		this.do_not_distrub = 0;
		this.room_id = 0;
		
		this.csv = CsvNode;
		this.sp_id = this.csv.getSpecialAbilityIDByBrawlerID(this.brawler_id);
		this.skin_id = this.csv.getSkinIDByBrawlerID(this.brawler_id);
	}
	
}
