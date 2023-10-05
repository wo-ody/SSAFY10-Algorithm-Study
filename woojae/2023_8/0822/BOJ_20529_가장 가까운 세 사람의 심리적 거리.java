import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static String[] mbti;
	static int[] res = new int[3];  // 조합을 저장할 배열, 무조건 3명을 뽑음
	static int n;
	static List<int []> arr;  // 생성되는 조합들을 저장할 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			int answer = Integer.MAX_VALUE;
			mbti = new String[n];
			arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++)
				mbti[i] = st.nextToken();
			
			if(n > 32)  // mbti가 33개 이상들어오면 최소 3개의 중복된 mbti가 발생하고 이 경우 세 사람의 거리는 무조건 0이 된다. -> 16 * 2 -> 같은 mbti가 2개씩 존재 -> 33 -> 특정 mbti는 3개가 존재하게 됨 
				answer = 0;
			else  // 그 외 3명의 조합을 찾아서
				comb(0, 0);
				for (int[] i : arr) {  // 찾아낸 조합에서
					int distance = cal(i[0], i[1]) + cal(i[0], i[2]) + cal(i[1], i[2]);  // 각각의 거리를 계산 후 합산
					answer = distance < answer ? distance : answer;
				}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int idx, int target) {
		if(target == 3) {
			arr.add(res.clone());  
			// 작성한 코드에서 한 가지 배열을 가지고 값을 변경하므로 특정 순간의 특정 조합을 저장하더라도 마지막에 배열의 값이 변경되어 버리면 저장된 조합들도 최종 값들로 변경됨
			return;
		}
		if(idx == n) {
			return;
		}
		res[target] = idx;
		comb(idx + 1, target + 1);
		comb(idx + 1, target);
	}
	
	static int cal(int student1, int student2) {
		int distance = 0;
		for(int i = 0; i < 4; i++)
			if(mbti[student1].charAt(i) != mbti[student2].charAt(i))  // 학생들의 mbti를 뜯어서 서로 다른 요소가 있다면
				distance++;
		return distance;
	}
}
