def solution(a,b):
    answer=[[0 for _ in range(len(a[0]))] for _ in range(len(a))]
    for i in range(len(a)):
        for j in range(len(a[i])):
            answer[i][j]=a[i][j]+b[i][j]

    return answer