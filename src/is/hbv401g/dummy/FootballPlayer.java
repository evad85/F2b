package is.hbv401g.dummy;

public class FootballPlayer {
	private String name;
	private int age;
	private int number;
	private String teamName;
	private double marketValue;
	private Statistics [] roundStatistics = new Statistics[19];
	
	public FootballPlayer(String name, int age, String teamName, int number,
			double marketValue) {
		this.name = name;
		this.age = age;
		this.number = number;
		this.teamName = teamName;
		this.marketValue = marketValue;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void updateMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public Statistics [] getRoundStatistics() {
		return roundStatistics;
	}

	public void addRoundStatistics(int round, Statistics statistic) {
		roundStatistics[round] = statistic;
	}

}
