import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//left와 right 끝의 좌표를 저장 후
//left보다 왼쪽 위치에 사과가 떨어진다면 둘 다 차이만큼 - 이동
//right보다 오른쪽 위치에 사과가 떨어진다면 둘 다 차이만큼 + 이동
//중간에 있다면 움직이지 않음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		st.nextToken();
		int ans = 0;

		int left = 1;
		int right = Integer.parseInt(st.nextToken());

		int J = Integer.parseInt(br.readLine());

		for (int i = 0; i < J; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp < left) {
				int dis = left - temp;
				ans += dis;
				left -= dis;
				right -= dis;
			}

			if (temp > right) {
				int dis = temp - right;
				ans += dis;
				left += dis;
				right += dis;
			}
		}
		System.out.println(ans);
	}
}