import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 소난다_19699 {
    static int N, M; // 전체 소의 수, 고를 소의 수
    static int[] cows; // 모든 소의 무게
    static int[] target; // 무게의 조합
    static Set<Integer> primeSum = new HashSet<>(); // 소들의 무게합이 소수인 경우 무게 합(중복제거를 위해 집합 사용)

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cows = new int[N];
        target = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }

        // 조합
        comb(0, 0);
        
        // 집합에 아무것도 없으면 -1
        if(primeSum.size() == 0){
            System.out.println(-1);
            return;
        }
        // 무게의 합이 소수인 경우가 존재할 때
        Integer[] answer = primeSum.toArray(new Integer[0]); // 정렬을 위해 집합을 배열로 전환
        Arrays.sort(answer); // 정렬
        
        // 출력
        for(int i : answer){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());

    }

    static void comb(int srcIdx, int targetIdx){
        if(targetIdx == M){
            // complete code
            // 해당 조합의 소 무게 합
            int sum = 0;
            for(int weight : target){
                sum+=weight;
            }
            // 무게 합의 소수여부 판별
            boolean isPrime = true;
            for(int i = 2; i<sum/2; i++){
                if(sum%i == 0){
                    isPrime = false;
                    break;
                }
            }
            // 소수일때 소수무게 집합에 추가
            if(isPrime) primeSum.add(sum);
            return;
        }

        if(srcIdx == N) return;
        target[targetIdx] = cows[srcIdx];
        comb(srcIdx+1, targetIdx+1);
        comb(srcIdx+1, targetIdx);

    }
}
