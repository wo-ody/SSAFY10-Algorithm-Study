import java.util.*;
// 목표 합을 구해놓고 (전체 합의 절반) 각 큐의 합을 매번 구하면서 목표보다 큰 큐에서 하나를 꺼내고 반대에 넣고

class Solution {
    static long sum1; // queue1 합
    static long sum2; // queue2 합
    static Queue<Long> que1 = new ArrayDeque<>();
    static Queue<Long> que2 = new ArrayDeque<>();
    
    public int solution(int[] queue1, int[] queue2) {
        for (int q1 : queue1) {
            que1.offer(Long.valueOf(q1));
            sum1 += Long.valueOf(q1);
        }
        for (int q2 : queue2) {
            que2.offer(Long.valueOf(q2));
            sum2 += Long.valueOf(q2);
        }
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        } 
        long tgt = (sum1 + sum2) / 2;
        
        int cnt = 0;
        
        try {
            while (sum1 != sum2) {
                if (cnt > (que1.size() + que2.size()) + 5) {
                    throw new Exception();
                }
                if (sum1 > sum2) {
                    long cur1 = que1.poll();
                    if (cur1 > tgt) {
                        throw new Exception();
                    }
                    que2.offer(cur1);
                    sum1 -= cur1;
                    sum2 += cur1;
                    cnt++;
                } else if (sum2 > sum1) {
                    long cur2 = que2.poll();
                    if (cur2 > tgt) {
                        throw new Exception();
                    }
                    que1.offer(cur2);
                    sum2 -= cur2;
                    sum1 += cur2;
                    cnt++;
                }
            }
        } catch(Exception e) {
            return -1;
        }
        
        return cnt;
    }
}

