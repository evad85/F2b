package is.hbv401g.code.user;

import is.hbv401g.dummy.FootballPlayer;

import java.util.HashMap;
import java.util.Random;


public class UserTeam {
	
	private static HashMap<String, FootballPlayer> players;
	
	
	public UserTeam() {
		players = new HashMap<String, FootballPlayer>();
	}
	
	public int size() {
		return players.size();
	}
	
	public HashMap<String, FootballPlayer> getPlayers() {
		return players;
	}
	
	public void addPlayer(String name, FootballPlayer player) {
		players.put(name, player);
	}
	
	public void removePlayer(String name) {
		players.remove(name);
	}
	
	public boolean containsPlayer(String name) {
		return players.containsKey(name);
	}
}
