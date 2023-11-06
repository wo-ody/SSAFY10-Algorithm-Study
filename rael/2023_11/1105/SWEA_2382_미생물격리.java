import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Virus implements Comparable<Virus> {
        int num;
        int i, j;
        int cnt;
        int dir;

        Virus(int num, int i, int j, int cnt, int dir) {
            this.num = num;
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.num == o.num) {
                return o.cnt - this.cnt;
            }
            return this.num - o.num;
        }

    }

    // (상: 1, 하: 2, 좌: 3, 우: 4)
    static int di[] = { 0, -1, 1, 0, 0 };
    static int dj[] = { 0, 0, 0, -1, 1 };

    static int N;
    static int M;
    static int K;

    static List<Virus> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = Integer.parseInt(sc.nextLine());

        for (int tc = 1; tc <= TC; tc++) {
            // 셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K
            N = sc.nextInt(); // (5 ≤ N ≤ 100)
            M = sc.nextInt(); // (1 ≤ M ≤ 1,000)
            K = sc.nextInt(); // (5 ≤ K ≤ 1,000)

            list = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                int cnt = sc.nextInt();
                int dir = sc.nextInt();
                list.add(new Virus(i * N + j, i, j, cnt, dir));
            }

            for (int time = 0; time < M; time++) {
                // 이동
                for (int idx = 0; idx < list.size(); idx++) {
                    Virus virus = list.get(idx);
                    virus.i = virus.i + di[virus.dir];
                    virus.j = virus.j + dj[virus.dir];
                    virus.num = (virus.i * N) + virus.j;

                    // 약품: 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다.
                    if (virus.i == 0 || virus.j == 0 || virus.i == N - 1 || virus.j == N - 1) {
                        virus.cnt /= 2;
                        virus.dir = changeDir(virus.dir);
                        if (virus.cnt == 0) {
                            list.remove(idx);
                            idx--;
                        }
                    }
                }

                Collections.sort(list);

                // 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다.
                for (int idx = 0; idx < list.size() - 1; idx++) {
                    Virus now = list.get(idx);
                    Virus next = list.get(idx + 1);

                    if (now.num == next.num) {
                        now.cnt += next.cnt;
                        list.remove(idx + 1);
                        idx--;
                    }
                }

            }

            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i).cnt;
            }
            System.out.println("#" + tc + " " + total);

        }
    }

    static int changeDir(int dir) {
        switch (dir) {
        case 1:
            return 2;
        case 2:
            return 1;
        case 3:
            return 4;
        case 4:
            return 3;
        }
        return -1;
    }

}
