import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 접시의 수 N, 초밥 가짓수 d, 연속 접시 수 k, 쿠폰 번호 c
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N+k-1];
        int[] kinds = new int[d];

        // N개 줄에 벨트 초밥 종류
        for(int i=0; i<N; i++)
            belt[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<k-1; i++) {
            belt[N+i] = belt[i];
        }

        // 초밥 가짓 수의 최댓값
        int max = 0;

        // 슬라이딩 윈도우
        int left = 0;
        int right = k;
        int select = 0;

        for(int i=left; i<right; i++) {
            kinds[belt[i] - 1] += 1;

            if (kinds[belt[i] - 1] == 1)
                select += 1;
        }

        if(kinds[c-1]==0) {
            if(max < select+1)
                max = select+1;
        }
        else {
            if(max < select)
                max = select;
        }

        while(right < belt.length) {
            // 첫 번째 인덱스 제거
            kinds[belt[left]-1] -= 1;

            if(kinds[belt[left++]-1] == 0)
                select -= 1;

            // 마지막 인덱스 추가
            kinds[belt[right]-1] += 1;

            if(kinds[belt[right++]-1] == 1)
                select += 1;

            // 쿠폰을 사용하지 않았다면 메뉴 하나 추가해서 최댓값 갱신
            if(kinds[c-1]==0) {
                if(max < select+1)
                    max = select+1;
            }
            else {
                if(max < select)
                    max = select;
            }
        }
        System.out.println(max);
    }
}
