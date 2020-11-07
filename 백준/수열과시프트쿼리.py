import sys
from copy import deepcopy
input = sys.stdin.readline

n,q = map(int,input().rstrip().split())
data = list(map(int,input().rstrip().split()))

for i in range(q):
    order = list(map(int,input().rstrip().split()))
    if order[0]==1:
        data[order[1]-1] += order[2] 
    elif order[0]==2:
        shiftData = data[-(n-order[1]):]+data[0:order[1]-1]
        data = deepcopy(shiftData)
    elif order[0]==3:
        shiftData = data[order[1]:]+data[0:order[1]]
        data = deepcopy(shiftData)

for item in data:
    print(item,end=" ")

