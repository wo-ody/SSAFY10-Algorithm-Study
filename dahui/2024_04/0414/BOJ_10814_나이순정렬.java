import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	public static void main(String[] args) throws Exception{
		ArrayList<Node> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			list.add(new Node(num, str));
		}

		list.sort((o1, o2) -> o1.age - o2.age);

		for(Node node : list) {
			sb.append(node.age).append(" ").append(node.name).append("\n");
		}
		System.out.println(sb);
	}
	public static class Node {
		int age;
		String name;
		public Node(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
