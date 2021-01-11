def solution(nums):
    pick=len(nums)//2
    unique=len(set(nums))
    if pick<=unique: return pick
    else: return unique

nums=[3,3,3,2,2,2]
print(solution(nums))