input=__import__('sys').stdin.readline
n=int(input().rstrip())
check=[False for _ in range(10)]
result=[0 for _ in range(10)]
for i in range(n):
    d=1
    data=input().rstrip()
    check[ord(data[0])-65]=True
    for j in range(len(data)-1,-1,-1):
        result[ord(data[j])-65]+=d;d*=10
z=0
for i in range(10):
    if not check[i]: z=i;break

for i in range(10):
    if not check[i] and result[i]<result[z]:
        z=i
result[z]=0
result.sort(reverse=True)
ans=0
for i in range(10):
    ans+=(9-i)*result[i]
print(ans)