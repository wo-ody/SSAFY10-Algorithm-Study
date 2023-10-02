from collections import deque

class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.data = [tuple(map(int, input().split())) for _ in range(self.n + self.m)]
        self.ladders = dict(self.data[:self.n])  # 오류 메시지가 뜨는 이유는 값이 2개가 들어와야 하는데 위 코드대로 하면
        self.snakes = dict(self.data[self.n:])   # 2개 이상이 들어올 수도 있기 때문에 발생하는 것
        self.board = [0] * 101

    def solve(self):
        q = deque([1])  # 1번 위치부터 시작
        while True:
            current_pos = q.popleft()
            if current_pos == 100:
                break
            for step in range(1, 7):
                moved_pos = current_pos + step
                if moved_pos <= 100 and not self.board[moved_pos]:
                    if moved_pos in self.ladders.keys():
                        moved_pos = self.ladders[moved_pos]  # 이동한 칸에 사다리가 있다면 사다리가 가리키는 곳으로 이동
                    elif moved_pos in self.snakes.keys():
                        moved_pos = self.snakes[moved_pos]  # 이동한 칸에 뱀이 있다면 뱀이 가리키는 곳으로 이동
                    if not self.board[moved_pos]:  # 위에 조건들에 걸리지 않았다면 아무것도 없는 칸이며 아직 방문하지 않았다면
                        self.board[moved_pos] = self.board[current_pos] + 1
                        q.append(moved_pos)
                        # 방문 조건을 검사하지 않으면 불필요하게 똑같은 행위를 반복해야 함
                        # 또한 이동하려는 칸이 사다리를 통해서 빠르게 온 경우로 기록되어 있는데 사다리나 뱀의 도움없이 오로지 주사위만 굴린 경우
                        # 최소 횟수를 보장하는 경우를 지우고 덮어씌우게됨
        # 테스트케이스에 연속적인 뱀이나 사다리의 경우는 없는 듯함
        # 또한 알고리즘의 특성상 해당 위치에서 최소 횟수를 비교해서 갱신할 필요가 없음, 가장 빨리 도착하면 큐에 먼저들어왔다는 것이고 그것이 최소의 경우임
        print(self.board[100])


problem = main()
problem.solve()
