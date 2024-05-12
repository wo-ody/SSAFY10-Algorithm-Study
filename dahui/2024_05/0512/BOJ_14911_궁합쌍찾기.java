import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14911_궁합쌍찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int num = Integer.parseInt(br.readLine());
		ArrayList<Node> nodes = new ArrayList<>();
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j <list.size() ; j++) {
				int a = list.get(i);
				int b = list.get(j);
				if (a+b == num) {
					String str = "";
					if (a <= b) {
						str += a;
						str += b;
						if (!set.contains(str)){
							nodes.add(new Node(a, b));
							set.add(str);
						}
					} else{
						str += b;
						str += a;
						if (!set.contains(str)){
							nodes.add(new Node(b, a));
							set.add(str);
						}
					}
				}
			}
		}

		Collections.sort(nodes , (o1, o2) -> {
			if (o1.a == o2.a) {
				return o1.b - o2.b;
			}else return o1.a - o2.a;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			sb.append(node.a).append(" ").append(node.b).append("\n");
		}
		sb.append(nodes.size());
		System.out.println(sb);
	}

	public static class Node {
		int a,b;
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
