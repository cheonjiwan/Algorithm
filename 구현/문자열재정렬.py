import sys, heapq

input = sys.stdin.readline

s = input().rstrip()
string = []
sum = 0

for c in s:
    if (ord("a") <= ord(c) and ord("z") >= ord(c)) or (
        ord("A") <= ord(c) and ord("Z") >= ord(c)
    ):
        heapq.heappush(string, c)

    if ord("0") <= ord(c) and ord("9") >= ord(c):
        sum += int(c)

while string:
    print(heapq.heappop(string), end="")

print(sum)