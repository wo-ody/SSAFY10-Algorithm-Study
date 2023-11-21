import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'X')
				temp++;// 이어진 X의 개수를 카운트
			else {
				if (!check("."))// .을 만났을 때 그 전 까지의 X덩어리의 값으로 계산
					return;
			}
		}
		if (!check(null))
			return;// .이 나오지 않아 계산되지 않은 값들 계산
		System.out.println(sb);
	}

	static boolean check(String s) {
		if (temp % 2 != 0) {// 짝수가 아니면
			System.out.println(-1);
			return false;
		} else {
			for (int j = 0; j < temp / 4; j++) {
				sb.append("AAAA");
			}
			if (temp % 4 == 2)
				sb.append("BB");
			if (s != null)
				sb.append(s);
			temp = 0;
		}
		return true;
	}
}
