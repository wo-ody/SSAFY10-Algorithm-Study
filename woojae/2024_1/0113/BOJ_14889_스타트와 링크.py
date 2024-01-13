import math


'''
class Main:  # 접근 방향: 팀 조합 뽑아서 점수 합산하기
    def __init__(self):
        self.n = int(input())
        self.status = [list(map(int, input().split())) for _ in range(self.n)]
        self.comb = []  # 팀 조합들을 저장할 리스트
        self.comb_set = [0] * (self.n//2)  # 팀 조합
        self.selected = [False] * self.n  # 만들어진 팀 기준 상대 팀을 식별하기 위한 리스트
        self.answer = math.inf

    def get_comb(self, idx, cnt):
        if cnt == self.n//2:  # 팀에 대한 인원이 다 뽑히면
            self.comb.append(self.comb_set[:])
            return
        if idx == self.n:  # 인덱스 에러 방지
            return
        self.comb_set[cnt] = idx
        self.get_comb(idx+1, cnt+1)  # 선택
        self.get_comb(idx+1, cnt)  # 비선택

    def solve(self):  # 결정적으로 3중 for문으로 굉장히 느림
        self.get_comb(0, 0)

        for c in self.comb:
            team_a, team_b = 0, 0  # 팀에 대한 능력치 값

            for i in c:
                self.selected[i] = True  # 선택된 팀원

            for i in range(self.n):  # 전체 인원 조합에 대해
                for j in range(self.n):
                    if self.selected[i] and self.selected[j]:  # 선택된 팀원
                        team_a += self.status[i][j]
                    elif not self.selected[i] and not self.selected[j]:  # 나머지 팀
                        team_b += self.status[i][j]

            self.answer = min(self.answer, abs(team_a - team_b))

            for i in c:  # 다음 조합을 위해 선택된 팀원 해제
                self.selected[i] = False

        print(self.answer)
'''

class Main:  # 접근 방향: 팀 조합 뽑아서 점수 합산하기
    def __init__(self):
        self.n = int(input())
        self.status = [list(map(int, input().split())) for _ in range(self.n)]
        self.comb = [0] * (self.n//2)  # 팀 조합
        self.answer = math.inf

    def get_comb(self, idx, cnt, arr):
        if cnt == self.n//2:  # 팀에 대한 인원이 다 뽑히면
            team_a, team_b = 0, 0  # 팀에 대한 능력치 값
            temp = [i for i in range(self.n) if i not in arr]  # 나머지 팀

            for i in range(self.n//2):  # 각 팀이 n//2 만큼 멤버를 가지므로
                for j in range(i+1, self.n//2):  # 자신이 선택되면 당연히 다음 사람을 고려해야 하므로
                    team_a += self.status[arr[i]][arr[j]] + self.status[arr[j]][arr[i]]  # 선택된 팀원
                    team_b += self.status[temp[i]][temp[j]] + self.status[temp[j]][temp[i]]  # 나머지 팀

            self.answer = min(self.answer, abs(team_a - team_b))
            return
        if idx == self.n:  # 인덱스 에러 방지
            return
        arr[cnt] = idx  # 선택 팀원
        self.get_comb(idx+1, cnt+1, arr)  # 선택
        self.get_comb(idx+1, cnt, arr)  # 비선택

    def solve(self):  # 기존 코드에서 시간 및 메모리 약 반으로 줄임
        self.get_comb(0, 0, self.comb[:])
        print(self.answer)


problem = Main()
problem.solve()
