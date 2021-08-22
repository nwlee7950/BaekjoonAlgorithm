import java.io.*;

public class Main {
	static int N, count;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; //(1,1)부터 시작하려고 사이즈를 +1씩 더 줌
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=1; j<=N; j++)
				map[i][j] = Integer.parseInt(str[j-1]);
		}
		count = 0; //count를 0으로 초기화함
		solve(1, 2, 0); // 첫 시작이 배열의 (1,1), (1,2)로 가로로 놓여져 있기 때문. direction은 0이 가로, 1이 세로, 2가 대각선
		System.out.println(count);
	}
	private static void solve(int r, int c, int direction) {
		if(r == N && c == N) { // 기저조건
			count++;
			return;
		}
		
		if(direction == 0) { // 파이프가 가로일 때
			if(c+1 <= N && map[r][c+1] == 0) //열이 범위를 넘지 않고 비었으면
				solve(r, c+1, 0);
		}
		else if(direction == 1) { //파이프가 세로일 때
			if(r+1 <= N && map[r+1][c] == 0) // 행이 범위를 넘지 않고 비었으면
				solve(r+1, c, 1);
		}
		else if(direction == 2) { //파이프가 대각선일 때
			if(c+1 <= N && map[r][c+1] == 0) //열이 범위를 넘지 않고 비었으면
				solve(r, c+1, 0);
			if(r+1 <= N && map[r+1][c] == 0) //행이 범위를 넘지 않고 비었으면
				solve(r+1, c, 1);
		}
		
		//대각선은 direction이 0,1,2 어느때이던 필요하므로 밑에 뺐다.
		if(c+1 <= N && r+1 <= N && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0)
			solve(r+1, c+1, 2);
	}
}