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
	private String teamName;
	private int userTurn = 0;
	private Round round = new Round();
	private Core core = new Core();
	private Market market = new Market(core);
	
	
	/**
	 * 
	 * @param name
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
		UserTeam team = new UserTeam(teamName, players);
		users.get(userTurn).setUserTeam(team);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int addPlayer(String name) {
		User user = users.get(userTurn);
		Player player = market.findPlayer(name);
		double marketValue = player.getMarketValue();
		boolean validBudget = user.buyPlayer(marketValue);
		if(validBudget && tmpTeam.size()<12) {
			tmpTeam.put(name, player);
			return 0;
		}
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
	
	/**
	 * 
	 * @return
	 */
	public Core getCore() {
		return core;
	}
	
	public int getUserTurn() {
		return userTurn;
	}

}
