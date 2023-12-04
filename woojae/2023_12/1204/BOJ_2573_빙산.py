from collections import deque
import sys
sys.setrecursionlimit(10**4)  # python3로 하면 시간 초과 pypy3로 할 경우 limit을 조정하지 않으면 메모리 초과


class Main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.grid = [list(map(int, input().split())) for _ in range(self.n)]
        self.visited = [[False for _ in range(self.m)] for _ in range(self.n)]
        self.direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.q = deque([])
        self.year = 0
        self.check = 0

    def dfs(self, y, x):
        if 0 <= y < self.n and 0 <= x < self.m:  # 유효 범위이며
            if self.grid[y][x] != 0 and not self.visited[y][x]:  # 빙산임과 동시에 아직 방문하지 않았다면
                self.visited[y][x] = True
                self.dfs(y-1, x)
                self.dfs(y+1, x)
                self.dfs(y, x-1)
                self.dfs(y, x+1)
                return True
        else:
            return False

    def bfs(self):
        point = len(self.q)  # 현재 시점에서 탐색할 빙산의 수
        cnt = 0  # 확인한 빙산의 수
        while self.q:
            current_y, current_x = self.q.popleft()
            cnt += 1

            for d in self.direction:
                my, mx = current_y + d[0], current_x + d[1]
                if 0 <= my < self.n and 0 <= mx < self.m:
                    # 유효 범위이며 현재 위치에 빙산이 있고 주변이 0임과 동시에 주변이 아직 체크되지 않은 빙산이라면
                    if self.grid[current_y][current_x] != 0 and self.grid[my][mx] == 0 and not self.visited[my][mx]:
                        self.grid[current_y][current_x] -= 1  # 빙산 녹임
                        if self.grid[current_y][current_x] == 0:  # 빙산이 다 녹으면
                            self.visited[current_y][current_x] = True  # 빙산 체크
                            break
            # 녹은 빙산을 체크하지 않으면 현재 시점에서 다른 빙산으로 넘어갈 때 방금 녹은 빙산도 처리 범위에 포함
            # -> 모든 빙산은 한 번에 처리해야 함

            if self.grid[current_y][current_x] != 0:  # 해당 빙산이 아직 녹지 않았다면
                self.q.append([current_y, current_x])

            if cnt == point:  # 현재 시점의 모든 빙산을 체크했다면
                self.check = 0  # 빙산이 연결되어 있는지 확인
                self.visited = [[False for _ in range(self.m)] for _ in range(self.n)]
                for y in range(self.n):
                    for x in range(self.m):
                        if self.grid[y][x] != 0 and self.dfs(y, x):  # 빙산일 경우 연결 상태가 확인되면
                            self.check += 1  # 연결된 빙하의 수 갱신
                self.year += 1  # 시점 갱신
                if self.check >= 2:  # 연결된 빙하의 수가 2 이상이라면 더 이상 탐색할 필요 없음
                    break
                cnt, point = 0, len(self.q)  # 그게 아니라면 다음 탐색을 위해 탐색할 빙산의 수와 탐색된 빙산의 수 초기화
                self.visited = [[False for _ in range(self.m)] for _ in range(self.n)]  # 다음 탐색에서 빙산을 녹이기 위해

    def solve(self):
        for y in range(self.n):
            for x in range(self.m):
                if self.grid[y][x] != 0:
                    self.q.append([y, x])

        self.bfs()

        print(0 if self.check < 2 else self.year)  # 연결된 빙산의 수가 2보다 작다면 0 아니라면 걸린 시간


problem = Main()
problem.solve()
