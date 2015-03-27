package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PlayRound extends JPanel {
	private static Game game;
	JButton btnPlayer1Ready, btnPlayer2Ready,btnPlayRound;
	JLabel labelPlayer1PointsText,labelPlayer1,labelPlayer2,labelPlayer1Points,labelPlayer1Name,labelPlayer1NameText;
	JLabel labelPlayer2Name,labelPlayer2NameText,labelPlayer2Points,labelPlayer2PointsText;
	
	public PlayRound(final Game game) {
		setLayout(null);
		this.game = game;
		btnPlayer1Ready = new JButton("not ready");
		btnPlayer1Ready.setBounds(47, 114, 104, 30);
		add(btnPlayer1Ready);
		
		btnPlayer2Ready = new JButton("not ready");
		btnPlayer2Ready.setBounds(257, 114, 104, 30);
		add(btnPlayer2Ready);
		
		btnPlayRound = new JButton("Play round");
		btnPlayRound.setBounds(166, 198, 104, 30);
		add(btnPlayRound);
		
		labelPlayer1PointsText = new JLabel("0");
		labelPlayer1PointsText.setBounds(118, 84, 33, 14);
		add(labelPlayer1PointsText);
		
		labelPlayer1 = new JLabel("Player 1");
		labelPlayer1.setBounds(47, 43, 104, 14);
		add(labelPlayer1);
		
		labelPlayer2 = new JLabel("Player 2");
		labelPlayer2.setBounds(257, 43, 104, 14);
		add(labelPlayer2);
		
		labelPlayer1Points = new JLabel("Points:");
		labelPlayer1Points.setBounds(47, 80, 61, 23);
		add(labelPlayer1Points);
		
		labelPlayer1Name = new JLabel("name");
		labelPlayer1Name.setBounds(47, 68, 46, 14);
		add(labelPlayer1Name);
		
		labelPlayer1NameText = new JLabel("");
		labelPlayer1NameText.setBounds(118, 68, 33, 14);
		add(labelPlayer1NameText);
		
		labelPlayer2Name = new JLabel("name");
		labelPlayer2Name.setBounds(257, 68, 46, 14);
		add(labelPlayer2Name);
		
		labelPlayer2NameText = new JLabel("");
		labelPlayer2NameText.setBounds(328, 68, 33, 14);
		add(labelPlayer2NameText);
		
		labelPlayer2Points = new JLabel("Points:");
		labelPlayer2Points.setBounds(257, 84, 61, 14);
		add(labelPlayer2Points);
		
		labelPlayer2PointsText = new JLabel("0");
		labelPlayer2PointsText.setBounds(328, 84, 33, 14);
		add(labelPlayer2PointsText);
	}
}
