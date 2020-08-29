n, k = map(int,input().split())
count=0

while True:
    target = (n//k)*k
    count += (n-target)
    n = target
    
    if n < k:
        break
    
    count +=1
    n //= k

count += (n-1)
print(count)