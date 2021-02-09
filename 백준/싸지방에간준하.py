from heapq import heappush,heappop
from collections import deque
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip()); info=[]
for _ in range(n):
    info.append(list(MIS()))
info=sorted(info,key=lambda x:(x[0]))

pq=[]
result=[]
ans=[0]*n
cnt=0
for i in range(n):
    while pq:
        if pq[0][0]<=info[i][0]:
            heappush(result,pq[0][1])
            heappop(pq)
        else: break
    if not result:
        heappush(pq,[info[i][1],cnt])
        ans[cnt]+=1
        cnt+=1
    else:
        heappush(pq,[info[i][1],result[0]])
        ans[result[0]]+=1
        heappop(result)

print(cnt)
for i in range(cnt):
    print(ans[i],end=' ')
print()