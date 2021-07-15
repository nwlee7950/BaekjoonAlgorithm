import java.util.*;

public class Main {
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int C = sc.nextInt();
       
       for(int i = 0; i < C; i++) {
          int num = sc.nextInt();
          int[] Score = new int[num];
          int sum = 0;
          double avg = 0;
          int winner = 0;
          double winner_stu;
          
          for(int j = 0; j < num; j++) {
             Score[j] = sc.nextInt();
             sum += Score[j];
          }
          avg = sum / num;
          
          for(int k =0; k < num; k++) {
             if(Score[k] > avg)
                winner++;
          }
          
          winner_stu = (double)winner / (double)num * 100;
 
          System.out.printf("%.3f%%\n", winner_stu);
          
       }
    }
}