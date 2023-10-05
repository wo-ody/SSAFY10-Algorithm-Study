import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Time {
	int start, end;

	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Time[] arr = new Time[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i] = new Time(start, end);
		}

		Arrays.sort(arr, new Comparator<Time>() {
			public int compare(Time t1, Time t2) {

				if (t1.end == t2.end) {
					return t1.start - t2.start;
				}
				return t1.end - t2.end;
			}
		});

		int count = 0;
		int pre = 0;

		for (int i = 0; i < N; i++) {
			if (pre <= arr[i].start) {
				pre = arr[i].end;
				count++;
			}
		}

		System.out.println(count);
	}
}
