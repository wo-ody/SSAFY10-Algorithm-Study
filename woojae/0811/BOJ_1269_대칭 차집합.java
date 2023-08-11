import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer> a = new HashSet<Integer>();
		HashSet<Integer> b = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			a.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)
			b.add(Integer.parseInt(st.nextToken()));

		HashSet<Integer> temp1 = (HashSet<Integer>)a.clone();  // 집합연산을 사용하면 그대로 deepcopy됨
		HashSet<Integer> temp2 = (HashSet<Integer>)b.clone();  // 그래서 원본 집합을 유지하기 위해 원본 카피 
		a.removeAll(b);  // a - b
		temp2.removeAll(temp1);  // b - a
		System.out.println(a.size() + temp2.size());  // (a - b) + (b - a)
	}
}
