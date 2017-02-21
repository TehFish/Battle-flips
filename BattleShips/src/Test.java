
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		Ship s = new Ship();
		Main.boardReset(Main.board);
		s.setPosition(25);
		s.setDirection('u');
		s.setLength(3);
		s.place(Main.board);
		Main.showOponentBoard(Main.board);
	}
}
