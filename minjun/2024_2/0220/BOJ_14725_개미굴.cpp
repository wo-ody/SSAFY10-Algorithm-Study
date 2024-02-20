#include <bits/stdc++.h>

using namespace std;
struct Node {
    string value;
    map<string, Node*> next;
    Node(string value) {
        this->value = value;
    }
    Node() { }
};
class Trie {
public:
    Node root;
    void insert(Node* current, const vector<string>& v, int offset) {
        if (offset == v.size()) return;
        // v[offset]을 current 위치에 삽입
        if (current -> next[v[offset]] == nullptr) {
            current -> next[v[offset]] = new Node(v[offset]);
        }
        insert(current->next[v[offset]], v, offset + 1);
    }
    void print(Node* current, int depth) {
        for (int i = 1; i < depth; i++) {
            cout << "--";
        }
        if (current != &(this->root))
            cout << current->value << '\n';
        for (auto [val, nxt] : current->next) {
            print(nxt, depth + 1);
        }
    }
};
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    Trie trie;
    trie.root = Node();

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int c;
        cin >> c;
        vector<string> info(c);
        for (auto &elem : info) cin >> elem;
        trie.insert(&trie.root, info, 0);
    }
    trie.print(&trie.root, 0);
    return 0;
}