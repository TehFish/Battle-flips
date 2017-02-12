
public class Ship {
	private static int position;
	private static char direction;
	private static int length;
	
	public Ship(){
		position = 0;
		direction = 'n';
		length = 3;
	}
	public static int getPosition() {
		return position;
	}


	public static void setPosition(int position) {
		Ship.position = position;
	}


	public static char getDirection() {
		return direction;
	}


	public static void setDirection(char direction) {
		Ship.direction = direction;
	}


	public static int getLength() {
		return length;
	}


	public static void setLength(int length) {
		Ship.length = length;
	}
	public static void place(int[] board){
		board[getPosition()] = -1;
		switch (getDirection()){
		case 'r':
			board[getPosition() + 1] = -1;
			board[getPosition() + 2] = -1;
			break;
		case 'l':
			board[getPosition() - 1] = -1;
			board[getPosition() - 2] = -1;
			break;
		case 'u':
			board[getPosition() - 10] = -1;
			board[getPosition() - 20] = -1;
			break;
		case 'd':
			board[getPosition() + 10] = -1;
			board[getPosition() + 20] = -1;
			break;
		}

	}

	 
	 

	

}
