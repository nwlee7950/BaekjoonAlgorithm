import java.io.*;
import java.util.*;

public class Main {
   
   //Number라는 class를 만들어 숫자 그대로인 num과 그것을 문자열로 바꾼 num_to_str을 입력받는다.
   //그리고 이 List를 정렬하기 위해 Comparable을 implements 한다.
   public static class Number implements Comparable<Number>{
      int num; //숫자 그대로
      String num_to_str; // 문자열로 바꾼 것
      
      Number(int num, String num_to_str){
         this.num = num;
         this.num_to_str = num_to_str;
      }
      
      @Override
      public int compareTo(Number o) {
         // 사전 순으로 배치되게끔 비교함
         return (this.num_to_str.compareTo(o.num_to_str));
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      String[] str = br.readLine().split(" ");
      int M = Integer.parseInt(str[0]);
      int N = Integer.parseInt(str[1]);
      List<Number> li = new ArrayList<Number>(); //Number을 자료형으로 갖는 List
      
      // M부터 N까지
      for(int i = M; i <= N; i++) {
         String temp_str =""; // Number에 전달할 문자열을 위한 임시 문자열
         if(i < 10) { //i가 10보다 작으면 한번만 if문이 되게
            if(i == 1) {
               temp_str += "one";
            } else if(i == 2) {
               temp_str += "two";
            } else if(i == 3) {
               temp_str += "three";
            } else if(i == 4) {
               temp_str += "four";
            } else if(i == 5) {
               temp_str += "five";
            } else if(i == 6) {
               temp_str += "six";
            } else if(i == 7) {
               temp_str += "seven";
            } else if(i == 8) {
               temp_str += "eight";
            } else if(i == 9) {
               temp_str += "nine";
            }
         } else { //i가 10보다 같거나 크면
            if(i / 10 == 1) { //십의 자리수
               temp_str += "one";
            } else if(i / 10 == 2) {
               temp_str += "two";
            } else if(i / 10 == 3) {
               temp_str += "three";
            } else if(i / 10 == 4) {
               temp_str += "four";
            } else if(i / 10 == 5) {
               temp_str += "five";
            } else if(i / 10 == 6) {
               temp_str += "six";
            } else if(i / 10 == 7) {
               temp_str += "seven";
            } else if(i / 10 == 8) {
               temp_str += "eight";
            } else if(i / 10 == 9) {
               temp_str += "nine";
            }
            
            if(i % 10 == 0) { // 일의 자리수
               temp_str += " zero";
            } else if(i % 10 == 1) {
               temp_str += " one";
            } else if(i % 10 == 2) {
               temp_str += " two";
            } else if(i % 10 == 3) {
               temp_str += " three";
            } else if(i % 10 == 4) {
               temp_str += " four";
            } else if(i % 10 == 5) {
               temp_str += " five";
            } else if(i % 10 == 6) {
               temp_str += " six";
            } else if(i % 10 == 7) {
               temp_str += " seven";
            } else if(i % 10 == 8) {
               temp_str += " eight";
            } else if(i % 10 == 9) {
               temp_str += " nine";
            }
         }
         li.add(new Number(i, temp_str)); //리스트에 숫자 그대로와 문자열로 바꾼 것을 넣는다.
      }
      
      Collections.sort(li); //정렬한다.
      
      for(int i = 0; i < li.size(); i++) {
         if(i != 0) { //0이 아니라면
            if(i % 10 == 0) //10으로 나눈 나머지가 0일때 줄바꿈
               sb.append("\n");
         }
         sb.append(li.get(i).num).append(" "); // 리스트 i번째의 num을 sb에 담는다.
      }
      System.out.println(sb);
   }
}