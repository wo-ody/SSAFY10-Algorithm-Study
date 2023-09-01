import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T, answer, minBorder, maxBorder, min, max;
	static Person[] people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		people = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, L);
			max = Math.max(max, R);
			minBorder += L;
			maxBorder += R;
			people[i] = new Person(L, R);

		}
		
		if(T < minBorder || T > maxBorder) answer = -1;
		else {
			answer = binarySearch();
		}

		System.out.println(answer);

	}

	static int binarySearch() {
		int start = min;
		int end = max;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			int sum = 0;
			boolean check = false;
			for(int i=0; i<N; i++) {
				if(people[i].L > mid) {
					check = true;
					break;
				};
				sum += Math.min(mid, people[i].R);
			}
			
			if(check) {
				start = mid + 1;
				continue;
			}
			

			if(sum >= T) end = mid -1;
			else start = mid + 1;
		}
		
		return start;
	}
	
	static class Person {
		int L, R;

		Person(int L, int R) {
			this.L = L;
			this.R = R;
		}
	}
}
