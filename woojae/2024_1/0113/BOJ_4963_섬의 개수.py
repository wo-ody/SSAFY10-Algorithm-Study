import sys
sys.setrecursionlimit(10**6)


class Main:
    def __init__(self):
        self.grid = None
        self.visited = None
        self.w = self.h = -1
        self.cnt = 0
        self.answer = []

    def dfs(self, y, x):  # dfs 탐색을 통해 연결된 섬들을 하나의 섬으로 취급
        if y < 0 or y >= self.h or x < 0 or x >= self.w:
            return
        if self.grid[y][x] == 1 and not self.visited[y][x]:
            self.visited[y][x] = True
            self.dfs(y-1, x)
            self.dfs(y+1, x)
            self.dfs(y, x-1)
            self.dfs(y, x+1)
            self.dfs(y-1, x-1)
            self.dfs(y-1, x+1)
            self.dfs(y+1, x-1)
            self.dfs(y+1, x+1)
            return 1  # 섬 발견
        return 0  # 섬 발견 실패

    def solve(self):
        while True:
            self.w, self.h = map(int, input().split())
            if self.w == self.h == 0:  # 입력 종료 조건
                break
            self.grid = [list(map(int, input().split())) for _ in range(self.h)]
            self.visited = [[False for _ in range(self.w)] for _ in range(self.h)]
            self.cnt = 0  # 각 테스트케이스에 대한 섬의 수
            for i in range(self.h):
                for j in range(self.w):
                    if not self.visited[i][j]:  # 아직 방문 안 했다면
                        self.cnt += self.dfs(i, j)
            print(self.cnt)


problem = Main()
problem.solve()
