n=int(input().rstrip())
data=sorted(list(map(int,input().rstrip().split())))

l=0
r=n-1
ans=2e10
x,y=0,0
while l<r:
    tmp=data[l]+data[r]
    if abs(tmp)<abs(ans):
        ans=abs(tmp)
        x,y=l,r

    if tmp<0:
        l=l+1
    else:
        r=r-1
print(data[x],data[y])