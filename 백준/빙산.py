from collections import deque
import sys
from copy import deepcopy

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
n, m = map(int, input().rstrip().split())
board = []
ice = []

for _ in range(n):
    board.append(list(map(int, input().rstrip().split())))

for i in range(n):
    for j in range(m):
        if board[i][j] != 0:
            ice.append((i, j))


def melt():
    melt_list = []
    sea = 0
    q = deque(ice)
    length = len(ice)
    for _ in range(length):
        x, y = q.popleft()
        for idx in range(4):
            nx = x + dx[idx]
            ny = y + dy[idx]
            if board[nx][ny] == 0:
                sea += 1
        result = board[x][y] - sea
        if result > 0:
            melt_list.append((x, y, result))
            q.append((x, y))
        else:
            melt_list.append((x, y, 0))
        sea = 0

    for item in melt_list:
        x, y, cost = item
        board[x][y] = cost


def bfs():
    visit = [[False] * m for _ in range(n)]
    q = deque()
    cnt = 0  # 덩어리
    visited = deepcopy(visit)
    for i in range(1, n - 1):
        for j in range(1, m - 1):
            if board[i][j] != 0 and not visited[i][j]:
                q.append((i, j))
                visited[i][j] = True
                cnt += 1
                while q:
                    x, y = q.popleft()
                    for idx in range(4):
                        nx = x + dx[idx]
                        ny = y + dy[idx]
                        if 0 <= nx < n and 0 <= ny < m:
                            if board[nx][ny] != 0 and not visited[nx][ny]:
                                visited[nx][ny] = True
                                q.append((nx, ny))
    return cnt


year = 0
result = 0
while True:
    result = bfs()
    if result == 0:
        print(0)
        break
    elif result == 1:
        melt()
        year += 1
    elif result >= 2:
        print(year)
        break
