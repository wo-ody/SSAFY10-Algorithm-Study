import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int L;
	static int[] input;
	static long sum;

	public static void main(String[] args) throws Exception {
		L = Integer.parseInt(br.readLine());
		input = new int[L];
		char[] ch = br.readLine().toCharArray();
		hashing(ch);
		System.out.println(sum);
	}

	static void hashing(char[] ch) {
		for (int i = 0; i < L; i++) {
			input[i] = ch[i] - 96;//문자열로 받아서 char 배열에 넣은 뒤 96을 빼서 a부터 1로 맞춰줌

		}
		for (int i = 0; i < L; i++) {
			long num = input[i];
			for (int j = 0; j < i; j++) {
				num *= 31;
				if (num >= 1234567891)
					num %= 1234567891;//수가 커지면 범위 밖으로 나가므로 나누기 연산이 가능할 때마다 계속 해줌
			}
			sum += num;
			if (sum >= 1234567891)
				sum %= 1234567891; //수가 커지면 범위 밖으로 나가므로 나누기 연산이 가능할 때마다 계속 해줌

		}
	}

}
