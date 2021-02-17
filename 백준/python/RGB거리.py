input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip());board=[]
for _ in range(n):
    board.append(list(MIS()))

for i in range(1,n):
    col=0
    while col<3:
        minV=2e10
        for j in range(3):
            if col!=j:
                if minV>board[i-1][j]: minV=board[i-1][j]
        board[i][col]+=minV;col+=1

print(min(board[-1]))