package algorithm2024.mar.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195_친구네트워크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> parent;
	static HashMap<String, Integer> network;

	static int union(String f1, String f2) {
		String pf1 = find(f1);
		String pf2 = find(f2);
		if(!pf1.equals(pf2)){
			parent.put(pf2,pf1);
			network.put(pf1, network.get(pf2)+network.get(pf1));
		}
		return network.get(pf1);
	}

	static String find(String f) {
		if(parent.get(f).equals(f))return f;
		String p = find(parent.get(f));
		parent.put(f,p);
		return p;
	}
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int F = Integer.parseInt(br.readLine());
			parent = new HashMap<>();
			network = new HashMap<>();

			for (int j = 0; j < F; j++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				parent.put(f1,parent.getOrDefault(f1,f1));
				network.put(f1,network.getOrDefault(f1,1));
				parent.put(f2,parent.getOrDefault(f2,f2));
				network.put(f2,network.getOrDefault(f2,1));
				sb.append(union(f1,f2)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
