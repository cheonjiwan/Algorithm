n = int(input())
arr = []
for i in range(n):
    data = int(input())
    arr.append(data)
arr.sort()

for i in range(n):
    print(arr[i])