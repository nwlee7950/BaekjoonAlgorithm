import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if(hs.contains(name)){
                ans.add(name);
            }
        }
        
        Collections.sort(ans);
        System.out.println(ans.size());
        
        for (String s : ans) {
            System.out.println(s);
        }
    }
}