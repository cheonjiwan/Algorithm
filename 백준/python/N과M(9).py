n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
answer=[]
visited=[False]*n

def solution(depth):
    if depth==m:
        print(*answer)
        return

    pre=-1
    for i in range(len(data)):
        if not visited[i] and pre!=data[i]:
            pre=data[i]
            answer.append(data[i])
            visited[i]=True
            solution(depth+1)
            visited[i]=False
            answer.pop()
        
solution(0)