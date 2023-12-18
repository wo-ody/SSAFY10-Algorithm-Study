import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, m, n, sum, ans;
	static int[] A, B, countA = new int[2000001], countB = new int[2000001];// A,B피자 크기의 정보와 각 누적합의 정보를 담은 배열
//N이 최대 2000000이므로 배열의크기는 2000001로 설정

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		A = new int[m * 2];
		B = new int[n * 2];
		for (int i = 0; i < m; i++) {
			A[i] = A[i + m] = Integer.parseInt(br.readLine());// 순환배열
			sum += A[i];
		}

		countA[0] = countA[sum] = 1;// 누적합이 0일 때와 전체 합일 때는 1로 처리

		sum = 0;// B피자 정보를 구하기 전에 sum초기화

		for (int i = 0; i < n; i++) {
			B[i] = B[i + n] = Integer.parseInt(br.readLine());// 순환배열
			sum += B[i];
		}

		countB[0] = countB[sum] = 1;// 누적합이 0일 때와 전체 합일 때는 1로 처리

		sum();

		for (int i = 0; i <= N; i++) {
			ans += countA[i] * countB[N - i];// 크기의 합이 N이 되는 각 피자의 누적합 별 개수를 곱해서 경우의 수를 체크
		}

		System.out.println(ans);

	}

	static void sum() {
		for (int i = 0; i < m; i++) {
			sum = 0;// 시작 지점별 누적합을 구함(전체 합은 제외)
			for (int j = i; j < i + m - 1; j++) {
				sum += A[j];
				countA[sum]++;// 각 누적합 별로 개수를 체크
			}
		}

		for (int i = 0; i < n; i++) {
			sum = 0;// 시작 지점별 누적합을 구함(전체 합은 제외)
			for (int j = i; j < i + n - 1; j++) {
				sum += B[j];
				countB[sum]++;// 각 누적합 별로 개수를 체크
			}
		}
	}
}