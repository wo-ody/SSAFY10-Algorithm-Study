import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] alphabet = new int[26];
    static char[] palindrome;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] input = br.readLine().toCharArray();
        int size = input.length;
        int idx = 0;

        //홀수, 짝수 확인용
        boolean check = size % 2 == 1;

        palindrome = new char[(size + 1) / 2];

        for (char c : input) {
            alphabet[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                if (check) {
                    check = false;
                    palindrome[((size + 1) / 2) - 1] = (char) (i + 'A');
                    alphabet[i]--;
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }

            int count = alphabet[i] / 2;
            for (int j = 0; j < count; j++) {
                palindrome[idx++] = (char) (i + 'A');
            }
        }

        for (int i = 0; i < size / 2; i++) {
            sb.append(palindrome[i]);
        }

        if (size % 2 == 1)
            sb.append(palindrome[((size + 1) / 2) - 1]);

        for (int i = (size / 2) - 1; i >= 0; i--) {
            sb.append(palindrome[i]);
        }

        System.out.println(sb);
    }
}