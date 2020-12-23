def solution(arr1, arr2):
    answer = []
    for a in arr1:
        tmp=[]
        for col in range(len(arr2[0])):
            num=0;idx=0
            for row in range(len(arr2)):
                num+=arr2[row][col]*a[idx];idx+=1
            tmp.append(num)
        answer.append(tmp)
    return answer

arr1=[[1, 2, 3], [4, 5, 6]]
arr2=[[1, 4], [2, 5], [3, 6]]
print(solution(arr1,arr2))