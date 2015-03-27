package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
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
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton button_6;
	private JLabel label_9;
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
		initView();
		JButton btnBuyPlayer = new JButton("Kaupa leikmann");
		btnBuyPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyPlayer();
			}
		});
		btnBuyPlayer.setBounds(500, 364, 144, 29);
		add(btnBuyPlayer);
		
		JButton btnSellPlayer = new JButton("Selja leikmann");
		btnSellPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSellPlayer.setBounds(500, 395, 144, 29);
		add(btnSellPlayer);
		
		listMarket = new JList();
		listMarket.setBounds(434, 569, 197, 173);
		add(listMarket);
		
		lblBudget = new JLabel("New label");
		lblBudget.setBounds(583, 310, 61, 16);
		add(lblBudget);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(583, 338, 61, 16);
		add(lblNewLabel);
		
		

		
		

		
		
		

		

		
		

		
		
	}
	
	/**
	 * 
	 */
	private void buyPlayer() {
		String playerName = listMarket.getSelectedValue().toString();
		int valid = game.addPlayer(playerName);
		if(valid==0) {
			lblNewLabel.setText(playerName);
		}
	}
	
	/**
	 * 
	 */
	private void sellPlayer() {
		
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
		addDefence1.setBounds(60, 169, 20, 16);
		add(addDefence1);
		
		addDefence2 = new JButton("+");
		addDefence2.setBounds(157, 169, 20, 16);
		add(addDefence2);
		
		addDefence3 = new JButton("+");
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
		button_6.setBounds(265, 74, 20, 16);
		add(button_6);
		
		btnI = new JButton("i");
		btnI.setBounds(101, 169, 20, 16);
		add(btnI);
		
		btnI_1 = new JButton("i");
		btnI_1.setBounds(198, 169, 20, 16);
		add(btnI_1);
		
		btnI_2 = new JButton("i");
		btnI_2.setBounds(322, 169, 20, 16);
		add(btnI_2);
		
		btnI_3 = new JButton("i");
		btnI_3.setBounds(414, 169, 20, 16);
		add(btnI_3);
		
		button = new JButton("i");
		button.setBounds(101, 292, 20, 16);
		add(button);
		
		button_1 = new JButton("i");
		button_1.setBounds(198, 292, 20, 16);
		add(button_1);
		
		button_2 = new JButton("i");
		button_2.setBounds(322, 292, 20, 16);
		add(button_2);
		
		button_3 = new JButton("i");
		button_3.setBounds(414, 292, 20, 16);
		add(button_3);
		
		button_4 = new JButton("i");
		button_4.setBounds(211, 408, 20, 16);
		add(button_4);
		
		button_5 = new JButton("i");
		button_5.setBounds(308, 408, 20, 16);
		add(button_5);
		
		
		//Name labels
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(70, 192, 61, 16);
		add(lblName);
		
		label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(171, 192, 61, 16);
		add(label);
		
		label_1 = new JLabel("Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(287, 192, 61, 16);
		add(label_1);
		
		label_2 = new JLabel("Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(373, 192, 61, 16);
		add(label_2);
		
		label_3 = new JLabel("Name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(70, 310, 61, 16);
		add(label_3);
		
		label_4 = new JLabel("Name");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(171, 310, 61, 16);
		add(label_4);
		
		label_5 = new JLabel("Name");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(287, 310, 61, 16);
		add(label_5);
		
		label_6 = new JLabel("Name");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(373, 310, 61, 16);
		add(label_6);
		
		label_7 = new JLabel("Name");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(171, 431, 61, 16);
		add(label_7);
		
		label_8 = new JLabel("Name");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(272, 431, 61, 16);
		add(label_8);
		
		label_9 = new JLabel("Name");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(224, 91, 61, 16);
		add(label_9);
		
		//Pitch
		JLabel pitch = new JLabel("");
		pitch.setIcon(new ImageIcon(getClass().getResource("/resources/pitch.png")));
		pitch.setBounds(6, 6, 501, 482);
		add(pitch);
		
		JButton btnConf = new JButton("Confirm team");
		btnConf.setBounds(22, 521, 128, 40);
		add(btnConf);
	
	}
}
