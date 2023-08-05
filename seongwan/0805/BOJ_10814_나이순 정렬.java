import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person {
	int age;
	String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}// 나이와 이름을가지고 있는 Person 클래스 생성

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Person[] people;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		people = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[i] = new Person(age, name);

		} // 나이와 이름 입력 N만큼 입력 받기

		sort();
		for (int i = 0; i < N; i++) {
			sb.append(people[i].age).append(" ");
			sb.append(people[i].name).append("\n");

		}
		System.out.println(sb);
	}

	static void sort() {
		Arrays.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {

				return Integer.compare(p1.age, p2.age);
			}

		});
	}

}
