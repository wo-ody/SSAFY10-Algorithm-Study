import java.io.BufferedReader;
import java.io.InputStreamReader;

//전체 빈 칸인 경우, 왼쪽 사자, 오른쪽 사자인 경우를 나눔
//전체 빈칸인 경우엔 그 다음 나올 수 있는 경우가 전체 빈 칸인 경우, 왼쪽 사자, 오른쪽 사자 3개
//한 칸에 사자가 있는 경우엔 그 다음에 나올 수 있는 경우가 사자의 반대 방향 2개
//이걸 이용해서 사자가 아예 없는 경우와 한 마리만 있는 경우를 나눠서
//dp로 답을 구함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] zero, one;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		//0은 더미
		zero = new int[N + 1];
		one = new int[N + 1];

		//N이 1일 때 사자가 없는 경우는 1 사자가 1마리 있는 경우는 2
		zero[1] = 1;
		one[1] = 2;
		for (int i = 2; i <= N; i++) {
			zero[i] = zero[i - 1] + one[i - 1] % 9901;
			one[i] = zero[i - 1] * 2 + one[i - 1] % 9901;
		}

		System.out.println((zero[N] + one[N]) % 9901);
	}
}