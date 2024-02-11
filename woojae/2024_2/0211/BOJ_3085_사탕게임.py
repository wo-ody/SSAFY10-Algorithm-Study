class Main:
    def __init__(self):
        self.n = int(input())
        self.grid = [list(input()) for _ in range(self.n)]
        self.direction = [[1, 0], [0, 1]]
        self.answer = 1

    def find_candy(self):
        max_candy = 0
        for i in range(self.n):
            column_candy = 1
            for y in range(1, self.n):
                if self.grid[y][i] == self.grid[y - 1][i]:
                    column_candy += 1
                else:
                    column_candy = 1
                max_candy = max(max_candy, column_candy)

            row_candy = 1
            for x in range(1, self.n):
                if self.grid[i][x] == self.grid[i][x - 1]:
                    row_candy += 1
                else:
                    row_candy = 1
                max_candy = max(max_candy, row_candy)

        return max_candy

    def solve(self):
        for i in range(self.n):
            for j in range(self.n):
                for d in self.direction:
                    if i + d[0] < self.n and self.grid[i][j] != self.grid[i + d[0]][j]:
                        self.grid[i][j], self.grid[i + d[0]][j] = self.grid[i + d[0]][j], self.grid[i][j]  # 스왑
                        self.answer = max(self.answer, self.find_candy())
                        self.grid[i][j], self.grid[i + d[0]][j] = self.grid[i + d[0]][j], self.grid[i][j]  # 원복
                    if j + d[1] < self.n and self.grid[i][j] != self.grid[i][j + d[1]]:
                        self.grid[i][j], self.grid[i][j + d[1]] = self.grid[i][j + d[1]], self.grid[i][j]
                        self.answer = max(self.answer, self.find_candy())
                        self.grid[i][j], self.grid[i][j + d[1]] = self.grid[i][j + d[1]], self.grid[i][j]

        print(self.answer)


problem = Main()
problem.solve()
