import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int count = 0;
		int days = 13;
		
		for(int i = 2019; i <= N; i++) {
			for(int j = 1; j <= 12; j++) {
				if(days % 7 == 4)
					count++;
				
				if(j == 2) {
    				if(i % 400 == 0)
						days += 29;
					else if(i % 400 != 0 && i % 100 == 0)
						days += 28;
					else if(i % 100 != 0 && i % 4 == 0)
						days += 29;
					else
						days += 28;
    			} else {
    				days += month[j];
    			}
			}
		}
		System.out.println(count);
	}
}