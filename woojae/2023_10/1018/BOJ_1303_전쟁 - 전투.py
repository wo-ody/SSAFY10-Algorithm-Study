from collections import deque


class Main:
    def __init__(self):
        self.n, self.m = map(int, input().split())  # 가로, 세로
        self.maps = [list(input()) for _ in range(self.m)]
        self.visited = [[False] * self.n for _ in range(self.m)]
        self.directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.q = deque([])
        self.log = {"W": [], "B": []}
        self.answer = []

    def solve(self):
        for i in range(self.m):
            for j in range(self.n):
                if not self.visited[i][j]:  # 일단 방문하지 않았으면 탐색 시작
                    self.bfs(i, j, self.maps[i][j])  # W와 B를 하나의 메서드에서 각각 계산해주기 위해 플래그 삽입

        for i in self.log.values():  # W, B 순서대로 값들의 제곱의 합 계산
            temp = 0
            for j in i:
                temp += j**2
            self.answer.append(temp)

        print(*self.answer)  # 출력 양식 맞춰줘야 함

    def bfs(self, y, x, flag):
        self.q.append([y, x])
        self.visited[y][x] = True
        cnt = 1  # 첫 방문이므로 1부터 시작

        while self.q:
            y, x = self.q.popleft()
            for d in self.directions:
                my, mx = y + d[0], x + d[1]
                if 0 <= my < self.m and 0 <= mx < self.n \
                        and not self.visited[my][mx] \
                        and self.maps[my][mx] == flag:  # 유효 범위, 방문 안 함, 찾고자 하는 병사라면
                    self.visited[my][mx] = True
                    self.q.append([my, mx])
                    cnt += 1  # 찾아낸 병사의 수 갱신

        self.log[flag].append(cnt)  # 탐색이 종료되면 플래그에 맞춰 찾아낸 병사의 수 저장


problem = Main()
problem.solve()
