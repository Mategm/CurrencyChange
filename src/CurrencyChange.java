import java.util.Scanner;

/**
 * @author mateg
 * Írjunk java programot ami bekér a felhasználótól egy pozitív egész számot, 
 * majd kiszámolja hogy ez a pénzösszeg milyen címletekben adható ki, 
 * úgy hogy a legkevesebb címletet használjuk fel.
 */
public class CurrencyChange {
	private static Scanner scanner;

	public static void main(String[] args) {
		String papir;
		String kerekitve = "";
		int moneyAmount = bekeres();
		byte kerek = (byte) (moneyAmount % 10);
		if (kerek > 0 ) {
			if (kerek < 5) {
				moneyAmount -= kerek;
				kerekitve = "(kerekítve)";
			} else {
				moneyAmount += 10 - kerek;
				kerekitve = "(kerekítve)";
			}
		}
		System.out.println("A megadott pénzösszeg: " + moneyAmount + " " + kerekitve);
		int[] currencies = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
		int[] pieces = new int[currencies.length];
		int remainingAmount = moneyAmount;
		for (int i = 0; i < currencies.length; i++) {
			pieces[i] = remainingAmount / currencies[i];
			remainingAmount = remainingAmount % currencies[i];
		}
//		System.out.println(Arrays.toString(pieces));
		System.out.println("Adunk önnek: ");
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] != 0) {
				if (currencies[i] >= 2000) {
					papir = "értekű bankjegyet";
				} else {
					papir = "értekű érmét";
				}
				System.out.println(pieces[i] + " db " + currencies[i] + " " + papir);
			}
		}
		System.out.println();
		System.out.println("Köszönjük, hogy az átváltási szolgáltatásunkat használta!");
	}

	public static int bekeres() {
		byte done = 0;
		int moneyAmount;
		do {
			scanner = new Scanner(System.in);
			System.out.print("Kérem, adja meg a pénzösszeget: ");
			moneyAmount = scanner.nextInt();
			if (moneyAmount == 0) {
				System.out.println("Nullát adott meg, nem adunk semmit se.");
			} else if (moneyAmount < 0) {
				System.out.println("Negatív számot adott meg, így ön fizetne nekünk.");
			} else {
				System.out.println("Köszönöm, egy pillanat...");
				done = 1;
			}
		} while (done != 1);
		return moneyAmount;
	}
	
}
