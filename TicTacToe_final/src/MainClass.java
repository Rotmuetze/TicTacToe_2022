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
import java.util.Scanner;

public class MainClass {
	// Inizialisierung:
	static Scanner sc = new Scanner(System.in);

	static int zahlpc;
	static int playerscoreX = 0;
	static int playerscoreO = 0;
	static int gamemode = 0;
	static int zugpc = 0;

/*******************************************************************
 * function				: spielzugpc
 * parmeter				: ---
 * This function give a value for the KI player back
 * ****************************************************************
 * date of last change	: 20.04.2022
 * author				: Benjamin Wende
 * *****************************************************************
 */
	public static int spielzugpc() {
		eingabepc();

		if (zugpc != 1) {
			random();
		}
		return zahlpc;
	}

	
	/*******************************************************************
	 * method				: eingabepc
	 * parmeter				: ---
	 * This method changes zahlpc if the logic of the method allows it
	 * gameboard
	 * ****************************************************************
	 * date of last change	: 24.05.2022
	 * author				: Benjamin Wende
	 * *****************************************************************
	 */
	public static void eingabepc() {
		zugpc = 0;
		int feldermitX = 0;
		String Q = "X";

		for (int i = 0; i < 2; i++) {
			if (i == 1) {
				Q = "O";
			}

			if (TicTacToeGame.button[0].getText().equals(Q)) {
				feldermitX++;
			}

			if (TicTacToeGame.button[3].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[6].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[0].getText().equals("")) {
					zahlpc = 0;
					zugpc = 1;
				}
				if (TicTacToeGame.button[3].getText().equals("")) {
					zahlpc = 3;
					zugpc = 1;
				}
				if (TicTacToeGame.button[6].getText().equals("")) {
					zahlpc = 6;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[1].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[4].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[7].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[1].getText().equals("")) {
					zahlpc = 1;
					zugpc = 1;
				}
				if (TicTacToeGame.button[4].getText().equals("")) {
					zahlpc = 4;
					zugpc = 1;
				}
				if (TicTacToeGame.button[7].getText().equals("")) {
					zahlpc = 7;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[2].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[5].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[8].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[2].getText().equals("")) {
					zahlpc = 2;
					zugpc = 1;
				}
				if (TicTacToeGame.button[5].getText().equals("")) {
					zahlpc = 5;
					zugpc = 1;
				}
				if (TicTacToeGame.button[8].getText().equals("")) {
					zahlpc = 8;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[0].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[1].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[2].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[0].getText().equals("")) {
					zahlpc = 0;
					zugpc = 1;
				}
				if (TicTacToeGame.button[1].getText().equals("")) {
					zahlpc = 1;
					zugpc = 1;
				}
				if (TicTacToeGame.button[2].getText().equals("")) {
					zahlpc = 2;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[3].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[4].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[5].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[3].getText().equals("")) {
					zahlpc = 3;
					zugpc = 1;
				}
				if (TicTacToeGame.button[4].getText().equals("")) {
					zahlpc = 4;
					zugpc = 1;
				}
				if (TicTacToeGame.button[5].getText().equals("")) {
					zahlpc = 5;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[6].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[7].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[8].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[6].getText().equals("")) {
					zahlpc = 6;
					zugpc = 1;
				}
				if (TicTacToeGame.button[7].getText().equals("")) {
					zahlpc = 7;
					zugpc = 1;
				}
				if (TicTacToeGame.button[8].getText().equals("")) {
					zahlpc = 8;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[2].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[4].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[6].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[2].getText().equals("")) {
					zahlpc = 2;
					zugpc = 1;
				}
				if (TicTacToeGame.button[4].getText().equals("")) {
					zahlpc = 4;
					zugpc = 1;
				}
				if (TicTacToeGame.button[6].getText().equals("")) {
					zahlpc = 6;
					zugpc = 1;
				}
			}

			feldermitX = 0;
			if (TicTacToeGame.button[0].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[4].getText().equals(Q)) {
				feldermitX++;
			}
			if (TicTacToeGame.button[8].getText().equals(Q)) {
				feldermitX++;
			}

			if (feldermitX == 2) {
				if (TicTacToeGame.button[0].getText().equals("")) {
					zahlpc = 0;
					zugpc = 1;
				}
				if (TicTacToeGame.button[4].getText().equals("")) {
					zahlpc = 4;
					zugpc = 1;
				}
				if (TicTacToeGame.button[8].getText().equals("")) {
					zahlpc = 8;
					zugpc = 1;
				}
			}

			feldermitX = 0;

		}

	}

	/*******************************************************************
	 * method				: random
	 * parmeter				: ---
	 * This method change zahlpc if eingabepc no value changes
	 * ****************************************************************
	 * date of last change	: 18.03.2022
	 * author				: Benjamin Wende
	 * *****************************************************************
	 */
	public static void random() {
		zahlpc = (int) (Math.random() * 8);
	}
}