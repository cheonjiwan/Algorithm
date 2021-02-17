from copy import deepcopy
from collections import deque
import sys

input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())
m,n=MIS();board=[]
for _ in range(n):
    board.append(list(MIS()))

dx=[-1,0,1,0];dy=[0,-1,0,1]
tomato=[];cnt=0
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]==1: tomato.append((i,j))
        elif board[i][j]==0: cnt+=1

if cnt==0: print(0);sys.exit()
else:
    result=0
    while True:
        q=deque(tomato)
        tmp=[]
        while q:
            x,y=q.popleft()
            for i in range(4):
                nx,ny=x+dx[i],y+dy[i]
                if 0<=nx<n and 0<=ny<m and board[nx][ny]==0:
                    board[nx][ny]=1
                    tmp.append((nx,ny))
        if tmp:
            tomato=deepcopy(tmp)
            result+=1
        else: break
        
for row in board:
    for col in row:
        if col==0: print(-1);sys.exit()
print(result)