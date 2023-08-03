package algorithm2023.aug.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L,C;
	static char src[], target[];
	//모음의 개수를 세기 위해 모음을 배열로 생성
	static char[] gather = {'i','e','a','o','u'};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//목표로 하는 암호문의 길이는 L
		target = new char[L];
		
		//입력을 바로 문자 배열로 변환
		src = br.readLine().replace(" ", "").toCharArray();
		
		//사전순 출력을 위해 정렬
		Arrays.sort(src);
		
		//맞는 문자열 조합을 모두 찾음
		comb(0,0);
		
		//찾은 문자열 출력
		System.out.println(sb);
		
	}
	
	static void comb(int sIdx, int tIdx) {
		//필요한 길이까지 채웠다면
		if(tIdx==L) {
			//자음 모음의 개수를 세어 유효성 검사
			if(isValid()) {
				//StringBuilder에 append
				sb.append(target).append("\n");
			}
			return;
		}
		//src의 범위 밖을 탐색하지 않게 조건 설정
		if(sIdx==C)return;
		
		//다음 tIdx와 현재 tIdx를 모두 탐색
		target[tIdx] = src[sIdx];
		comb(sIdx+1,tIdx+1);
		comb(sIdx+1,tIdx);
	}
	
	static boolean isValid() {
		//모음의 개수를 세는 변수
		int cntG = 0;
		for(int i= 0;i<L;i++) {
			for(int j = 0;j<5;j++) {
				//모음이라면 카운트
				if(target[i]==gather[j])cntG++;
			}
		}
		//모음의 개수가 1개 이상이고 전체-모음 -> 자음의 개수가 2개 이상이면 true
		if(cntG>0&&L-cntG>1)return true;
		return false;
	}
}
