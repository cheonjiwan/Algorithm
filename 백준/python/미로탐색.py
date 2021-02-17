import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]

board = []
n,m = map(int,input().rstrip().split())
for _ in range(n):
    board.append(list(map(int,input().rstrip())))

def bfs(s_x,s_y):
    q = deque([(s_x,s_y)])
    # visited = [[False]*(m) for _ in range(n)]
    while q:
        x,y = q.popleft()
        # visited[x][y]=True
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<m and board[nx][ny]==1:
                board[nx][ny]=board[x][y]+1
                q.append((nx,ny))

    return board[n-1][m-1]

print(bfs(0,0))