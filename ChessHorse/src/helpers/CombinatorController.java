package helpers;

public class CombinatorController {

	public static void main(String[] args) {
		Combinator c = new Combinator(8);
		int counter = 1;
		do {
			System.out.println("\n=== #"+ counter +" ===");
			c.printState();
			if (counter > 100) {
				return;
			}
			counter++;
		} while (c.next());
	}
	
}
