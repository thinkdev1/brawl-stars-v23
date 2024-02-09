package com.nosteam.nostbrawl.Database;

import com.nosteam.nostbrawl.Sessions.PlayerSession;

public class CreateBrawlersList {
  public PlayerSession player;

    public CreateBrawlersList(PlayerSession a1) {
        this.player = a1;
    }
  public void start() {
      Integer[] BrawlersUnlockedState = {};
      for(int id : this.player.csv.getBrawlersIDs()) {
          if (id == 0) {
              ;//BrawlersUnlockedState = Integer[].valueOf(1);
          }
          else {
              ;//BrawlersUnlockedState = Integer[].valueOf(0);
          }
      }
      ;//return BrawlersUnlockedState;
  }
}