info = {'A+': 4.5,
        'A0': 4.0,
        'B+': 3.5,
        'B0': 3.0,
        'C+': 2.5,
        'C0': 2.0,
        'D+': 1.5,
        'D0': 1.0,
        'F': 0.0}

answer = 0
total_score = 0

for _ in range(20):
    data = input()
    subject, score, grade = data.split()

    if grade == 'P':
        continue

    answer += float(score) * float(info[grade])
    total_score += float(score)
    
answer /= total_score

print(answer)
