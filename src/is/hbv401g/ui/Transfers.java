package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.Player;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;

public class Transfers extends JPanel {

	private Game game;
	private JList listMarket;
	private JLabel lblBudget;
	private JLabel lblNewLabel;
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
		
		JButton btnBuyPlayer = new JButton("Kaupa leikmann");
		btnBuyPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyPlayer();
			}
		});
		btnBuyPlayer.setBounds(26, 108, 144, 29);
		add(btnBuyPlayer);
		
		JButton btnSellPlayer = new JButton("Selja leikmann");
		btnSellPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSellPlayer.setBounds(26, 162, 144, 29);
		add(btnSellPlayer);
		
		listMarket = new JList();
		listMarket.setBounds(217, 80, 197, 173);
		add(listMarket);
		
		lblBudget = new JLabel("New label");
		lblBudget.setBounds(34, 17, 61, 16);
		add(lblBudget);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(34, 57, 61, 16);
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
		Player[] players = core.getAllPlayers();
		for(int i = 0; i<players.length; i++) {
			listModel.addElement(players[i].getName());
		}
		listMarket.setModel(listModel);
		User user = game.getUsers().get(game.getUserTurn());
		lblBudget.setText(user.getBudget()+"");
	}
}
