import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count = 0;
		int new_num = num;
		int temp;
		
		while(true) {
			count++;
			int a = new_num / 10;
			int b = new_num % 10;
			
			temp = (a + b) % 10;
			new_num = b * 10 + temp;
			if(new_num == num)
				break;

		}
		System.out.println(count);
	}
}