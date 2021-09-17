import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 사람의 수
        int M = Integer.parseInt(str[1]); // 간선의 수
        int[][] adj = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }
        for(int i = 0; i < M; i++) {
        	str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            adj[from][to] = 1;
        }
            //floyd warshall 알고리즘 수행
        for (int i = 1; i <= N; i++) {
           for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (adj[j][k] > adj[j][i] + adj[i][k]) {
                       adj[j][k] = adj[j][i] + adj[i][k];
                    }
                }
               }
        }

        int[] cnt = new int[N+1];//각 사람별로 INF의 숫자를 셀 변수
        //각 사람별로 INF의 갯수를 카운트
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(adj[i][j] != INF && adj[i][j] != 0) {
            		cnt[i]++;
                	cnt[j]++;
            	}
           	}
        }
            //INF의 갯수가 0인 사람은 내 키를 아는것. 그 수를 센다
        int ans = 0;
        for(int i = 1; i<=N; i++) {
        	if(cnt[i] == N-1) {
        		ans++;
            }
           }
        System.out.println(ans);
            //그 값이 결과
        
    }
}