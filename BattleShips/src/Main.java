import java.util.*;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int[] board = new int[101];
	public static int[] board2 = new int[101];
	private static final String YES = "yes";
	public static void main(String[] args) {
		// TODO fix oponentboard print
		Ship[] ships = new Ship[1];
		Ship[] ships2 = new Ship[1];
		System.out.println("Do you know the board configurations?");
		if (sc.next().equals(YES) == false){
			System.out.println("The board has numbers from 1 to 100");
			System.out.println("These numbers are the boxes wich you can choose to do actions with");
			System.out.println("If you see -1 in a board that means there is a ship there");
			System.out.println("If you see -2 in a board that means that place has been shot");
			System.out.println("Good luck!");
		}
		int oponent = 1;
		boardReset(board);
		boardReset(board2);
		startGame(board, ships, oponent);
		oponent = 2;
		startGame(board2, ships2, oponent);
		oponent = 1;
		while (true){
			startShooting(board, board2, oponent);
			oponent = 2;
			if (end(board2)){
				System.out.println("Oponent number 1 has won!");
				break;
			}
			startShooting(board2, board, oponent);
			oponent = 1;
			if (end(board)){
				System.out.println("Oponent number 2 has won!");
				break;
			}
		}
	}
	public static boolean end(int[] board){
		for (int i : board){
			if (i == -1)
				return false;
		}
		return true;
	}
	public static void shoot(int[] board){
		boolean hit = true;
		int check;
		while (hit){
			System.out.println("Choose a place to shoot, this should be a number between 1 and 100");
			check = sc.nextInt();
			if (board[check] == -1){
				System.out.println("You hit!");
				board[check] = -2;
				hit = false;
			}
			else if (board[check] == -2){
				System.out.println("You already shot there, better luck next time");
				System.out.println("Do you want to see the oponent's board?");
				if (sc.next().equals(YES)){
					System.out.println("This is how the oponents board looks like");
					showOponentBoard(board);
				}
			}
			else{
				System.out.println("You missed :(");
				board[check] = -2;
				hit = false;
			}
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
			if (counter < 10){
				if (i == -1 || i == -2)
					System.out.print(i+"  ");
				else
					System.out.print(i+"   ");
			}
			else
				System.out.print(i+"  ");
			counter++;
		}
	}
	public static void showOponentBoard(int[] board){
		int counter = -1;
		for (int i : board){
			if (counter % 10 == 0)
				System.out.println();
			if (counter < 10){
				if (i == -1){
					i = counter + 1;
					System.out.print(i+"   ");	
				}
				else if (i == -2)
					System.out.print(i+"  ");
				else
					System.out.print(i+"   ");
			}
			else if (i == -1){
				i = counter + 1;
				System.out.print(i+"  ");
			}
			else
				System.out.print(i+"  ");
			counter++;
		}
	}
	public static void whoWon(){
		if (end(board))
			System.out.println("Oponent number 1 has won, woohoo!");
		if (end(board2))
			System.out.println("Oponent number 2 has won, woohoo!");
	}
	public static void startGame(int[] board, Ship[] ships, int oponent){
		System.out.println("Oponent no."+oponent+"'s turn");
		System.out.println("Enter the position for 5 ships, this should be a number between 0 and 99");
		System.out.println("Enter the direction of the ship you want to place, this should be u - up, d - down, r - right, l - left");
		for (int i = 0; i < ships.length; i++){
			try{
				System.out.println("\nEnter the position and direction of the ship");	
				ships[i] = new Ship();
				ships[i].setPosition(sc.nextInt());
				ships[i].setDirection(sc.next().charAt(0));
				if (i == 0){
					if (oponent == 1){
						ships[i].place(board);
						continue;
					}
					else if (oponent == 2){
						ships[i].place(board2);
						continue;
					}
				}
				if (board[ships[i].getPosition()] == -1){
					System.out.println("There is already a ship there, please try again");
					System.out.println("Do you want to see how your side looks?");
					if (sc.next().equals(YES)){
						System.out.println("This is how your side looks like");
						showBoard(board);
					}
					continue;
				}
				switch(ships[i].getDirection()){
				case 'r':
					if (board[ships[i].getPosition() + 1] == -1 || board[ships[i].getPosition() + 2] == -1){
						System.out.println("There is already a ship there please try again");
						i--;
						System.out.println("Do you want to see how your side looks?");
						if (sc.next().equals(YES)){
							System.out.println("This is how your side looks like");
							showBoard(board);
						}
						break;
					}

					if (oponent == 1)
						ships[i].place(board);
					else
						ships[i].place(board2);
					continue;
				case 'l':
					if (board[ships[i].getPosition() - 1] == -1 || board[ships[i].getPosition() - 2] == -1){	
						System.out.println("There is already a ship there please try again");
						i--;
						System.out.println("Do you want to see how your side looks?");
						if (sc.next().equals(YES)){
							System.out.println("This is how your side looks like");
							showBoard(board);
						}
						break;
					}

					if (oponent == 1)
						ships[i].place(board);
					else
						ships[i].place(board2);
					continue;
				case 'd':
					if (board[ships[i].getPosition() + 10] == -1 || board[ships[i].getPosition() + 20] == -1){
						System.out.println("There is already a ship there please try again");
						i--;
						System.out.println("Do you want to see how your side looks?");
						if (sc.next().equals(YES)){
							System.out.println("This is how your side looks like");
							showBoard(board);
						}
						break;
					}
					if (oponent == 1)
						ships[i].place(board);
					else
						ships[i].place(board2);
					continue;
				case 'u':	
					if (board[ships[i].getPosition() - 10] == -1 || board[ships[i].getPosition() - 20] == -1){
						System.out.println("There is already a ship there please try again");
						i--;
						System.out.println("Do you want to see how your side looks?");
						if (sc.next().equals(YES)){
							System.out.println("This is how your side looks like");
							showBoard(board);
						}
						break;
					}
					if (oponent == 1)
						ships[i].place(board);
					else
						ships[i].place(board2);
					continue;
				}
			}

			catch (IndexOutOfBoundsException e){
				System.out.println("The ship is out of the board please try again");
				i--;
				System.out.println("Do you want to see how your side looks?");
				if (sc.next().equals(YES)){
					System.out.println("This is how your side looks like");
					showBoard(board);
					i--;
				}
				sc.reset();
			}
			catch (InputMismatchException e){
				System.out.println("Inorrect input, please try again");
				i--;
				sc.reset();
			}
		}// <----- end of for block
		System.out.println("Do you want to see how your side looks?");
		if (sc.next().equals(YES)){
			System.out.println("This is how your side looks like");
			showBoard(board);
		}
		System.out.println("Do you want to continue?");
		if (sc.next().equals(YES))
			System.out.println("\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n");
		else{
			System.out.println("Ok i'll wait 3 seconds");
			try {
				Thread.sleep(3000);
				System.out.println("\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void startShooting(int[] board, int[] board2, int oponent){
		System.out.println("it's oponent no."+oponent+"'s turn to shoot");
		shoot(board2);
		System.out.println("Do you want to see how your side looks?");
		if (sc.next().equals(YES)){
			System.out.println("This is how your side looks like");
			showBoard(board);
		}
		System.out.println("Do you want to see the oponent's board?");
		if (sc.next().equals(YES)){
			System.out.println("This is how the oponents board looks like");
			showOponentBoard(board2);
		}
		System.out.println("Do you want to continue?");
		if (sc.next().equals(YES))
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		else{
			System.out.println("Ok i'll wait 3 seconds");
			try {
				Thread.sleep(3000);
				System.out.println("\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}





