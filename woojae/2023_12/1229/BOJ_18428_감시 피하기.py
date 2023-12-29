from collections import deque

class Main:
    def __init__(self):
        self.n = int(input())
        self.grid = [input().split() for _ in range(self.n)]
        self.directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.teacher_pos = [[i, j] for j in range(self.n) for i in range(self.n) if self.grid[i][j] == 'T']
        self.answer = 'NO'

    def dfs(self, found_wall):
        if found_wall == 3:  # 모든 벽을 다 설치했다면
            if self.bfs():
                self.answer = 'YES'
            return
        for i in range(self.n):
            for j in range(self.n):
                if self.grid[i][j] == 'X':
                    self.grid[i][j] = 'O'
                    self.dfs(found_wall + 1)
                    self.grid[i][j] = 'X'

    def bfs(self):
        for pos in self.teacher_pos:
            for d in self.directions:
                y, x = pos

                while 0 <= y < self.n and 0 <= x < self.n:
                    if self.grid[y][x] == 'O':  # 벽을 만나면 더 이상 탐색할 수 없음
                        break
                    if self.grid[y][x] == 'S':  # 학생을 만나면 해당 벽 조합은 실패
                        return False
                    y += d[0]
                    x += d[1]

        return True

    def solve(self):
        self.dfs(0)
        print(self.answer)


problem = Main()
problem.solve()
