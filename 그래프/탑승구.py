input=__import__('sys').stdin.readline
g=int(input().rstrip());p=int(input().rstrip());

def find_parent(parent,x):
    if parent[x]!=x: return find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b: parent[b]=a
    else: parent[a]=b

parent=[0]*(g+1)
for i in range(g+1):
    parent[i]=i

result=0
for _ in range(p):
    info=int(input().rstrip())
    data=find_parent(parent,info)
    if data==0: break
    union_parent(parent,data,data-1)
    result+=1
print(result)

