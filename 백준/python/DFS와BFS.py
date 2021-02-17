import sys
from collections import deque
input = sys.stdin.readline

n,m,v = map(int,input().rstrip().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,n+1):
    graph[i].sort()
    
def dfs(graph,visited,start):
    visited[start] = True
    print(start, end =' ')

    for i in graph[start]:
        if visited[i]==False:
            dfs(graph,visited,i)

def bfs(graph,visited,start):
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True


visited = [False]*(n+1)
dfs(graph,visited,v)
print()
visited = [False]*(n+1)
bfs(graph,visited,v)