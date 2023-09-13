import java.util.Scanner;
public class IfElse {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("score");
		double score = myScanner.nextDouble();

		if(score > 8.0) {
			System.out.println("sex");
			char sex = myScanner.next().charAt(0);
			if(sex == 'm') {
				System.out.println("In,M");
			} else if(sex == 'f') {
				System.out.println("In,F");
			} else {
				System.out.println("input m or f");
			}
		} else {
			System.out.println("Fail");
		}
	}
}