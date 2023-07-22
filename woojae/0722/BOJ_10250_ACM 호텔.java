import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
          int h = sc.nextInt();
          int w = sc.nextInt();
          int n = sc.nextInt();
          int floor = (n % h == 0) ? h : (n % h);  // 순서를 층으로 나눴을 때 나머지가 0이라면 층수는 h, 아니라면 나머지가 됨
          int room = (n % h == 0) ? (n / h) : (n / h + 1);  // 마찬가지로 순서를 층으로 나눴을 때 나머지가 0이라면 호실은 몫, 아니라면 몫 + 1이 됨
          String floor_num = String.valueOf(floor);  // 층수와 호실 번호를 붙이기 위해 문자열로 변환
          String room_num = String.valueOf(room);
          String answer = "";
          
          answer = (room_num.length() == 1) ? floor_num + "0" + room_num : floor_num + room_num;  // 호실이 한 자릿수라면 앞에 0을 붙임
          System.out.println(Integer.parseInt(answer));  // 정수로 변환. 정수로 변환하지 않고 문자열로 출력해서 계속해서 틀렸음
        }
    }
}
