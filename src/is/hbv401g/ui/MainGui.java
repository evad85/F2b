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

public class MainGui extends JFrame {

	JPanel contentPane;
	private final Game game = new Game();
	private final JTextField textFieldUserName;

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
		setBounds(100, 100, 450, 300);
		final JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelUsers = new JPanel();
		contentPane.add(panelUsers, "users");
		panelUsers.setLayout(null);
		
		JButton btnNewGame = new JButton("Hefja leik");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane, "game");
				UserGui.updateTextArea();
			}
		});
		btnNewGame.setBounds(317, 233, 117, 29);
		panelUsers.add(btnNewGame);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(6, 110, 217, 28);
		panelUsers.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnNewUser = new JButton("Staðfesta");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.addNewUser(textFieldUserName.getText(), "");
				textFieldUserName.setText("");
			}
		});
		btnNewUser.setBounds(317, 111, 117, 29);
		panelUsers.add(btnNewUser);
		
		JTabbedPane tabbedPaneGame = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPaneGame, "game");
		
		UserGui panelUserGui = new UserGui(game);
		tabbedPaneGame.addTab("User", null, panelUserGui, null);
		
		Schedule panelSchedule = new Schedule(game);
		tabbedPaneGame.addTab("Schedule", null, panelSchedule, null);
		
		Transfers panelTransfers = new Transfers(game);
		tabbedPaneGame.addTab("Tansfers", null, panelTransfers, null);
		
		
	}
	
}
