package is.hbv401g.mock;

import is.hbv401g.code.user.UserTeam;

public class FullTeamMock implements UserTeam {

	@Override
	public int getNumberOfPlayers() {
		return 15;
	}
}