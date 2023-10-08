import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(n);
        tree.init(arr, 1, 0, n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            long min = tree.findMin(1, 0, n - 1, left - 1, right - 1);
            long max = tree.findMax(1, 0, n - 1, left - 1, right - 1);
            answer.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(answer);

    }

    static class SegmentTree {
        long[] minTree;
        long[] maxTree;
        int treeSize;

        public SegmentTree(int arrSize) {
            treeSize = getTreeSize(arrSize);
            minTree = new long[treeSize];
            maxTree = new long[treeSize];
        }

        public int getTreeSize(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            return (int) Math.pow(2, h + 1);
        }

        public void init(long[] arr, int node, int start, int end) {
            if (start == end) {
                minTree[node] = arr[start];
                maxTree[node] = arr[start];
                return;
            }

            init(arr, node * 2, start, (start + end) / 2);
            init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }

        public long findMin(int node, int start, int end, int left, int right) {
            if (start > right || end < left) {
                return Long.MAX_VALUE;
            }

            if (left <= start && right >= end) {
                return minTree[node];
            }

            long val1 = findMin(node * 2, start, (start + end) / 2, left, right);
            long val2 = findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return Math.min(val1, val2);
        }

        public long findMax(int node, int start, int end, int left, int right) {
            if (start > right || end < left) {
                return Long.MIN_VALUE;
            }

            if (left <= start && right >= end) {
                return maxTree[node];
            }

            long val1 = findMax(node * 2, start, (start + end) / 2, left, right);
            long val2 = findMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return Math.max(val1, val2);
        }
    }
}
