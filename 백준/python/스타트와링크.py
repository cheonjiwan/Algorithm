from itertools import permutations,combinations
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
board=[]
for _ in range(n):
    board.append(list(MIS()))
    
minV=2e10
person=[i for i in range(n)]
combis=list(combinations(person,n//2))
for combi in combis:
    start=list(combi)
    other=[i for i in range(n)]
    for who in combi:
        other.remove(who)
    
    a,b=0,0
    for i,j in list(combinations(start,2)):
        a+=board[i][j]
        a+=board[j][i]
    for i,j in list(combinations(other,2)):
        b+=board[i][j]
        b+=board[j][i]
    minV=min(minV,abs(a-b))        
print(minV)