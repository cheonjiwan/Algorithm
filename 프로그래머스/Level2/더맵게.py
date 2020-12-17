import heapq

def solution(scoville, K):
    q=[];answer = 0
    for item in scoville:
        heapq.heappush(q,item)
    
    while True:
        if q[0]>=K: return answer
        else:
            if len(q)>1:
                a=heapq.heappop(q)
                b=heapq.heappop(q)
                heapq.heappush(q,a+(b*2))
                answer+=1
            else: return -1

    return answer

scoville=[1,2,3];K=11
print(solution(scoville,K))