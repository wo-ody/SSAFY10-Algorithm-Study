import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0803 BOJ_2961_도영이가 만든 맛있는 음식
public class Main {
	static int N;
	static int s[], b[];
	static int min_diff=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//음식의 개수
		N = Integer.parseInt(br.readLine());
		
		//신맛 쓴맛 저장
		s = new int[N];
		b = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		
		System.out.println(min_diff);
	}
	
	static void subset(int srcIdx, int mask) {
		//기저조건
		if(srcIdx == s.length) {
			get(srcIdx, mask);
			return;
		}
		
		//선택
		subset(srcIdx+1, mask | 1 << srcIdx);
		//비선택
		subset(srcIdx+1, mask);
	}
	static void get(int idx, int mask) {
		int cnt=0;
		int sm=1, bm=0;
		for (int i = 0; i < s.length; i++) {
			if((mask & 1 << i) != 0) {
				sm *= s[i];
				bm += b[i];
				cnt++;
			}
		}
		
		//최솟값 구하기
		if(cnt > 0) {
			min_diff = Math.min(Math.abs(sm-bm), min_diff);
		}
	}
}
