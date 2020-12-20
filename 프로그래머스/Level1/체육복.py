def solution(n, lost, reserve):
    ans=0;tmp=[]
    ans+=n-len(lost)
    lost.sort();reserve.sort()

    for i in lost:
        if i in reserve:
            reserve.remove(i);ans+=1;tmp.append(i)
    for i in tmp:
        lost.remove(i)
    for i in reserve:
        if len(lost)==0: break
        if i-1!=n and i-1 in lost:
            lost.remove(i-1);ans+=1;continue
        elif i+1!=0 and i+1 in lost:
            lost.remove(i+1);ans+=1;continue
    return ans

n=30
lost=[1,3]
reserve=[2,4,5]
print(solution(n,lost,reserve))