package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.dummy.FootballPlayer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class UserGui extends JPanel {
	
	private static Game game;
	private static User user;
	private static JLabel lblName, lblPoints;
	private JLabel goalkeeperImg;
	private JLabel defenceImg1, defenceImg2, defenceImg3, defenceImg4;
	private JLabel middleImg1, middleImg2, middleImg3, middleImg4;
	private JLabel forwardImg1, forwardImg2;
	private JButton addDefence1, addDefence2, addDefence3, addDefence4;
	private JButton addMiddle1, addMiddle2, addMiddle3, addMiddle4;
	private JButton addForward1, addForward2;
	private JButton addGoalkeeper;
	private JLabel defenceName1, defenceName2, defenceName3, defenceName4;
	private JButton btnDefense1Info, btnDefense2Info, btnDefense3Info, btnDefense4Info;
	private JButton btnMiddle1Info, btnMiddle2Info, btnMiddle3Info, btnMiddle4Info, btnForward1Info, btnForward2Info, btnGoalKeeperInfo;
	private JLabel middleName1, middleName2, middleName3, middleName4;
	private JLabel forwardName1, forwardName2;
	private JLabel goalkeeperName;
	private JLabel budgetLabel;
	
	private HashMap<String, ImageIcon> shirts;
	private ArrayList<JButton> addButtons;
	private ArrayList<FootballPlayer> p;
	private ArrayList<JLabel> namesLabels, shirtLabels;

	
	/**
	 * Create the panel.
	 */
	public UserGui(final Game game) {
		setLayout(null);
		this.game = game;
		initGui();	
	}
	
	public static void initPlayer(){
		user = game.getCurrentUser();
		lblName.setText(user.getName());
		lblPoints.setText(String.valueOf(user.getPoints()) + " points");
		
	}
	
	private void initGui() {
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(538, 27, 283, 29);
		add(lblName);
		
		lblPoints = new JLabel("Points: ");
		lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPoints.setBounds(538, 74, 283, 16);
		add(lblPoints);
		
		namesLabels = new ArrayList<JLabel>();
		shirtLabels = new ArrayList<JLabel>();
		p = new ArrayList<FootballPlayer>();
		
		shirts = new HashMap<String, ImageIcon>();
		initShirts();
		initView();
	}
	
	private void initView(){
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBounds(6, 0, 501, 482);
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
		pitch.setBounds(6, 0, 495, 476);
		panelTeam.add(pitch);
		pitch.setIcon(new ImageIcon(getClass().getResource("/resources/pitch.png")));
		
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
