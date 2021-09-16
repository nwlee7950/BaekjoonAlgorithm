import java.io.*;
import java.util.Arrays;

public class Main {
		static char[][] map;
		static boolean[][] visit;
		static int N;
		static int count;
	    static int[] dx = {-1, 0, 0, 1};
	    static int[] dy = {0, 1, -1, 0};
	    
	public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        visit = new boolean[N+1][N+1];
        count = 0;
        
        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
        	for(int j=0; j<N; j++) {
        		map[i][j] = str[j].charAt(0);
        	}
        }
        
        //색맹이 아닌사람
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(!visit[i][j]) {
        	        solve(i,j);
        	        count++;
        		}
        	}
        }
        sb.append(count).append(" ");
        
        //색맹인 사람
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(map[i][j] == 'R')
        			map[i][j] = 'G';
        		
        		visit[i][j] = false;
        	}
        }
        count = 0;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(!visit[i][j]) {
        	        solve(i,j);
        	        count++;
        		}
        	}
        }        sb.append(count);
        
        System.out.println(sb);
	}
	
	private static void solve(int x, int y) {
		visit[x][y] = true;
		char cur_color = map[x][y];
		for(int i=0; i<4; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			
			if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= N)
				continue;
			if(!visit[new_x][new_y] && map[new_x][new_y] == cur_color) {
				solve(new_x, new_y);
			}
		}
	}
}