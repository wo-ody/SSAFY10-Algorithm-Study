class Main:
    def __init__(self):
        self.h, self.w, self.x, self.y = map(int, input().split())
        self.b = [list(map(int, input().split())) for _ in range(self.h + self.x)]
        self.a = [[0 for _ in range(self.w)] for _ in range(self.h)]  # (i, j)가 두 배열 모두에 포함되지 않으면, Bi,j = 0이다.

    def solve(self):
        for i in range(self.h):  # 배열 a에 배열 a를 겹친 것이 배열 b -> 겹치기 전 기본 형태 복원
            for j in range(self.w):
                self.a[i][j] = self.b[i][j]  # (i, j)가 두 배열 중 하나에 포함되면, Bi,j = Ai,j 또는 Ai-X,j-Y이다.

        for i in range(self.x, self.h):  # 이동한 만큼 빼주기
            for j in range(self.y, self.w):  # (i, j)가 두 배열 모두에 포함되면, Bi,j = Ai,j + Ai-X,j-Y이다.
                self.a[i][j] = self.b[i][j] - self.a[i-self.x][j-self.y]

        for i in self.a:
            print(*i)


problem = Main()
problem.solve()
