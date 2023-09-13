import java.util.Scanner;
public class Homework2 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int year = myScanner.nextInt();

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}