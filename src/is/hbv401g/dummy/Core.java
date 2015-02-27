package is.hbv401g.dummy;

public class Core {
	public FootballTeam[] teams;
	
	public Core() {
		Player[] liverpoolPlayers = new Player[]{new Player("Palli", 20, "Liverpool", 10, 34.5),
				new Player("Siggi", 22, "Liverpool", 11, 30.5),new Player("Maggi", 30, "Liverpool", 10, 22.5),
				new Player("Jói", 20, "Liverpool", 10, 45.0)}; 
		
		Player[] unitedPlayers = new Player[]{new Player("Palli", 20, "Manchester United", 10, 34.5),
				new Player("Siggi", 22, "Manchester United", 11, 30.5),new Player("Maggi", 30, "Manchester United", 10, 22.5),
				new Player("Jói", 20, "Manchester United", 10, 45.0)}; 
		
		Player[] tottenhamPlayers = new Player[]{new Player("Palli", 20, "Tottenham", 10, 34.5),
				new Player("Siggi", 22, "Tottenham", 11, 30.5),new Player("Maggi", 30, "Tottenham", 10, 22.5),
				new Player("Jói", 20, "Tottenham", 10, 45.0)}; 
		
		Player[] cityPlayers = new Player[]{new Player("Palli", 20, "Manchester City", 10, 34.5),
				new Player("Siggi", 22, "Manchester City", 11, 30.5),new Player("Maggi", 30, "Manchester City", 10, 22.5),
				new Player("Jói", 20, "Manchester City", 10, 45.0)}; 
		
		FootballTeam liverpool = new FootballTeam("Liverpool", liverpoolPlayers);
		FootballTeam united = new FootballTeam("Manchester United", unitedPlayers);
		FootballTeam tottenham = new FootballTeam("Tottenham", tottenhamPlayers);
		FootballTeam city = new FootballTeam("Manchester City", cityPlayers);
		
		teams = new FootballTeam[]{liverpool, united, tottenham, city};
	}
	
	public Player[] getAllPlayers() {
		return teams[0].players;
	}
	
}
