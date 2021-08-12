import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    private static String[] arr;
    private static int L, C;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        L = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);
 
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
 
        solve(0,"");
    }
    private static void solve(int idx, String str){
        if(str.length() == L){
            if(isPossible(str)){
                System.out.println(str);
            }
            return;
        }
        if(idx >= C ){
            return;
        }
        solve(idx+ 1, str + arr[idx]);
        solve(idx+ 1, str );
    }
 
    private static boolean isPossible(String str){
        int vowel = 0, consonant = 0;
        for (int i = 0; i < str.length(); i++) {
            if(isVowel(str.charAt(i))){
                vowel++;
            }else {
                consonant++;
            }
        }
        return vowel>=1 && consonant >=2 ? true : false;
    }
 
 
    private static boolean isVowel( char ch ){
        return ch == 'a' | ch=='e' | ch=='i' | ch=='o' | ch=='u';
    }
 
}