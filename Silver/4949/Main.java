import java.io.*;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
		while(true) {
			str = br.readLine();
			if(str.equals("."))
				break;
			else
				sb.append(solve(str)).append("\n");
		}
		System.out.println(sb);
	}

	private static String solve(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
        	char c = str.charAt(i);
        	
        	if(c == '(' || c == '[')
        		stack.push(c);
        	else if(c == ')') {
        		if(stack.empty() || stack.peek() != '(')
        			return "no";
        		else
        			stack.pop();
        	}
        	else if(c == ']') {
        		if(stack.empty() || stack.peek() != '[')
        			return "no";
        		else
        			stack.pop();
        	}
        }
		if(stack.empty())
			return "yes";
		else
			return "no";
	}
}
