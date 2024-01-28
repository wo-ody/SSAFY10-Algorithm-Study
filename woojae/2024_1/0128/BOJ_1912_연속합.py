class Main:
    def __init__(self):
        self.n = int(input())
        self.arr = list(map(int, input().split()))
        self.dp = [0] * self.n
        self.answer = self.arr[0]  # 값의 범위에 음수가 포함되며 값이 하나만 존재할 수 있음

    def solve(self):
        self.dp[0] = self.arr[0]
        for i in range(1, self.n):
            self.dp[i] = max(self.arr[i], self.dp[i-1]+self.arr[i])  # 이전 누적값에서 합산 한 것이 큰지 지금 값 자체가 큰지
            self.answer = max(self.answer, self.dp[i])

        print(self.answer)


problem = Main()
problem.solve()
