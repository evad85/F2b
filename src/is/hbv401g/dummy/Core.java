package is.hbv401g.dummy;

public class Core {
	public FootballTeam[] teams;
	
	public Core() {
		FootballPlayer[] liverpoolPlayers = new FootballPlayer[]{new FootballPlayer("Sterling", 20, "Liverpool", 10, 34.5),
				new FootballPlayer("Gerrard", 22, "Liverpool", 11, 30.5),new FootballPlayer("Balotelli", 30, "Liverpool", 10, 22.5),
				new FootballPlayer("Sturrige", 20, "Liverpool", 10, 45.0)}; 
		
		FootballPlayer[] unitedPlayers = new FootballPlayer[]{new FootballPlayer("Rooney", 20, "Man Utd", 10, 34.5),
				new FootballPlayer("Di Maria", 22, "Man Utd", 11, 30.5),new FootballPlayer("De Gea", 30, "Man Utd", 10, 22.5),
				new FootballPlayer("Falcao", 20, "Man Utd", 10, 45.0)}; 
		
		FootballPlayer[] tottenhamPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Spurs", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Spurs", 11, 30.5),new FootballPlayer("Maggi", 30, "Spurs", 10, 22.5),
				new FootballPlayer("Jói", 20, "Spurs", 10, 45.0)}; 
		
		FootballPlayer[] cityPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Man City", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Man City", 11, 30.5),new FootballPlayer("Maggi", 30, "Man City", 10, 22.5),
				new FootballPlayer("Jói", 20, "Man City", 10, 45.0)}; 
		
		FootballTeam liverpool = new FootballTeam("Liverpool", liverpoolPlayers);
		FootballTeam united = new FootballTeam("Man Utd", unitedPlayers);
		FootballTeam tottenham = new FootballTeam("Spurs", tottenhamPlayers);
		FootballTeam city = new FootballTeam("Man City", cityPlayers);
		
		teams = new FootballTeam[]{liverpool, united, tottenham, city};
	}
	
	public FootballPlayer[] getAllPlayers() {
		return teams[0].players;
	}
	
	public static String[] getNextRoundSchedule(){
		String[] schedule = {"Liverpool - Chelsea", "Southampton - Spurs","WestHam - Swansea", "Stoke - Manchester United", "Manchester City - Arsenal"};
		return schedule;
	}

}
