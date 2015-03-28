package is.hbv401g.code.fantasy;

import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.mock.RandomNumberOfPlayersMock;
import is.hbv401g.ui.MainGui;
import is.hbv401g.ui.PlayRound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final List <User> users = new ArrayList<>();
	private UserTeam tmpTeam = new UserTeam();
	private int roundNumber = 0;
	private int maxRounds = 18;
	private int userTurn = 0;
	private Core core = new Core();
	private Market market = new Market(core);
	private boolean firstGame = true;
	
	public Game() {
		
	}
	
	/**
	 * 
	 * @param name
	 * 
	 */
	public void addNewUser(String userName) {
		User newUser = new User(userName, new UserTeam());
		users.add(newUser);
	}

	
	/**
	 * 
	 */
	public void updateUserTeam() {
		users.get(userTurn).setUserTeam(tmpTeam);
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
		if(tmpTeam.containsPlayer(name)) {
			return 1;
		}
		else if(user.hasEnoughBudget(marketValue) && tmpTeam.size()<12) {
			tmpTeam.addPlayer(name, player);
			user.updateBudget(marketValue, true);
			System.out.println("budget " + user.getBudget());
			System.out.println("marketvalue " +marketValue);
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
			tmpTeam.removePlayer(name);
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
	
	public void setCurrentUser(int userNum) {
		userTurn = userNum;
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
	
	public void setTmpTeam(UserTeam tmpTeam) {
		this.tmpTeam = tmpTeam;
	}
	
	public int getNumberOfSelectedPlayers() {
		return tmpTeam.size();
	}
	
	public void endUserTurn() {
		updateUserTeam();
		users.get(userTurn).setTransferFinished(true);
		PlayRound.endUserTurn();
		tmpTeam = new UserTeam();
		MainGui.showCardLayout("panelPlayRound");
	}
	
	public void setFirstGame(boolean value) {
		firstGame = value;
	}
	
	public boolean isFirstGame() {
		return firstGame;
	}
}
