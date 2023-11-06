import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		SegmentTree tree = new SegmentTree(n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				if (left > right) {
					int temp = right;
					right = left;
					left = temp;
				}

				long result = tree.query(1, 0, n - 1, left-1, right-1);
				answer.append(result).append("\n");
			} else {
				int index = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				tree.update(arr, 1, 0, n - 1, index-1, val);
			}
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

	public long query(int node, int start, int end, int left, int right) {
		if (start > right || end < left) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		long lSum = query(node * 2, start, (start + end) / 2, left, right);
		long rSum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return lSum + rSum;
	}

	public void update(int[] arr, int node, int start, int end, int index, int val) {
		if (index < start || index > end) {
			return;
		}

		if (start == end) {
			arr[index] = val;
			tree[node] = val;
			return;
		}

		update(arr, node * 2, start, (start + end) / 2, index, val);
		update(arr, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
