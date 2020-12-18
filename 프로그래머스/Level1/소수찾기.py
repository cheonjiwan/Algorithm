from math import sqrt
def solution(n):
    check=[False]*(n+1)
    for i in range(2,int(sqrt(n)+1)):
        for j in range(i+i,len(check),i):
            check[j]=True
    cnt=0
    for i in range(2,n+1):
        if not check[i]: cnt+=1
    return cnt