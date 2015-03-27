package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.mock.RandomNumberOfPlayersMock;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ListSelectionModel;

import java.awt.Font;

public class Transfers extends JPanel {

	private Game game;
	private JList listMarket;
	private JLabel lblBudget;
	private JLabel lblNewLabel;
	private JLabel goalkeeperImg;
	private JLabel defenceImg1;
	private JLabel defenceImg2;
	private JLabel defenceImg3;
	private JLabel defenceImg4;
	private JLabel middleImg1;
	private JLabel middleImg2;
	private JLabel middleImg3;
	private JLabel middleImg4;
	private JLabel forwardImg1;
	private JLabel forwardImg2;
	private JButton addDefence1;
	private JButton addDefence2;
	private JButton addDefence3;
	private JButton addDefence4;
	private JButton addMiddle1;
	private JButton addMiddle2;
	private JButton addMiddle3;
	private JButton addMiddle4;
	private JButton addForward1;
	private JButton addForward2;
	private JButton addGoalkeeper;
	private JLabel defenceName1;
	private JLabel defenceName2;
	private JLabel defenceName3;
	private JLabel defenceName4;
	private JButton btnI;
	private JButton btnI_1;
	private JButton btnI_2;
	private JButton btnI_3;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel middleName1;
	private JLabel middleName2;
	private JLabel middleName3;
	private JLabel middleName4;
	private JLabel forwardName1;
	private JLabel forwardName2;
	private JButton button_6;
	private JLabel goalkeeperName;
	private JLabel budgetLabel;
	
	private HashMap<String, ImageIcon> shirts;
	private ArrayList<JButton> addButtons;
	
	private ArrayList<JLabel> namesLabels;
	private ArrayList<JLabel> shirtLabels;
	JFrame frame = new JFrame();
	/**
	 * Create the panel.
	 */
	public Transfers(Game game) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				setMarket();
			}
		});
		this.game = game;
		setLayout(null);
		
		shirts = new HashMap<String, ImageIcon>();
		initShirts();
		initView();
		
		displayUserTeam();
		

		
		listMarket = new JList();
		listMarket.setBounds(583, 37, 197, 304);
		add(listMarket);
		
		lblBudget = new JLabel("New label");
		lblBudget.setBounds(583, 310, 61, 16);
		add(lblBudget);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(583, 338, 61, 16);
		add(lblNewLabel);
		
		JLabel lblBudget_1 = new JLabel("Budget:");
		lblBudget_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBudget_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBudget_1.setBounds(332, 521, 61, 40);
		add(lblBudget_1);
		
		budgetLabel = new JLabel("200 kr");
		budgetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		budgetLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		budgetLabel.setBounds(414, 521, 61, 40);
		add(budgetLabel);
		
		
	}
	
	private void displayUserTeam() {
		//UserTeam userTeam = game.getCurrentUser().getUserTeam();
		//HashMap<String, FootballPlayer> players = userTeam.getPlayers();
	}
	
	/**
	 * 
	 */
	private void buyPlayer(FootballPlayer player, String playerName) {
		int valid = game.addPlayer(playerName);
		if(valid==0) {
			defenceName1.setText(playerName);
			defenceImg1.setIcon(shirts.get(player.getTeamName()));
			addDefence1.setText("X");
			budgetLabel.setText(game.getCurrentUser().getBudget() + "kr");
			
		}else {
			JOptionPane.showMessageDialog(frame,
				    "You don´t have enough budget too buy" + playerName);
		}
	}
	
	/**
	 * 
	 */
	private void sellPlayer(String playerName) {
		game.removePlayer(playerName);
		defenceName1.setText("");
		defenceImg1.setIcon(shirts.get("noTeam"));
		addDefence1.setText("+");
		budgetLabel.setText(game.getCurrentUser().getBudget() + "kr");
	}
	
	private void setMarket() {
		
		DefaultListModel listModel = new DefaultListModel();
		Core core = game.getCore();
		FootballPlayer[] players = core.getAllPlayers();
		for(int i = 0; i<players.length; i++) {
			listModel.addElement(players[i].getName());
		}
		listMarket.setModel(listModel);
		User user = game.getUsers().get(game.getUserTurn());
		lblBudget.setText(user.getBudget()+"");
	}
	
	private void initView(){
		// Shirt images
		goalkeeperImg = new JLabel("");
		goalkeeperImg.setIcon(new ImageIcon(Transfers.class.getResource("/resources/manutd_goalkeeper_shirt.png")));
		goalkeeperImg.setBounds(224, 13, 61, 66);
		add(goalkeeperImg);
		
		defenceImg1 = new JLabel("");
		defenceImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		defenceImg1.setBounds(73, 91, 61, 66);
		add(defenceImg1);
				
		defenceImg2 = new JLabel("");
		defenceImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/chelsea_shirt.png")));
		defenceImg2.setBounds(171, 91, 61, 66);
		add(defenceImg2);
		
		defenceImg3 = new JLabel("");
		defenceImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/mancity_shirt.png")));
		defenceImg3.setBounds(287, 91, 61, 66);
		add(defenceImg3);
			
		defenceImg4 = new JLabel("");
		defenceImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/southampton_shirt.png")));
		defenceImg4.setBounds(373, 91, 61, 66);
		add(defenceImg4);
				
		middleImg1 = new JLabel("");
		middleImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/manutd_shirt.png")));
		middleImg1.setBounds(73, 220, 61, 66);
		add(middleImg1);
				
		middleImg2 = new JLabel("");
		middleImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/swansea_shirt.png")));
		middleImg2.setBounds(171, 220, 61, 66);
		add(middleImg2);
		
		middleImg3 = new JLabel("");
		middleImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/westham_shirt.png")));
		middleImg3.setBounds(287, 220, 61, 66);
		add(middleImg3);
				
		middleImg4 = new JLabel("");
		middleImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/liverpool_shirt.png")));
		middleImg4.setBounds(373, 220, 61, 66);
		add(middleImg4);
		
		forwardImg1 = new JLabel("");
		forwardImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/spurs_shirt.png")));
		forwardImg1.setBounds(181, 338, 61, 66);
		add(forwardImg1);
		
		forwardImg2 = new JLabel("");
		forwardImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		forwardImg2.setBounds(267, 338, 61, 66);
		add(forwardImg2);
		
		// Add buttons
		
		addGoalkeeper = new JButton("+");
		addGoalkeeper.setBounds(211, 74, 20, 16);
		add(addGoalkeeper);
		
		
		addDefence1 = new JButton("+");
		addDefence1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				String playerName = (String) listMarket.getModel().getElementAt(listMarket.getSelectedIndex());
				FootballPlayer player = game.getMarket().findPlayer(playerName);
				if (button.getText().equals("+")) {
					
					buyPlayer(player, playerName);
						
				}else{
					sellPlayer(defenceName1.getText());
				}
			}
		});
		
		addDefence1.setBounds(60, 169, 20, 16);
		add(addDefence1);
		
		
		addDefence2 = new JButton("+");
		addDefence2.setBounds(157, 169, 20, 16);
		add(addDefence2);

		
		addDefence3 = new JButton("+");
		addDefence3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addDefence3.setBounds(281, 169, 20, 16);
		add(addDefence3);
		
		addDefence4 = new JButton("+");
		addDefence4.setBounds(373, 169, 20, 16);
		add(addDefence4);
		
		addMiddle1 = new JButton("+");
		addMiddle1.setBounds(373, 292, 20, 16);
		add(addMiddle1);
		
		addMiddle2 = new JButton("+");
		addMiddle2.setBounds(281, 292, 20, 16);
		add(addMiddle2);
		
		addMiddle3 = new JButton("+");
		addMiddle3.setBounds(157, 292, 20, 16);
		add(addMiddle3);
		
		addMiddle4 = new JButton("+");
		addMiddle4.setBounds(60, 292, 20, 16);
		add(addMiddle4);
		
		addForward1 = new JButton("+");
		addForward1.setBounds(170, 408, 20, 16);
		add(addForward1);
		
		addForward2 = new JButton("+");
		addForward2.setBounds(267, 408, 20, 16);
		add(addForward2);
		
		//info buttons
		button_6 = new JButton("i");
		button_6.setBackground(Color.YELLOW);
		button_6.setBounds(265, 74, 20, 16);
		add(button_6);
		
		btnI = new JButton("i");
		btnI.setBackground(Color.LIGHT_GRAY);
		btnI.setBounds(101, 169, 20, 16);
		add(btnI);
		
		btnI_1 = new JButton("i");
		btnI_1.setBackground(Color.YELLOW);
		btnI_1.setBounds(198, 169, 20, 16);
		add(btnI_1);
		
		btnI_2 = new JButton("i");
		btnI_2.setBackground(Color.YELLOW);
		btnI_2.setBounds(322, 169, 20, 16);
		add(btnI_2);
		
		btnI_3 = new JButton("i");
		btnI_3.setBackground(Color.YELLOW);
		btnI_3.setBounds(414, 169, 20, 16);
		add(btnI_3);
		
		button = new JButton("i");
		button.setBackground(Color.YELLOW);
		button.setBounds(101, 292, 20, 16);
		add(button);
		
		button_1 = new JButton("i");
		button_1.setBackground(Color.YELLOW);
		button_1.setBounds(198, 292, 20, 16);
		add(button_1);
		
		button_2 = new JButton("i");
		button_2.setBackground(Color.YELLOW);
		button_2.setBounds(322, 292, 20, 16);
		add(button_2);
		
		button_3 = new JButton("i");
		button_3.setBackground(Color.YELLOW);
		button_3.setBounds(414, 292, 20, 16);
		add(button_3);
		
		button_4 = new JButton("i");
		button_4.setBackground(Color.YELLOW);
		button_4.setBounds(211, 408, 20, 16);
		add(button_4);
		
		button_5 = new JButton("i");
		button_5.setBackground(Color.YELLOW);
		button_5.setBounds(308, 408, 20, 16);
		add(button_5);
		
		
		//Name labels
		
		defenceName1 = new JLabel("Name");
		defenceName1.setForeground(Color.WHITE);
		defenceName1.setHorizontalAlignment(SwingConstants.CENTER);
		defenceName1.setBounds(70, 192, 61, 16);
		add(defenceName1);
		
		defenceName2 = new JLabel("Name");
		defenceName2.setForeground(Color.WHITE);
		defenceName2.setHorizontalAlignment(SwingConstants.CENTER);
		defenceName2.setBounds(171, 192, 61, 16);
		add(defenceName2);
		
		defenceName3 = new JLabel("Name");
		defenceName3.setForeground(Color.WHITE);
		defenceName3.setHorizontalAlignment(SwingConstants.CENTER);
		defenceName3.setBounds(287, 192, 61, 16);
		add(defenceName3);
		
		defenceName4 = new JLabel("Name");
		defenceName4.setForeground(Color.WHITE);
		defenceName4.setHorizontalAlignment(SwingConstants.CENTER);
		defenceName4.setBounds(373, 192, 61, 16);
		add(defenceName4);
		
		middleName1 = new JLabel("Name");
		middleName1.setForeground(Color.WHITE);
		middleName1.setHorizontalAlignment(SwingConstants.CENTER);
		middleName1.setBounds(70, 310, 61, 16);
		add(middleName1);
		
		middleName2 = new JLabel("Name");
		middleName2.setForeground(Color.WHITE);
		middleName2.setHorizontalAlignment(SwingConstants.CENTER);
		middleName2.setBounds(171, 310, 61, 16);
		add(middleName2);
		
		middleName3 = new JLabel("Name");
		middleName3.setForeground(Color.WHITE);
		middleName3.setHorizontalAlignment(SwingConstants.CENTER);
		middleName3.setBounds(287, 310, 61, 16);
		add(middleName3);
		
		middleName4 = new JLabel("Name");
		middleName4.setForeground(Color.WHITE);
		middleName4.setHorizontalAlignment(SwingConstants.CENTER);
		middleName4.setBounds(373, 310, 61, 16);
		add(middleName4);
		
		forwardName1 = new JLabel("Name");
		forwardName1.setForeground(Color.WHITE);
		forwardName1.setHorizontalAlignment(SwingConstants.CENTER);
		forwardName1.setBounds(171, 431, 61, 16);
		add(forwardName1);
		
		forwardName2 = new JLabel("Name");
		forwardName2.setForeground(Color.WHITE);
		forwardName2.setHorizontalAlignment(SwingConstants.CENTER);
		forwardName2.setBounds(272, 431, 61, 16);
		add(forwardName2);
		
		goalkeeperName = new JLabel("Name");
		goalkeeperName.setForeground(Color.WHITE);
		goalkeeperName.setHorizontalAlignment(SwingConstants.CENTER);
		goalkeeperName.setBounds(224, 91, 61, 16);
		add(goalkeeperName);
		
		//Pitch
		JLabel pitch = new JLabel("");
		pitch.setIcon(new ImageIcon(getClass().getResource("/resources/pitch.png")));
		pitch.setBounds(6, 6, 501, 482);
		add(pitch);
		
		JButton btnConf = new JButton("Confirm transfare");
		btnConf.setBounds(22, 521, 128, 40);
		add(btnConf);
	
	}
	
	private void initShirts(){
		shirts.put("Arsenal", new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		shirts.put("Chelsea", new ImageIcon(Transfers.class.getResource("/resources/chelsea_shirt.png")));
		shirts.put("Stoke", new ImageIcon(Transfers.class.getResource("/resources/stoke_shirt.png")));
		shirts.put("Man Utd", new ImageIcon(Transfers.class.getResource("/resources/manutd_shirt.png")));
		shirts.put("Man City", new ImageIcon(Transfers.class.getResource("/resources/mancity_shirt.png")));
		shirts.put("Southampton", new ImageIcon(Transfers.class.getResource("/resources/southampton_shirt.png")));
		shirts.put("Swansea", new ImageIcon(Transfers.class.getResource("/resources/swansea_shirt.png")));
		shirts.put("Spurs", new ImageIcon(Transfers.class.getResource("/resources/spurs_shirt.png")));
		shirts.put("West Ham", new ImageIcon(Transfers.class.getResource("/resources/westham_shirt.png")));
		shirts.put("Liverpool", new ImageIcon(Transfers.class.getResource("/resources/liverpool_shirt.png")));
		shirts.put("noTeam", new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
	}
}
