from heapq import heappush,heappop
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
minh=[]
for _ in range(n):
    a,b=MIS()
    heappush(minh,(a,b))
l,p=MIS()

maxh=[]
cnt=0
while True:
    if p>=l: 
        print(cnt)
        break
    while minh and minh[0][0]<=p:
        dist,fuel=heappop(minh)
        heappush(maxh,(-fuel,dist))
    if not maxh:
        print(-1)
        break

    fuel,dist=heappop(maxh)
    p=p-fuel
    cnt+=1