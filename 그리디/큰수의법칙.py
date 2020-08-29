n, m, k = map(int, input().split())

arr = list(map(int, input().split()))

arr.sort(reverse=True)
count = 0
result = 0
for i in range(m):
    if count != 3:
        result += arr[0]
        count = count + 1
    else:
        result += arr[1]
        count = 0

print(result)