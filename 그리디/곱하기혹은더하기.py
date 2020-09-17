import sys

input = sys.stdin.readline

data = list(map(int,input().rstrip()))

result = 1

for i in data:
    if i!=0:
        result*=i
    else:
        result+=i

print(result)