public class Main {
    static int n, m;
    static int[] parents;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        n = in.nextInt();
        m = in.nextInt();

        make();

        for (int i = 0; i < m; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            if (!union(start, end)) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(0);
    }

    static void make() {
        parents = new int[n];
        rank = new int[n]; // 추가된 부분: rank 배열 초기화
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 0; // 초기 rank는 0
        }
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;

        // rank를 이용한 union
        if (rank[aRoot] < rank[bRoot]) {
            parents[aRoot] = bRoot;
        } else if (rank[aRoot] > rank[bRoot]) {
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] = aRoot;
            rank[aRoot]++;
        }
        return true;
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    String nextString() throws Exception {
        StringBuilder sb = new StringBuilder();
        byte c;
        while ((c = read()) < 32) {
            if (size < 0) return "endLine";
        }
        do sb.appendCodePoint(c);
        while ((c = read()) > 32); // SPACE 분리라면 >로, 줄당 분리라면 >=로
        return sb.toString();
    }

    char nextChar() throws Exception {
        byte c;
        while ((c = read()) < 32) ; // SPACE 분리라면 <=로, SPACE 무시라면 <로
        return (char) c;
    }

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) {
            if (size < 0) return -1;
        }
        if (c == 45) {
            c = read();
            isMinus = true;
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    long nextLong() throws Exception {
        long n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) ;
        if (c == 45) {
            c = read();
            isMinus = true;
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    double nextDouble() throws Exception {
        double n = 0, div = 1;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) {
            if (size < 0) return -12345;
        }
        if (c == 45) {
            c = read();
            isMinus = true;
        } else if (c == 46) {
            c = read();
        }
        do n = (n * 10) + (c & 15);
        while (isNumber(c = read()));
        if (c == 46) {
            while (isNumber(c = read())) {
                n += (c - 48) / (div *= 10);
            }
        }
        return isMinus ? -n : n;
    }

    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    boolean isAlphabet(byte c) {
        return (64 < c && c < 91) || (96 < c && c < 123);
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}