n,k=map(int,input().split())
number=list(map(str,input()))

arr=[]
for c in number:
    while arr and arr[-1]<c:
        if k>0:
            arr.pop()
            k-=1
        else: break
    arr.append(c)
    
while k>0:
    arr.pop()
    k-=1
print(''.join(arr))
