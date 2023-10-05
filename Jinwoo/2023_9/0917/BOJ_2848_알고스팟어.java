import java.io.*;
import java.util.*;
public class Main {

	public static void BOJ_2848_알고스팟어(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> g = new ArrayList<>();
		for (int i=0; i<26; i++) g.add(new ArrayList<Integer>());
		boolean[] check = new boolean[26];
		int[] indegree = new int[26];
		int n = Integer.parseInt(br.readLine());
		
		int idx; char[] before, now;
		before = br.readLine().toCharArray();
		for (int c : before) check[c-'a']=true;
		
		StringBuilder sb = new StringBuilder();
		boolean flag= false;
		for (int i=1; i<n; i++) {
			now = br.readLine().toCharArray();
			if (flag) continue;
			for (int c : now) check[c-'a']=true;
			
			idx=0;
			try {
				while (before[idx]==now[idx]) idx++;
				
				g.get(before[idx]-'a').add(now[idx]-'a');
				indegree[now[idx]-'a']++;
				before = now;
			}catch (Exception e) {
				if(now.length==idx && before.length > idx)flag=true;
				before = now; 
			}
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		int cnt=0;
		for (int i=0; i<26; i++) {
			if (!check[i]) continue;
			cnt++;
			if (indegree[i]==0) q.add(i);
		}
		int now2;
		boolean flag2 = false;
		for (int a=0; a<cnt; a++) {
			if (flag || q.isEmpty()) {flag=true; break;}
			if (q.size()>1) {flag2=true;}
			now2 = q.poll();
			if (!flag2) sb.append((char) (now2 +'a'));
			for (int i : g.get(now2)) {
				if (--indegree[i]==0) q.add(i);
			}
		}
		if (flag) System.out.println("!");
		else if (flag2) System.out.println("?");
		else System.out.println(sb);
	}
}
