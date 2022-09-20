/*game TicTacToe
*This programm is a version of TicTacToe, using Swing.
*The programm has Single- and Multiplayer, which can be selected in the menü.
*TThe game was programmed in the Java programming language.
*
*
*name						: TicTactToe.jar
*Author						: Benjamin Wende and Julius Fleiting
*ide						: Eclipse version 2022-03
*version					: 5.0
*date of last change		: 03.06.2022
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menue implements ActionListener {
	//Inizialisieren
	JFrame frame = new JFrame();
	JPanel t_panel = new JPanel();
	JPanel bt_panel = new JPanel();
	JPanel pic_panel = new JPanel();
	JPanel resetbt_panel = new JPanel();
	JLabel textfield = new JLabel();
	static JButton[] button = new JButton[3];

	menue() {

//algemeine frame settings
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 290);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);

		// Icon bar
		ImageIcon imgicon = new ImageIcon(
				"C:\\Users\\Benjamin Wende\\OneDrive - Carl Benz Schule Koblenz\\Bilder\\tictactoe.PNG");
		frame.setIconImage(imgicon.getImage());

		// textfeld oben
		textfield.setForeground(Color.DARK_GRAY);
		textfield.setFont(new Font("Arial", Font.BOLD, 50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setForeground(Color.white);
		textfield.setText("Menü:");
		textfield.setOpaque(true);
		textfield.setBackground(Color.DARK_GRAY);
		t_panel.setBackground(Color.DARK_GRAY);

		// button erstellen und konfigurieren
		bt_panel.setLayout(new GridLayout(3, 1));
		bt_panel.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			bt_panel.add(button[i]);
			button[i].setForeground(Color.white);
			button[i].setBackground(Color.DARK_GRAY);
			button[i].setFont(new Font("Arial", Font.BOLD, 35));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
//button benennen
		button[0].setText("SINGLEPLAYER");
		button[1].setText("MULTIPLAYER");
		button[2].setText("EXIT");
		t_panel.add(textfield);

		// frame add
		frame.add(t_panel, BorderLayout.NORTH);
		frame.add(pic_panel);
		frame.add(bt_panel);

	}

	// wenn actionperformed
	public void actionPerformed(ActionEvent Action) {
		for (int i = 0; i < button.length; i++) {
			if (Action.getSource() == button[i]) {
				if (i == 0) {
					frame.dispose();
					MainClass.gamemode = 1;
					new TicTacToeGame();
				}
				if (i == 1) {
					frame.dispose();
					MainClass.gamemode = 2;
					new TicTacToeGame();
				}
				if (i == 2) {
					frame.dispose();
					System.exit(0);
				}

			}
		}

	}

}
