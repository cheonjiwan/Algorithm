n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
visited=[False]*n
answer=[]

def solution(depth):
    if depth==m:
        print(*answer)
        return
    for i in range(len(data)):
        if not visited[i]:
            visited[i]=True
            answer.append(data[i])
            solution(depth+1)
            answer.pop()
            visited[i]=False

solution(0)