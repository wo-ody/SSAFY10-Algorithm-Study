import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input == null || input.length() == 0)
				break;
			st = new StringTokenizer(input);

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int val = Integer.parseInt(st.nextToken());
				if (val > 0) arr[i] = 1; 
				else if (val < 0) arr[i] = -1;
				else arr[i] = 0;
				
			}

			SegmentTree tree = new SegmentTree(n);
			tree.init(arr, 1, 0, n - 1);

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);

				if (cmd == 'C') {
					int index = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					
					if (val > 0) val = 1;
					else if (val < 0) val = -1;
					tree.update(arr, 1, 0, n - 1, index - 1, val);
				} else {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					long result = tree.query(1, 0, n - 1, left - 1, right - 1);

					if (result > 0) answer.append("+");
					else if (result < 0) answer.append("-");
					else answer.append("0");
					}
				}
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}

class SegmentTree {
	long[] tree;
	int treeSize;

	public SegmentTree(int arrSize) {
		treeSize = getTreeSize(arrSize);
		tree = new long[treeSize];
	}

	public int getTreeSize(int arrSize) {
		int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
		return (int) Math.pow(2, h + 1);
	}

	public void init(int[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}

		init(arr, node * 2, start, (start + end) / 2);
		init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}

	public long query(int node, int start, int end, int left, int right) {
		if (start > right || end < left) {
			return 1;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		long lSum = query(node * 2, start, (start + end) / 2, left, right);
		long rSum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return lSum * rSum;

	}

	public void update(int[] arr, int node, int start, int end, int index, int val) {
		if (start > index || end < index) {
			return;
		}

		if (start == end) {
			tree[node] = val;
			arr[start] = val;
			return;
		}

		update(arr, node * 2, start, (start + end) / 2, index, val);
		update(arr, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
		tree[node] = tree[node * 2] * tree[node * 2 + 1];

	}
}
