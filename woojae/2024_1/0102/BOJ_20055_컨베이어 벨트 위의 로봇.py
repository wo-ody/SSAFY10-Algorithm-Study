from collections import deque


class Main:
    def __init__(self):
        self.n, self.k = map(int, input().split())
        self.a = list(map(int, input().split()))
        self.belt_durability = deque(self.a)  # 벨트 내구도
        self.belt_status = deque([False] * self.n)  # 벨트 상태
        self.answer = 0

    def rotate(self):
        self.belt_durability.rotate(1)
        self.belt_status.rotate(1)
        if self.belt_status[-1]:
            self.remove()  # 내리는 위치에서 로봇 제거

    def move(self):  # 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
        for i in range(self.n-2, -1, -1):  # rotate가 되면 n-1은 항상 False이므로 n-2번 위치부터 이동
            if self.belt_status[i] and not self.belt_status[i+1] and self.belt_durability[i+1] > 0:
                # 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
                self.belt_status[i+1], self.belt_status[i] = self.belt_status[i], not self.belt_status[i]
                self.belt_durability[i+1] -= 1

        if self.belt_status[-1]:
            self.remove()  # 내리는 위치에서 로봇 제거

    def load(self):  # 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
        if self.belt_durability[0] > 0:
            self.belt_status[0] = True
            self.belt_durability[0] -= 1

    def remove(self):
        self.belt_status[-1] = False

    def check(self):
        return self.belt_durability.count(0) < self.k

    def solve(self):
        while self.check():  # 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            self.answer += 1
            self.rotate()
            self.move()
            self.load()

        print(self.answer)


problem = Main()
problem.solve()
