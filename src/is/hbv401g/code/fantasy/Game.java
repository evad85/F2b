package is.hbv401g.code.fantasy;

import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.mock.RandomNumberOfPlayersMock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final List <User> users = new ArrayList<>();
	private HashMap<String, FootballPlayer> tmpTeam = new HashMap<String, FootballPlayer>();
	private int roundNumber = 0;
	private String teamName;
	private int maxRounds = 18;
	private int userTurn = 0;
	private Core core = new Core();
	private Market market = new Market(core);
	
	
	/**
	 * 
	 * @param name
	 * 
	 */
	public void addNewUser(String userName, String teamName ) {
		User newUser = new User(userName, new UserTeam(null));
		users.add(newUser);
		this.teamName = teamName;
	}

	
	/**
	 * 
	 */
	public void updateUserTeam() {
		
		FootballPlayer[] players = (FootballPlayer[])tmpTeam.values().toArray();
		UserTeam team = new UserTeam(tmpTeam);
		users.get(userTurn).setUserTeam(team);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int addPlayer(String name) {
		User user = users.get(userTurn);
		FootballPlayer player = market.findPlayer(name);
		double marketValue = player.getMarketValue();
		System.out.println("budget before buy" + user.getBudget());
		if(user.hasEnoughBudget(marketValue) && tmpTeam.size()<12) {
			tmpTeam.put(name, player);
			user.updateBudget(marketValue, true);
			System.out.println("budget after buy" + user.getBudget());
			return 0;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removePlayer(String name) {
		User user = users.get(userTurn);
		FootballPlayer player = market.findPlayer(name);
		double marketValue = player.getMarketValue();
		if (tmpTeam.size() > 0) {
			user.updateBudget(marketValue, false);
			tmpTeam.remove(name);
		}
		System.out.println("budget after sell" + user.getBudget());
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
		return core;
	}
	
	public int getUserTurn() {
		return userTurn;
	}
	
	private void calculatePoints() {
		
	}
	
	public int getCurrentRound() {
		return roundNumber;
	}
	
	public Market getMarket(){
		return market;
	}

}
