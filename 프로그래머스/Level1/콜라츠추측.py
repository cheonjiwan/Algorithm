def solution(num):
    answer = 0
    if num==1: return answer
    for _ in range(500):
        if num%2==0: num=num//2
        else: num=num*3+1
        answer+=1
        if num==1: return answer
    return -1
