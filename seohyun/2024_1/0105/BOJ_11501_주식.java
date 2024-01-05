import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] num;
        StringTokenizer st;
        //각 테스트케이스 진행!
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            st = new StringTokenizer(br.readLine()," ");
            num = new int[N];
            //주식의 시세 정보 저장
            for(int j=0;j<N;j++)
                num[j] = Integer.parseInt(st.nextToken());
            int max = num[N-1];	//마지막 값을 가장 큰 시세로 설정!
            //역방향 탐색 진행!
            for(int j=N-2;j>=0;j--) {
                if(num[j] <= max)	//가장 큰 시세보다 작은 시세일 때 판매!
                    answer += max - num[j];
                else		//가장 큰 시세보다 큰 시세 탐색시 바꾸기
                    max = num[j];
            }
            bw.write(answer + "\n");	//시세 차익의 합 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}
