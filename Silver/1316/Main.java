import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int count = t;
		
		for(int tc = 1; tc <= t; tc++) {
			String word = sc.next();
			boolean[] arr = new boolean[26];

			for(int i = 1; i < word.length(); i++) {
				
				if(word.charAt(i-1) != word.charAt(i)) {
					if(arr[word.charAt(i) - 'a'] == true) {
						count--;
						break;
					}
						arr[word.charAt(i-1)- 'a'] = true;
				}
			}
		}
		System.out.println(count);
	}
}