package is.hbv401g.code.fantasy;

import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballTeam;
import is.hbv401g.dummy.FootballPlayer;

public class Market {
	
	private FootballPlayer[] players;
	private Core core;
	
	public Market(Core core) {
		this.core = core;
		players = this.core.getAllFootballPlayers();
	}
	
	
	public void updateMarket() {
		players = this.core.getAllFootballPlayers();
	}
	// tók út team name í params
	public FootballPlayer findPlayer(String name) {
		FootballPlayer player = null;
		for(int i = 0; i<players.length; i++) {
			if(players[i].getName().equals(name)) {
				player = players[i];
			}
		}
		return player;
		
	}

}
