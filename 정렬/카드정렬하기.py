import sys,heapq
input = sys.stdin.readline

n = int(input().rstrip())
size = []

for _ in range(n):
    heapq.heappush(size,(int(input().rstrip())))

result = 0
while len(size)!=1:
    a = heapq.heappop(size)
    b = heapq.heappop(size)
    Value = a+b
    result+=Value
    heapq.heappush(size,Value)

print(result) 

