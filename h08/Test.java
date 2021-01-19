import java.util.ArrayList;

public class Test{
	public static void main(String[] args) {
		// Test eines Turms
		Rook rook = new Rook(new Position(4, 5));
		System.out.println(rook);
		rook.moveTo(new Position(4, 1));
		System.out.println(rook);
		System.out.println(rook.getMoveList());
		// Test eines Springers
		Knight knight = new Knight(new Position(5, 4));
		System.out.println(knight);
		knight.moveTo(new Position(6, 6)); // mitten auf dem Feld
		System.out.println(knight);
		System.out.println(knight.getMoveList());
		knight.moveTo(new Position(8, 5)); // am Rand des Feldes
		System.out.println(knight);
		System.out.println(knight.getMoveList());
        

        // Testen und ausprobieren der extra Funktionen :)

        // ArrayList<Chessman> chessmen = new ArrayList<>();
		// Position pos = new Position(3, 5);

		// chessmen.add(new Knight(pos));
		// chessmen.add(new Rook(pos));
		// chessmen.add(new Bishop(pos));
		// chessmen.add(new Pawn(pos));
		// chessmen.add(new King(pos));
		// chessmen.add(new Queen(pos));

		// for (Chessman chessman : chessmen) {
		// 	chessman.print();
		// 	System.out.println();
		// }

		// Chessman p = new Pawn(pos);
		// p.print();
		// try {
		// 	p.moveTo(new Position(pos.getX() - 2, pos.getY()));
		// } catch (PawnWantsToEvolveException e) {
		// 	p = new Queen(p.getPosition());
		// }
		// p.print();
        // System.out.println(p);
    }
}

