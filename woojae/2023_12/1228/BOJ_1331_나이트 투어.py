class Main:
    def __init__(self):
        self.order = [input() for _ in range(36)]
        self.charToNum = {'A': 0, 'B': 1, 'C': 2, 'D': 3, 'E': 4, 'F': 5}
        self.board = [[0 for _ in range(6)] for _ in range(6)]
        self.visit = [[False for _ in range(6)] for _ in range(6)]
        self.direction = [[-2, -1], [-2, 1], [-1, 2], [1, 2], [2, -1], [2, 1], [-1, -2], [1, -2]]
        self.answer = "Invalid"

    def solve(self):
        start = self.order[0]
        start_y, start_x = self.charToNum[start[0]], int(start[1]) - 1
        self.visit[start_y][start_x] = True
        cnt = 1

        last_y, last_x = start_y, start_x  # 마지막 위치 -> 현재 위치
        for i in self.order[1:]:
            y, x = self.charToNum[i[0]], int(i[1]) - 1
            for d in self.direction:  # 나이트의 움직임
                my, mx = last_y + d[0], last_x + d[1]  # 현재 위치에서 나이트의 움직임으로 움직였을 때
                if my == y and mx == x:  # 정상적으로 움직였다면
                    if not self.visit[y][x]:  # 게다가 그곳이 첫 방문이라면
                        self.visit[y][x] = True
                        cnt += 1
                        last_y, last_x = y, x  # 마지막 위치 갱신
                    else:  # 이미 방문했다면 종료
                        break

        for d in self.direction:  # 마지막 위치에서 첫 위치로 이동할 수 있는지 확인
            my, mx = last_y + d[0], last_x + d[1]
            if my == start_y and mx == start_x and cnt == 36:  # 이동할 수 있으며 36번의 이동이 성공했다면
                self.answer = "Valid"

        print(self.answer)


problem = Main()
problem.solve()
