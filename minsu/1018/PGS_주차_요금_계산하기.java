import java.util.*;
import java.util.stream.*;

class Solution {
    // 출차를 했다면 HashMap에서 지웠을 것이기 때문에 contains = true라면 주차장에 있다는 뜻
    // map에 시간 넣을때는 시각 * 60 + 분 해주고 차이도 이렇게 구하면 될듯
    // -> 그렇다면 시간을 가져와서 계산하고 적립시켜준다. -> 이것도 map을 써도 될듯
    static HashMap<String, Integer> car = new HashMap<>(); // 차가 입차, 출차 되는 정보
    static HashMap<String, Integer> time = new HashMap<>(); // 차 별로 누적된 주차 시간
    static List<Integer> list = new ArrayList<>();
    static int endTime = 1439; // 23:59에 대한 시간
    public List<Integer> solution(int[] fees, String[] records) {
        int[] answer = {};
        for (String r : records) {
            String[] arr = r.split(" ");
            // 차 번호가 이미 있으면 출차를 시킬것이기 때문에 map에서 지워주고 
            // 시간 게산해서 time에 저장
            if (car.containsKey(arr[1])) {
                int inTime = car.get(arr[1]); // 입차시간
                int t = Integer.parseInt(arr[0].substring(0, 2)) * 60; // 시각
                int min = Integer.parseInt(arr[0].substring(3, 5)); // 분
                int outTime = t + min;
                int diff = outTime - inTime;
                car.remove(arr[1]);
                if (time.containsKey(arr[1])) {
                    time.put(arr[1], time.get(arr[1]) + diff);
                } else {
                    time.put(arr[1], diff);   
                }
            } else {
                int t = Integer.parseInt(arr[0].substring(0, 2)) * 60; // 시각
                int min = Integer.parseInt(arr[0].substring(3, 5)); // 분
                // System.out.println(t + " " + min);
                car.put(arr[1], t + min);
            }
        }
        
        // System.out.println(Integer.parseInt("0000")); // 0000을 정수변환하면 그냥 0이 되네...
        // 아직 출차가 안된ㄷ 차가 있을 수 있다
        for (Map.Entry<String, Integer> entry : car.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("0")) {
                int inTime = entry.getValue(); // 입차시간
                int diff = endTime - inTime;
                if (time.containsKey(entry.getKey())) {
                    time.put(entry.getKey(), time.get(entry.getKey()) + diff);
                } else {
                    time.put(entry.getKey(), diff);   
                }
            }
        }
        
        // fees[0] 초과하면 fees[1] + ((누적시간 - 기본시간) / fees[2]) * fees[3] 
        // 출력은 차 번호가 작은순으로 stream을 통해 정렬
        List<Map.Entry<String, Integer>> entries = time.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toList());
        
        for (Map.Entry<String, Integer> entry : entries) {
            int fee = fees[1];
            if (entry.getValue() > fees[0]) {
                fee += (Math.ceil((double)(entry.getValue() - fees[0]) / fees[2])) * fees[3];
                list.add(fee);
             } else {
                list.add(fees[1]);
            }
        }   
        
        return list;
    }
}
