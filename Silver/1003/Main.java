import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int T = Integer.parseInt(br.readLine());
      
      int[] zero = new int[41];
      int[] one = new int[41];
      
      zero[0] = 1;
      zero[1] = 0;
      one[0] = 0;
      one[1] = 1;
      
      for(int j=2; j<41; j++) {
    	  zero[j] = zero[j-1] + zero[j-2];
    	  one[j] = one[j-1] + one[j-2];
      }
      for(int i=0; i<T; i++) {
    	  int n = Integer.parseInt(br.readLine());
    	  sb.append(zero[n]).append(" ").append(one[n]).append("\n");
      }
      System.out.println(sb);
   }
}