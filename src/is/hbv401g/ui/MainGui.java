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

	JPanel contentPane;
	private final Game game = new Game();
	private final JTextField textFieldUserName1;
	private JTextField textFieldUserName2;

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
				String user1=textFieldUserName1.getText();
				String user2=textFieldUserName2.getText();
				if(user1.equals("") && user2.equals("")){
					labelErrorMessage..setText("Vinsamlegast fylla út leikmannanöfn");
				}
				else{
					game.addNewUser(user1,"");
					game.addNewUser(user2,"");
					System.out.println("leikmaður 1: " + textFieldUserName1.getText());
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "game");
					UserGui.updateTextArea();
				}
			}
		});
		btnNewGame.setBounds(132, 190, 164, 39);
		panelUsers.add(btnNewGame);
		
		textFieldUserName1 = new JTextField();
		textFieldUserName1.setBounds(132, 47, 164, 29);
		panelUsers.add(textFieldUserName1);
		textFieldUserName1.setColumns(10);
		
		textFieldUserName2 = new JTextField();
		textFieldUserName2.setBounds(132, 98, 164, 29);
		panelUsers.add(textFieldUserName2);
		textFieldUserName2.setColumns(10);
		
		JLabel labelUsernName1 = new JLabel("Leikma\u00F0ur 1");
		labelUsernName1.setBounds(132, 23, 164, 23);
		panelUsers.add(labelUsernName1);
		
		JLabel labelUserName2 = new JLabel("Leikma\u00F0ur 2");
		labelUserName2.setBounds(132, 75, 164, 23);
		panelUsers.add(labelUserName2);
		
		JLabel labelErrorMessage = new JLabel("");
		labelErrorMessage.setBounds(132, 150, 164, 29);
		panelUsers.add(labelErrorMessage);
		
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
