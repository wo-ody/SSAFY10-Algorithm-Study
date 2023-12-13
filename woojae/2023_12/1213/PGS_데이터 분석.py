def solution(data, ext, val_ext, sort_by):
    cond = {"code": 0, "date": 1, "maximum": 2, "remain": 3}  # ext와 sort_by에서 처리해야 하므로 별도의 자료구조로 처리
    answer = [i for i in data if i[cond[ext]] < val_ext]  # 특정 데이터 추출
    answer.sort(key=lambda x: x[cond[sort_by]])  # 특정 기준으로 정렬
    return answer
