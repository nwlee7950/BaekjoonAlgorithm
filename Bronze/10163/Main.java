import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[1001][1001];
      int[] count = new int[N];
      
      for(int i=1; i<=N; i++) {
         String[] str = br.readLine().split(" ");
         int x = Integer.parseInt(str[0]);
         int y = Integer.parseInt(str[1]);
         int width = Integer.parseInt(str[2]);
         int height = Integer.parseInt(str[3]);

         for(int a = y; a < y+height; a++) {
            for(int b = x; b < x+width; b++) {
               map[a][b] = i;
            }
         }
      }
      for(int k=1; k<=N; k++) {
         for(int i=0; i<1001; i++) {
            for(int j=0; j<1001; j++) {
               if(map[i][j] == k)
                  count[k-1]++;
            }
         }
      }
      for(int i=0; i<N; i++) {
         sb.append(count[i]).append("\n");
      }
      System.out.println(sb);
   }
}