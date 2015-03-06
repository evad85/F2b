/**
 * @author: .....
 * @since: 27.02.2015
 * Holds user related information such as username and points and
 * includes methods to access and modify that information
 */
package is.hbv401g.code.user;


public class User {
	
	// The team the user has selected for the present
	// round
	private UserTeam userTeam; 
	private final String name; 
	private int points = 0;
	private double budget = 200.0;
	// Each seat in the array holds information about the
	// team the user selected for one round and the users score
	// in that round. The first seat is empty so that seat number 1
	// represents the first round and etc.
	private final UserRound[] rounds = new UserRound[19];
	
	/**
	 * Creates new user with name as user name
	 * @param name
	 */
	public User(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name the user has selected
	 * for himself
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the team that the user selected for
	 * the present round
	 * @return
	 */
	public UserTeam getUserTeam() {
		return userTeam;
	}

	/**
	 * Sets the users team for the present round
	 * @param userTeam
	 */
	public void setUserTeam(UserTeam userTeam) {
		this.userTeam = userTeam;
	}

	/**
	 * Returns the users accumulated points for all rounds
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Updates the users points
	 * @param points
	 */
	public void updatePoints(int points) {
		this.points += points;
	}
	
	/**
	 * Returns the users current budget
	 * @return
	 */
	public double getBudget() {
		return budget;
	}
	
	
	/**
	 * Returns true if the users budget is enough to buy
	 * a selected player with the market value marketValue and
	 * userTeam is not full. Returns false otherwise.
	 * @param marketValue
	 * @return
	 */
	public boolean buyPlayer(double marketValue, double budget) {
		boolean enoughBudget = marketValue <= budget;
		int playerCount = userTeam.getNumberOfPlayers();
		
		return true;
	}
	
	/**
	 * Adds marketValue to the users budget 
	 * @param marketValue
	 */
	public void sellPlayer(double marketValue) {
		
	}

}
