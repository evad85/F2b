package is.hbv401g.dummy;

public class FootballTeam {
	private String teamName;
	public FootballPlayer [] players = null;
	private int numPlayers = 0;
	
	public FootballTeam(String name, FootballPlayer[] players) {
		this.teamName = name;
		this.players = players;
		numPlayers = players.length;
	}
	
	public void addPlayer(FootballPlayer player) {
		players[numPlayers] = player;
		numPlayers++;
	}
	
	public FootballPlayer[] getAllPlayers() {
		return players;
	}
	
	public String getTeamName() {
		return teamName;
	}
}


