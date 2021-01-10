def find_parent(parent,x):
    if parent[x]!=x: parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b: parent[b]=a
    else: parent[a]=b

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip())

parent=[0]*(n+1)
for i in range(1,n+1):
    parent[i]=i

x=[];y=[];z=[]
for i in range(1, n + 1):
    data=list(MIS())
    x.append((data[0],i))
    y.append((data[1],i))
    z.append((data[2],i))
x.sort();y.sort();z.sort()

edges=[]
for i in range(n-1):
    edges.append((x[i+1][0]-x[i][0], x[i][1],x[i+1][1]))
    edges.append((y[i+1][0]-y[i][0], y[i][1],y[i+1][1]))
    edges.append((z[i+1][0]-z[i][0], z[i][1],z[i+1][1]))

edges.sort();result=0
for cost,a,b in edges:
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b);result+=cost
print(result)