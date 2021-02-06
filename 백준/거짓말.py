import sys
from copy import deepcopy
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n,m=MIS()
data=list(MIS())
party=[]
for _ in range(m):
    party.append(list(MIS()))

if data[0]==0:
    print(m)
    sys.exit()
lier=set(data[1:])
while True:
    new_lier=deepcopy(lier)
    for arr in party:
        for num in arr[1:]:
            if num in lier:
                lier.update(arr[1:])
                break
    if new_lier==lier:
        break

cnt=0
for arr in party:
    flag=True
    for num in arr[1:]:
        if num in lier:
            flag=False
    if flag:
        cnt+=1
print(cnt)