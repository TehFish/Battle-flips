import java.util.*;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int[] board = new int[101];
	public static int[] board2 = new int[101];
	public static void main(String[] args) {
		// TODO 
		Ship[] ships = new Ship[5];
		Ship[] ships2 = new Ship[5];
		int oponent = 1;
		boardReset(board);
		boardReset(board2);
		System.out.println("Oponent no.1's turn");
		System.out.println("Enter the position for 5 ships, this should be a number between 0 and 99");
		System.out.println("Enter the direction of the ship you want to place, this should be u - up, d - down, r - right, l - left");
		for (int i = 0; i < ships.length; i++){
			System.out.println("Enter the position and direction of the ship");	
			ships[i] = new Ship();
			ships[i].setPosition(sc.nextInt());
			ships[i].setDirection(sc.next().charAt(0));
			System.out.println(i);
			if (board[ships[i].getPosition()] == -1){
				System.out.println("There is already a ship there, please try again");
				i--;
			}
			if (i == 0)
				ships[i].place(board);
				System.out.println(i);
		}
		System.out.println("Oponent no.2's turn");
		System.out.println("Enter the position for 5 ships, this should be a number between 0 and 99");
		System.out.println("Enter the direction of the ship you want to place, this should be u - up, d - down, r - right, l - left");
		System.out.println("Enter the position and dirction of ship 1");
		for (int j = 0; j < ships.length; j++){
			System.out.println("Enter the position and direction of the ship");	
			//ships2[j] = new Ship(sc.nextInt(), sc.next().charAt(0), 3);

		}

		while (end()){
			if (oponent == 1){
				System.out.println("it's oponent no.1's turn to shoot");
				shoot(board2);
			}
			else{
				System.out.println("It's oponent no.2's turn to shoot");
				shoot(board);
			}
		}
	}
	public static boolean end(){
		for (int i : board){
			if (i == -1){
				System.out.println("The game is over now go away");
				return false;
			}
		}
		return true;
	}
	public static void shoot(int[] board){
		System.out.println("Choose a place to shoot, this should be a nmber between 1 and 100");
		if (board[Main.sc.nextInt()] == -1){
			System.out.println("You hit!");
			board[Main.sc.nextInt()] = -2;
		}
		else if (board[Main.sc.nextInt()] == -2)
			System.out.println("You already shot there :(");
		else{
			System.out.println("You missed :(");
			board[Main.sc.nextInt()] = -2;
		}
	}
	public static void boardReset(int[] board){
		for (int i = 0; i < board.length; i++)
			board[i] = i;
	}
	public static void showBoard(int[] board){
		int counter = -1;
		for (int i : board){
			if (counter % 10 == 0)
				System.out.println();
			System.out.print(i+" ");
			counter++;
		}
	}
}


