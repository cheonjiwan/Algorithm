from copy import deepcopy
MIS=lambda: map(int,input().split())
n,m=MIS();board=[];cctvs=[]
result=2e10;d=[0,4,2,4,4,1]
for _ in range(n):
    board.append(list(MIS()))
for i in range(n):
    for j in range(m):
        if 1 <= board[i][j] <= 5:cctvs.append((board[i][j],i,j))

def countResult():
    global result
    cnt=0
    for row in board:
        for col in row:
            if col==0:cnt+=1
    result=min(result,cnt)

def move(x,y,dir):
    dir%=4
    if dir==0:#up
        for i in range(x-1,-1,-1):
            if board[i][y]==6:break
            if board[i][y]==0:board[i][y]=9
    elif dir==2:#down
        for i in range(x+1,n):
            if board[i][y]==6:break
            if board[i][y]==0:board[i][y]=9
    elif dir==3:#left
        for j in range(y-1,-1,-1):
            if board[x][j]==6:break
            if board[x][j]==0:board[x][j]=9
    elif dir==1:#right
        for j in range(y+1,m):
            if board[x][j]==6:break
            if board[x][j]==0:board[x][j]=9

def dfs(now):
    global board
    if now==len(cctvs):return countResult()

    num,x,y=cctvs[now]
    for i in range(d[num]):
        copy=deepcopy(board)
        if num==1:move(x,y,i)
        elif num==2:move(x,y,i);move(x,y,i+2)
        elif num==3:move(x,y,i);move(x,y,i+1)
        elif num==4:move(x,y,i);move(x,y,i+1);move(x,y,i+2)
        elif num==5:move(x,y,i);move(x,y,i+1);move(x,y,i+2);move(x,y,i+3);
        dfs(now + 1)
        board=deepcopy(copy)

dfs(0);print(result)