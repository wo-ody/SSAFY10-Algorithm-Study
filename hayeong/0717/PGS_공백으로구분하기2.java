import java.util.Arrays;

public class 공백으로구분하기2 {
    public String[] solution(String my_string) {
        return Arrays.stream(my_string.trim().split("")).filter(x->!x.equals("")).toArray(String[]::new);
    }
}
