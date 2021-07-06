import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num1, num2;
		int firstLine, secondLine, thirdLine;
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		a = num2 % 10;
		b = num2 % 100 / 10;
		c = num2 / 100;

		firstLine = num1 * a;
		secondLine = num1 * b;
		thirdLine = num1 * c;

		System.out.println(firstLine);
		System.out.println(secondLine);
		System.out.println(thirdLine);
		System.out.println(num1 * num2);
	}

}
