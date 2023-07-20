package bronze;

import java.util.Scanner;

public class BOJ_10820_문자열_분석 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			while (true) {
				String str = sc.nextLine();
				int cnt_lower = 0;
				int cnt_upper = 0;
				int cnt_num = 0;
				int cnt_space = 0;
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c == ' ') {
						cnt_space++;
					}
					if (Character.isDigit(c))
						cnt_num++;
					if (Character.isUpperCase(c))
						cnt_upper++;
					if (Character.isLowerCase(c))
						cnt_lower++;
				}
				System.out.println(cnt_lower + " " + cnt_upper + " " + cnt_num + " " + cnt_space);
			}
		} catch (Exception e) {

		}

	}

}
