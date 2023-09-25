import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int[] a, b;
	static int cnt = 0;
	static List<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(b);
		for (int i : a) {
			if(bs(i) == 0)  // a의 원소가 b에 존재하지 않는다면 -> 즉 집합 b는 a의 원소를 가질 수는 있으나 모두 가져서는 안 됨
				answer.add(i);
		}
		System.out.println(answer.size());
		Collections.sort(answer);  // 증가하는 순서로 출력이라는 조건이 존재
		for (int i : answer)  // 집합 b가 a의 원소를 모두 가질 경우 추가할 값이 없음
			sb.append(i).append(" ");
		System.out.println(sb);
	}

	static int bs(int target) {
		int low = 0;
		int high = m - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if(b[mid] == target) {
				return 1;
			}
			else if(target < b[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}
}