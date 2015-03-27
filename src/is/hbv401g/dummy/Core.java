package is.hbv401g.dummy;

public class Core {
	public FootballTeam[] teams;
	
	public Core() {
		FootballPlayer[] liverpoolPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Liverpool", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Liverpool", 11, 30.5),new FootballPlayer("Maggi", 30, "Liverpool", 10, 22.5),
				new FootballPlayer("Jói", 20, "Liverpool", 10, 45.0)}; 
		
		FootballPlayer[] unitedPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Manchester United", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Manchester United", 11, 30.5),new FootballPlayer("Maggi", 30, "Manchester United", 10, 22.5),
				new FootballPlayer("Jói", 20, "Manchester United", 10, 45.0)}; 
		
		FootballPlayer[] tottenhamPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Tottenham", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Tottenham", 11, 30.5),new FootballPlayer("Maggi", 30, "Tottenham", 10, 22.5),
				new FootballPlayer("Jói", 20, "Tottenham", 10, 45.0)}; 
		
		FootballPlayer[] cityPlayers = new FootballPlayer[]{new FootballPlayer("Palli", 20, "Manchester City", 10, 34.5),
				new FootballPlayer("Siggi", 22, "Manchester City", 11, 30.5),new FootballPlayer("Maggi", 30, "Manchester City", 10, 22.5),
				new FootballPlayer("Jói", 20, "Manchester City", 10, 45.0)}; 
		
		FootballTeam liverpool = new FootballTeam("Liverpool", liverpoolPlayers);
		FootballTeam united = new FootballTeam("Manchester United", unitedPlayers);
		FootballTeam tottenham = new FootballTeam("Tottenham", tottenhamPlayers);
		FootballTeam city = new FootballTeam("Manchester City", cityPlayers);
		
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
