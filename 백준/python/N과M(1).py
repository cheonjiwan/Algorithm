n,m=map(int,input().split())
visited=[False]*(n+1)
answer=[]

def solution(depth,num):
    if depth==m:
        print(*answer)
        return
    
    for i in range(1,n+1):
        if not visited[i]:
            visited[i]=True
            answer.append(i)
            solution(depth+1,i)
            visited[i]=False
            answer.pop()

solution(0,0)