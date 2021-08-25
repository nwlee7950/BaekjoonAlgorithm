import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		String[] croatiaAlp2 = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
		String croatiaAlp3 = "dz=";
		int count = 0;
		OUT : for(int i=0; i<str.length; i++) {
			if(i <= str.length- 3) {
				if(str[i].equals(Character.toString(croatiaAlp3.charAt(0)))
						&& str[i+1].equals(Character.toString(croatiaAlp3.charAt(1)))
						&& str[i+2].equals(Character.toString(croatiaAlp3.charAt(2)))){
					count++;
					i += 2;
					continue OUT;
				}
			}
			if(i <= str.length-2) {
				for(int j=0; j<croatiaAlp2.length; j++) {
					if(str[i].equals(Character.toString(croatiaAlp2[j].charAt(0)))
							&& str[i+1].equals(Character.toString(croatiaAlp2[j].charAt(1)))) {
							count++;
							i++;
							continue OUT;
					}
				}
			}
					count++;
			}
		System.out.println(count);
		}
	}