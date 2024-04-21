package algorithm2024.jan.day10;

import java.util.ArrayDeque;

public class PG_같은숫자는싫어 {
        public int[] solution(int []arr) {
            int[] answer = {};

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for(int i : arr){
                if(dq.isEmpty()){
                    dq.add(i);
                }else{
                    if(dq.peekLast()!=i){
                        dq.add(i);
                    }
                }
            }
            answer = new int[dq.size()];
            int idx = 0;
            while(!dq.isEmpty()){
                answer[idx++] = dq.pop();
            }

            return answer;
        }
}
