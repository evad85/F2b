package is.hbv401g.dummy;

public class FootballTeam {
	private String teamName;
	public Player [] players = null;
	private int numPlayers = 0;
	
	public FootballTeam(String name, Player[] players) {
		this.teamName = name;
		this.players = players;
		numPlayers = players.length;
	}
	
	public void addPlayer(Player player) {
		players[numPlayers] = player;
		numPlayers++;
	}
	
	public Player[] getAllPlayers() {
		return players;
	}
	
	public String getTeamName() {
		return teamName;
	}
}


