from collections import deque


class Main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.maps = [list(map(int, input().split())) for _ in range(self.n)]
        self.sharks = []
        self.q = deque([])
        self.directions = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        self.visited = [[False] * self.m for _ in range(self.n)]
        self.answer = -1

    def solve(self):
        self.search_shark()

        while self.q:
            y, x = self.q.popleft()
            for d in self.directions:
                my, mx = y + d[0], x + d[1]
                if (0 <= my < self.n and 0 <= mx < self.m) and not self.visited[my][mx]:  # 유효 범위이며 아직 방문 안 했다면
                    self.maps[my][mx] = self.maps[y][x] + 1  # 거리 갱신
                    self.visited[my][mx] = True  # 방문 처리
                    self.q.append([my, mx])
                    self.answer = max(self.answer, self.maps[my][mx])  # 방문할 때 마다 정답 확인

        print(self.answer)
        for i in self.maps:
            print(i)

    def search_shark(self):
        for y in range(self.n):
            for x in range(self.m):
                if self.maps[y][x] == 1:
                    self.maps[y][x] = 0  # 각 칸의 거리를 갱신하기 위해 상어의 값을 0으로 변경
                    self.visited[y][x] = True  # 상어의 위치는 탐색 범위에서 제외시켜야 함
                    self.q.append([y, x])


problem = Main()
problem.solve()
