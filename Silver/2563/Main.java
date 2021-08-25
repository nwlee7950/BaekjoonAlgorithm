import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			for(int a = x; a < x+10; a++) {
				for(int b = y; b < y+10; b++)
					map[a][b] = 1;
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
	}
}