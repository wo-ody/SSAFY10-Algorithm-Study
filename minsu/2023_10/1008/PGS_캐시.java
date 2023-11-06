package programmers.Lv2;

import java.util.LinkedList;

public class PGS_캐시 {
    static LinkedList<String> queue = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        // cacheSize만큼 먼저 넣어주고
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            
            if(queue.remove(s)) {
                queue.offerFirst(s);
                answer += 1;
            } else {
                int curSize = queue.size();
                if (curSize == cacheSize) {
                    queue.pollLast();
                }
                queue.offerFirst(s);
                answer += 5;
            }
        
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(new PGS_캐시().solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
				"Pangyo", "Seoul", "NewYork", "LA" }));
	}
}
