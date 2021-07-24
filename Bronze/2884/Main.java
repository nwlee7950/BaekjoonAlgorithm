import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();

		int after_hour = 0;
		int after_minute = 0;
		
		if(hour == 0)
		{
			if(minute >= 45)
			{
				after_minute = minute - 45;
			}
			else {
				after_hour = 23;
				after_minute = minute + 15;
			}
		}
		else {
			
			if(minute >= 45) {
				after_hour = hour;
				after_minute = minute - 45;
			}
			else {
				after_hour = hour - 1;
				after_minute = minute + 15;
			}
		}
		System.out.println(after_hour + " " + after_minute);
	}
}
