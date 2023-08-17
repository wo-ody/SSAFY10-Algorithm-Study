import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] N;
	static int[] chk = new int[9];// 개수 체크용 배열(9는 6으로 바꿔서 체크)
	static int set;

	public static void main(String[] args) throws Exception {
		N = br.readLine().toCharArray();
		for (int i = 0; i < N.length; i++) {
			if (N[i] == '9')
				N[i] = '6';

			if (chk[N[i] - '0'] == 0) {
				set++;
				for (int j = 0; j < 9; j++) {
					chk[j] += 1;
					if (j == 6)
						chk[j] += 1;
				}
				chk[N[i] - '0']--; // 세트에 없는 번호가 나왔을 때 새 세트를 더 들여와 chk배열에 개수 추가(6,9는 같이 합쳐서 2)
			} else
				chk[N[i] - '0']--;//있는 번호가 나왔을 때 chk배열안의 수로 플라스틱 숫자 남은 개수 판단
		}
		System.out.println(set);
	}

}
