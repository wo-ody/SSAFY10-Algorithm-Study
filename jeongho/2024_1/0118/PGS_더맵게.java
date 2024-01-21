import java.util.*;

class PGS_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //스코빌 지수가 낮은 걸 우선적으로 계산하기 위해 pq 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //배열의 요소를 pq에 담기
        for(int i : scoville){
            pq.add(i);
        }
        int cnt = 0;
        //가장 스코빌지수가 작은 음식이 K보다 작다면 섞어야 함.
        while(pq.peek()<K){
            //음식이 하나밖에 없어서 섞을 수 없다면 -1 반환
            if(pq.size()==1){
                return -1;
            }
            //섞을 수 있다면 섞어서 pq에 삽입.
            //가장 작은 값이 K보다 커지면 종료됨
            int sc1 = pq.poll();
            int sc2 = pq.poll();
            pq.add(sc1+(sc2*2));
            cnt++;
        }
        
        
        return cnt;
    }
}
