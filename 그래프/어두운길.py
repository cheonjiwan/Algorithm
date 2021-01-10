input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n,m=MIS();arr=[]
for _ in range(m):
    a,b,cost=MIS();arr.append((cost,a,b))
arr.sort()

def find_parent(parent,x):
    if parent[x]!=x: parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b: parent[b]=a
    else: parent[a]=b

parent=[0]*(n+1)
for i in range(1,n+1):
    parent[i]=i

total=0;result=0
for cost,a,b in arr:
    total+=cost
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b); result+=cost
    
print(total-result)