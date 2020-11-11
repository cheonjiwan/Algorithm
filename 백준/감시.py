from copy import deepcopy

MIS=lambda:map(int,input().split())
n,m=MIS();board=[];cctvs=[]
for _ in range(n):
    board.append(list(MIS()))
for i in range(n):
    for j in range(m):
        if 1<=board[i][j]<=5:
            cctvs.append((board[i][j],i,j))

def count():
    cnt=0
    for row in board:
        for col in row:
            if col==0:cnt+=1
    return cnt

def dfs(now):
    

if len(cctvs)>0:
    print(dfs(0))
else:
    print(count())