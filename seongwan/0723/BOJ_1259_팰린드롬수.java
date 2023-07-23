import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String num = sc.next();
			if (num.charAt(0) == '0') {// 0이 입력되면 종료
				break;
			}
			String rev = "";
			for (int i = num.length() - 1; i >= 0; i--) {
				rev = rev + num.charAt(i); // 맨 뒤의 요소부터 앞으로 할당

			}
			if (num.equals(rev)) { // 뒤집은 문자열과 원래의 문자열 값 비교
				System.out.println("yes");
			} else
				System.out.println("no");

		}

	}

}
