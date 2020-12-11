def solution(progresses, speeds):
    answer=[]
    while len(progresses)>1:
        cnt=0
        for i in range(len(progresses)):
            progresses[i]+=speeds[i]
        while True:
            if len(progresses)!=0:
                if progresses[0]>=100: cnt+=1;progresses.pop(0);speeds.pop(0)
                else: break
            else: break
        if cnt!=0: answer.append(cnt)
    if len(progresses)==1: answer.append(1)

    return answer

progresses= [40, 93, 30, 55, 60, 65]
speeds= [60, 1, 30, 5 , 10, 7]
print(solution(progresses,speeds))