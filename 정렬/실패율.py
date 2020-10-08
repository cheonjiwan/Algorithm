N = 8
stages = [1,2,3,4,5,6,7]

def solution(N, stages):
    answer = []
    result = []
    count=0
    length=0
    for n in range(1,N+1):
        for stage in stages:
            if stage==n:
                count+=1
                length+=1
            elif stage>=n:
                length+=1
        if length==0:
            result.append((0,n))
        else:   
            result.append((count/length,n))
        count=0
        length=0
    result = sorted(result,key=lambda x: (-x[0],x[1]))
    
    return [s[1] for s in result]

print(solution(N,stages))