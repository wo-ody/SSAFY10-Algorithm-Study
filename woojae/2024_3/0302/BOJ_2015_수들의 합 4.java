package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_2015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] arr;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static long answer = 0;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int acc = 0;
        for (int i = 0; i < n; i++) {
            acc += arr[i]; // 누적 합 계산
            if(acc - k == 0)  // 누적합이 k와 완전히 일치하는 경우
            	answer++;  // 2 -2 2 -2와 같은 경우 해당 처리를 하지 않으면 2 + (-2)일 때 k가 되지만 최초 등장인 경우 answer에 합산하지 않음  
            if (hash.containsKey(acc - k)) // 현재 누적 합에서 k를 뺀 값이 딕셔너리에 있는지 확인
                answer += hash.get(acc - k); //누적 합에서 k를 뺀 값이 이전에 등장한 적이 있다면, 그것은 현재 위치에서의 부분합이 k인 경우를 의미
            hash.put(acc, hash.getOrDefault(acc, 0) + 1); // 현재 누적 합을 딕셔너리에 추가
        }
        System.out.println(answer);
    }
}
