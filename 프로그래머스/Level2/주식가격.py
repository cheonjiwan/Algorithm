def solution(prices):
    answer=[]
    for i in range(len(prices)-1):
        cnt=1
        for j in range(i+1,len(prices)-1):
            if prices[i]<=prices[j]: cnt+=1
            else: break
        answer.append(cnt)
    answer.append(0)
    return answer
