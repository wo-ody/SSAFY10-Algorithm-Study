alphabets = ["A", "E", "I", "O", "U"]
answer = []

def search(target, word):
    answer.append(["", 0] if not answer else [target, answer[-1][1]+1])
    if target == word or len(target) == 5:
        return
    
    for alphabet in alphabets:
        if answer[-1][0] != word:
            search(target + alphabet, word)
        else:
            return


def solution(word):
    search("", word)
    return answer[-1][1]
