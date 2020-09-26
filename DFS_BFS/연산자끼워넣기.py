import sys
from itertools import product
input = sys.stdin.readline

n = int(input().rstrip())
num = list(map(int,input().rstrip().split()))
plus, minus, mul, div = map(int,input().rstrip().split())

maxValue = -987654321
minValue = 987654321

def dfs(i,now):
    global plus, minus, mul, div, maxValue, minValue
    if i==n:
        maxValue = max(maxValue,now)
        minValue = min(minValue,now)
    else:
        if plus>0:
            plus-=1
            dfs(i+1,now+num[i])
            plus+=1
        if minus>0:
            minus-=1
            dfs(i+1,now-num[i])
            minus+=1
        if mul>0:
            mul-=1
            dfs(i+1,now*num[i])
            mul+=1
        if div>0:
            div-=1
            dfs(i+1,int(now/num[i]))
            div+=1
dfs(1,num[0])

print(maxValue)
print(minValue)




