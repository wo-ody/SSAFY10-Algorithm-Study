import java.util.ArrayList;
import java.util.List;

public class 공백으로구분하기2 {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0; i<answer.length; i++){
            if(!answer[i].equals("")){
                list.add(answer[i]);
            }
        }
        String[] result = new String[list.size()];
        for(int i= 0; i< result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
