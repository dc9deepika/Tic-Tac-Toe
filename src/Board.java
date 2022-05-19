
public class Board {
     private char board[][];
     private int boardSize=3;
     private char p1Symbol,p2Symbol;
     private int count;

		public Board(char p1symbol, char p2symbol) {
			board = new char[boardSize][boardSize];
			for (int i = 0; i < boardSize; i++) {
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = ' ';
				}
			}
			this.p1Symbol = p1symbol; // here board accepting the symbols given as an argument by user
			this.p2Symbol = p2symbol;

  } 

    public final static int PLAYER_1_WINS=1;
    public final static int PLAYER_2_WINS=2;
    public final static int DRAW=3;
    public final static int INCOMPLETE=4;
    public final static int INVALID=5;
     
	public int move(char symbol, int x, int y) {
//check condns for invalid
		if (x < 0 || x >= boardSize || y < 0 || y >=boardSize || board[x][y] != ' ') // board[x][y]!=' ' -> this will
																						// check whether the player is
																						// not playing his move in the
																						// cell which is already taken
																						// by another player(i.e cell is
																						// already occupied)
		{
			return INVALID;
		}

		board[x][y] = symbol;
		count++;
//checking cases of winning

		// row -> if someone is doing goal horizontally
		if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}

		// col -> if anyplayer is doing goal vertically
		if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}

		// 1st diagonal
		// board[0][0]!=' ' -> we are checking this bcuz if a player is palying for 1st
		// time or any time and he is not playing his move at cell of diagonal
		// . Let he is palying valid move. but as space ' ' is present in all the
		// diagonal cells it will return saying that player playing at that particular
		// turn
		// wins.Although it shouldn't be the case. cuz due to presence of space it is
		// returning that. Hence we need to check that all the diagonal cells are equal
		// nd they must not be equal to space.
		// Need to put this check only while digonal checking

		if (board[0][0] != ' ' && (board[0][0] == board[1][1] && board[0][0] == board[2][2])) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}

		// 2nd diagonal
		if (board[0][2] != ' ' && (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}

//Draw conds ->
		if (count == boardSize * boardSize) {
			return DRAW;
		}
		return INCOMPLETE;
	}

	// print() function to print the status of board after every move. Easy for
	// visualising
	public void print() {
		System.out.println("BOARD'S STATUS ->");
		System.out.println("-----------------------");
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print("|  " + board[i][j] + "  |" + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-----------------------");
	}
    

}
