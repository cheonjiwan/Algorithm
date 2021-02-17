import sys
input=sys.stdin.readline
n,c=map(int,input().rstrip().split())
pos=[]
for _ in range(n):
    pos.append(int(input().rstrip()))

pos=sorted(pos)
l=0
r=pos[-1]-pos[0]
ans=0
while l<=r:
    mid=(l+r)//2
    start=pos[0]
    cnt=1
    for i in range(1,n):
        if pos[i]-start>=mid:
            cnt+=1
            start=pos[i]
    
    if cnt<c:
        r=mid-1
    else:
        l=mid+1
        ans=mid
print(ans)