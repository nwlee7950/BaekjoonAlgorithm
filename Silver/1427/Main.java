import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	int a = sc.nextInt();
	int len = (int)( Math.log10(a)+1 );
	int[] num = new int[len];
	for(int i = 0; i < len; i++) {
			num[i] = a % 10;
			a /= 10;
	}
	Arrays.sort(num);
	for(int b = len-1; b >= 0; b--)
		System.out.print(num[b]);
}
}