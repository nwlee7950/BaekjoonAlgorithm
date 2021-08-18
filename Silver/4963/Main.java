import java.util.Scanner;

public class Main {
    static int[][] map;
    static int W, H;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            W = sc.nextInt();
            H = sc.nextInt();
            if(W == 0 && H == 0)
                break;
            map = new int[H][W];
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++)
                    map[i][j] = sc.nextInt();
            }
            //탐색하면서, 육지인 경우. 카운트를 하나 세고, 연결된 모든 육지를 삭제
            int cnt = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if( map[i][j] == 1 ) {
                        cnt++;
                        //연결된 모든 육지를 0으로 삭제
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int r, int c) {
        //현재 육지를 삭제
        map[r][c] = 0;
        //8방에 대해서, 지도 밖이면 패스, 바다여도 패스.
        //육지라면 재귀 콜
//        for(int d = 0; d < 8; d++) {
//            int nr = r + dr[d];
//            int nc = c + dc[d];
//            //밖으로 나가면 패스
//            if( nr < 0 || nc < 0 || nr >= H || nc >= W )
//                continue;
//            //바다여도 패스
//            if( map[nr][nc] == 0 )
//                continue;
//            dfs(nr, nc);
//        }
        for(int i=0; i<8; i++) {
        	if(r + delta[i][0] < 0 || c+delta[i][1] < 0 || r + delta[i][0] >= H || c+delta[i][1] >=W)
        		continue;
        	if(map[r+delta[i][0]][c+delta[i][1]] == 0)
        		continue;
        	dfs(r+delta[i][0], c+delta[i][1]);
        }
    }
    static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
//    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1};
}