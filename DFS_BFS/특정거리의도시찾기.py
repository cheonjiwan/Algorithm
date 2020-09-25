import sys
from collections import deque

input = sys.stdin.readline

n,m,k,x = map(int,input().rstrip().split())
graph = [[] for _ in range(n+1)]
INF = 987654321
distance = [-1]*(n+1)
distance[x] = 0

for _ in range(m):
    a,b = map(int,input().rstrip().split())
    graph[a].append(b)

q = deque([x])
while q:
    pos = q.popleft()
    for i in graph[pos]:
        if distance[i]==-1:
            distance[i] = distance[pos]+1
            q.append(i)

flag=0
for i in range(1,n+1):
    if distance[i]==k:
        flag=1
        print(i)

if flag==0:
    print(-1)


