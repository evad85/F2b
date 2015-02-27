package is.hbv401g.ui;

import is.hbv401g.code.Game;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfers extends JPanel {

	private Game game;
	/**
	 * Create the panel.
	 */
	public Transfers(final Game game) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.game = game;

	}

}
