class Main:
    def __init__(self):
        self.grid = [list(input().split()) for _ in range(5)]
        self.answer = set()  # 중복된 값 저장을 방지하기 위해 집합 자료형 사용

    def dfs(self, y, x, digit):  # 이동하는 데 제약이 없으므로 visit을 둘 필요 없음
        if y < 0 or y >= 5 or x < 0 or x >= 5:  # 유효 범위를 벗어나면 종료
            return
        if len(digit) == 6:  # 6개짜리 숫자가 만들어지면 저장
            self.answer.add(digit)
            return
        self.dfs(y-1, x, digit+self.grid[y][x])  # 들어가는 파라미터들은 이동할 좌표들, 현재까지 만들어진 숫자들임
        self.dfs(y+1, x, digit+self.grid[y][x])
        self.dfs(y, x-1, digit+self.grid[y][x])
        self.dfs(y, x+1, digit+self.grid[y][x])
        return

    def solve(self):
        for i in range(5):
            for j in range(5):
                self.dfs(i, j, "")  # 각 좌표에서 아직 숫자들이 만들어지지 않았으므로 빈 문자열을 넘겨줌

        print(len(self.answer))


problem = Main()
problem.solve()
