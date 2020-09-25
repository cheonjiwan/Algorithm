import sys
from collections import deque

input = sys.stdin.readline

data = []
virus = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

# input
n, k = map(int, input().rstrip().split())
for i in range(n):
    row = list(map(int, input().rstrip().split()))
    data.append(row)
    for j in range(n):
        if row[j] != 0:
            virus.append((i, j, 0, row[j]))
result_s, result_x, result_y = map(int, input().rstrip().split())

virus.sort(key=lambda x: x[3])
q = deque(virus)

while q:
    x, y, s, num = q.popleft()
    if s == result_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < n:
            if data[nx][ny] == 0:
                data[nx][ny] = num
                q.append((nx, ny, s + 1, num))

print(data[result_x - 1][result_y - 1])
