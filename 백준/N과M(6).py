n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
visited=[False]*(n+1)
answer=[]

def solution(depth):
    if depth==m:
        print(*answer)
        return
    
    for i in range(len(data)):
        if not visited[i]:
            visited[i]=True
            if not answer:
                answer.append(data[i])
                solution(depth+1)
                answer.pop()
            elif data[i]>answer[-1]:
                answer.append(data[i])
                solution(depth+1)
                answer.pop()
            visited[i]=False

solution(0)