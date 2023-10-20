import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());//테스트 케이스 수
		for(int i = 0;i<num;i++) {
			LinkedList<Integer> PQ = new LinkedList<>();
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);//문서의 개수
			int M = Integer.parseInt(s[1]);//몇번째로 인쇄되었는지 궁금한 문서
			s = br.readLine().split(" ");
			for(int j = 0;j<N;j++) {//중요도 입력
				PQ.add(Integer.parseInt(s[j]));
			}
			int seq = 1;
			while(!PQ.isEmpty()) {//큐가 빌때까지
				int n = PQ.poll();
				boolean mostP = true;
				for(int k = 0;k<PQ.size();k++) {//중요도가 더 큰 원소가 있으면 mostP아님
					if(PQ.get(k)>n) {
						mostP = false;
					}
				}
				if(mostP == true) {//중요도가 가장 클 경우 poll
					if(M==0) {
						System.out.println(seq);
						break;
					}
					seq++;
				}else {//아닐경우 맨 뒤로
					PQ.offer(n);
					if(M==0) {
						M+=PQ.size();
					}
				}
				M--;
			}
			
		}
	}
}
