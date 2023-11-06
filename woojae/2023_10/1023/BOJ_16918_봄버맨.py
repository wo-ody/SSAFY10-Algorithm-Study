from collections import deque


class Main:
    def __init__(self):
        self.r, self.c, self.n = map(int, input().split())
        self.grid = [list(input()) for _ in range(self.r)]
        self.direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.visited = [[False] * self.c for _ in range(self.r)]
        self.bomb_pos = deque([])

    def solve(self):  # 초기 폭탄 설치부터 1초가 흐른 상태라고 가정 -> 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발
        self.check_bomb()  # 설치된 폭탄 위치 확인
        self.wait_bomberman()  # 봄버맨 대기 -> 시간 감소
        while True:
            if self.n <= 0: break  # 타이머가 끝났다면 종료
            self.set_bomb()  # 폭탄 설치 -> 시간 감소
            if self.n <= 0: break
            self.explode_bomb()  # 시간이 경과한 폭탄들 폭파 -> 코드 하나당 1초의 시간을 가정 -> 종료되지 않았다면 항상 폭발 -> 시간 감소

        self.print_result()

    def check_bomb(self):
        for y in range(self.r):
            for x in range(self.c):
                if self.grid[y][x] == "O":
                    self.bomb_pos.append([y, x])

    def wait_bomberman(self):
        self.n -= 1

    def set_bomb(self):
        for y in range(self.r):
            for x in range(self.c):
                if self.grid[y][x] != "O":
                    self.grid[y][x] = "O"
        self.n -= 1

    def explode_bomb(self):
        while self.bomb_pos:
            y, x = self.bomb_pos.popleft()
            self.grid[y][x] = "."
            for d in self.direction:
                my, mx = y + d[0], x + d[1]
                if 0 <= my < self.r and 0 <= mx < self.c:
                    self.grid[my][mx] = "."
        self.check_bomb()  # 남아있는 폭탄 위치 저장
        self.n -= 1

    def print_result(self):
        for i in self.grid:
            print("".join(i))


problem = Main()
problem.solve()
