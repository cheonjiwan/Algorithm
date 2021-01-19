n=int(input())
board=[[0 for _ in range(101)] for _ in range(101)]
for _ in range(n):
    a,b=map(int,input().split())
    for i in range(a,a+10):
        for j in range(b,b+10):
            board[i][j]=1
result=0
for row in board:
    for col in row:
        if col==1: result+=1
print(result)