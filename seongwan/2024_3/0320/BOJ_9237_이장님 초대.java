import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//걸리는 시간이 긴 묘목부터 키우면서
//맨 마지막에 심은 묘목이 다 자란 다음 날 이장님을 초대한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int time = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] tree = new Integer[N];

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tree, (i1, i2) -> i2 - i1);

		for (int i = 0; i < N; i++) {
			int temp = i + tree[i];
			if (temp > time)
				time = temp;
		}

		//처음 키우는 날, 다 키우고 다음 날에 이장님을 불러야 하므로 +2
		System.out.println(time + 2);
	}
}