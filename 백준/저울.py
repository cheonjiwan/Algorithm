import sys
input = sys.stdin.readline

n = int(input().rstrip())
board = list(map(int,input().rstrip().split()))

board.sort()

k = 1
for item in board:
    if k<item:
        break
    k+=item

print(k)

