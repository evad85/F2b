package is.hbv401g.mock;

import java.util.Random;

import is.hbv401g.code.user.UserTeam;

public class RandomNumberOfPlayersMock implements UserTeam {

	@Override
	public int numberOfPlayers() {
		Random rand = new Random();
	    int randomNum = rand.nextInt((15 - 0) + 1) + 0;
		return randomNum;
	}

}
