def solution(A,B):
    answer = 0
    a=sorted(A);b=sorted(B,reverse=True)
    for i,j in zip(a,b):
        answer+=i*j
    return answer
