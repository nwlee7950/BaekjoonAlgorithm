import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N;
    static int total_count;
    static int each_count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
            N = sc.nextInt();
            total_count = 0;
            each_count = 0;
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
            	String[] str = sc.next().split("");
                for(int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(str[j]);
            }

            //탐색하면서, 육지인 경우. 카운트를 하나 세고, 연결된 모든 육지를 삭제
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if( map[i][j] == 1 ) {
                        total_count++;
                        //연결된 모든 육지를 0으로 삭제
                        dfs(i, j);
                        pq.add(each_count+1);
                        each_count = 0;
                    }   
                }
            }
            System.out.println(total_count);
            while(!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
        
    }
    static void dfs(int r, int c) {
        map[r][c] = 0;
        //4방에 대해서, 지도 밖이면 패스, 0이어도 패스.
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            //밖으로 나가면 패스
            if( nr < 0 || nc < 0 || nr >= N || nc >= N )
                continue;
            if( map[nr][nc] == 0 )
                continue;
            each_count++;
            dfs(nr, nc);
        }

    }
    static int[] dr = { -1, 0, 1, 0};
    static int[] dc = { 0, 1, 0, -1};
}