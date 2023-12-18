import sys
sys.setrecursionlimit(10**9)


class Node:
    def __init__(self, num=None, left=None, right=None):
        self.num = num
        self.left = left
        self.right = right


class Main:
    def __init__(self):
        self.tree = []

    def input_tree(self):
        while True:
            try:
                num = sys.stdin.readline().rstrip()
                self.tree.append(int(num))
            except:
                break

    def post_order(self, tree):  # 재귀를 이용한 분할 정복
        if not tree:  # 왼쪽 혹은 오른쪽을 호출했는데 빈 리스트라면 이는 호출한 위치가 말단 -> 루트 노트임을 의미
            return []

        root = tree[0]
        left_subtree = [x for x in tree[1:] if x < root]
        right_subtree = [x for x in tree[1:] if x > root]

        postorder_left = self.post_order(left_subtree)
        postorder_right = self.post_order(right_subtree)

        return postorder_left + postorder_right + [root]  # 후위 순회의 기본 형태

    def solve(self):
        self.input_tree()

        for i in self.post_order(self.tree):
            print(i)


problem = Main()
problem.solve()
