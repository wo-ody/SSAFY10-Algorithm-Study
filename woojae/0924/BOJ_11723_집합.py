import sys

class main
    def __init__(self)
        self.m = int(input())
        self.s = set()

    def solve(self)
        for _ in range(self.m)
            i = sys.stdin.readline().rstrip().split()  # 명령 및 출력을 따로 받아서 처리하면 메모리 혹은 시간 초과 발생
            if i[0] == add
                self.s.add(int(i[1]))
            elif i[0] == remove
                self.s.discard(int(i[1]))
            elif i[0] == check
                print(1 if int(i[1]) in self.s else 0)
            elif i[0] == toggle
                if int(i[1]) in self.s
                    self.s.remove(int(i[1]))
                else
                    self.s.add(int(i[1]))
            elif i[0] == all
                self.s = set((range(1, 21)))
            else
                self.s.clear()

main = main().solve()