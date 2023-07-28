import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();

        for(int i= 0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        ArrayList<Integer> list= new ArrayList<>();
        for(int i = 0; i<photo.length;i++){
            int score  = 0;
            for(int j = 0; j<photo[i].length; j++){
                if(!map.keySet().contains(photo[i][j])){
                    continue;
                }
                score+=map.get(photo[i][j]);
            }
            list.add(score);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
