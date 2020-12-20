def solution(dartResult):
    answer = 0;arr=[];flag=False
    idx=0
    while True:
        if idx>=len(dartResult): break
        num=''
        while ord('0')<=ord(dartResult[idx])<=ord('9'):
            num+=dartResult[idx]
            idx+=1
        if dartResult[idx]=='S' or dartResult[idx]=='D' or dartResult[idx]=='T':
            if dartResult[idx]=='S':
                arr.append(pow(int(num),1))
            elif dartResult[idx]=='D':
                arr.append(pow(int(num),2))
            elif dartResult[idx]=='T':
                arr.append(pow(int(num),3))
        elif dartResult[idx]=='#' or dartResult[idx]=='*':
            if dartResult[idx]=='*':
                for i in range(len(arr)-1,len(arr)-3,-1):
                    if i<0: break
                    else: arr[i]*=2
            elif dartResult[idx]=='#':
                arr[-1]*=-1
        idx+=1
    
    for i in range(len(arr)):
        answer+=arr[i]
    return answer

dartResult='1S*2T*3S'
print(solution(dartResult))