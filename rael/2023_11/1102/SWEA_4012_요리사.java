import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 (단, 그룹이 나뉘므로 mask 사용)
public class Solution {
	static int T, N, halfN, min;
	static int matrix[][];
	static int A[], B[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			
			//그룹 배열 초기화
			A = new int[N];
			B = new int[N];
			
			//배열 초기화
			matrix = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//풀이
			min = Integer.MAX_VALUE;
			comb(0,0,0);		//srcIdx, tgtIdx, mask
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx, int mask) {
		//기저조건1
		if(tgtIdx == halfN) {
			//complete code
			check(mask);
			return;
		}
		//기저조건2
		if(srcIdx == N) return;
		
		//풀이
		comb(srcIdx+1, tgtIdx+1, (mask|1<<srcIdx));
		comb(srcIdx+1, tgtIdx, mask);
	}
	
	static void check(int mask) {
		//각 그룹의 합
		int sumA = 0; int sumB = 0;
		//재료 선택을 위한 idx
		int idxA = 0; int idxB = 0;
		
		//선택된 재료, 비선택 재료 구분하기
		for(int i=0; i<N; i++) {
			//선택
			if((mask&1<<i)!=0) A[idxA++] = i;
			else B[idxB++] = i;
		}
		
		//합 구하기
		for(int i=0; i<halfN; i++) {
			for(int j=0; j<halfN; j++) {
				sumA += matrix[A[i]][A[j]];
				sumB += matrix[B[i]][B[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
	}
}
