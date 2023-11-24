import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member> members = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(members);
		for (int i = 0; i < N; i++) {
			Member member = members.get(i);
			System.out.println(member.age + " " + member.name);
		}
	}
}

class Member implements Comparable<Member>{
	int age;
	String name;
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Member o) {
		return this.age - ((Member)o).age;
	}
}
