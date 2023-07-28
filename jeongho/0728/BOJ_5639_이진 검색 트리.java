package algorithm2023.jul.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G5_BOJ5639 {

	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = Integer.parseInt(s);
		list.add(n);
		int cnt = 1;
		while(cnt<8) {
			s= br.readLine();
			list.add(Integer.parseInt(s));
			cnt++;
		}
		post(0,list.size()-1);
		
	}
	static void post(int i, int end) {
		if(i>end) {
			return;
		}
		int mid = i+1;
		while(mid<=end&&list.get(mid)<list.get(i)) {
			mid++;
		}
		post(i+1, mid-1);
		post(mid, end);
		System.out.println(list.get(i));
	}
	
}