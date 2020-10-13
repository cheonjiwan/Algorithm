import sys
from collections import deque
input = sys.stdin.readline

dx =[-1,0,1,0]
dy = [0,1,0,-1]

board = []
n,m = map(int,input().rstrip().split())
r,c,d = map(int,input().rstrip().split()) # 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
for _ in range(n):
    board.append(list(map(int,input().rstrip().split())))

def bfs(r,c,d):
    result = 0
    count=0
    q = deque()
    q.append((r,c,d))
    while q :
        x,y,d = q.popleft()
        if board[x][y]!=9:
            board[x][y]=9
            result+=1
        index = d
        for i in range(4):
            index = (index+3)%4
            nx = x + dx[index]
            ny = y + dy[index]
            if 0<=nx<n and 0<=ny<m:
                if board[nx][ny]==0:
                    # d = (d+1)%4
                    q.appendleft((nx,ny,index))
                    count=0
                    break
                else:
                    count+=1
        if count==4:
            if d==0:
                if board[x+1][y]!=1:
                    q.appendleft((x+1,y,d))
                    count=0
                else:
                    break
            elif d==1:
                if board[x][y-1]!=1:
                    q.appendleft((x,y-1,d))
                    count=0
                else:
                    break
            elif d==2:
                if board[x-1][y]!=1:
                    q.appendleft((x-1,y,d))
                    count=0
                else:
                    break
            elif d==3:
                if board[x][y+1]!=1:
                    q.appendleft((x,y+1,d))
                    count=0
                else:
                    break
    return result

print(bfs(r,c,d))
