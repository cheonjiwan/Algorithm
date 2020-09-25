import sys
input = sys.stdin.readline

board = []


dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,m = map(int,input().rstrip().split())
for _ in range(n):
    board.append(list(map(int,input().rstrip().split())))

temp = [[0]*m for _ in range(n)]
result = 0

def start(x,y):
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<m:
            if temp[nx][ny]==0:
                temp[nx][ny]=2
                start(nx,ny)

def dfs(count):
    global result
    if count==3:
        score=0
        for i in range(n):
            for j in range(m):
                temp[i][j] = board[i][j]
        
        for i in range(n):
            for j in range(m):
                if temp[i][j]==2:
                    start(i,j)
        for i in range(n):
            for j in range(m):
                if temp[i][j]==0:
                    score+=1
        result = max(result,score)
        return
        
    for i in range(n):
        for j in range(m):
            if board[i][j]==0:
                board[i][j]=1
                count+=1
                dfs(count)
                board[i][j]=0
                count-=1
    
dfs(0)
print(result)