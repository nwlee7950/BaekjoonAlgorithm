import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		String temp1 = "";
		String temp2 = "";
		
		for(int i = a.length()-1; i >= 0; i--) {
			temp1 += a.charAt(i);
			temp2 += b.charAt(i);
		}
		
		int num1 = Integer.parseInt(temp1);
		int num2 = Integer.parseInt(temp2);
		
		System.out.println(num1>num2?num1:num2);
	}
}