class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right


class Main:
    def __init__(self):
        self.n = int(input())
        self.nodes = dict()
        for _ in range(self.n):
            val, left, right = input().split()
            self.nodes[val] = Node(val, left, right)

    def building(self):
        for i in self.nodes.items():
            val, node = i
            if self.nodes[val].left != '.':  # 초기 더미값 확인후 자식 노드를 가진다면
                self.nodes[val].left = self.nodes[self.nodes[val].left]  # 더미값에 해당하는 실제 노드를 연결
            if self.nodes[val].right != '.':
                self.nodes[val].right = self.nodes[self.nodes[val].right]

    def preoder(self, v: Node):
        if v != '.':
            print(v.val, end='')
            self.preoder(v.left)
            self.preoder(v.right)

    def inoder(self, v: Node):
        if v != '.':
            self.inoder(v.left)
            print(v.val, end='')
            self.inoder(v.right)

    def postoder(self, v: Node):
        if v != '.':
            self.postoder(v.left)
            self.postoder(v.right)
            print(v.val, end='')

    def solve(self):
        self.building()
        root = self.nodes['A']
        self.preoder(root)
        print()
        self.inoder(root)
        print()
        self.postoder(root)


problem = Main()
problem.solve()
