import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] info = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			info[i][0] = sc.next();  // age
			info[i][1] = sc.next();  // name
		}
		
		Arrays.sort(info, (o1, o2) -> Integer.valueOf(o1[0]) - Integer.valueOf(o2[0]));  // 문자열 배열이므로 age를 정수로 변환해서 오름차순 정렬
		
		for (String[] data : info) {
			System.out.println(data[0] + " " + data[1]);
		}
	}
}
