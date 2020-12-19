from math import sqrt
def solution(n):
    tmp=sqrt(n)
    if tmp.is_integer():
        return pow((tmp+1),2)
    else: return -1

solution(121)