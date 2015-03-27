package is.hbv401g.mock;

import java.util.HashMap;
import java.util.Random;

import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.FootballPlayer;

public class RandomNumberOfPlayersMock {
	
	HashMap<String, FootballPlayer> players;
	
	
	public RandomNumberOfPlayersMock() {
		// TODO Auto-generated constructor stub
		players = new HashMap<String, FootballPlayer>();
		players.put("Sterling", new FootballPlayer("Sterling", 20, "Liverpool", 10, 34.5));
		players.put("Gerrard", new FootballPlayer("Gerrard", 22, "Liverpool", 11, 30.5));
		players.put("Jói", new FootballPlayer("Jói", 20, "Spurs", 10, 45.0));
		players.put("Siggi", new FootballPlayer("Siggi", 22, "Man City", 11, 30.5));
		players.put("Rooney", new FootballPlayer("Rooney", 20, "Man Utd", 10, 34.5));
		players.put("Palli", new FootballPlayer("Palli", 20, "Arsenal", 10, 34.5));
		players.put("Halli", new FootballPlayer("Halli", 20, "Stoke", 10, 34.5));
		players.put("Gunnar", new FootballPlayer("Gunnar", 20, "Chelsea", 10, 34.5));
		players.put("Gylfi", new FootballPlayer("Gylfi", 20, "Swansea", 10, 34.5));
		players.put("Rikki", new FootballPlayer("Rikki", 20, "Southampton", 10, 34.5));
		players.put("Bjarki", new FootballPlayer("Bjarki", 20, "West Ham", 10, 34.5));
		
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
