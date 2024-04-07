public static void Solution(String[] args) {

        String move = "drrd";

        // 상하좌우
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        // 방향을 저장할 변수 처음은 상(-1,0)
        int dir = 0; // 0,1,2,3 중에 가능(상하좌우)

        int[][] map = new int[3][3];

        // 처음 위치 (0,0)
        map[0][0] = 1;

        // 처음 위치 변수에 저장
        int r = 0;
        int c = 0;

        for(int[] m : map) {
            System.out.println(Arrays.toString(m));
        }

        for(int i=0; i < move.length(); i++) {
            char a = move.charAt(i);

            switch (a) {
                case 'u':
                    dir = 0;
                    break;
                case 'd':
                    dir = 1;
                    break;
                case 'l':
                    dir = 2;
                    break;
                case 'r':
                    dir = 3;
                    break;
            }

            r = r + dr[dir];
            c = c + dc[dir];

            map[r][c] = 1;

        }

        System.out.println();
        for(int[] m : map) {
            System.out.println(Arrays.toString(m));
        }

    }
