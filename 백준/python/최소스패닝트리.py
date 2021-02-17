input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())

def find_parent(parent,x):
    if parent[x]!=x: parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b:
        parent[b]=a
    else: parent[a]=b

v,e=MIS();edges=[]
parent=[i for i in range(v+1)]
for _ in range(e):
    a,b,c=MIS()
    edges.append((c,a,b))
edges=sorted(edges)

result=0
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        result+=cost
        union(parent,a,b)
print(result)
