import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] temp;
    static int N;
    static int max;
    static int[] count;
    static int idx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            map = new int[N][N];
            max = Integer.MIN_VALUE;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                	 map[i][j] = sc.nextInt();
                	 max = Math.max(max, map[i][j]);
                }
            }
            count = new int[++max];
            idx = 0;
            temp= new int[map.length][map.length];
            for(int a=0; a<max; a++){
            	 for (int i = 0; i < map.length; i++) {
            	        temp[i]= Arrays.copyOf(map[i],map[i].length);
            	      }
            	for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if( temp[i][j] <= a ) {
                            temp[i][j] = 0;
                        }
                    }
                }
            	for(int i=0; i<N; i++) {
            		for(int j=0; j<N; j++) {
            			if(temp[i][j] != 0) {
            				dfs(i, j);
            				count[idx]++;
            			}
            		}
            	}
            	idx++;
            }
            Arrays.sort(count);
            System.out.println(count[count.length-1]);      
    }
    static void dfs(int r, int c) {
        temp[r][c] = 0;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            //밖으로 나가면 패스
            if( nr < 0 || nc < 0 || nr >= N || nc >= N || temp[nr][nc] == 0)
                continue;
            dfs(nr, nc);
        }
    }
    static int[] dr = { -1, 0, 1, 0};
    static int[] dc = { 0, 1, 0, -1};
}