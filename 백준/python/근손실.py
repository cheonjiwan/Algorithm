import sys
from itertools import permutations
input=sys.stdin.readline

n,k=map(int,input().rstrip().split())
data=list(map(int,input().rstrip().split()))

permus=list(permutations(data,n))
cnt=0
for permus in permus:
    total=500
    flag=False
    for weight in permus:
        total+=(weight-k)
        if total<500: flag=True;break
    if not flag: cnt+=1

print(cnt)