n,t,c,p = map(int,input().rstrip().split())

result = 0
day = 1
while True:
    day += t
    if day<=n:
        result += c*p
    else:
        break

print(result)