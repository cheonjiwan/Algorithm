input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n,m=MIS();heights=list(MIS())    
l,r=0,2000000000;ans=0
while l<=r:
    total=0
    mid=(l+r)//2
    for height in heights:
        if height>mid: total+=height-mid
    
    if total<m: r=mid-1
    else: ans=mid;l=mid+1
print(ans)