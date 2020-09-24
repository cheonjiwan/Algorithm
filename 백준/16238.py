import sys
input = sys.stdin.readline

n = int(input().rstrip())
data = list(map(int,input().rstrip().split()))

result =0
while data:
    result+= max(data)
    data.remove(max(data))
    for i in range(len(data)):
        if data[i]!=0:
            data[i] -=1

print(result)