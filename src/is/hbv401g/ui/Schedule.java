package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.FootballTeam;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Schedule extends JPanel {
	
	private Game game;
	private	JTable table;
	private	JTable homeImgTable;
	private FootballTeam[][] gameSchedule;

	/**
	 * Create the panel.
	 */
	public Schedule(final Game game) {
		this.game = game;
						
						gameSchedule = game.getCore().getScheduleForNextRound();
						String columnNames[] = { "Column 1", "Column 2", "Column 3" };

						// Create some data
						String dataValues[][] =
						{
							{ gameSchedule[0][0].getName(), "234", "67" },
							{ "-123", "43", "853" },
							{ "93", "89.2", "109" },
							{ "279", "9033", "3092" }
						};
						setLayout(null);
				
						// Create a new table instance
						//table = new JTable( dataValues, columnNames );
						//table.setBounds(110, 103, 225, 64);

						
						
						
				        String[] columns = {"Picture", "Description"};
				        Object[][] data =
				        {
				            {new ImageIcon(Schedule.class.getResource("/resources/arsenal.png")), "Arsenal"},
				            {new ImageIcon(Schedule.class.getResource("/resources/arsenal.png")), "Arsenal"},
				            {new ImageIcon(Schedule.class.getResource("/resources/arsenal.png")), "Arsenal"},
				        };

				        DefaultTableModel model = new DefaultTableModel(data, columnNames);
				        
				        table = new JTable( model )
				        {
				            //  Returning the Class of each column will allow different
				            //  renderers to be used based on Class
				            public Class getColumnClass(int column)
				            {
				                return getValueAt(0, column).getClass();
				            }
				        };
				        
				        table.setPreferredScrollableViewportSize(table.getPreferredSize());
				        table.setBounds(0, 167, 225, -167);
				        
				        add(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(406, 37, 0, 0);
		add(panel);
						panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		// Create columns names

		// Create columns names

				
	}
}
