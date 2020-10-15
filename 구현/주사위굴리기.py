import sys
from copy import deepcopy
input = sys.stdin.readline

board = []
orders = []
n,m,x,y,k = map(int,input().rstrip().split())

for _ in range(n):
    board.append(list(map(int,input().rstrip().split())))

orders= list(map(int,input().rstrip().split()))

cp_dice = [0,0,0,0,0,0]
dice = [0,0,0,0,0,0] # 왼 오 위 뒤 아래 앞
board[x][y] = dice[4]
for order in orders:
    if order == 1: # 동
        nx,ny = x,y+1
        if 0<=nx<n and 0<=ny<m:
            cp_dice = deepcopy(dice)
            cp_dice[0] = dice[4]
            cp_dice[1] = dice[2]
            cp_dice[2] = dice[0]
            cp_dice[4] = dice[1]
            if board[nx][ny]==0:
                board[nx][ny] = cp_dice[4]
            else:
                cp_dice[4] = board[nx][ny]
                board[nx][ny] = 0
            x,y = nx,ny
            print(cp_dice[2])
    elif order == 2: # 서
        nx,ny = x,y-1
        if 0<=nx<n and 0<=ny<m: 
            cp_dice = deepcopy(dice)
            cp_dice[0] = dice[2]
            cp_dice[1] = dice[4]
            cp_dice[2] = dice[1]
            cp_dice[4] = dice[0]
            if board[nx][ny]==0:
                board[nx][ny] = cp_dice[4]
            else:
                cp_dice[4] = board[nx][ny]
                board[nx][ny] = 0
            x,y = nx,ny
            print(cp_dice[2])
    elif order == 3: # 북
        nx, ny = x-1,y
        if 0<=nx<n and 0<=ny<m:
            cp_dice = deepcopy(dice)
            cp_dice[2] = dice[5]
            cp_dice[3] = dice[2]
            cp_dice[4] = dice[3]
            cp_dice[5] = dice[4]
            if board[nx][ny]==0:
                board[nx][ny] = cp_dice[4]
            else:
                cp_dice[4] = board[nx][ny]
                board[nx][ny] = 0
            x,y = nx,ny
            print(cp_dice[2])
    elif order == 4: # 남
        nx,ny = x+1,y
        if 0<=nx<n and 0<=ny<m:
            cp_dice = deepcopy(dice)
            cp_dice[2] = dice[3]
            cp_dice[3] = dice[4]
            cp_dice[4] = dice[5]
            cp_dice[5] = dice[2]
            if board[nx][ny]==0:
                board[nx][ny] = cp_dice[4]
            else:
                cp_dice[4] = board[nx][ny]
                board[nx][ny] = 0
            x,y = nx,ny
            print(cp_dice[2])
    dice = deepcopy(cp_dice)
        