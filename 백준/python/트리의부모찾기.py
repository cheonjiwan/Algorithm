from collections import deque
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip());graph=[[] for _ in range(n+1)]
for _ in range(n-1):
    a,b=MIS();graph[a].append(b);graph[b].append(a)
parent=[0]*(n+1);visited=[False for _ in range(n+1)]
for i in range(1,n+1):
    parent[i]=i

def bfs(start):
    q=deque([start])
    visited[start]=True
    while q:
        now=q.popleft()
        for i in graph[now]:
            if not visited[i]:
                parent[i]=now
                visited[i]=True
                q.append(i)

bfs(1)
for i in range(2,n+1):
    print(parent[i])