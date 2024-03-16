import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//자리별 글자 개수를 체크한 뒤 제일 많이 있는 문자를 해당 자리로 지정한다
//수가 같다면 사전순으로 앞 서는 것부터
//Hamming Distance 는 자리별 다른 문자 개수의 합
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] count;// A,C,G,T의 개수
	static char[] ch = {'A', 'C', 'G', 'T'};
	static int ans;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] input = new String[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}

		for (int i = 0; i < M; i++) {
			count = new int[4];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					if (input[j].charAt(i) == ch[k]) {
						count[k]++;
					}
				}
			}

			int idx = 0;
			for (int j = 1; j < 4; j++) {
				//현재보다 더 많은 값이 있는 문자가 있다면
				if (count[j] > count[idx]) {
					ans += count[idx];
					idx = j;
				} else {
					ans += count[j];
				}
			}
			sb.append(ch[idx]);
		}
		System.out.println(sb);
		System.out.println(ans);
	}
}