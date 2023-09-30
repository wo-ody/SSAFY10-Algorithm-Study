class main:
    def __init__(self):
        self.t = int(input())
        self.n = []
        self.p = [0, 1, 1]
        self.max = 0

    def solve(self):
        for _ in range(self.t):
            self.n.append(int(input()))
            self.max = max(self.n[-1], self.max)  # 가장 큰 n에 대한 수열만 계산

        for i in range(3, self.max + 1):
            self.p.append(self.p[i - 2] + self.p[i - 3])

        for i in self.n:  # 이미 만들어진 최장 길이의 수열에서 n번째 값만 확인
            print(self.p[i])


problem = main()
problem.solve()
