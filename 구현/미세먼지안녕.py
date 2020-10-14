import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]
board = []
cleaner = []
others = []
r,c,t = map(int,input().rstrip().split())
for _ in range(r):
    board.append(list(map(int,input().rstrip().split())))

for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]==0:
            continue
        else:
            if board[i][j]==-1:
                cleaner.append((i,j))
            else:
                others.append((i,j,board[i][j]))

q = deque(others)
for _ in range(t):
    # 확산
    count=0
    for _ in range(len(q)):
        x,y,amount=q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<r and 0<=ny<c and board[nx][ny]!=-1:
                count+=1
                board[nx][ny] += amount//5
        board[x][y] = board[x][y] - ((amount//5)*count)
        count=0

    # 공기 청정기
    c1_x,c1_y = cleaner[0]
    c2_x,c2_y = cleaner[1]

    # 바람 1
    for i in range(c1_x,0,-1):
        board[i][0] = board[i-1][0]
    for i in range(0,c-1):
        board[0][i] = board[0][i+1]
    for i in range(c1_x):
        board[i][c-1] = board[i+1][c-1]
    for i in range(c-1,1,-1):
        board[c1_x][i] = board[c1_x][i-1]
    board[c1_x][1] = 0
    board[c1_x][c1_y] = -1

    # 바람 2
    for i in range(c2_x,r-1):
        board[i][0] = board[i+1][0]
    for i in range(c-1):
        board[r-1][i] = board[r-1][i+1]
    for i in range(r-1,c2_x,-1):
        board[i][c-1] = board[i-1][c-1]
    for i in range(c-1,0,-1):
        board[c2_x][i] = board[c2_x][i-1]
    board[c2_x][1] = 0
    board[c2_x][c2_y] = -1

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j]!=-1 and board[i][j]!=0:
                q.append((i,j,board[i][j]))

result = 0

for row in board:
    for col in row:
        if col!=-1 and col!=0:
            result +=col

print(result)




