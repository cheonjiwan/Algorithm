from collections import deque

def topology_sort(student):
    global n
    count=0
    graph = [[] for _ in range(n+1)]
    indegree = [0]*(n+1)
    result = []
    q = deque()

    for i in range(1,n+1):
        graph[i].append(student[i-1])
        indegree[student[i-1]]+=1
    
    for i in range(1,n+1):
        if indegree[i]==0:
            q.append(i)

    while q:
        now = q.popleft()
        
        for i in graph[now]:
            indegree[i]-=1
            if(indegree[i]==0):
                q.append(i)
    
    for i in range(1,n+1):
        if(indegree[i]==0):
            count+=1

    return count

    

tc = int(input())
result = []

for _ in range(tc):
    n = int(input())
    student = list(map(int,input().split()))

    result.append(topology_sort(student))

for i in range(len(result)):
    print(result[i])



