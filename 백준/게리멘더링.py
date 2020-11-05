from collections import deque
import sys
input = sys.stdin.readline

INF = 2e10
n = int(input().rstrip())
peoples = list(map(int,input().rstrip().split()))
graph = [[] for _ in range(n+1)]
for i in range(1,n+1):
    data = list(map(int,input().rstrip().split()))
    for j in range(1,data[0]+1):
        graph[i].append(data[j])



def bfs(start):
    result = INF
    visited = [False]*(n+1)
    v_list = []
    q = deque()
    q.append(start)
    visited[start] = True

    v1=0;v2=0
    while q :
        v = q.popleft()
        v_list.append(v)
        for i in range(len(peoples)):
            if i+1 in v_list:
                v1+=peoples[i]
            else:
                v2 += peoples[i]
        result = min(result,abs(v2-v1))
        v2=0;v1=0

        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
    return result

value = INF
for i in range(1,n+1):
    value = min(bfs(i),value)

print(value)