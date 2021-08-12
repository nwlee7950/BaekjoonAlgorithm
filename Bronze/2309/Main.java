import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] temp = new int[7];
    static boolean isFinish;
    
    private static void solution1(int idx, int count, int sum) {
        if(isFinish) return;
    	if(count==7) {      
            if(sum == 100) {
            	Arrays.sort(temp);
            	for(int i=0; i<7; i++) {
            		System.out.println(temp[i]);
            	}
            	isFinish = true;
            }
            return;
        }
        if(idx >= 9) return;
        if(sum > 100) return;
        
        temp[count] = arr[idx];
        solution1(idx+1, count + 1, sum + arr[idx]);
        solution1(idx+1, count , sum);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution1(0, 0, 0); 
    }
}

