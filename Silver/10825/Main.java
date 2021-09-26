import java.io.*;
import java.util.*;

public class Main {
	public static class Student implements Comparable<Student>{
		String name;
		int kor;
		int eng;
		int math;
		
		Student(String name, int kor, int eng, int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if(this.kor < o.kor) {
				return 1;
			} else if(this.kor == o.kor) {
				if(this.eng > o.eng) {
					return 1;
				} else if(this.eng == o.eng) {
					if(this.math < o.math) {
						return 1;
					} else if(this.math == o.math) {
						if(this.name.compareTo(o.name) > 0) {
							return 1;
						}
					}
				}
			}
			
			return -1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Student> li = new ArrayList<Student>();

		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			String name = str[0];
			int kor = Integer.parseInt(str[1]);
			int eng = Integer.parseInt(str[2]);
			int math = Integer.parseInt(str[3]);
			li.add(new Student(name, kor, eng, math));
		}
		
		Collections.sort(li);
		for(int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).name);
		}
	}
}