import java.util.Scanner; //Scanner를 쓸 수 있게 import함

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); //입력을 위해 Scanner 객체를 만듦
      StringBuilder sb = new StringBuilder(); //출력속도 향상을 위해 StringBuilder 객체를 만듦
      String[] str = sc.nextLine().split(" "); // 입력을 공백을 기준으로 구분하고, 공백단위로 구분한 String을 str이란 이름의 String배열에 각각 집어넣는다.
      
      for(int i=0; i<str.length; i++) { //str의 길이만큼 for문을 반복한다.
         if(str[i].contains("apa")) //만약 str[i]가 apa이란 문자열을 포함하고 있으면
            str[i] = str[i].replace("apa", "a"); //str[i]에 포함된 apa란 문자열을 a로 바꾸고 str[i]에 대입한다.

         if(str[i].contains("epe")) //만약 str[i]가 epe이란 문자열을 포함하고 있으면
            str[i] = str[i].replace("epe", "e"); //str[i]에 포함된 epe란 문자열을 e로 바꾸고 str[i]에 대입한다.
         
         if(str[i].contains("ipi")) //만약 str[i]가 ipi이란 문자열을 포함하고 있으면
            str[i] = str[i].replace("ipi", "i"); //str[i]에 포함된 ipi란 문자열을 i로 바꾸고 str[i]에 대입한다.

         if(str[i].contains("opo")) //만약 str[i]가 opo이란 문자열을 포함하고 있으면
            str[i] = str[i].replace("opo", "o"); //str[i]에 포함된 opo란 문자열을 o로 바꾸고 str[i]에 대입한다.

         if(str[i].contains("upu")) //만약 str[i]가 upu이란 문자열을 포함하고 있으면
            str[i] = str[i].replace("upu", "u"); //str[i]에 포함된 upu란 문자열을 u로 바꾸고 str[i]에 대입한다.
      }
      
      for(int j=0; j<str.length; j++) //str의 길이만큼 for문을 반복한다.
         sb.append(str[j]).append(" "); //str[j]와 공백을 sb에 저장한다.
      
      System.out.println(sb); //저장된 sb를 출력한다.
   }
}