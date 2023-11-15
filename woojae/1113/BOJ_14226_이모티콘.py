from collections import deque

class Main:
    def __init__(self):
        self.s = int(input())
        self.visited = [[False for _ in range(1001)] for _ in range(1001)]  # 메모리 절약을 위한 방문 리스트
        self.answer = 0

    def solve(self):
        q = deque([[1, 0, 0]])  # 이모티콘의 수, 클립보드의 이모티콘 수, 시간
        self.visited[1][0] = True

        while q:
            smile, board, time = q.popleft()
            if smile == self.s:  # s개의 스티커를 만들었다면
                self.answer = time
                break
            for i in [[smile, smile], [smile+board, board], [smile-1, board]]:  # 각각 문제에서 주어진 세 가지 연산
                temp_smile, temp_board = i
                if 0 <= temp_smile <= 1000 and not self.visited[temp_smile][temp_board]:  # 스티커의 수는 음수가 될 수 없고 최대를 넘길 수 없음
                    self.visited[temp_smile][temp_board] = True
                    q.append([temp_smile, temp_board, time + 1])  # 연산을 수행한 후 시간 갱신

        print(self.answer)


problem = Main()
problem.solve()
