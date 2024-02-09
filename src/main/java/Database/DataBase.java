package com.nosteam.nostbrawl.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

public class DataBase {
  public PlayerSession player;

    public DataBase(PlayerSession a1) {
        this.player = a1;
    }
	public void loadAccount() {
	    Connection conn = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        String userName = "sammy";
	        String password = "compot6753";
	        String url = "jdbc:MySQL://localhost:3306/direbrawl";
	        conn = DriverManager.getConnection(url, userName, password);
	        
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * FROM players WHERE token = '" + this.player.token + "'");
	            while (rs.next()) {
	                this.player.token = rs.getString("token");
	                this.player.name = rs.getString("name");
	                this.player.trophy_road = rs.getInt("leagueReward");
	                this.player.low_id = rs.getInt("lowID");
	                this.player.tgid = rs.getInt("tgid");
	                this.player.club_low_id = rs.getInt("clubID");
	                this.player.club_role = rs.getInt("clubID");
	                this.player.player_experience = rs.getInt("playerExp");
	                this.player.solo_wins = rs.getInt("soloWins");
	                this.player.duo_wins = rs.getInt("duoWins");
	                this.player.TvsT_Wins = rs.getInt("TvsTWins");
	                this.player.gems = rs.getInt("gems");
	                this.player.gold = rs.getInt("gold");
	                this.player.tokensdoubler = rs.getInt("tokensdoubler");
	                this.player.battle_tokens = rs.getInt("availableTokens");
	                this.player.tickets = rs.getInt("tickets");
	                this.player.brawler_id = rs.getInt("brawlerID");
	                this.player.skin_id = rs.getInt("skinID");
	                this.player.trophies = rs.getInt("trophies");
	                this.player.highest_trophies = rs.getInt("highestTrophies");
	                this.player.profile_icon = rs.getInt("profileIcon");
	                this.player.name_color = rs.getInt("nameColor");
	                this.player.brawl_boxes = rs.getInt("brawlBoxes");
	                this.player.big_boxes = rs.getInt("bigBoxes");
	                this.player.starpower = rs.getInt("starpower");
	                this.player.do_not_distrub = rs.getInt("doNotDistrub");
	                this.player.room_id = rs.getInt("roomID");
	                this.player.status = rs.getInt("status");
	            }
	        }
	        catch (SQLException ex) {
	            System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                }
	                catch (SQLException sqlEx) {
	                    rs = null;
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                }
	                catch (SQLException sqlEx) {
	                    stmt = null;
	                }
	            }
	        }
	    }
	    catch (Exception ex) {
	        System.out.println("Error to connection");
	        ex.printStackTrace();
	    }
	    finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            }
	            catch (Exception ex) {
	                System.out.println("Error in connection termination!");
	            }
	        }
	    }
	}
	public void createAccount() {
	    Connection conn = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        String userName = "sammy";
	        String password = "compot6753";
	        String url = "jdbc:MySQL://localhost:3306/direbrawl";
	        conn = DriverManager.getConnection(url, userName, password);
	        
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            stmt = conn.createStatement();
	            rs = null; //stmt.executeQuery("CREATE TABLE IF NOT EXISTS players ( token CHAR(200), name CHAR(200), `lowID` INT )");
	            String command1 = "CREATE TABLE IF NOT EXISTS players ( token CHAR(200), name CHAR(200), `leagueReward` INT, `lowID` INT, `tgid` INT, `clubID` INT, `clubRole` INT, `playerExp` INT, `soloWins` INT, `duoWins` INT, `TvsTWins` INT, `gems` INT, `gold` INT, `tokensdoubler` INT, `availableTokens` INT, `tickets` INT, `brawlerID` INT, `skinID` INT, `trophies` INT, `highestTrophies` INT, `profileIcon` INT, `nameColor` INT, `brawlBoxes` INT, `bigBoxes` INT, `starpower` INT, `doNotDistrub` INT, `roomID` INT, `status` INT )";
	            String command2 = "INSERT INTO `players` VALUES ( '" + this.player.token + "', '" + this.player.name + "', '" + this.player.trophy_road + "', '" + this.player.low_id + "', '" + this.player.tgid + "', '" + this.player.club_low_id + "', '" + this.player.club_role + "', '" + this.player.player_experience + "', '" + this.player.solo_wins + "', '" + this.player.duo_wins + "', '" + this.player.TvsT_Wins + "', '" + this.player.gems + "', '" + this.player.gold + "', '" + this.player.tokensdoubler + "', '" + this.player.battle_tokens + "', '" + this.player.tickets + "', '" + this.player.brawler_id + "', '" + this.player.skin_id + "', '" + this.player.trophies + "', '" + this.player.highest_trophies + "', '" + this.player.profile_icon + "', '" + this.player.name_color + "', '" + this.player.brawl_boxes + "', '" + this.player.big_boxes + "', '" + this.player.starpower + "', '" + this.player.do_not_distrub + "', '" + this.player.room_id + "', '" + this.player.status + "')";
	            stmt.addBatch(command1);
	            stmt.addBatch(command2);
	            stmt.executeBatch();
	        }
	        catch (SQLException ex) {
	            System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                }
	                catch (SQLException sqlEx) {
	                    rs = null;
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                }
	                catch (SQLException sqlEx) {
	                    stmt = null;
	                }
	            }
	        }
	    }
	    catch (Exception ex) {
	        System.out.println("Error to connection");
	        ex.printStackTrace();
	    }
	    finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            }
	            catch (Exception ex) {
	                System.out.println("Error in connection termination!");
	            }
	        }
	    }
	}
	public void replaceValue(String value_name, String new_value) {
	    Connection conn = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        String userName = "sammy";
	        String password = "compot6753";
	        String url = "jdbc:MySQL://localhost:3306/direbrawl";
	        conn = DriverManager.getConnection(url, userName, password);
	        
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            stmt = conn.createStatement();
	            rs = null;
	            String command = "UPDATE players SET " + value_name + " = '" + new_value + "' WHERE token = '" + this.player.token + "'";
	            stmt.addBatch(command);
	            stmt.executeBatch();
	        }
	        catch (SQLException ex) {
	            System.out.println("SQLException: " + ex.getMessage());
              System.out.println("SQLState: " + ex.getSQLState());
              System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                }
	                catch (SQLException sqlEx) {
	                    rs = null;
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                }
	                catch (SQLException sqlEx) {
	                    stmt = null;
	                }
	            }
	        }
	    }
	    catch (Exception ex) {
	        System.out.println("Error to connection");
	        ex.printStackTrace();
	    }
	    finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            }
	            catch (Exception ex) {
	                System.out.println("Error in connection termination!");
	            }
	        }
	    }
	}
}