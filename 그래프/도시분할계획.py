def find_parent(parent,x):
    if(parent[x]!=x):
        parent[x] = find_parent(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int,input().split())

parent = [0]*(n+1)
for i in range(1,n+1):
    parent[i] = i

edges = []
for _ in range(m):
    a,b,cost = map(int,input().split())
    edges.append((cost,a,b))

edges.sort()

result = 0
last = 0

for edge in edges:
    if(find_parent(parent,edge[1]) != find_parent(parent,edge[2])):
        union(parent,edge[1],edge[2])
        result += edge[0]
        last = edge[0]

print(result-last)



