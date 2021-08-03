import java.util.Scanner;
public class Main {

	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void hanoi(int n, int from, int to, int temp) {
		if (n == 0)
			return;
		else {
			count++;
			hanoi(n - 1, from, temp, to);
			sb.append(from + " " + to + "\n");
			hanoi(n - 1, temp, to, from);		
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		hanoi(n, 1, 3, 2);

		System.out.println(count);
		System.out.println(sb);
	}
}