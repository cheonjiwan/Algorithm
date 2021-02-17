from itertools import permutations
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n,k=MIS(); board=[]
for _ in range(n):
    board.append(list(MIS()))

for x in range(n):
    for i in range(n):
        for j in range(n):
            board[i][j]=min(board[i][j],board[i][x]+board[x][j])

nums=[i for i in range(n)]
permus=list(permutations(nums,n))

result=2e10
for permu in permus:
    tmp=0
    if permu[0]==k:
        for i in range(n-1):
            tmp+=board[permu[i]][permu[i+1]]
        result=min(result,tmp)
print(result)