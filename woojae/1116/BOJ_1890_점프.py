class Main:
    def __init__(self):
        self.n = int(input())
        self.arr = [list(map(int, input().split())) for _ in range(self.n)]
        self.dp = [[0] * self.n for _ in range(self.n)]
        self.dp[0][0] = 1  # 점프한 곳에 값은 이전까지 점프한 횟수 이므로 처음 점프하는 곳은 1이 되어야 함

    def solve(self):
        for y in range(self.n):
            for x in range(self.n):
                if y == x == self.n-1:  # 마지막 위치 도달하면 종료
                    print(self.dp[-1][-1])
                    break
                down, right = y + self.arr[y][x], x + self.arr[y][x]  # 현재 위치에서 각각 아래 점프, 오른쪽 점프
                if right < self.n:  # 점프했을 때 맵을 벗어나지 않았다면
                    self.dp[y][right] += self.dp[y][x]  # 점프 뛴 곳에 현재까지 이동한 횟수 합산
                if down < self.n:
                    self.dp[down][x] += self.dp[y][x]


problem = Main()
problem.solve()
