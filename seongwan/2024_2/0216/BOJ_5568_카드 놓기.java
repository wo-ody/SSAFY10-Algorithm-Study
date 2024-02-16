import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

//카드 정보 저장 후 n개에서 k개의 순서를 정해 뽑은 뒤
//각 수를 String으로 합쳐서 hashSet에 저장 후 최종적으로
//set의 사이즈를 구해 정답을 구함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tgt;
	static int n, k;
	static HashSet<String> set = new HashSet<>();
	static boolean[] select;
	static int[] card;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		card = new int[n];
		select = new boolean[n];
		tgt = new int[k];
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}

		perm(0);
		System.out.println(set.size());
	}

	static void perm(int idx) {
		if (idx == k) {
			StringBuilder sb = new StringBuilder();
			for (int i : tgt) {
				sb.append(i);
			}
			set.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!select[i]) {
				select[i] = true;
				tgt[idx] = card[i];
				perm(idx + 1);
				select[i] = false;
			}
		}
	}
}