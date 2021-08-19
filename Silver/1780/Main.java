import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		count = new int[3];
		int size = N;
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		
		solve(0, 0, size);
		for(int j=0; j<=2; j++)
			System.out.println(count[j]);
		
	}
	private static void solve(int x, int y, int size) {
		if(isOk(x, y, size)) {
			count[arr[x][y]+1] += 1;
			return;
		}
		int new_size = size/3;
		solve(x, y, new_size); //좌상
		solve(x , y + new_size , new_size); // 중상
		solve(x, y + new_size*2 , new_size); // 우상
		
		solve(x + new_size, y, new_size); // 좌중
		solve(x + new_size, y + new_size, new_size); // 중중
		solve(x + new_size, y + new_size*2 , new_size); // 우중
		
		solve(x + new_size*2, y , new_size); // 좌하
		solve(x + new_size*2, y + new_size, new_size); // 중하
		solve(x + new_size*2, y + new_size*2 , new_size); // 우하
	}
	
	private static boolean isOk(int x, int y, int size) {
		int temp = arr[x][y];
		
		for(int i=x; i < x+size; i++) {
			for(int j=y; j < y+size; j++) {
				if(temp != arr[i][j])
					return false;
			}
		}
		return true;
	}
}