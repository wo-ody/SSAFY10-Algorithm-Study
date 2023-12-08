class Main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.queen = list(map(int, input().split()))
        self.knight = list(map(int, input().split()))
        self.pawn = list(map(int, input().split()))
        self.board = [[1 for _ in range(self.m)] for _ in range(self.n)]
        self.answer = 0

    def set_player(self):
        for i in range(1, len(self.queen)-1, 2):
            r, c = self.queen[i:i+2]
            self.board[r-1][c-1] = -1

        for i in range(1, len(self.knight)-1, 2):
            r, c = self.knight[i:i+2]
            self.board[r-1][c-1] = -1

        for i in range(1, len(self.pawn)-1, 2):
            r, c = self.pawn[i:i+2]
            self.board[r-1][c-1] = -1

    def move_queen(self):
        direction = [[-1, -1], [-1, 1], [1, -1], [1, 1], [-1, 0], [1, 0], [0, -1], [0, 1]]

        for i in range(1, len(self.queen)-1, 2):
            r, c = self.queen[i:i+2]
            r -= 1
            c -= 1
            for d in direction:
                mr, mc = r + d[0], c + d[1]
                while 0 <= mr < self.n and 0 <= mc < self.m:
                    if self.board[mr][mc] == -1:  # 이동하려는 곳에 말이 있다면 이동할 수 없음
                        break
                    self.board[mr][mc] = 0  # 이동이 가능하다고 표시
                    mr += d[0]
                    mc += d[1]

    def move_knight(self):
        direction = [[-2, -1], [-2, 1], [-1, -2], [1, -2], [2, -1], [2, 1], [-1, 2], [1, 2]]

        for i in range(1, len(self.knight)-1, 2):
            y, x = self.knight[i:i+2]
            y -= 1
            x -= 1
            for d in direction:
                mr, mc = y + d[0], x + d[1]
                if 0 <= mr < self.n and 0 <= mc < self.m and self.board[mr][mc] == 1:
                    self.board[mr][mc] = 0

    def solve(self):
        self.set_player()
        self.move_queen()
        self.move_knight()

        for i in self.board:  # 말들이 세팅되어 있을 때, 말들이 움직일 수 있는 곳을 제하고 남은 영역을 구하는 것이 문제
            self.answer += i.count(1)

        print(self.answer)


problem = Main()
problem.solve()
