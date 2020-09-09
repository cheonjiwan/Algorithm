from collections import deque

n = int(input())
graph = [[] for i in range(n+1)]
indegree=[0]*(n+1)
time = [0]*(n+1)
for j in range(1,n+1):
    input_data = list(map(int,input().split()))
    for i in range(len(input_data)):
        if i==0:
            time[j]=input_data[i]
            continue
        elif input_data[i]!=-1:
            graph[input_data[i]].append(j)
            indegree[j]+=1
        elif input_data[i]==-1:
            break

def topology_sort():
    q = deque()

    for i in range(1,n+1):
        if indegree[i]==0:
            q.append(i)

    while q:
        now = q.popleft()
        

        for x in graph[now]:
            indegree[x]-=1
            if(indegree[x]==0):
                time[x] += time[now]
                q.append(x)



topology_sort()
for i in range(1,n+1):
    print(time[i])


