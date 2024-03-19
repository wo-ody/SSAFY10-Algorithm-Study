import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이분탐색을 통해 해당 스네이크버드의 높이보다 낮은 과일들의 개수를 알아내고
//그 개수만큼 먹기 처리를 해서 높이를 증가시킨 후
//다시 낮은 과일들 이후의 과일들부터 스네이크버드의 높이보다 낮은 과일의 개수를 알아내는 식으로 반복
//스네이크버드의 높이보다 낮은 과일이 더 이상 없다면 종료
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] fruits;
	static int cnt, N, L;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		fruits = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruits);

		while (true) {
			//해낭 스네이크버드의 높이보다 작거나 같은 과일들의 개수
			int temp = BS();
			//앞에 구했었던 수와 같다면
			if (temp == cnt) {
				break;
			}//다르다면 그 차이만큼 높이를 늘려준다
			else {
				L += (temp - cnt);
				cnt = temp;
			}
		}

		System.out.println(L);
	}

	static int BS() {
		int left = cnt;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (L < fruits[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}