class Main:
    def __init__(self):
        self.n = int(input())
        self.codes = [input().split() for _ in range(self.n)]
        self.table = {"ADD": "0000", "ADDC": "0000",
                      "SUB": "0001", "SUBC": "0001",
                      "MOV": "0010", "MOVC": "0010",
                      "AND": "0011", "ANDC": "0011",
                      "OR": "0100", "ORC": "0100",
                      "NOT": "0101",
                      "MULT": "0110", "MULTC": "0110",
                      "LSFTL": "0111", "LSFTLC": "0111",
                      "LSFTR": "1000", "LSFTRC": "1000",
                      "ASFTR": "1001", "ASFTRC": "1001",
                      "RL": "1010", "RLC": "1010",
                      "RR": "1011", "RRC": "1011",
                      }
        self.answer = ""

    def solve(self):  # "opcode rD rA rB" or "opcode rD rA #C"의 형태, rA를 사용하지 않는 경우는 000
        for code in self.codes:
            self.answer = ""
            flag = False  # 상수 사용 여부
            for i, cmd in enumerate(code):
                if i == 0:  # opcode(+flag) + dummy
                    self.answer += self.table[cmd]
                    if cmd[-1] == "C":  # 상수 사용 여부 및 5번 째 자리 0 삽입
                        flag = not flag
                        self.answer += "10"
                    else:
                        self.answer += "00"
                elif i == 1:  # rD
                    self.answer += bin(int(cmd))[2:].zfill(3)  # 문자열 -> 정수 -> 이진수 -> 세 자리 포매팅
                elif i == 2:  # rA
                    self.answer += ("000" if cmd == "0" else bin(int(cmd))[2:].zfill(3))
                else:  # rB or #C
                    x = bin(int(cmd))[2:]
                    self.answer += (x.zfill(4) if flag else x.zfill(3) + "0")  # 레지스터를 사용하지 않는 경우 뒤에 0 삽입
            print(self.answer)


problem = Main()
problem.solve()
