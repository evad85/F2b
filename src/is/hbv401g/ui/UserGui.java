package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class UserGui extends JPanel {
	JTextField textFieldUserName;
	private static Game game;
	static JTextArea textArea;

	
	/**
	 * Create the panel.
	 */
	public UserGui(final Game game) {
		setLayout(null);
		this.game = game;
		textArea = new JTextArea();
		textArea.setBounds(86, 97, 229, 154);
		add(textArea);
		
	}
	
	public static void updateTextArea() {
		List <User> users = game.getUsers();
		int i = users.size();
		String text = " ";
		for(int j = 0; j<i; j++) {
			User user = users.get(j);
			text += user.getName() + " ";
		}
		textArea.setText(text);
	}
}
