import java.io.BufferedReader;
import java.io.InputStreamReader;

//B의 첫글자를 기준으로 탐색하면서 첫글자가 A에서 발견되면
//그 인덱스부터 B가 맞는지 하나 하나 탐색
//맞으면 ans를 올리고 다시 탐색하고 틀리면 그냥 B의 첫글자 탐색
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] A, B;
	static int ans;

	public static void main(String[] args) throws Exception {
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();

		for (int i = 0; i < A.length; i++) {
			if (A.length - i < B.length) {
				break;
			}
			if (A[i] == B[0]) {
				boolean chk = true;
				for (int j = 1; j < B.length; j++) {
					if (A[i + j] != B[j]) {
						chk = false;
						break;
					}
				}
				if (chk) {
					i += B.length - 1;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}