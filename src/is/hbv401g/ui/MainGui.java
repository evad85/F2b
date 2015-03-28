package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainGui extends JFrame {

	private static JPanel contentPane;
	private static CardLayout cardLayout = new CardLayout();
	private final Game game = new Game();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 800, 700);
		setContentPane(contentPane);
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		System.out.println("hahe");
		PlayRound panelPlayRound = new PlayRound(game);		
		StartGui panelStart = new StartGui(game);
		JTabbedPane panelUser = new JTabbedPane(JTabbedPane.TOP);		
		
		contentPane.add(panelPlayRound, "panelPlayRound");
		contentPane.add(panelUser, "panelUser");
		contentPane.add(panelStart, "panelStart");
		cardLayout.show(contentPane, "panelStart");
		
		
		UserGui panelUserGui = new UserGui(game);
		panelUser.addTab("User", null, panelUserGui, null);
		
		Schedule panelSchedule = new Schedule(game);
		panelUser.addTab("Schedule", null, panelSchedule, null);
		
		Transfers panelTransfers = new Transfers(game);
		panelUser.addTab("Tansfers", null, panelTransfers, null);	
	}
	
	public static void showCardLayout(String type ) {
		cardLayout.show(contentPane, type);
	}
}
