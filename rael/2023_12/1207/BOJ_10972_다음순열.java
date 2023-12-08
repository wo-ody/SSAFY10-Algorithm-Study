import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    static int[] array;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        String[] temp = br.readLine().split(" ");

        // 입력 순열
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(temp[i]);
        }

        nextPermutation();
    }

    public static void nextPermutation() {
        // 가장 긴 내림차순 순열을 찾는 과정
        int i = array.length - 2;
        while (i >= 0 && array[i] > array[i + 1]) {
            i--;
        }

        // 더이상 다음 순열이 없으면 "-1" 출력 하고 종료
        if (i < 0) {
            System.out.println(-1);
            return;
        }


        // 위에서 찾은 내림차순 순열중 array[i] 보다 큰 수중 가장 최소값 찾기
        int j = array.length - 1;
        while (array[j] < array[i]) {
            j--;
        }

        // i와 j에 위치한 값을 서로 변경
        swap(i, j);

        // 내림차순 순열을 다시 오름차순으로 변경
        reverse(i+1, array.length-1);

        String result = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void reverse(int start, int end) {
        while (start < end) {
            swap(start, end);
            start++;
            end--;
        }
    }
}
