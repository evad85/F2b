package is.hbv401g.code;

public class UserRound {
	
	private final UserTeam userTeam;
	private final int score;
	
	public UserRound(UserTeam team, int score) {
		userTeam = team;
		this.score = score;
	}

	public UserTeam getUserTeam() {
		return userTeam;
	}

	public int getScore() {
		return score;
	}

}
