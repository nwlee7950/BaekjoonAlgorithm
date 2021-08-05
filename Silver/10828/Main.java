import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {		
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("push")) {
				stack.push(Integer.parseInt(str[1]));
			}else if(str[0].equals("pop")) {
				if(stack.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(stack.pop() + "\n");
			}else if(str[0].equals("size")){
				bw.write(stack.size() + "\n");
			}else if(str[0].equals("empty")) {
				if(stack.isEmpty())
					bw.write("1" + "\n");
				else
					bw.write("0" + "\n");
			}else if(str[0].equals("top")) {
				if(stack.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(stack.peek() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}