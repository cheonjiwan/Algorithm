from heapq import heappush,heappop

input=__import__('sys').stdin.readline
n=int(input().rstrip())
q=[]
for _ in range(n):
    num=int(input().rstrip())
    if num!=0:
        if num>0: heappush(q,(abs(num),True))
        else: heappush(q,(abs(num),False))
    else:
        if q:
            num,flag=heappop(q)
            if flag: print(num)
            else: print(-num)
        else: print(0)