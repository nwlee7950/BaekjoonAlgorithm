import java.util.Scanner;
//스위치번호가 1번부터 입력되기 때문에,
//스위치 배열에 0부터 담았다면 번호를 1 줄여서 생각해야되고
//아니면 스위치배열을 0번을 비워두고 1번부터 채우는 방법도.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//스위치의 길이를 입력
		int size = sc.nextInt();
		//스위치들을 입력받음
		int[] sw = new int[size + 1];//1번부터 사용하기 위해 하나 더 큰 배열 준비.
		for(int i = 1; i <= size; i++)
			sw[i] = sc.nextInt();
		//학생 수
		int num = sc.nextInt();
		//학생 수 만큼 명령이 입력됨.
		for(int i = 0; i < num; i++) {
			//명령의 첫번째 숫자는 성별.
			int gender = sc.nextInt();
			//명령의 두번째 숫자는 누를 스위치.
			int sw_num = sc.nextInt();
			//남자애면, 자신의 배수들을 스위치 변경
			if(gender == 1) {
				for(int j = sw_num; j <= size; j+= sw_num) {
					sw[j] = sw[j]==1?0:1;
				}
			}
			//여자애면, 자신의 좌우로 한쪽 끝이 만날때까지 스위치를 변경
			else if(gender == 2) {
				int cur = 1;
				//일단 현재 위치 변경
				sw[sw_num] = sw[sw_num] == 1 ? 0 : 1;
				while(true) {
					if( sw_num-cur < 1 || sw_num + cur > size || sw[sw_num-cur] != sw[sw_num+cur])
						break;
					sw[sw_num-cur] = sw[sw_num-cur] == 1 ? 0 : 1;
					sw[sw_num+cur] = sw[sw_num+cur] == 1 ? 0 : 1;
					cur++;
				}
			}
		}
		for(int i = 1; i <= size; i++) {
			System.out.print(sw[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
		
	}
}