class Main:
    def __init__(self):
        self.n = int(input())
        self.schedule = [list(map(int, input().split())) for _ in range(self.n)]
        self.visited = [False] * 10001
        self.answer = 0

    def solve(self):
        self.schedule.sort(key=lambda x: (-x[0]))  # 수업료가 큰 순으로 정렬
        for pay, day in self.schedule:
            if not self.visited[day]:  # 해당 수업을 진행하기 위해 스케쥴 체크, 해당 스케쥴에 일정이 없다면
                self.visited[day] = True  # 수업 확정
                self.answer += pay
            else:  # 해당 수업을 해당 스케쥴에 못 한다면
                for check in range(day-1, 0, -1):  # d일 안에만 와서 수업하면 되므로 가능한 스케쥴 탐색
                    if not self.visited[check]:  # 빈 스케쥴이 있으면
                        self.visited[check] = True  # 수업 확정
                        self.answer += pay
                        break  # 확정된 시점에서 더 이상 수업을 진행할 필요가 없으므로 탐색 종료
        print(self.answer)


problem = Main()
problem.solve()
