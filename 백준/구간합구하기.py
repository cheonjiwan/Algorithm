input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n,m,k=MIS();order=[];data=[];tree=[0]*(4*n)
for _ in range(n):
    data.append(int(input().rstrip()))
for _ in range(m+k):
    order.append(list(MIS()))

def init(node, start, end): 
    if start==end:
        tree[node]=data[start]
        return tree[node]
    else :
        tree[node]=init(node*2,start,(start+end)//2)+init(node*2+1,(start+end)//2+1,end)
        return tree[node]

def subSum(node, start, end, left, right) :    
    if left>end or right<start: return 0
    if left<=start and end<=right: return tree[node]
    return subSum(node*2, start, (start+end)//2, left, right) + subSum(node*2 + 1, (start+end)//2+1, end, left, right)

def update(node, start, end, index, diff) :
    if index<start or index>end: return
    tree[node] += diff
    if start != end :
        update(node*2, start, (start+end)//2, index, diff)
        update(node*2+1, (start+end)//2+1, end, index, diff)

init(1,0,n-1)
for a,b,c in order:
    if a==1:
        b=b-1
        diff=c-data[b]
        data[b]=c
        update(1,0,n-1,b,diff)
    elif a==2:
        print(subSum(1,0,n-1,b-1,c-1))