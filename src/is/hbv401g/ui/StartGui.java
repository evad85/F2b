package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StartGui extends JPanel {
	
	private Game game;
	
	private JTextField textFieldUserName1, textFieldUserName2;
	private String user1, user2;
	private JLabel lblErrorMessage;

	/**
	 * Create the panel.
	 */
	public StartGui(Game game) {
		setLayout(null);
		this.game = game;
		
		initGui();

	}
	
	private void addUsers(){
		game.addNewUser(user1);
		game.addNewUser(user2);
	}
	
	private void initGui() {	
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBounds(254, 214, 291, 272);
		add(playerPanel);
		playerPanel.setLayout(null);
		JButton btnNewGame = new JButton("Start game");
		btnNewGame.setBounds(0, 228, 291, 40);
		playerPanel.add(btnNewGame);
		
		textFieldUserName1 = new JTextField();
		textFieldUserName1.setBounds(0, 24, 291, 40);
		playerPanel.add(textFieldUserName1);
		textFieldUserName1.setColumns(10);
		
		textFieldUserName2 = new JTextField();
		textFieldUserName2.setBounds(0, 132, 291, 40);
		playerPanel.add(textFieldUserName2);
		textFieldUserName2.setColumns(10);
		
		JLabel labelUsernName1 = new JLabel("Player 1");
		labelUsernName1.setBounds(2, 0, 119, 14);
		playerPanel.add(labelUsernName1);
		
		JLabel labelUserName2 = new JLabel("Player 2");
		labelUserName2.setBounds(0, 106, 199, 14);
		playerPanel.add(labelUserName2);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(0, 184, 291, 32);
		playerPanel.add(lblErrorMessage);
		
		JLabel lblFantasyFootball = new JLabel("Fantasy Football");
		lblFantasyFootball.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		lblFantasyFootball.setBounds(248, 36, 304, 55);
		add(lblFantasyFootball);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user1=textFieldUserName1.getText();
				user2=textFieldUserName2.getText();
				if(user1.equals("") || user2.equals("")){
					lblErrorMessage.setText("Vinsamlegast fylla út leikmannanöfn");
					lblErrorMessage.setVisible(true);
				}
				else{
					addUsers();
					PlayRound.initPlayers();
					MainGui.showCardLayout("panelPlayRound");
				}
			}
		});
	}
}
