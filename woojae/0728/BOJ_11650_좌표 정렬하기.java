import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[][] cord = new Integer[n][2];
		for(int i = 0; i < n; i++) {
			cord[i][0] = sc.nextInt();
			cord[i][1] = sc.nextInt();
		}
		Arrays.sort(cord, (o1, o2) -> (o1[0].equals(o2[0])) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
    // 반드시 명심할 것. 타입이 어떻든 모든 객체는 equals로 비교해야함
		for (Integer[] c : cord) {
			System.out.println(c[0] + " " + c[1]);
		}
	}
}
