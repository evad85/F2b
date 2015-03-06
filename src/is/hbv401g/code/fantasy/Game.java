package is.hbv401g.code.fantasy;

import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final List <User> users = new ArrayList<>();
	private HashMap<String, Player> tmpTeam = new HashMap<String, Player>();
	private int roundNumber = 0;
	private String teamName;
	private int maxRounds = 18;
	private int userTurn = 0;
	private Core base = new Core();
	private Market market = new Market(base);
	
	
	/**
	 * 
	 * @param name
	 * 
	 */
	public void addNewUser(String userName, String teamName ) {
		User newUser = new User(userName);
		users.add(newUser);
		this.teamName = teamName;
	}
	
	/**
	 * 
	 */
	private void updateUserTeam() {
		Player[] players = (Player[])tmpTeam.values().toArray();
		//UserTeam team = new UserTeam(teamName, players);
		//users.get(userTurn).setUserTeam(team);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int addPlayer(String name) {
		User user = users.get(userTurn);
		Player player = market.findPlayer(name, "");
		double marketValue = player.getMarketValue();
		//boolean validBudget = user.buyPlayer(marketValue);
		//if(validBudget && tmpTeam.size()<12) {
			//tmpTeam.put(name, player);
			//return 0;
		//}
		return -1;
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
	public List<User> getUsers() {
		return users;
	}
	
	public User getCurrentUser() {
		return users.get(userTurn);
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
		// updateTeam
		// athuga hvort að allir séu búnir að gera
		// updateMarket
		// uppfæra stig
		// breyta userTurn í 0
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Core getCore() {
		return base;
	}
	
	public int getUserTurn() {
		return userTurn;
	}
	
	private void calculatePoints() {
		
	}
	
	public int getCurrentRound() {
		return roundNumber;
	}

}
