from itertools import combinations, permutations

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
balls = list(map(int, input().split()))
arr = [0] * 11

# results = list(combinations(balls,2))

# count=0
# for result in results:
#     if result[0]!=result[1]:
#         count+=1

# print(count)

for ball in balls:
    arr[ball] += 1

result = 0
for i in range(1, m + 1):
    n -= arr[i]
    result += n * arr[i]

print(result)
