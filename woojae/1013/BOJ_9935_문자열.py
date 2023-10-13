from collections import deque

class Main:
    def __init__(self):
        self.string = list(input())
        self.bomb = input()
        self.stack = []  # 빼낸 문자들을 저장할 자료구조

    def solve(self):
        self.string = deque(self.string)  # 검사할 문자를 입력에서 O(1)에 제거하기 위해
        while self.string:  # 입력된 문자열을 앞에서부터 모두 저장
            self.stack.append(self.string.popleft())  # 검사할 문자 저장
            if len(self.stack) >= len(self.bomb):  # 검사할 문자들의 수가 폭탄의 길이만큼 모였다면
                if "".join(self.stack[-len(self.bomb):]) == self.bomb:  # 폭탄의 길이부터 마지막까지 검사했을 때 해당 문자들이 폭탄이라면
                    for _ in range(len(self.bomb)):
                        self.stack.pop()  # 폭탄 제거

        print("".join(self.stack) if self.stack else "FRULA")  # 자료구조에 데이터가 없다면 모두 폭발한 것으로 간주


problem = Main()
problem.solve()
