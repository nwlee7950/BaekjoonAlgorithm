import java.util.*;

public class Main {

	public static void main(String[] args) {
		int arraySize;
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		arraySize = sc.nextInt();
		int[] numbers = new int[arraySize];
		
		for(n = 0; n < arraySize; n++)
		{
			numbers[n] = sc.nextInt();
		}
		
		int min = numbers[0];
		int max = numbers[0];
		
		for(n = 0; n < arraySize; n++)
		{
			if(numbers[n] > max)
				max = numbers[n];
			
			if(numbers[n] < min)
				min = numbers[n];
		}
		System.out.print(min + " " + max);
	}

}
