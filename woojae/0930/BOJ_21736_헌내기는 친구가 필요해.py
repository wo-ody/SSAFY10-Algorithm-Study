import sys
sys.setrecursionlimit(10**6)


class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.campus = [list(input()) for _ in range(self.n)]
        self.visited = [[False] * self.m for _ in range(self.n)]
        self.answer = 0

    def solve(self):
        y, x = 0, 0
        for i in range(self.n):
            for j in range(self.m):
                if self.campus[i][j] == "I":
                    y, x = i, j  # 탐색 시작 위치
                if self.campus[i][j] == "X":  # 벽을 탐색 범위에서 제외
                    self.visited[i][j] = True
        self.dfs(y, x)
        print(self.answer if self.answer > 0 else "TT")  # 발견한 사람이 없다면 문자열 출력

    def dfs(self, y, x):
        if 0 <= y < self.n and 0 <= x < self.m and not self.visited[y][x]:  # 유효 범위이며 아직 방문하지 않았다면
            self.visited[y][x] = True
            if self.campus[y][x] == "P":  # 방문한 곳에 사람이 있다면
                self.answer += 1  # 찾아낸 사람 수 갱신
            self.dfs(y-1, x)  # 사람을 찾았다고 탐색을 종료해서는 안 됨, 그 다음 위치에 사람이 존재할 수도 있기 때문
            self.dfs(y+1, x)
            self.dfs(y, x-1)
            self.dfs(y, x+1)
        return


problem = main()
problem.solve()
