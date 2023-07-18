import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 최빈값구하기 {
    public static int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        List<Integer> maxList = new ArrayList<>();
        int maxCnt = Integer.MIN_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i) > maxCnt) {
                maxCnt = map.get(i);
            }
        }
        for (int i : map.keySet()) {
            if (maxCnt == map.get(i)) {
                maxList.add(i);
            }
        }
        if (maxList.size() > 1) {
            return -1;
        }
        return maxList.get(0);
    }
}
