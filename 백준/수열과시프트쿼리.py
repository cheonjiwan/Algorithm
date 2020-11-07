n, q = map(int, input().rstrip().split())
data = list(map(int, input().rstrip().split()))

idx = 0
for i in range(q):
    order = list(map(int, input().rstrip().split()))
    if order[0] == 1:
        data[(idx + order[1] - 1) % n] += order[2]
    elif order[0] == 2:
        idx = n + idx - order[1] if idx - order[1] < 0 else idx - order[1]
    elif order[0] == 3:
        idx = (idx + order[1]) % n

for i in range(idx, n):
    print(data[i], end=" ")
for i in range(idx):
    print(data[i], end=" ")
