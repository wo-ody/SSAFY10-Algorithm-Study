import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//물이 새는 곳 위치를 정렬한 후에 처음 만나는 곳에서 개수 체크하고 테이프 길이까지는 그냥 넘어가고
//테이프 길이가 끝난 후에도 계속 반복하면서 개수를 체크하면 될 거 같음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, L, cnt, prev;
	static int[] pipe;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		pipe = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pipe);

		for (int i = 0; i < N; i++) {
			if (pipe[i] > prev) {
				cnt++;
				prev = pipe[i] + L - 1;
			}
		}

		System.out.println(cnt);
	}
}