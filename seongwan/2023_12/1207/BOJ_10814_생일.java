import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class per {
	int age;
	String name;

	public per(int age, String name) {
		this.age = age;
		this.name = name;
	}
}// 나이와 이름을 가지고 있는 Person 클래스 생성

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static per[] people;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		people = new per[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();

			int dd = Integer.parseInt(st.nextToken());
			int mm = Integer.parseInt(st.nextToken());
			int yyyy = Integer.parseInt(st.nextToken());

			int age = yyyy * 10000 + mm * 100 + dd;

			people[i] = new per(age, name);

		}

		sort();
		System.out.println(people[N - 1].name);
		System.out.println(people[0].name);

	}

	static void sort() {
		Arrays.sort(people, new Comparator<per>() {

			@Override
			public int compare(per p1, per p2) {

				return Integer.compare(p1.age, p2.age);
			}

		});
	}// Arrays.sort와 comparator로 나이 순으로 정렬

}
