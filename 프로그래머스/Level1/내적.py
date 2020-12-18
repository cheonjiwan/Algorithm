def solution(a, b):
    ans=0
    for i,j in zip(a,b):
        ans+=i*j
    return ans

