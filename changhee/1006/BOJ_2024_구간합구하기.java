import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		st =new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
		
		long[] arr= new long[n];
		for(int i =0; i<n; i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		
		SegmentTree tree= new SegmentTree(n);
		tree.init(arr, 1, 0, n-1);
		for(int i =0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int cmd= Integer.parseInt(st.nextToken());
			
			if(cmd==1) {
				int index =Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());
				tree.update(arr, 1, 0, n-1, index-1, val);
			}else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long result = tree.query(1, 0, n-1, left-1, right-1);
				answer.append(result).append("\n");
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

	public void init(long[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}

		init(arr, node * 2, start, (start + end) / 2);
		init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public long query(int node, int start, int end, int left, int right) {
		if (start > right || end < left) {
			return 0;
		}

		if (start >= left && end <= right) {
			return tree[node];
		}

		long lsum = query(node * 2, start, (start + end) / 2, left, right);
		long rsum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return lsum + rsum;

	}

	public void update(long[] arr, int node, int start, int end, int index, long val) {
		if (start > index || end < index) {
			return;
		}

		if (start == end) {
			arr[index] = val;
			tree[node] = val;
			return;
		}

		update(arr, node * 2, start, (start + end) / 2, index, val);
		update(arr, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
}
