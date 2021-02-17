from collections import deque
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
a,b=MIS()
m=int(input().rstrip())
graph=[[] for _ in range(n+1)]
for _ in range(m):
    x,y=MIS()
    graph[x].append(y)
    graph[y].append(x)

answer=[0]*(n+1)
def bfs(start):
    q=deque(); q.append(start)
    visited=[False]*(n+1)
    visited[start]=True

    while q:
        now=q.popleft()
        for nextNode in graph[now]:
            if not visited[nextNode]:
                visited[nextNode]=True
                answer[nextNode]=answer[now]+1
                q.append(nextNode)

bfs(a)
print(answer[b]) if answer[b]!=0 else print(-1)
