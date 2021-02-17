import sys
sys.setrecursionlimit(10000)
input=sys.stdin.readline
MIS=lambda:map(str,input().rstrip())

r,c=map(int,input().rstrip().split());board=[]
for _ in range(r):
    board.append(list(MIS()))

dx=[-1,0,1,0];dy=[0,-1,0,1]
check=[0]*26;check[ord(board[0][0])-ord('A')]=1
answer=1

def dfs(x,y,cnt):
    global answer
    answer=max(answer,cnt)

    for i in range(4):
        nx,ny=x+dx[i],y+dy[i]
        if 0<=nx<r and 0<=ny<c and not check[ord(board[nx][ny])-ord('A')]:
            check[ord(board[nx][ny])-ord('A')]=1
            dfs(nx,ny,cnt+1)
            check[ord(board[nx][ny])-ord('A')]=0

dfs(0,0,answer)
print(answer)