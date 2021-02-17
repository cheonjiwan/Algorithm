from collections import deque
from copy import deepcopy
import sys
input=sys.stdin.readline

dx=[0,1,1,1,0,0,0,-1,-1,-1]
dy=[0,-1,0,1,-1,0,1,-1,0,1]

r,c=map(int,input().rstrip().split())
board=[list(map(str,input().rstrip())) for _ in range(r)]
order=list(map(int,input().rstrip()))
sx,sy=0,0
crazy=[]
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]=='I': sx,sy=i,j
        if board[i][j]=='R':
            crazy.append((i,j))

def bfs(direction):
    global sx,sy
    nsx,nsy=sx+dx[direction],sy+dy[direction]
    new_crazy={}
    return_arr=[]
    if board[nsx][nsy]=='R':
        return False,new_crazy
    else:
        board[sx][sy]='.'
        board[nsx][nsy]='I'
    sx,sy=nsx,nsy
    q=deque(crazy)
    
    while q:
        x,y=q.popleft()
        minV=2e10
        minv_x,minv_y=0,0
        for i in range(1,10):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<r and 0<=ny<c:
                if abs(sx-nx)+abs(sy-ny)<minV:
                    minV=abs(sx-nx)+abs(sy-ny)
                    minv_x,minv_y=nx,ny
        if board[minv_x][minv_y]=='I': 
            return False,new_crazy
        else:
            board[x][y]='.'
            if (minv_x,minv_y) not in new_crazy:
                new_crazy[(minv_x,minv_y)]=1
            else:
                new_crazy[(minv_x,minv_y)]+=1

    for pos,cnt in new_crazy.items():
        if cnt>=2:
            continue
        board[pos[0]][pos[1]]='R'
        return_arr.append((pos[0],pos[1]))
    return True,return_arr
cnt=0
for direction in order:
    flag,crazy=bfs(direction)
    cnt+=1
    if not flag:
        print('kraj {}'.format(cnt))
        sys.exit()

for row in board:
    for col in row:
        print(col,end='')
    print()

sys.setrecursionlimit