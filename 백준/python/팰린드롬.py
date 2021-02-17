n = int(input().rstrip())
data = list(input().rstrip())
char = "a"

for i in range(n // 2 + 1):
    if data[i] == "?":
        if data[len(data) - i - 1] == "?":
            data[i] = char
            data[len(data) - i - 1] = char
        else:
            data[i] = data[len(data) - i - 1]
    else:
        if data[len(data) - i - 1] == "?":
            data[len(data) - i - 1] = data[i]

ans = "".join(data)
print(ans)