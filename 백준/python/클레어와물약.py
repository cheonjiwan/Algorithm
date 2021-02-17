import sys
from copy import deepcopy
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().rstrip().split())
graph = [[] for _ in range(n+1)]
indegree = [set() for _ in range(n+1)]

for _ in range(m):
    data = list(map(int,input().rstrip().split()))
    append_data = [];r = data[-1]
    for i in range(1,data[0]+1):
        append_data.append(data[i])
    graph[r].append(append_data)
    for item in append_data:
        indegree[item].add(r)

l = int(input().rstrip())
y = list(map(int,input().rstrip().split()))
q = deque(y)

result = set()
while q :
    now = q.popleft();result.add(now)

    for idx in indegree[now]:
        for item in graph[idx]:
            if now in item:item.remove(now)
            if not item:
                result.add(idx)
                q.append(idx)
    indegree[now] = []

result = list(result)
print(len(result))
print(*sorted(result))