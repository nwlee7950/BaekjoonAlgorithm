import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		cnt = 0;
		backtrack(0);
		System.out.println(cnt);
	}

	static void backtrack(int idx) {
		if (idx == map.length) {
			cnt++;
			return;
		}
		for (int i = 0; i < map[idx].length; i++) {
			if (!isPossible(idx, i))
				continue;
			map[idx][i] = 1;
			backtrack(idx + 1);
			map[idx][i] = 0;
		}
	}

	static boolean isPossible(int r, int c) {
		for (int i=r; i>=0; i--) {
			if (map[i][c] == 1)
				return false;
		}
		for (int i=r, j=c; i>= 0 && j>=0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		for (int i=r, j=c; i>=0 && j<map[i].length; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}
		return true;
	}
}