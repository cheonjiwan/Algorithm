import sys

input = sys.stdin.readline

n = input().rstrip()

length = len(n) // 2
left = 0
right = 0
for i in range(length):
    left += int(n[i])
    right += int(n[i + length])

if left == right:
    print("LUCKY")
else:
    print("READY")
