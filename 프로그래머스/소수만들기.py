from math import sqrt,floor,ceil

nums = [1,2,3,4]
nums.sort()

def solution(nums):
    answer = -1
    count=0
    flag=0
    for i in range(len(nums)-2):
        for j in range(i+1,len(nums)-1):
            for x in range(j+1,len(nums)):
                val=0
                val = nums[i]+nums[j]+nums[x]
                for p in range(2,ceil(sqrt(val))+1):
                    if val%p==0:
                        flag=1
                        break
                if(flag==0):
                    count+=1
                else:
                    flag=0


    answer=count
    return answer

print(solution(nums))




