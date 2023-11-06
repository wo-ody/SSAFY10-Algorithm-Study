class Main:
    def __init__(self):
        self.n = int(input())
        self.m = int(input())
        self.maps = [list(map(int, input().split())) for _ in range(self.n)]
        self.schedule = [i-1 for i in map(int, input().split())]
        self.parents = [i for i in range(self.n)]  # 여행 계획인 m개의 도시에 대해 만드는 것이 아님
        self.answer = "YES"

    def solve(self):
        for i in range(self.n):
            for j in range(self.n):
                if self.maps[i][j] == 1:
                    self.union(i, j)
        self.search()
        print(self.answer)

    def find(self, x):
        if x == self.parents[x]:
            return x
        self.parents[x] = self.find(self.parents[x])
        return self.parents[x]

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x < y:
            self.parents[y] = x
        elif y < x:
            self.parents[x] = y

    def search(self):
        go = self.parents[self.schedule[0]]
        for i in range(1, self.m):
            if go != self.parents[self.schedule[i]]:
                self.answer = "NO"
                break


problem = Main()
problem.solve()
