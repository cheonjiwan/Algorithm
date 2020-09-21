from collections import deque
import sys
input = sys.stdin.readline

def rotate(dir,next_dir):
    if next_dir == 'D':
        dir = (dir+1)%4
    else:
        dir = (dir-1)%4

    return dir

n = int(input().rstrip())
board = [[0]*(n+1) for _ in range(n+1)]
k = int(input().rstrip())
for _ in range(k):
    x,y = map(int,input().split())
    board[x][y] = 9
l = int(input())

play_info = []
for _ in range(l):
    time, dir = input().split()
    time = int(time)
    play_info.append((time,dir))

dx = [0,1,0,-1]
dy = [1,0,-1,0]

x,y = 1,1
q = deque([(x,y)])
dir = 0
count=0
board[x][y]=2
idx= 0
while True:
    nx = x+dx[dir]
    ny = y+dy[dir]
    
    if nx>=1 and nx<=n and ny>=1 and ny<=n and board[nx][ny]!=2:
        if board[nx][ny]==0:
            board[nx][ny]=2
            q.append((nx,ny))
            i,j = q.popleft()
            board[i][j]=0
        if board[nx][ny]==9:
            board[nx][ny]=2
            q.append((nx,ny))
    else:
        count+=1
        break
    x,y = nx,ny
    count+=1
    if idx<len(play_info) and play_info[idx][0]==count:
        dir = rotate(dir,play_info[idx][1])
        idx+=1

print(count)