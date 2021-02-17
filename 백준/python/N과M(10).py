n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
visited=[False]*n
answer=[]

def solution(depth):
    if depth==m:
        print(*answer)
        return
    pre=-1
    for i in range(n):
        if not visited[i] and pre!=data[i]:
            pre=data[i]
            visited[i]=True
            if not answer:
                answer.append(data[i])
                solution(depth+1)
                answer.pop()
            elif answer[-1]<=data[i]:
                answer.append(data[i])
                solution(depth+1)
                answer.pop()
            visited[i]=False

solution(0)