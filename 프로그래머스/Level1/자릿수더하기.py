def solution(n):
    answer = 0
    while n!=0:
        tmp=(n%10);answer+=tmp;n//=10
    return answer
