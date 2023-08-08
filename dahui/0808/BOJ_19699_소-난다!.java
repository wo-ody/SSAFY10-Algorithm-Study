import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class TestReport {
	//농장 소 수 N, 선별할 소 수 M
	//소들의 무게 H 
	//순서 상관 xx -> 조합
	static int N,M,sum;
	static int[] H;
	static HashSet<Integer> set = new HashSet<>(); //소의 몸무게 합 저장
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		H = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		cow(0,0,0);
		
		if(set.isEmpty()) {
			sb.append(-1);
		}else {
		
			List<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list);
			for(Integer i : list) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
	//조합
	static void cow(int NIdx, int MIdx, int sum) {
		
		if(MIdx == M) {
			if(is_prime(sum)) {
				set.add(sum);
				return;
			}
			return;
		}
		
		if(NIdx == N) return;
		
		cow(NIdx + 1, MIdx + 1, sum+H[NIdx]);

		cow(NIdx + 1, MIdx, sum);

		
	}
	//소수 확인 메소드
	static boolean is_prime(int num) {
		if(num < 2) {
			return false;
		}
		
		if(num == 2) {
			return true;
		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if( num % i == 0 ) return false;
		}
		
		return true;
	}
}
