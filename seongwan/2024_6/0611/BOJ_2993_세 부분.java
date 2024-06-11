import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        ans = new StringBuilder(input);

        for (int i = 0; i < input.length() - 2; i++) {
            int cut1 = i + 1;

            for (int j = i + 1; j < input.length() - 1; j++) {
                int cut2 = j + 1;

                StringBuilder first = new StringBuilder(input.substring(0, cut1));
                first.reverse();

                StringBuilder two = new StringBuilder(input.substring(i + 1, cut2));
                two.reverse();

                StringBuilder three = new StringBuilder(input.substring(cut2));
                three.reverse();

                StringBuilder temp = first.append(two).append(three);

                if (temp.toString().compareTo(ans.toString()) < 0) {
                    ans = temp;
                }
            }
        }

        System.out.println(ans);
    }
}