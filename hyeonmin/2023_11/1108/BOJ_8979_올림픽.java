package Algorithm_2023.src.month11.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {

    static int N, K, rank;

    static PriorityQueue<Country> pqueue = new PriorityQueue<>(
            (e1, e2) -> (e2.gold == e1.gold) ? (
                    (e1.silver == e2.silver) ? (e2.bronze - e1.bronze) : (e2.silver - e1.silver)
            ) : (e2.gold - e1.gold)
    );
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pqueue.offer(new Country(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        Stack<Country> stack = new Stack<>();
        Boolean isFinish = false;
        for (int i = 1; i <= N; i++) {
            Country country = pqueue.poll();
            stack.push(country);
            if(country.num == K) {
                stack.pop(); // 자기 자신이 한번 기록되었기 때문에 폐기
                rank = i;
                while(!stack.isEmpty()) {
                    Country pop = stack.pop();
                    if(pop.gold == country.gold
                            && pop.silver == country.silver
                            && pop.bronze == country.bronze) {
                        rank--;
                    } else {
                        isFinish = true;
                        break;
                    }
                }
            }
            if( isFinish ) break;
        }
        System.out.println(rank);
    }

    static class Country {
        int num, gold, silver, bronze;
        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}