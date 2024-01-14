import sys
sys.setrecursionlimit(10**6)


class Main:
    def __init__(self):
        self.m, self.n, self.k = map(int, input().split())  # k = 그려지는 직사각형의 수
        self.cord = [list(map(int, input().split())) for _ in range(self.k)]
        self.grid = [[0 for _ in range(self.n)] for _ in range(self.m)]
        self.visited = [[False for _ in range(self.n)] for _ in range(self.m)]
        self.area_num = 0
        self.current_area = 0
        self.area = []

    def dfs(self, y, x):
        if y < 0 or y >= self.m or x < 0 or x >= self.n:
            return
        if self.grid[y][x] == 0 and not self.visited[y][x]:
            self.visited[y][x] = True
            self.dfs(y-1, x)
            self.dfs(y+1, x)
            self.dfs(y, x-1)
            self.dfs(y, x+1)
            self.current_area += 1  # 직사각형이 아닌 영역을 발견할 때마다
            return 1  # 직사각형이 아닌 영역들을 하나의 덩어리로
        return 0

    def solve(self):
        for c in self.cord:
            x1, y1, x2, y2 = c
            for y in range(self.m-y2, self.m-y1):  # 실제 좌표계가 아닌 2차원 리스트 좌표계에 맞춰 좌표 매핑
                for x in range(x1, x2):
                    self.grid[y][x] = 1  # 직사각형

        for i in range(self.m):
            for j in range(self.n):
                if not self.visited[i][j]:
                    self.current_area = 0
                    self.area_num += self.dfs(i, j)
                    if self.current_area != 0:  # 현재 탐색에서 직사각형이 아닌 영역들이 발견된 경우
                        self.area.append(self.current_area)

        print(self.area_num)
        print(*sorted(self.area))


problem = Main()
problem.solve()
