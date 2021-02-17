import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

def find_parent(parent,x):
    if x!=parent[x]:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b: parent[b]=a
    else: parent[a]=b

n=int(input().rstrip())
m=int(input().rstrip())
parent=[i for i in range(n+1)]

edges=[]
for _ in range(m):
    a,b,c=MIS()
    edges.append((c,a,b))

ans=0
edges=sorted(edges)
cnt=0
for edge in edges:
    cost,a,b=edge
    if cnt==n-1:
        break
    if find_parent(parent,a)!=find_parent(parent,b):
        union(parent,a,b)
        ans+=cost
        cnt+=1
print(ans)