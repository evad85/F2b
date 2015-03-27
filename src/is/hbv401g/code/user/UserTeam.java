package is.hbv401g.code.user;

import is.hbv401g.dummy.FootballPlayer;

import java.util.HashMap;
import java.util.Random;


public class UserTeam {
	
HashMap<String, FootballPlayer> players;
	
	
	public UserTeam(HashMap<String, FootballPlayer> players) {
		// TODO Auto-generated constructor stub
		players = new HashMap<String, FootballPlayer>();

		
	}

	public int getNumberOfPlayers() {
		Random rand = new Random();
	    int randomNum = rand.nextInt((15 - 0) + 1) + 0;
		return randomNum;
	}
	
	public HashMap<String, FootballPlayer> getPlayers() {
		return players;
	}


}
