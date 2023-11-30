import java.util.*;
import java.io.*;


public class BOJ_458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken(); // 문자열

        int cnt = 0; // 추가된 문자의 개수
        int left = 0;
        while (true) {
        	// 팰린드롬 확인
            boolean flag = isPalindrome(left, str.length() - 1, str.toCharArray());
            if (flag) {
                cnt = left + str.length();
                break;
            }
            left++;
        }
        System.out.println(cnt);
    }

    public static boolean isPalindrome(int left, int right, char[] arr) {
        while (left < right) {
        	// 같지 않을 경우
            if (arr[left] != arr[right]) {
                break;
            }
            left++;
            right--;
        }
        
        if (left >= right) {
            return true;
        }
        return false;
    }
}
