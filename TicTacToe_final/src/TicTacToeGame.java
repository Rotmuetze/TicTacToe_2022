/*Game TicTacToe
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener {
//Inizialisieren
	JFrame frame = new JFrame();
	JPanel t_panel = new JPanel();
	JPanel bt_panel = new JPanel();
	JPanel pkt_panel = new JPanel();
	JPanel bteast_panel = new JPanel();
	JLabel textfield = new JLabel();
	JLabel pktfield = new JLabel();
	static JButton[] button = new JButton[11];
	int chance_flag = 0;
	boolean p1_chance = true;


	// MAIN
	public static void main(String[] args) {
		new menue();
	}

	
	TicTacToeGame() {

		// Frame allgemein
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(620, 500);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);

// Icon bar (NUR ABSOLUTER PFAD MÖGLICH)
		ImageIcon img = new ImageIcon(
				"C:\\Users\\Benjamin Wende\\OneDrive - Carl Benz Schule Koblenz\\Bilder\\tictactoe.PNG");
		frame.setIconImage(img.getImage());

//Textfeld oben
		textfield.setBackground(Color.LIGHT_GRAY);
		textfield.setForeground(Color.white);
		textfield.setFont(new Font("Arial", Font.BOLD, 35));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic Tac Toe");
		textfield.setOpaque(true);
		textfield.setBackground(new Color(50, 50, 50));
		t_panel.setLayout(new BorderLayout());
		t_panel.setBounds(0, 0, 800, 100);

//Punkte unten
		pktfield.setBackground(new Color(50, 50, 50));
		pktfield.setForeground(Color.WHITE);
		pktfield.setFont(new Font("Arial", Font.BOLD, 35));
		pktfield.setHorizontalAlignment(JLabel.CENTER);
		pktfield.setOpaque(true);
		pkt_panel.setBackground(new Color(50, 50, 50));
		pktfield.setText(
				"X:  " + MainClass.playerscoreX + "  O:  " + MainClass.playerscoreO + "                      ");

		// buttons spielfeld
		bt_panel.setLayout(new GridLayout(3, 3));
		bt_panel.setBackground(Color.LIGHT_GRAY);
		bteast_panel.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			bt_panel.add(button[i]);
			button[i].setFont(new Font("Arial", Font.BOLD, 120));
			button[i].setBackground(Color.DARK_GRAY);
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		// Button reset knopf

		button[9] = new JButton();
		bteast_panel.add(button[9]);
		bteast_panel.setBackground(new Color(50, 50, 50));
		button[9].setFont(new Font("Arial", Font.BOLD, 20));
		button[9].setText("RESET");
		button[9].setBackground(Color.DARK_GRAY);
		button[9].setForeground(Color.white);
		button[9].setFocusable(false);
		button[9].addActionListener(this);

		// Button menü knopf
		button[10] = new JButton();
		bteast_panel.add(button[10]);
		button[10].setFont(new Font("Arial", Font.BOLD, 20));
		button[10].setBackground(Color.DARK_GRAY);
		button[10].setForeground(Color.white);
		button[10].setText("MENÜ");
		button[10].setFocusable(false);
		button[10].addActionListener(this);

		// Frame adden und start
		t_panel.add(textfield);
		pkt_panel.add(pktfield);
		frame.add(t_panel, BorderLayout.NORTH);
		frame.add(bt_panel);
		frame.add(bteast_panel, BorderLayout.EAST);
		frame.add(pkt_panel, BorderLayout.SOUTH);
		startGame();
	}

	/*******************************************************************
	 * method				: startGame
	 * parmeter				: ---
	 * This method is used for start the game
	 * ****************************************************************
	 * date of last change	: 20.04.2022
	 * author				: Julius Fleiting
	 * *****************************************************************
	 */
	public void startGame() {
		p1_chance = true;
		textfield.setText("X ist am Zug");
	}

	/*******************************************************************
	 * method				: points
	 * parmeter				: ---
	 * updates player points
	 * ****************************************************************
	 * date of last change	: 25.05.2022
	 * author				: Benjamin Wende
	 * *****************************************************************
	 */
	public void points() {
		pktfield.setText(
				"X:  " + MainClass.playerscoreX + "  O:  " + MainClass.playerscoreO + "                      ");
	}

	/*******************************************************************
	 * method				: gamover
	 * parmeter				: String s bring the message which is shown
	 * Brings up a message with the option to play another game or return to the menu
	 * ****************************************************************
	 * date of last change	: 6.04.2022
	 * author				: Julius Fleiting
	 * *****************************************************************
	 */
	public void gameOver(String s) {

		Object[] option = { "Nochmal", "Menü" };

		int n = JOptionPane.showOptionDialog(frame, s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (n == 0) {
			frame.dispose();
			new TicTacToeGame();
		}
		if (n == 1) {
			MainClass.playerscoreX = 0;
			MainClass.playerscoreO = 0;
			frame.dispose();
			new menue();

		}

	}

	/*******************************************************************
	 * method				: Check
	 * parmeter				: ---
	 * Checks if a player has won
	 * ****************************************************************
	 * date of last change	: 6.04.2022
	 * author				: Julius Fleiting
	 * *****************************************************************
	 */
	public void Check() {
		if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {

			xWin(0, 1, 2);

		} else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {

			xWin(0, 4, 8);

		} else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {

			xWin(0, 3, 6);

		} else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {

			xWin(1, 4, 7);

		} else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {

			xWin(2, 4, 6);

		} else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
			xWin(2, 5, 8);

		} else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {

			xWin(3, 4, 5);

		} else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {

			xWin(6, 7, 8);

		}

		else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {

			oWin(0, 1, 2);

		} else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {

			oWin(0, 3, 6);

		} else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {

			oWin(0, 4, 8);

		} else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {

			oWin(1, 4, 7);

		} else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
			oWin(2, 4, 6);

		} else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {

			oWin(2, 5, 8);

		} else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {

			oWin(3, 4, 5);

		} else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {

			oWin(6, 7, 8);

		} else if (chance_flag == 9) {
			textfield.setForeground(Color.white);
			textfield.setText("Unentschieden");
			p1_chance = true;
			gameOver("Unentschieden");
		}
	}

	/*******************************************************************
	 * method				: xwin
	 * parmeter				: ---
	 * flashes 3 in a row in team color when a player has 3 in a row. Gameover will be started
	 * ****************************************************************
	 * date of last change	: 6.04.2022
	 * author				: Julius Fleiting
	 * *****************************************************************
	 */
	public void xWin(int x1, int x2, int x3) {
		p1_chance = true;
		button[x1].setBackground(Color.GREEN);
		button[x2].setBackground(Color.GREEN);
		button[x3].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		textfield.setForeground(Color.BLUE);
		textfield.setText("X gewinnt");
		MainClass.playerscoreX++;
		points();
		gameOver("X gewinnt");
	}

	/*******************************************************************
	 * method				: owin
	 * parmeter				: ---
	 * flashes 3 in a row in team color when a player has 3 in a row. Gameover will be started
	 * ****************************************************************
	 * date of last change	: 6.04.2022
	 * author				: Julius Fleiting
	 * *****************************************************************
	 */
	public void oWin(int x1, int x2, int x3) {
		button[x1].setBackground(Color.RED);
		button[x2].setBackground(Color.RED);
		button[x3].setBackground(Color.RED);
		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		textfield.setForeground(Color.RED);
		textfield.setText("O gewinnt");
		MainClass.playerscoreO++;
		points();
		gameOver("O gewinnt");
	}

//wenn actionperformed
	public void actionPerformed(ActionEvent Action) {
		for (int i = 0; i < 9; i++) {
			if (Action.getSource() == button[i]) {
				if (MainClass.gamemode == 2) {

					if (p1_chance) {
						if (button[i].getText() == "") {
							button[i].setForeground(Color.BLUE);
							button[i].setText("X");
							p1_chance = false;
							textfield.setText("O ist am Zug");
							chance_flag++;
							Check();
						}
					} else {

						if (button[i].getText() == "") {
							button[i].setForeground(Color.RED);
							button[i].setText("O");
							p1_chance = true;
							textfield.setText("X ist am Zug");
							chance_flag++;
							Check();
						}
					}
				} else {

					if (p1_chance) {

						if (button[i].getText() == "") {
							button[i].setForeground(Color.BLUE);
							button[i].setText("X");
							p1_chance = false;
							textfield.setText("Der PC ist am Zug:");
							chance_flag++;
							Check();

						}
					}
					if (p1_chance == false) {

						int eingabe = 10;
						do {
							MainClass.zahlpc = 0;
							eingabe = MainClass.spielzugpc();
						} while (TicTacToeGame.button[eingabe].getText().equals("X")
								|| TicTacToeGame.button[eingabe].getText().equals("O"));

						button[eingabe].setForeground(Color.RED);
						button[eingabe].setText("O");
						p1_chance = true;
						textfield.setText("X ist am Zug");
						chance_flag++;
						Check();

					}
				}
			}

		}
		if (Action.getSource() == button[9]) {
			reset();
		}

		if (Action.getSource() == button[10]) {
			reset();
			frame.dispose();
			new menue();

		}
	}
	/*******************************************************************
	 * method				: reset
	 * parmeter				: ---
	 * reset all parameters for a new game
	 * ****************************************************************
	 * date of last change	: 25.05.2022
	 * author				: Benjamin Wende
	 * *****************************************************************
	 */
	public void reset() {
		p1_chance = true;
		chance_flag = 0;
		MainClass.playerscoreX = 0;
		MainClass.playerscoreO = 0;
		for (int j = 0; j < 9; j++) {
			button[j].setText("");
			points();
		}
	}
}