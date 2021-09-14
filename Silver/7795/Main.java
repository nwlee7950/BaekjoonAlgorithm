import java.io.*;
import java.util.Arrays;

public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int T = Integer.parseInt(br.readLine());
      for(int tc = 0; tc < T; tc++) {
         String[] str = br.readLine().split(" ");
         int N = Integer.parseInt(str[0]);
         int M = Integer.parseInt(str[1]);
         int[] arrN = new int[N];
         int[] arrM = new int[M];
         int count = 0;
         
         str = br.readLine().split(" ");
         for(int i=0; i<N; i++)
            arrN[i] = Integer.parseInt(str[i]);
         str = br.readLine().split(" ");
         for(int j=0; j<M; j++)
            arrM[j] = Integer.parseInt(str[j]);
         
         Arrays.sort(arrN);
         Arrays.sort(arrM);
         
         for(int a=N-1; a>=0; a--) {
        	 int temp = 0;
            while(temp < M && arrN[a] > arrM[temp]) {
            	temp++;
            }
            count += temp;
         }
         sb.append(count).append("\n");
      }
      System.out.print(sb);
   }
}