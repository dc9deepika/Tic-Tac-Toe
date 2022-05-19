import java.util.Scanner;
import java.util.*;

public class Tic_Tac_Toe {           
         private Player player1, player2;
         private Board board;
         
//Tic_Tac_Toe class is our manager class here. It will manage the whole game.
//Like whose turn is next, who is winning, who is losing etc , will take care by this class.
			public void startGame() {
				Scanner input = new Scanner(System.in);
	
//(1.) PLAYER INPUT->	  
			player1 =takePlayerInput(1);
			player2 =takePlayerInput(2);
	    while(player1.getSymbol()==player2.getSymbol())
	    //using while()  loop so that it keep asking player 2 to enter correct symbol,until correct symbol is not given by p2  	
	     {
	    	 System.out.println("Symbol Alredy Taken!! Pick another Symbol");
	    	 char symbol=input.next().charAt(0);
	    	 player2.setSymbol(symbol);
	     }
// (2.)CREATE BOARD->	
	    
	       board=new Board(player1.getSymbol(),player1.getSymbol());
	//passing only symbols as parameters bcuz board should be knowing only symbols.Board has no work to do with names of players
	
//(3.) CONDUCT THE GAME->	
	   boolean player1Turn=true;
	   // 
	   int status= Board.INCOMPLETE;
	    while(status==Board.INCOMPLETE || status==Board.INVALID)
	    {
	    if(player1Turn)	
	    {
	   System.out.println("Player - 1  "+ player1.getName()+"'s turn :");   	
	   System.out.println("Enter x coordinate of cell :");
	   int x=input.nextInt();                //asking for the coordinates of cell at which he wants to play his move. like 0,1   2,2 etc
	   System.out.println("Enter y coordinate of cell :");
       int y=input.nextInt();
	   
       status=board.move(player1.getSymbol(),x,y);
         if(status==Board.INVALID)
         {
        	 System.out.println("Invalid Move !! Try Again!");
         }
         else {
        	 player1Turn=false; 
        	 board.print();            //using small b while accessing method of board class
         }
	}
	    else     //-> if(player2Turn)
	{
		System.out.println("Player - 2  " + player2.getName() + "'s turn :");
		System.out.println("Enter x coordinate of cell :");
		int x = input.nextInt(); 
		// asking for the coordinates of cell at which he wants to play his move. like 0,1   2,2 etc
		System.out.println("Enter y coordinate of cell :");
		int y = input.nextInt();

		status = board.move(player2.getSymbol(), x, y);
		if (status == Board.INVALID) 
		{
			System.out.println("Invalid Move !! Try Again!");
		} else
		{
			player1Turn = true;    //cant do something like player2Turn=false. bcuz we havent made anything like player2Turn. so using player1Turn =true means same i.e p2 turn finished now its p1 s turn to play his move
			board.print(); // using small b while accessing method of board class
		}
	}
}	
	if(status==Board.PLAYER_1_WINS)
	{
		System.out.println("Player - 1  "+player1.getName()+ "  Won!");
	}
	else if(status==Board.PLAYER_2_WINS)
	{
		System.out.println("Player - 2  "+player2.getName()+ "  Won!");
	}
	else {
		System.out.println(" MATCH DRAW!");
	}
}	 
 
//takeInput method	   
public Player takePlayerInput(int playerNumber) {
	Scanner input = new Scanner(System.in); // bcuz here,in this method also we wanna take input . Hence use and
											// import  scanner
	System.out.println("Enter Player-" + playerNumber +" "+ "name :");
	String name = input.nextLine();
	System.out.println("Enter Player-" + playerNumber + "'s symbol :");
	char symbol = input.next().charAt(0);

	Player p = new Player(name, symbol);
	return p;
}
	
//psvm() part->
 public static void main(String[] args) {
		   Tic_Tac_Toe t=new Tic_Tac_Toe();
		   t.startGame();
		   
  }
}
