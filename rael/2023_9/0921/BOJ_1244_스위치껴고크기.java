
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;		//스위치 개수
	static int[] status;	//스위치 상태
	static int M; 		//학생 수
	
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 status = new int[N];

		 StringTokenizer st = new StringTokenizer(br.readLine());
		 for(int i=0; i<N; i++) {
			 status[i] = Integer.parseInt(st.nextToken());
		 }
		 M = Integer.parseInt(br.readLine());
		 
		 //학생 입력 받으면서 스위치 상태 바꾸기
		 for(int i=0; i<M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int gender = Integer.parseInt(st.nextToken());
			 int no = Integer.parseInt(st.nextToken());
			 
			//남자
			if(gender == 1) {
				for(int j=0; j<N; j++) //뽑은 수의 배수 위치에 있는 스위치의 상태를 바꾼다.
					if((j+1) % no == 0)
						status[j] = status[j] == 0? 1: 0;
			}
			 //여자
			 else {
				 //뽑은 수를 중심으로 좌우가 대칭이면 상태를 바꾼다.
				 status[no-1] = status[no-1] == 0 ? 1 : 0;
					for(int j=1; j<N/2; j++) {
						if(no - 1 + j >= N || no - 1 - j < 0)
							break;
						if(status[no - 1 - j] == status[no - 1 + j]) {
							status[no - 1 - j] = status[no - 1 - j] == 0 ? 1 : 0;
							status[no - 1 + j] = status[no - 1 + j] == 0 ? 1 : 0;
						}
						else break; //대칭 아닌것이 나오면 바로 끝낸다.
					}
			 }
		 }
		 for(int i=0; i<N; i++) {
			 System.out.print(status[i]+" ");
			 if((i+1)%20==0)
				 System.out.println();
		 }
		 
	}
}
