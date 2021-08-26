import java.io.*;

public class Main {
	static class Rectangle{
		int startX, startY;
		int endX, endY;
		
		public Rectangle(int startX, int startY, int endX, int endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<4; tc++) {
			String[] str = br.readLine().split(" ");
			Rectangle rec1 = new Rectangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			Rectangle rec2 = new Rectangle(Integer.parseInt(str[4]), Integer.parseInt(str[5]), Integer.parseInt(str[6]), Integer.parseInt(str[7]));
			
			if((rec1.endX == rec2.startX && rec1.endY == rec2.startY)
					|| (rec1.startX == rec2.endX && rec1.endY == rec2.startY)
					|| (rec1.endX == rec2.startX && rec1.startY == rec2.endY)
					|| (rec1.startX == rec2.endX && rec1.startY == rec2.endY)) {
				sb.append("c").append("\n");
			}
			else if((rec1.endX == rec2.startX && rec1.endY != rec2.startY)
					|| (rec1.startX == rec2.endX && rec1.endY != rec2.startY)
					|| (rec1.endX != rec2.startX && rec1.startY == rec2.endY)
					|| (rec1.startX != rec2.endX && rec1.startY == rec2.endY)) {
				sb.append("b").append("\n");
			}
			else if(rec1.endX < rec2.startX || rec2.endX < rec1.startX || rec1.endY < rec2.startY || rec2.endY < rec1.startY) {
				sb.append("d").append("\n");
			}
			else
				sb.append("a").append("\n");
		}
		System.out.print(sb);
	}
}