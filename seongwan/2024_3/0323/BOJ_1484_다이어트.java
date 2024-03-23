import java.io.BufferedReader;
import java.io.InputStreamReader;

//G+1의 절반의 수까지 투포인터를 통해 제곱의 차이가 G가 될 때를 찾는다.
//G+1의 절반이 넘어가는 수는 1이 늘어날 때 차이가 G가 넘어가므로 의미가 없음
//투 포인터를 통해 두 제곱의 차이가 G가 넘어간다면 왼쪽을 +1 작다면 오른쪽을 +1
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int G = Integer.parseInt(br.readLine());
		int max = (G + 1) / 2;

		int left = 1;
		int right = 2;

		while (right <= max) {
			long diff = (long)Math.pow(right, 2) - (long)Math.pow(left, 2);

			if (diff == G) {
				sb.append(right).append("\n");
				left++;
				right++;
			}

			if (diff > G)
				left++;

			if (diff < G)
				right++;
		}

		System.out.println(sb.length() == 0 ? -1 : sb);
	}

	static int pow(int num) {
		return num * num;
	}
}