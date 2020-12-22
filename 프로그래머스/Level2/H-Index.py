def solution(citations):
    citations=sorted(citations,reverse=True)
    max_h=-1
    for h in range(len(citations)+1):
        cnt=0
        for num in citations:
            if num>=h: cnt+=1
            else: break
        if cnt>=h: max_h=h    
    return max_h
