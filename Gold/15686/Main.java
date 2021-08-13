import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] visit;
	static ArrayList<Dot> chicken;
	static ArrayList<Dot> home;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N+1][N+1];
        chicken = new ArrayList<Dot>();
        home = new ArrayList<Dot>();
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) 
        			home.add(new Dot(i, j));
        		else if(arr[i][j] == 2) 
        			chicken.add(new Dot(i, j));
        	}
        }
        visit = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;
        
        solve(0, 0);
        System.out.println(ans);
    }

	private static void solve(int idx, int start) {
		if(idx == M) {
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(visit[j]) {
						int gap = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						
						if(min > gap)
							min = gap;
					}
					
				}
				sum += min;
			}
			if(sum < ans)
				ans = sum;
			return;
		}
			for(int i=start; i<chicken.size(); i++) {
				if(!visit[i]) {
					visit[i] = true;
					solve(idx+1, i+1);
					visit[i] = false;
				}
			}
	}
	
	static class Dot{
		int x;
		int y;
		
		Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}