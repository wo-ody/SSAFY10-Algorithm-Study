import copy


class Main:
    def __init__(self):
        self.n = int(input())  # 사진틀
        self.candidate_num = int(input())
        self.candidates = [int(i) for i in input().split()]
        self.frame = []
        self.table = {i: [0, 0, -1] for i in range(1, self.candidate_num+1)}  # 후보별 추천 수, 기재 기간, 액자 위치
        self.recommend, self.period, self.pos = 0, 1, 2

    def solve(self):
        for candidate in self.candidates:
            if len(self.frame) < self.n:  # 사진을 다 걸기 전
                if self.check_candidate(candidate):  # 등록 여부 확인
                    continue
                self.enroll_candidate(candidate)  # 후보 등록
            else:
                if self.check_candidate(candidate):
                    continue  # 이 경우 제거할 필요 없음
                self.delete_candidate(candidate)  # 후보 제거
            self.update_period()  # 등록된 후보들의 기재 기간 갱신
        
        self.frame.sort()  # 결과 정렬
        print(*self.frame)

    def enroll_candidate(self, candidate):
        self.table[candidate][self.recommend] += 1
        self.table[candidate][self.pos] = len(self.frame)  # 순차적으로 위치 배정
        self.frame.append(candidate)

    def delete_candidate(self, candidate):
        remove_candidate = copy.deepcopy(
            min([(i, self.table[i]) for i in self.frame], key=lambda x: (x[1][0], -x[1][1])))
        # 처리할 때 처음부터, 추천수가 적고 오래된 후보를 찾아냄, deepcopy하지 않으면 딕셔너리의 키의 주소가 갱신됨
        self.reset_candidate(remove_candidate[0])
        self.table[candidate][self.recommend] += 1  # 새로운 후보 추천수 갱신
        self.table[candidate][self.pos] = remove_candidate[1][self.pos]  # 새로운 후보 액자 위치 갱신
        self.frame[remove_candidate[1][self.pos]] = candidate

    def check_candidate(self, candidate):
        if self.table[candidate][self.pos] != -1:  # 기재 여부 확인
            self.table[candidate][self.recommend] += 1  # 이미 기재된 경우 추천수만 갱신
            return True

    def reset_candidate(self, candidate):
        self.table[candidate][self.recommend] = 0  # 추천수 초기화
        self.table[candidate][self.period] = 0  # 기재 기간 초기화
        self.table[candidate][self.pos] = -1  # 위치 초기화

    def update_period(self):
        for candidate, info in self.table.items():  # 사진이 걸린 후보들 기재 기간 갱신
            if info[self.recommend] > 0:  # 추천이 하나라도 있다는 것은 사진이 걸려있다는 것
                self.table[candidate][self.period] += 1


problem = Main()
problem.solve()
