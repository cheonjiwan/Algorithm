n, m = map(int, input().split())
arr = [[0 for col in range(m)] for row in range(n)]

for i in range(n):
    arr[i] = list(map(int, input().split()))

maxValue = min(arr[0])

for i in range(1, n):
    if maxValue < min(arr[i]):
        maxValue = min(arr[i])

print(maxValue)