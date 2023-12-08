from collections import deque


class Main:
    def __init__(self):
        self.height, self.width = map(int, input().split())
        self.grid = [list(input()) for _ in range(self.height)]
        self.direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.answer = 0

    def bfs(self, y, x):
        q = deque([[y, x, 0]])
        visited = [[False for _ in range(self.width)] for _ in range(self.height)]  # 탐색을 시작할 때마다 방문 여부 초기화
        visited[y][x] = True

        while q:
            y, x, time = q.popleft()
            self.answer = max(self.answer, time)

            for d in self.direction:
                my, mx = y + d[0], x + d[1]
                if 0 <= my < self.height and 0 <= mx < self.width and self.grid[my][mx] != 'W' and not visited[my][mx]:
                    q.append([my, mx, time+1])
                    visited[my][mx] = True

    def solve(self):
        for i in range(self.height):  # 어느 부분에서 시작해야 최장거리를 최단으로 이동하는지 알 수 없음
            for j in range(self.width):
                if self.grid[i][j] == 'L':  # 다만 땅에서 시작해야하며 땅들의 중간보다 측면의 땅에서 시작해야 최장거리를 보장함
                    if 0 <= i-1 and i+1 < self.height and self.grid[i-1][j] == 'L' and self.grid[i+1][j] == 'L' or \
                        0 <= j-1 and j+1 < self.width and self.grid[i][j-1] == 'L' and self.grid[i][j+1] == 'L':
                        continue
                        # 모든 포인트에 대해 bfs를 도는 것의 비효율적이므로 횡 혹은 종 방향으로 땅들이 둘러싸여 있다면 탐색 무시
                    self.bfs(i, j)

        print(self.answer)


problem = Main()
problem.solve()
