package is.hbv401g.code;

import java.util.ArrayList;

public class Game {
	private final ArrayList <User> users = new ArrayList<>();
	private UserTeam tmpTeam = null;
	private int userTurn = 0;
	private int roundNumber = 0;
	private int maxRounds = 18;
	private FootballTeam[] allTeams = null;
	
	
	/**
	 * 
	 * @param name
	 */
	public void addNewUser(String name) {
		User newUser = new User(name);
		users.add(newUser);
	}
	
	/**
	 * 
	 */
	private void updateUserTeam() {
		
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int addPlayer(String name) {
		return 0;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removePlayer(String name) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**
	 * 
	 */
	public void changeUserTurn() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean endRound() {
		return false;
	}

}
