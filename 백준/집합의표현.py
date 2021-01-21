import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**5)
MIS=lambda:map(int,input().rstrip().split())

n,m=MIS()
parent=[i for i in range(n+1)]
def find_parent(x):
    if parent[x]==x: return x
    parent[x]=find_parent(parent[x])
    return parent[x]

def union(a,b):
    a=find_parent(a)
    b=find_parent(b)
    if a==b: return
    parent[a]=b

for _ in range(m):
    order,a,b=MIS()
    if not order:
        union(a,b)
    else:
        if find_parent(a)==find_parent(b): print("YES")
        else: print("NO")
