from collections import deque
import sys
input=sys.stdin.readline

n=int(input().rstrip())
m=int(input().rstrip())
graph=[[] for _ in range(n+1)]
for _ in range(m):
    a,b=map(int,input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

visited=[False]*(n+1)
def bfs(i):
    q=deque();q.append(i)
    visited[i]=True
    cnt=0
    while q:
        now=q.popleft()
        for nextNode in graph[now]:
            if not visited[nextNode]:
                cnt+=1
                visited[nextNode]=True
                q.append(nextNode)
    return cnt

print(bfs(1))