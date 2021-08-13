import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int temp;
        int count = 0;
        int num = 0;
        while(true) {
        	temp = N;
        	count = 0;
        	while(temp > 0){
            	if(temp % 2 == 1) {
            		count++;
            	}
            	temp /= 2;
            }
        	if(count <= K) {
        		System.out.println(num);
        		break;
        	}
        	else {
        		N++;
        		num++;
        	}
        }
	}
}