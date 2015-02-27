package is.hbv401g.code.fantasy;

import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballTeam;
import is.hbv401g.dummy.Player;

public class Market {
	
	private FootballTeam allTeams;
	private Core core;
	
	public Market(Core core) {
		this.core = core;
		allTeams = new FootballTeam("Öll lið", this.core.getAllPlayers());
	}
	
	
	public void updateMarket() {
		allTeams = new FootballTeam("Öll lið", core.getAllPlayers());
	}
	
	public Player findPlayer(String name) {
		Player[] allPlayers = allTeams.getAllPlayers();
		Player player = null;
		for(int i = 0; i<allPlayers.length; i++) {
			if(allPlayers[i].getName().equals(name)) {
				player = allPlayers[i];
			}
		}
		return player;
		
	}

}
