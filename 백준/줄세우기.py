from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
indegree = [0] * (n + 1)
students = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().rstrip().split())
    indegree[b] += 1
    students[a].append(b)

result = []
q = deque()
for i in range(1, n + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    now = q.popleft()
    result.append(now)
    for i in students[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)

for i in result:
    print(i, end=" ")
