package is.hbv401g.code.user;

import is.hbv401g.dummy.Player;

import java.awt.Image;

public class UserTeam {
	private final String name;
	private Player[] players = new Player[11];
	private final Image logo = null;
	
	public UserTeam(String name, Player[] players) {
		this.name = name;
		this.players = players;
	}
	

}
