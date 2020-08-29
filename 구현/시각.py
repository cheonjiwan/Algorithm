n = int(input())
count = 0

for i in range(n + 1):
    for j in range(60):
        for x in range(60):
            result = str(i) + str(j) + str(x)
            if result.find("3") != -1:
                count += 1

print(count)