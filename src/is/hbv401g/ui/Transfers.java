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
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Transfers extends JPanel {

	private static Game game;
	private Core core;
	private FootballPlayer[] players;
	private static User user;
	private UserTeam userTeam;
	
	private JTable tableMarket;
	private JPanel tablePanel;
	
	private JLabel goalkeeperImg;
	private JLabel defenceImg1, defenceImg2, defenceImg3, defenceImg4;
	private JLabel middleImg1, middleImg2, middleImg3, middleImg4;
	private JLabel forwardImg1, forwardImg2;
	private static JLabel[] imageArray;
	private JButton addDefence1, addDefence2, addDefence3, addDefence4;
	private JButton addMiddle4, addMiddle3, addMiddle2, addMiddle1;
	private JButton addForward1, addForward2;
	private JButton addGoalkeeper;
	private static JButton[] buttonArray;
	private JLabel defenceName1, defenceName2, defenceName3, defenceName4;
	private static JLabel[] playerNameArray;
	private JButton btnDefense1Info, btnDefense2Info, btnDefense3Info, btnDefense4Info;
	private JButton btnMiddle1Info, btnMiddle2Info, btnMiddle3Info, btnMiddle4Info, btnForward1Info, btnForward2Info, btnGoalKeeperInfo;
	private JLabel middleName1, middleName2, middleName3, middleName4;
	private JLabel forwardName1, forwardName2;
	private JLabel goalkeeperName;
	
	private static HashMap<String, ImageIcon> shirts;
	private ArrayList<JButton> addButtons;
	private ArrayList<FootballPlayer> p;
	private ArrayList<JLabel> namesLabels, shirtLabels;
	JFrame frame = new JFrame();
	private JPanel panelTeam;
	private static JLabel lblBudgetText;
	private JScrollPane marketScrollPane;
	/**
	 * Create the panel.
	 */
	public Transfers(Game game) {
		setLayout(null);
		this.game = game;
		this.core = game.getCore();
		this.players = core.getAllFootballPlayers();
		
		initGui();
	}
	
	public static void initPlayer() {
		user = game.getUsers().get(game.getUserTurn());
		displayUserTeam();
		lblBudgetText.setText(user.getBudget()+"");
	}
	
	private void changePlayer(int num, ActionEvent e) {
		if(tableMarket.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(frame,"You haven't selected any player");
		}
		JButton button = (JButton) e.getSource();
		String playerName = (String) tableMarket.getModel().getValueAt(tableMarket.getSelectedRow(), 0);
		FootballPlayer player = game.getMarket().findPlayer(playerName);
		if (button.getText().equals("+")) {
			
			buyPlayer(player, playerName, num);
				
		}else{
			sellPlayer(num);
		}
		System.out.println(game.getNumberOfSelectedPlayers());
	}
	
	private static void displayUserTeam() {
		if (game.getCurrentRound()==0) {
			for (int i = 0; i<11; i++) {
				playerNameArray[i].setText("Name");
				imageArray[i].setIcon(shirts.get("noTeam"));
				buttonArray[i].setText("+");
			}
			user.setUserTeam(new UserTeam(),game.getCurrentRound());
		}
		
		//Endurstilla tmp team - bæði þegar nýr user byrjar og þegar ýtt er á cancel transfers.
		//Mock - hér munum við sækja userteam frá user og fá leikmennina sem eru í því
/*		Map<String, FootballPlayer> players = new HashMap<String, FootballPlayer>();
		players.put("a", new FootballPlayer("a", "Liverpool", "a"));
		players.put("b", new FootballPlayer("a", "Man Utd", "a"));
		players.put("c", new FootballPlayer("a", "Man City", "a"));
		players.put("d", new FootballPlayer("a", "Stoke", "a"));
		players.put("e", new FootballPlayer("a", "West Ham", "a"));
		players.put("f", new FootballPlayer("a", "Swansea", "a"));
		players.put("p", new FootballPlayer("a", "Southampton", "a"));
		players.put("l", new FootballPlayer("a", "Chelsea", "a"));
		players.put("m", new FootballPlayer("a", "Arsenal", "a"));
		players.put("n", new FootballPlayer("a", "Spurs", "a"));
		players.put("g", new FootballPlayer("a", "Spurs", "a"));*/

		/*for(Entry<String, FootballPlayer> playersEntry : players.entrySet()){
            System.out.println(playersEntry.getKey());
            FootballPlayer m = playersEntry.getValue();
            p.add(m);
            
        }
		
		for(int i = 0; i < p.size(); i++){
			namesLabels.get(i).setText(p.get(i).getName());
			shirtLabels.get(i).setIcon(shirts.get(p.get(i).getTeamName()));
		}*/
	}
	
	/**
	 * 
	 */
	private void buyPlayer(FootballPlayer player, String playerName, int num) {
		int valid = game.addPlayer(playerName);
		if(valid==0) {
			playerNameArray[num].setText(playerName);
			imageArray[num].setIcon(shirts.get(player.getTeamName()));
			buttonArray[num].setText("X");
			lblBudgetText.setText(game.getCurrentUser().getBudget() + "kr");
			
		} else if (valid==1) {
			JOptionPane.showMessageDialog(frame,"You have already selected this player for your team");
		} else if (valid==-1) {
			JOptionPane.showMessageDialog(frame,"You don´t have enough budget too buy " + playerName);
		}
	}
	
	/**
	 * 
	 */
	private void sellPlayer(int num) {
		String playerName = playerNameArray[num].getText();
		game.removePlayer(playerName);
		playerNameArray[num].setText("");
		imageArray[num].setIcon(shirts.get("noTeam"));
		buttonArray[num].setText("+");
		lblBudgetText.setText(game.getCurrentUser().getBudget() + "kr");
	}
	
	private void setMarket() {
		Object [][] data = new Object[players.length][5];
		
		for(int i = 0; i<players.length; i++) {
			data[i][0] = players[i].getName();
			data[i][1] = players[i].getPosition();
			data[i][2] = players[i].getTeamName();
			data[i][3] = players[i].getScore();
			data[i][4] = players[i].getMarketValue();
		}
		
		String [] columnNames = {"Name", "Position", "Team", "Points", "Cost"};
		
		DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
		tableMarket.setModel(tableModel);
		
	}
	
	private void addButtons() {
		addGoalkeeper = new JButton("+");
		addGoalkeeper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(0, e);
			}
		});
		
		addDefence1 = new JButton("+");
		addDefence1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(1, e);
			}
		});
		
		addDefence2 = new JButton("+");
		addDefence2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(2, e);
			}
		});
				
		addDefence3 = new JButton("+");
		addDefence3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(3, e);
			}
		});
		
		addDefence4 = new JButton("+");
		addDefence4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(4, e);
			}
		});
		
		addMiddle1 = new JButton("+");
		addMiddle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(5, e);
			}
		});
		
		addMiddle2 = new JButton("+");
		addMiddle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(6, e);
			}
		});
		
		addMiddle3 = new JButton("+");
		addMiddle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(7, e);
			}
		});
		
		addMiddle4 = new JButton("+");
		addMiddle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(8, e);
			}
		});
		
		addForward1 = new JButton("+");
		addForward1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(9, e);
			}
		});
		
		addForward2 = new JButton("+");
		addForward2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlayer(10, e);
			}
		});
	}
	
	private void initGui() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				setMarket();
			}
		});
		
		namesLabels = new ArrayList<JLabel>();
		shirtLabels = new ArrayList<JLabel>();
		p = new ArrayList<FootballPlayer>();
		
		shirts = new HashMap<String, ImageIcon>();
		initShirts();
		initView();
		
		JLabel lblBudget = new JLabel("Budget:");
		lblBudget.setVerticalAlignment(SwingConstants.TOP);
		lblBudget.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBudget.setHorizontalAlignment(SwingConstants.LEFT);
		lblBudget.setBounds(599, 16, 61, 40);
		add(lblBudget);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayUserTeam();	
			}
		});
		btnCancel.setBounds(6, 553, 85, 29);
		add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(599, 75, 175, 27);
		add(comboBox);
		
		JLabel lblTeam = new JLabel("Team:");
		lblTeam.setBounds(519, 79, 61, 16);
		add(lblTeam);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(519, 120, 61, 16);
		add(lblPosition);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(599, 116, 175, 27);
		add(comboBox_1);
		
		lblBudgetText = new JLabel("");
		lblBudgetText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBudgetText.setBounds(672, 19, 90, 16);
		add(lblBudgetText);	
	}
	
	private void initView(){
		
		addButtons();
		
		panelTeam = new JPanel();
		panelTeam.setBounds(6, 59, 501, 482);
		add(panelTeam);
		panelTeam.setLayout(null);
		// Shirt images
		goalkeeperImg = new JLabel("");
		goalkeeperImg.setBounds(218, 7, 61, 66);
		panelTeam.add(goalkeeperImg);
		goalkeeperImg.setIcon(new ImageIcon(Transfers.class.getResource("/resources/manutd_goalkeeper_shirt.png")));
		
		
		//Add shirtLabels to list
		shirtLabels.add(goalkeeperImg);
		
		defenceImg1 = new JLabel("");
		defenceImg1.setBounds(67, 85, 61, 66);
		panelTeam.add(defenceImg1);
		defenceImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		shirtLabels.add(defenceImg1);
				
		defenceImg2 = new JLabel("");
		defenceImg2.setBounds(165, 85, 61, 66);
		panelTeam.add(defenceImg2);
		defenceImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/chelsea_shirt.png")));
		shirtLabels.add(defenceImg2);
		
		defenceImg3 = new JLabel("");
		defenceImg3.setBounds(281, 85, 61, 66);
		panelTeam.add(defenceImg3);
		defenceImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/mancity_shirt.png")));
		shirtLabels.add(defenceImg3);
			
		defenceImg4 = new JLabel("");
		defenceImg4.setBounds(367, 85, 61, 66);
		panelTeam.add(defenceImg4);
		defenceImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/southampton_shirt.png")));
		shirtLabels.add(defenceImg4);
				
		middleImg1 = new JLabel("");
		middleImg1.setBounds(67, 214, 61, 66);
		panelTeam.add(middleImg1);
		middleImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/manutd_shirt.png")));
		shirtLabels.add(middleImg1);
				
		middleImg2 = new JLabel("");
		middleImg2.setBounds(165, 214, 61, 66);
		panelTeam.add(middleImg2);
		middleImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/swansea_shirt.png")));
		shirtLabels.add(middleImg2);
		
		middleImg3 = new JLabel("");
		middleImg3.setBounds(281, 214, 61, 66);
		panelTeam.add(middleImg3);
		middleImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/westham_shirt.png")));
		shirtLabels.add(middleImg3);
				
		middleImg4 = new JLabel("");
		middleImg4.setBounds(367, 214, 61, 66);
		panelTeam.add(middleImg4);
		middleImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/liverpool_shirt.png")));
		shirtLabels.add(middleImg4);
		
		forwardImg1 = new JLabel("");
		forwardImg1.setBounds(175, 332, 61, 66);
		panelTeam.add(forwardImg1);
		forwardImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/spurs_shirt.png")));
		shirtLabels.add(forwardImg1);
		
		forwardImg2 = new JLabel("");
		forwardImg2.setBounds(261, 332, 61, 66);
		panelTeam.add(forwardImg2);
		forwardImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		shirtLabels.add(forwardImg2);
		
		addGoalkeeper.setBounds(205, 68, 20, 16);
		panelTeam.add(addGoalkeeper);
		
		addDefence1.setBounds(54, 163, 20, 16);
		panelTeam.add(addDefence1);
		
		addDefence2.setBounds(151, 163, 20, 16);
		panelTeam.add(addDefence2);
		
		addDefence3.setBounds(275, 163, 20, 16);
		panelTeam.add(addDefence3);
		
		addDefence4.setBounds(367, 163, 20, 16);
		panelTeam.add(addDefence4);
	
		addMiddle4.setBounds(367, 286, 20, 16);
		panelTeam.add(addMiddle4);
		
		addMiddle3.setBounds(275, 286, 20, 16);
		panelTeam.add(addMiddle3);
		
		addMiddle2.setBounds(151, 286, 20, 16);
		panelTeam.add(addMiddle2);
		
		addMiddle1.setBounds(54, 286, 20, 16);
		panelTeam.add(addMiddle1);
		
		
		addForward1.setBounds(164, 402, 20, 16);
		panelTeam.add(addForward1);
		
		addForward2.setBounds(261, 402, 20, 16);
		panelTeam.add(addForward2);
		
		//info buttons
		btnGoalKeeperInfo = new JButton("i");
		btnGoalKeeperInfo.setBounds(259, 68, 20, 16);
		panelTeam.add(btnGoalKeeperInfo);
		btnGoalKeeperInfo.setBackground(Color.YELLOW);
		
		btnDefense1Info = new JButton("i");
		btnDefense1Info.setBounds(95, 163, 20, 16);
		panelTeam.add(btnDefense1Info);
		btnDefense1Info.setBackground(Color.LIGHT_GRAY);
		
		btnDefense2Info = new JButton("i");
		btnDefense2Info.setBounds(192, 163, 20, 16);
		panelTeam.add(btnDefense2Info);
		btnDefense2Info.setBackground(Color.YELLOW);
		
		btnDefense3Info = new JButton("i");
		btnDefense3Info.setBounds(316, 163, 20, 16);
		panelTeam.add(btnDefense3Info);
		btnDefense3Info.setBackground(Color.YELLOW);
		
		btnDefense4Info = new JButton("i");
		btnDefense4Info.setBounds(408, 163, 20, 16);
		panelTeam.add(btnDefense4Info);
		btnDefense4Info.setBackground(Color.YELLOW);
		
		btnMiddle1Info = new JButton("i");
		btnMiddle1Info.setBounds(95, 286, 20, 16);
		panelTeam.add(btnMiddle1Info);
		btnMiddle1Info.setBackground(Color.YELLOW);
		
		btnMiddle2Info = new JButton("i");
		btnMiddle2Info.setBounds(192, 286, 20, 16);
		panelTeam.add(btnMiddle2Info);
		btnMiddle2Info.setBackground(Color.YELLOW);
		
		btnMiddle3Info = new JButton("i");
		btnMiddle3Info.setBounds(316, 286, 20, 16);
		panelTeam.add(btnMiddle3Info);
		btnMiddle3Info.setBackground(Color.YELLOW);
		
		btnMiddle4Info = new JButton("i");
		btnMiddle4Info.setBounds(408, 286, 20, 16);
		panelTeam.add(btnMiddle4Info);
		btnMiddle4Info.setBackground(Color.YELLOW);
		
		btnForward1Info = new JButton("i");
		btnForward1Info.setBounds(205, 402, 20, 16);
		panelTeam.add(btnForward1Info);
		btnForward1Info.setBackground(Color.YELLOW);
		
		btnForward2Info = new JButton("i");
		btnForward2Info.setBounds(302, 402, 20, 16);
		panelTeam.add(btnForward2Info);
		btnForward2Info.setBackground(Color.YELLOW);
		
		
		//Name labels
		
		defenceName1 = new JLabel("Name");
		defenceName1.setBounds(64, 186, 61, 16);
		panelTeam.add(defenceName1);
		defenceName1.setForeground(Color.WHITE);
		defenceName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName1);
		
		defenceName2 = new JLabel("Name");
		defenceName2.setBounds(165, 186, 61, 16);
		panelTeam.add(defenceName2);
		defenceName2.setForeground(Color.WHITE);
		defenceName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName2);
		
		defenceName3 = new JLabel("Name");
		defenceName3.setBounds(281, 186, 61, 16);
		panelTeam.add(defenceName3);
		defenceName3.setForeground(Color.WHITE);
		defenceName3.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName3);
		
		defenceName4 = new JLabel("Name");
		defenceName4.setBounds(367, 186, 61, 16);
		panelTeam.add(defenceName4);
		defenceName4.setForeground(Color.WHITE);
		defenceName4.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName4);
		
		middleName1 = new JLabel("Name");
		middleName1.setBounds(64, 304, 61, 16);
		panelTeam.add(middleName1);
		middleName1.setForeground(Color.WHITE);
		middleName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName1);
		
		middleName2 = new JLabel("Name");
		middleName2.setBounds(165, 304, 61, 16);
		panelTeam.add(middleName2);
		middleName2.setForeground(Color.WHITE);
		middleName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName2);
		
		middleName3 = new JLabel("Name");
		middleName3.setBounds(281, 304, 61, 16);
		panelTeam.add(middleName3);
		middleName3.setForeground(Color.WHITE);
		middleName3.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName3);
		
		middleName4 = new JLabel("Name");
		middleName4.setBounds(367, 304, 61, 16);
		panelTeam.add(middleName4);
		middleName4.setForeground(Color.WHITE);
		middleName4.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName4);
		
		forwardName1 = new JLabel("Name");
		forwardName1.setBounds(165, 425, 61, 16);
		panelTeam.add(forwardName1);
		forwardName1.setForeground(Color.WHITE);
		forwardName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(forwardName1);
		
		forwardName2 = new JLabel("Name");
		forwardName2.setBounds(266, 425, 61, 16);
		panelTeam.add(forwardName2);
		forwardName2.setForeground(Color.WHITE);
		forwardName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(forwardName2);
		
		goalkeeperName = new JLabel("Name");
		goalkeeperName.setBounds(218, 85, 61, 16);
		panelTeam.add(goalkeeperName);
		goalkeeperName.setForeground(Color.WHITE);
		goalkeeperName.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		// add labels to list
		namesLabels.add(goalkeeperName);
		
		
		//Pitch
		JLabel pitch = new JLabel("");
		pitch.setBounds(0, 0, 501, 476);
		panelTeam.add(pitch);
		pitch.setIcon(new ImageIcon(getClass().getResource("/resources/pitch.png")));
				
		
		tablePanel = new JPanel();
		tablePanel.setBounds(519, 148, 255, 381);
		add(tablePanel);
		tablePanel.setLayout(null);
		
		marketScrollPane = new JScrollPane();
		marketScrollPane.setBounds(0, 0, 255, 381);
		tablePanel.add(marketScrollPane);
		
		tableMarket = new JTable();
		marketScrollPane.setViewportView(tableMarket);
		
		
		JButton confirm = new JButton("Confirm transfer");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(game.getNumberOfSelectedPlayers()==11) {
					game.endUserTurn();	
				//}
				//else {
					//JOptionPane.showMessageDialog(frame,
						//    "Please select players for all positions");
				//}
			}
		});
		confirm.setBounds(6, 630, 788, 64);
		add(confirm);
		
		playerNameArray = new JLabel[]{goalkeeperName,defenceName1, defenceName2, defenceName3, defenceName4,
				middleName1, middleName2, middleName3, middleName4, forwardName1, forwardName2};
		imageArray = new JLabel[]{goalkeeperImg,defenceImg1, defenceImg2, defenceImg3, defenceImg4,
				middleImg1, middleImg2, middleImg3, middleImg4, forwardImg1, forwardImg2};
		
		buttonArray = new JButton[]{addGoalkeeper,addDefence1, addDefence2, addDefence3, addDefence4,addMiddle1, addMiddle2,
				addMiddle3, addMiddle4,addForward1, addForward2};	
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
