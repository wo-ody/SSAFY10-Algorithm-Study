class Main:
    def __init__(self):
        self.n = int(input())
        self.schedule = [list(map(int, input().split())) for _ in range(self.n)]
        self.answer = [0] * (self.n+2)  # n+1인 날까지 고려

    def solve(self):
        for i, data in enumerate(self.schedule, 1):
            end, day, pay = i+data[0], i, data[1]  # 종료날, 오늘날, 종료날 받는 돈
            if end <= self.n+1:  # 종료날이 n+1 이내일 때
                self.answer[end] = max(self.answer[end], self.answer[i]+pay)  # 현재까지 종료날 최고, 오늘날 누적 금액 + 보수
                for j in range(end+1, self.n+2):  # 마지막날까지 누적 금액 반영
                    self.answer[j] = max(self.answer[j], self.answer[j-1])  # 최대값을 기준으로 하지 않으면 단순히 이전 값으로 바뀜

        print(self.answer[-1])


problem = Main()
problem.solve()
