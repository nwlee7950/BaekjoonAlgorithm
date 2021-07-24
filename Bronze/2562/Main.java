import java.util.*;

public class Main {

	public static void main(String[] args) {
		int index = 0;
		int max;
		int i;
		int[] numbers = new int[9];
		
		Scanner sc = new Scanner(System.in);
		
		for(i = 0; i < 9; i++)
		{
			numbers[i] = sc.nextInt();
		}
		
		max = numbers[0];
		
		for (i = 0; i < 9; i++)
		{
			if(numbers[i] > max)
			{
				max = numbers[i];
				index = i;
			}
		}
		index = index + 1;
		
		System.out.println(max);
		System.out.println(index);
	}
}
