class Main:
    def __init__(self):
        self.board = [list(map(int, input().split())) for _ in range(19)]
        self.direction = [[1, 0], [0, 1], [1, 1], [-1, 1]]  # 첫 돌 기준 가장 왼쪽 혹은 세로일 때 가장 위를 기준으로 탐색하는 방향
        self.answer = None

    def solve(self):
        for y in range(19):
            for x in range(19):
                if self.board[y][x] != 0:
                    stone = self.board[y][x]
                    for d in self.direction:
                        cnt = 1
                        my, mx = y+d[0], x+d[1]
                        for _ in range(4):  # 첫 바둑돌은 확정이니까 연속한 4개만 검사하면 됨
                            # 처음부터 5개를 검사해서 6개 되는지 확인을 안 하는 이유는 111101과 같은 상황이 있어서임
                            if 0 <= my < 19 and 0 <= mx < 19 and self.board[my][mx] == stone:
                                cnt += 1
                            my += d[0]
                            mx += d[1]
                            if cnt == 5:  # 5개가 만들어지면
                                if 0 <= y-d[0] < 19 and 0 <= x-d[1] < 19 and self.board[y-d[0]][x-d[1]] == stone:
                                    break  # 시작돌의 뒤에 위치하는 돌이 같은 돌인지
                                if 0 <= my < 19 and 0 <= mx < 19 and self.board[my][mx] == stone:
                                    break  # 5개 이후의 돌이 같은 돌인지
                                self.answer = [stone, y+1, x+1]
                            # 해당 조건을 for _ in range(4)가 끝나고 검사하지 않는 이유 -> 아래와 같은 상황에서 성립이 안 되기 때문
                            # 1 1 1 1 1
                            # 1 1 0 0 0
                            # 1 0 1 0 0
                            # 1 0 0 1 0
                            # 1 0 0 0 1

        if self.answer is None:
            print(0)
        else:
            print(self.answer[0])
            print(f'{self.answer[1]} {self.answer[2]}')


problem = Main()
problem.solve()
