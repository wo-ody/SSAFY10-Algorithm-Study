import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		while (!str.equals("0")) {  // 입력이 0이 아니면
			int len = str.length();
			boolean flag = true;  // 팰린드롬 여부
			
			for (int i = 0; i < len / 2; i++) {
				if (str.charAt(i) != str.charAt(len - i - 1)) {  // 대칭되는 인덱스의 문자열들이 서로 다르다면
					System.out.println("no");
					flag = false;  // 팰린드롬 불가
					break;  // 반복 종료
				}
			}
			if (flag)  // 반복이 종료되었다면 팰린드롬 가능, 단 break로 종료될 수 있기 때문에 flag로 판단
				System.out.println("yes");
			str = sc.next();  // 다음 문자 입력
		}
	}
}
