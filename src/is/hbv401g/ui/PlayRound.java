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
import java.awt.Font;

public class PlayRound extends JPanel {
	private static Game game;
	private static User user1;
	private static User user2;
	private static JButton btnUser1, btnUser2,btnPlayRound;
	private static JButton[] btnUserArray;
	private static JLabel labelPlayer1PointsText,labelPlayer1Points,labelPlayer1NameText, lblPlayer1PointsText;
	private static JLabel labelPlayer2NameText,labelPlayer2Points,labelPlayer2PointsText, lblPlayer2PointsText;
	private static JLabel lblRound;
	
	
	public PlayRound(final Game game) {
		setLayout(null);
		this.game = game;	
		initGui();
	}
	
	public static void initPlayers() {
		user1 = game.getUsers().get(0);
		user2 = game.getUsers().get(1);
		labelPlayer1NameText.setText(user1.getName());
		labelPlayer2NameText.setText(user2.getName());
	}
	
	public static void updatePoints() {
		lblPlayer1PointsText.setText(String.valueOf(user1.getPoints()));
		lblPlayer2PointsText.setText(String.valueOf(user2.getPoints()));
	}
	
	public static void updateRound() {
		lblRound.setText("Round: " + String.valueOf(game.getCurrentRound()));
	}
	
	private void initGui() {
		btnUser1 = new JButton("Pick team");
		btnUser1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setCurrentUser(0);
				UserGui.initPlayer();
				Transfers.initPlayer();
				MainGui.showCardLayout("panelUser");
			}
		});
		btnUser1.setBounds(36, 140, 104, 44);
		add(btnUser1);
		
		btnUser2 = new JButton("Pick team");
		btnUser2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setCurrentUser(1);
				UserGui.initPlayer();
				Transfers.initPlayer();
				MainGui.showCardLayout("panelUser");
			}
		});
		btnUser2.setBounds(244, 140, 104, 44);
		add(btnUser2);
		
		btnPlayRound = new JButton("Play round");
		btnPlayRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.endRound();
			}
		});
		btnPlayRound.setEnabled(false);
		btnPlayRound.setBounds(320, 296, 177, 44);
		add(btnPlayRound);
		
		labelPlayer1PointsText = new JLabel("0");
		labelPlayer1PointsText.setBounds(118, 99, 33, 14);
		add(labelPlayer1PointsText);
		
		labelPlayer1Points = new JLabel("Points:");
		labelPlayer1Points.setBounds(47, 95, 61, 23);
		add(labelPlayer1Points);
		
		labelPlayer1NameText = new JLabel("Player 1");
		labelPlayer1NameText.setBounds(47, 73, 104, 14);
		add(labelPlayer1NameText);
		
		labelPlayer2NameText = new JLabel("Player 2");
		labelPlayer2NameText.setBounds(255, 73, 104, 14);
		add(labelPlayer2NameText);
		
		labelPlayer2Points = new JLabel("Points:");
		labelPlayer2Points.setBounds(255, 99, 61, 14);
		add(labelPlayer2Points);
		
		labelPlayer2PointsText = new JLabel("0");
		labelPlayer2PointsText.setBounds(328, 99, 33, 14);
		add(labelPlayer2PointsText);
		
		JLabel lblUsers = new JLabel("Players");
		lblUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsers.setBounds(166, 16, 104, 25);
		add(lblUsers);
		
		lblRound = new JLabel("Round: 1");
		lblRound.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRound.setBounds(41, 306, 99, 16);
		add(lblRound);
		
		btnUserArray = new JButton[]{btnUser1,btnUser2};
	}
	
	public static void endUserTurn(){
		btnUserArray[game.getUserTurn()].setEnabled(false);
		if(user1.isTransferFinished() && user2.isTransferFinished()){
			btnPlayRound.setEnabled(true);
		}
	}
}
